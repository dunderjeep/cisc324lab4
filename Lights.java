public class Lights extends Thread {

	static int q = 100;
	static int t = 150;
	
	public Lights() {
		Synch.timeSim.threadStart();	
	}

	public static void changeLights () {
		System.out.println("Westbound cars: " +Synch.westboundCars);
		while (Synch.eastboundCars >= 0 || Synch.westboundCars >= 0) {
			Synch.eastboundLight = true;
			Synch.westboundLight = false;
			System.out.println("Eastbound light is green, westbound light is red.");
			Synch.timeSim.doSleep(1, t);
			while (Synch.eastboundCars > 0) {
				Synch.eastbound.release();
				System.out.println("Letting 1 car of " + Synch.eastboundCars + " go eastbound.");
			}				
			Synch.eastboundLight = false;
			System.out.println("Both lights are red.");
			Synch.timeSim.doSleep(1,q);
			Synch.westboundLight = true;
			System.out.println("Eastbound light is red, westbound light is green.");
			while (Synch.westboundCars > 0) {
				Synch.westbound.release();
				System.out.println("Letting 1 car of " + Synch.westboundCars + " go westbound.");
			}				
			Synch.timeSim.doSleep(1,q);
			Synch.westboundLight = false;
			System.out.println("Both lights are red.");
		}				
	}
		
}
