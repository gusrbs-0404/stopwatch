package stopWatch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Input implements Runnable {
	protected final String STOP = "q";
	protected final String HOLD = "w";
	protected final int HOLDNUMBER = 0;
	protected final String RERUN = "e";
	protected final int RERUNNUMBER = 1;

	protected String qwe = "";

	protected Scanner scan = new Scanner(System.in);

	protected StringBuffer buffer = new StringBuffer();

	protected BufferedWriter writer;

	protected BufferedReader reader;

	boolean isInputRun = true;

	@Override
	public void run() {
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public void print(String message) {
		try {
			writer.write(message);
			writer.flush();
		} catch (Exception e) {
		}
	}

	public String input() {
		String input = "";
		try {
			input = reader.readLine(); // 입력 받기
		} catch (Exception e) {
		}

		return input;
	}
}
