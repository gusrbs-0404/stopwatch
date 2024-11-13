package stopWatch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Input implements Runnable {
	protected StringBuffer buffer = new StringBuffer();

	protected BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	boolean isInputRun = true;

	@Override
	public void run() {
		while (isInputRun) {
			try {
				String userInput = input("메뉴입력: ");
				if (userInput != null) {
					Stopwatch.getInstance().inputMenu(userInput);
				}
			} catch (Exception e) {
				isInputRun = false;
			}
		}
	}

	public String input(String message) {
		String input = "";
		try {
			writer.write(message);
			writer.flush();
			input = reader.readLine();
		} catch (Exception e) {
		}
		return input;
	}

}
