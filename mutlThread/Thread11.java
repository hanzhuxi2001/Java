package mutlThread;

class Thread11 extends Thread {
	ProduceConsume pc;

	public Thread11(ProduceConsume pp) {
		pc = pp;
	}

	public void run() {
		while (true) {
			pc.consume();

		}
	}
}