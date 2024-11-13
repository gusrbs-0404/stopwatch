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

	private boolean isRun = true;

	private int log = 0;

	@Override
	public void run() {
		menu();
		watchThread.start();
		while (isRun) {
			inputMenu();
		}

	}

	private void menu() {
		System.out.println("=== 스탑워치 ===");
		System.out.println("[q] STOP");
		System.out.println("[w] HOLD");
		System.out.println("[e] RERUN");

	}

	private void inputMenu() {
		String select = input("메뉴 입력");

		if (select.equals(STOP)) {
			stop();
		} else if (select.equals(HOLD)) {
			if (log == 0) {
				hold();
			} else {
				System.out.println("이미 일시정지 상태 입니다!");
			}
		} else if (select.equals(RERUN)) {
			if (log == 1) {
				rerun();
			} else {
				System.out.println("타이머가 작동중입니다!");
			}
		} else {
			System.out.println("메뉴를 잘못입력했습니다.");
		}
	}

	private void stop() {
		System.out.println("스탑워치 종료합니다!");
		isRun = false;
		watchThread.interrupt();
	}

	private void hold() {
		System.out.println("일시 정지!!");
		watchThread.interrupt();
		log = 1;
	}

	private void rerun() {
		System.out.println("다시 시작!!");

	}

	private String input(String msg) {
		while (true) {
			System.out.println(msg + " : ");
			String input = scan.nextLine();

			if (!input.equals(""))
				return input;
		}
	}

}
