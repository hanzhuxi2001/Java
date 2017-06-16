package mutlThread;
class Thread22 extends Thread {
		ProduceConsume pc;

		public Thread22(ProduceConsume pp) {
			pc = pp;
		}

		public void run() {
			while(true){
				pc.produce();

			}
		}
	}