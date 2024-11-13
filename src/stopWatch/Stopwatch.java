package stopWatch;

import java.util.Scanner;

public class Stopwatch extends Watch {

	private final String STOP = "q";
	private final String HOLD = "w";
	private final String RERUN = "e";

	private void Stopwatch() {

	}

	private static Stopwatch instance = new Stopwatch();

	public static Stopwatch getInstance() {
		return instance;
	}

	private Scanner scan = new Scanner(System.in);

	Watch watch = new Watch();
	Thread watchThread = new Thread(watch);

	@Override
	public void run() {

		watchThread.start();

	}

	private void menu() {
		System.out.println("[q] STOP");
		System.out.println("[w] HOLD");
		System.out.println("[e] RERUN");

		String select = input("메뉴 입력");

		if (select.equals(STOP)) {
			stop();
		} else if (select.equals(HOLD)) {
			hold();
		} else if (select.equals(RERUN)) {
			rerun();
		}
	}

	private void stop() {
		// TODO Auto-generated method stub

	}

	private void hold() {
		// TODO Auto-generated method stub

	}

	private void rerun() {
		// TODO Auto-generated method stub

	}

	private String input(String msg) {
		while (true) {
			System.out.print(msg + " : ");
			String input = scan.nextLine();

			if (!input.equals(""))
				return input;
		}
	}

}
