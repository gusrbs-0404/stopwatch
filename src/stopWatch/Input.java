package stopWatch;

public class Input implements Runnable{

	@Override
	public void run() {
		
		
	}
	
	private void inputMenu() {
		String select = input("메뉴 입력");

		if (select.equals(STOP)) {
			stop();
		} else if (select.equals(HOLD)) {
			if (log == HOLDNUMBER) {
				hold();
			} else {
				System.out.println("이미 일시정지 상태 입니다!");
			}
		} else if (select.equals(RERUN)) {
			if (log == RERUNNUMBER) {
				rerun();
			} else {
				System.out.println("타이머가 작동중입니다!");
			}
		} else {
			System.out.println("메뉴를 잘못입력했습니다.");
		}
	}
}
