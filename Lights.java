public class Lights extends Thread {
	int myName;
	boolean eastboundLights = true;
	boolean westboundLights = false;
	int q = 100;
	int t = 150;
	
	public Lights(int myName) {		
		Synch.timeSim.threadStart();	
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
			eastboundLights = true;
			westboundLights = false;
			Synch.timeSim.doSleep(1, t);
			eastboundLights = false;
			Synch.timeSim.doSleep(1,q);
			westboundLights = true;
			Synch.timeSim.doSleep(1,q);
			westboundLights = false;
		}				
	}
}
