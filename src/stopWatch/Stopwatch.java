package stopWatch;

public class Stopwatch extends Watch {

	private void Stopwatch() {

	}

	private static Stopwatch instance = new Stopwatch();

	public static Stopwatch getInstance() {
		return instance;
	}

	public void run() {
		while (true) {
			second++;
			printTime();

			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
