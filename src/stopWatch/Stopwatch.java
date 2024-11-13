package stopWatch;

public class Stopwatch extends Watch {
	private final String STOP = "q";
	private final String HOLD = "w";
	private final int HOLDNUMBER = 0;
	private final String RERUN = "e";
	private final int RERUNNUMBER = 1;

	private void Stopwatch() {

	}

	private static Stopwatch instance = new Stopwatch();

	public static Stopwatch getInstance() {
		return instance;
	}

	private Watch watch = new Watch();
	private Thread watchThread;

	private Input input = new Input();
	private Thread inputThread;

	private boolean isRun = true;

	private int log = HOLDNUMBER;

	@Override
	public void run() {
		menu();
		startWatchThread();
		startInputThread();

		while (isRun) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private void startWatchThread() {
		watchThread = new Thread(watch);
		watchThread.start();
	}

	private void startInputThread() {
		inputThread = new Thread(input);
		inputThread.start();

	}

	private void menu() {
		System.out.println("=== 스탑워치 ===");
		System.out.println("[q] STOP");
		System.out.println("[w] HOLD");
		System.out.println("[e] RERUN");
	}

	public void inputMenu(String Input) {

		if (Input.equals(STOP)) {
			stop();
		} else if (Input.equals(HOLD)) {
			if (log == HOLDNUMBER) {
				hold();
			} else {
				System.out.println("이미 일시정지 상태 입니다!");
			}
		} else if (Input.equals(RERUN)) {
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
		input.isInputRun = false;
		// 이거하니깐 메뉴입력 안뜸
		inputThread.interrupt();

		int getSeconds = watch.getSecond();
		int minute = getSeconds / 60;
		int second = getSeconds % 60;

		System.out.printf(">>>> %d분 %d초 소요됨", minute, second);
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
