package stopWatch;

import java.util.Scanner;

public class Stopwatch extends Watch {

	private void Stopwatch() {

	}

	private static Stopwatch instance = new Stopwatch();

	public static Stopwatch getInstance() {
		return instance;
	}

	private Watch watch = new Watch();
	private Thread watchThread = new Thread(watch);

	private Input input = new Input();
	private Thread inputThread = new Thread(input);

	private boolean isRun = true;

	private int log = HOLDNUMBER;

	@Override
	public void run() {
		menu();
		watchThread.start();
		inputThread.start();

		while (isRun) {
			input();
			inputThread.start();
			inputMenu();
			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {

			}
		}

	}

	private void menu() {
		System.out.println("=== 스탑워치 ===");
		System.out.println("[q] STOP");
		System.out.println("[w] HOLD");
		System.out.println("[e] RERUN");
	}

	private void inputMenu() {

		if (qwe.equals(STOP)) {
			stop();
		} else if (qwe.equals(HOLD)) {
			if (log == HOLDNUMBER) {
				hold();
			} else {
				System.out.println("이미 일시정지 상태 입니다!");
			}
		} else if (qwe.equals(RERUN)) {
			if (log == RERUNNUMBER) {
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
		inputThread.interrupt();
		int minute = second / 60;
		second = second % 60;

		System.out.printf(">>>> %d초 %d분 소요됨", minute, second);
	}

	private void hold() {
		System.out.println("일시 정지!!");
		menu();
		watchThread.interrupt();
		log = RERUNNUMBER;
	}

	private void rerun() {
		System.out.println("다시 시작!!");
		menu();
		watchThread = new Thread(watch);
		watchThread.start();

		log = HOLDNUMBER;
	}

}
