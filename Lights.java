public class Lights extends Thread {

	static int q = 100;
	static int t = 150;
	
	public Lights() {
		Synch.timeSim.threadStart();	
	}

	public static void changeLights () {
		System.out.println("Lights are starting.");
		System.out.println("Westbound cars: " +Synch.westboundCars);
		System.out.println("Eastbound cars: " +Synch.eastboundCars);
		do  {
			Synch.eastboundLight = true;
			Synch.westboundLight = false;
			System.out.println("Eastbound light is green, westbound light is red.");	
			Synch.timeSim.doSleep(1,q);
			System.out.println("Westbound cars: " +Synch.westboundCars);
			System.out.println("Eastbound cars: " +Synch.eastboundCars);	
			for (int i = 0; i < Synch.eastboundCars; i++) {
				Synch.mutex.acquire();
				Synch.eastboundCars--;
				Synch.mutex.release();
				Synch.eastbound.release();
				System.out.println("Letting 1 car of " + Synch.eastboundCars + " go eastbound.");
			}	
			System.out.println("Both lights are red.");
			Synch.eastboundLight = false;
			Synch.timeSim.doSleep(1, t);			
			Synch.westboundLight = true;
			System.out.println("Eastbound light is red, westbound light is green.");
			Synch.timeSim.doSleep(1,q);
			System.out.println("Westbound cars: " +Synch.westboundCars);
			System.out.println("Eastbound cars: " +Synch.eastboundCars);
			for (int i = 0; i < Synch.westboundCars; i++) {
				Synch.mutex.acquire();
				Synch.westboundCars--;
				Synch.mutex.release();
				Synch.westbound.release();
				System.out.println("Letting 1 car of " + Synch.westboundCars + " go westbound.");
			}				
			Synch.westboundLight = false;
			System.out.println("Both lights are red.");
			Synch.timeSim.doSleep(1, t);
		} while (Synch.carThreads > 0);
		System.out.println("Lights are stopping.");
		Synch.timeSim.threadEnd();		
	} 

		
}
