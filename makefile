JCC = javac
JFLAGS = -g
default: MainMethod.class Car.class Synch.class TimeSim.class Semaphore.class

MainMethod.class: MainMethod.java
	$(JCC) $(JFLAGS) MainMethod.java

Car.class: Car.java
	$(JCC) $(JFLAGS) Car.java

Synch.class: Synch.java
	$(JCC) $(JFLAGS) Synch.java

TimeSim.class: TimeSim.java
	$(JCC) $(JFLAGS) TimeSim.java

Semaphore.class: Semaphore.java
	$(JCC) $(JFLAGS) Semaphore.java

clean:
	$(RM) *.class *~
