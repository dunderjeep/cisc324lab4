public class Lights extends Thread {

	Synch synch;
	Synch.eastboundLights = true;
	Synch.westboundLights = false;
	int q = 100;
	int t = 150;
	Synch.eastboundCars = 0;
	Synch.westboundCars = 0;
	Synch.mutex = new Semaphore(1, true);
	Synch.eastboundSem = new Semaphore(1, true);
	Synch.westboundSem = new Semaphore(1, true);	
	
	public Lights(int myName) {	
		synch = new Synch();	
		synch.timeSim.threadStart();	
		changeLights();
	}

	public boolean getEastboundLights () {
		return eastboundLights;
	}

	public boolean getWestboundLights() {
		return westboundLights;
	}

	private changeLights () {
		while (true) {
			synch.eastboundLights = true;
			synch.westboundLights = false;
			synch.timeSim.doSleep(1, t);
			synch.eastboundLights = false;
			synch.timeSim.doSleep(1,q);
			synch.westboundLights = true;
			synch.timeSim.doSleep(1,q);
			synch.westboundLights = false;
		}				
	}
}
