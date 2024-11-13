package stopWatch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Watch {

	protected int second;

	protected void printTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");

		String dateInfo = sdf.format(cal.getTime());
		System.out.println(dateInfo + "(" + second + "초)");
	}
}
