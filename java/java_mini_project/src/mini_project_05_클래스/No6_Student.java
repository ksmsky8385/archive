package mini_project_05_클래스;

public class No6_Student {
	private int scoreKor;
	private int scoreEng;
	private int scoreMath;

	
	public No6_Student(int scoreKor, int scoreEng, int scoreMath) {
		this.scoreKor = scoreKor;
		this.scoreEng = scoreEng;
		this.scoreMath = scoreMath;
	}


public int sum() {
	return scoreKor + scoreEng + scoreMath;
}

public int avg() {
	return sum()/3;
}

public int getScoreKor() {
	return scoreKor;
}

public void setScoreKor(int scoreKor) {
	this.scoreKor = scoreKor;
}

public int getScoreEng() {
	return scoreEng;
}

public void setScoreEng(int scoreEng) {
	this.scoreEng = scoreEng;
}

public int getScoreMath() {
	return scoreMath;
}

public void setScoreMath(int scoreMath) {
	this.scoreMath = scoreMath;
}

}