public class Lights extends Thread {

	int q = 100;
	int t = 150;
	
	public Lights() {	

		Synch.timeSim.threadStart();	
		changeLights();
	}

	private static changeLights () {
		while (true) {
			Synch.eastboundLight = true;
			Synch.westboundLight = false;
			Synch.timeSim.doSleep(1, t);
			while (Synch.eastboundCars > 0)
				Synch.eastbound.release();
			Synch.eastboundLight = false;
			Synch.timeSim.doSleep(1,q);
			Synch.westboundLight = true;
			while (Synch.westboundCars > 0)
				Synch.westbound.release();
			Synch.timeSim.doSleep(1,q);
			Synch.westboundLight = false;
		}				
	}
}
