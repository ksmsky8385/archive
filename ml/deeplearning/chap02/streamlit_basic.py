import os
import time
import random
import streamlit as st
from dotenv import load_dotenv

# Optional: OpenAI 연결 (키 없으면 데모 모드로 동작)
try:
    from openai import OpenAI
except Exception:
    OpenAI = None

# ---------- 기본 설정 ----------
st.set_page_config(page_title="Chatbot", page_icon="💬")
load_dotenv()
API_KEY = os.getenv("OPENAI_API_KEY")

# ---------- 유틸 ----------
def typing_effect(container, text: str, delay: float = 0.04):
    """타이핑(스트리밍) 효과"""
    placeholder = container.empty()
    acc = ""
    for word in text.split():
        acc += word + " "
        placeholder.markdown(acc + "▌")
        time.sleep(delay)
    placeholder.markdown(acc.strip())

def build_openai_client():
    if API_KEY and OpenAI is not None:
        try:
            return OpenAI(api_key=API_KEY)
        except Exception:
            return None
    return None

def call_llm(client, history):
    """history: [{'role': 'user'|'assistant', 'content': str}, ...]"""
    system_msg = {"role": "system", "content": "너는 사용자를 도와주는 친절한 상담사야."}
    messages = [system_msg] + history  # 시스템 프롬프트 + 대화 이력
    try:
        resp = client.chat.completions.create(
            model="gpt-4o-mini",
            temperature=0.7,
            messages=messages,
        )
        return (resp.choices[0].message.content or "").strip()
    except Exception as e:
        # 에러를 사용자에게 친절히 전달
        return f"⚠️ LLM 호출 중 오류가 발생했어요: `{type(e).__name__}`\n\n{str(e)}"

def demo_reply(user_text: str) -> str:
    canned = [
        "안녕하세요! 무엇을 도와드릴까요?",
        "질문을 더 자세히 알려주시면 정확히 도와드릴게요.",
        "좋은 질문이에요. 함께 차근차근 해결해봅시다!",
        "관련 정보를 정리해볼게요. 원하시는 포맷이 있으신가요?",
    ]
    # 간단한 변주
    return random.choice(canned) + f"\n\n(메시지 요약: “{user_text[:40]}…”)"

# ---------- 상태 초기화 ----------
if "messages" not in st.session_state:
    st.session_state.messages = [
        {"role": "assistant", "content": "Let's start chatting! 👇"}
    ]

# ---------- 사이드바 ----------
with st.sidebar:
    st.header("⚙️ Settings")
    demo_mode_default = API_KEY is None or OpenAI is None
    demo_mode = st.toggle("Demo mode (LLM 미연결)", value=demo_mode_default,
                          help="끄면 OpenAI API로 실제 모델을 호출합니다.")
    if st.button("🧹 대화 초기화"):
        st.session_state.messages = [
            {"role": "assistant", "content": "대화를 다시 시작해볼까요? 👇"}
        ]
        st.rerun()
    if st.button("🎈 풍선 쏘기"):
        st.balloons()

# ---------- 본문 ----------
st.title("💬 Chatbot")
st.caption("※ 이 앱은 데모용입니다. Demo 모드에선 LLM을 호출하지 않습니다.")

# 기존 메시지 렌더
for m in st.session_state.messages:
    with st.chat_message(m["role"]):
        st.markdown(m["content"])

# 입력창
if user_text := st.chat_input("메시지를 입력하세요"):
    # 사용자 메시지 반영
    st.session_state.messages.append({"role": "user", "content": user_text})
    with st.chat_message("user"):
        st.markdown(user_text)

    # 어시스턴트 응답
    with st.chat_message("assistant"):
        if demo_mode:
            reply = demo_reply(user_text)
            typing_effect(st, reply)
        else:
            client = build_openai_client()
            if client is None:
                reply = "⚠️ OpenAI 클라이언트를 초기화할 수 없어요. Demo 모드로 전환하거나 API 키를 확인해주세요."
                typing_effect(st, reply)
            else:
                reply = call_llm(client, st.session_state.messages)
                typing_effect(st, reply)

    # 대화 이력에 추가
    st.session_state.messages.append({"role": "assistant", "content": reply})
