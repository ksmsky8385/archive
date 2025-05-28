import time

def long_task():
    for i in range(5):
        time.sleep(1)
        print("working : %s\n" %i)
        
print("start")
start = time.time()

for i in range(5):
    long_task()
    
end = time.time()
print("end")
print("걸린시간 : %.2f초" %(end-start))




import time
import threading

def long_task():
    for i in range(5):
        time.sleep(1)
        print("working : %s\n" %i)
        
print("start")
start = time.time()

threads = []

for i in range(5):
    t = threading.Thread(target=long_task)
    threads.append(t)
    
for t in threads:
    t.start()
    
for t in threads:
    t.join()
    
end = time.time()
print("End")
print("걸린 시간 : %f초" %(end-start))