package stopWatch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Watch implements Runnable {

	protected int second;

	protected boolean istimeRun = true;

	protected void printTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");

		String dateInfo = sdf.format(cal.getTime());
		System.out.println(dateInfo + "(" + second + "초)");
	}

	@Override
	public void run() {
		while (istimeRun) {
			second++;
			printTime();

			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				istimeRun = false;
			}

		}
	}
}
