package stopWatch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Input extends Stopwatch {
	protected final String STOP = "q";
	protected final String HOLD = "w";
	protected final int HOLDNUMBER = 0;
	protected final String RERUN = "e";
	protected final int RERUNNUMBER = 1;

	protected String qwe = "";

	protected Scanner scan = new Scanner(System.in);

	protected StringBuffer buffer = new StringBuffer();

	protected BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	boolean isInputRun = true;
	
	@Override
	public void run() {
		//while(isInputRun) {
			
			try {
				qwe = reader.readLine(); // ?????????
				//writer.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					writer.close();
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
					isInputRun = false;
				}
			}
				
	//	}

	}
	
	

//	private void input() {
//		qwe = inputString("메뉴입력");
//		buffer.append(qwe);
//
//		try {
//			qwe = reader.readLine();
//			buffer.append(qwe);
//		
//			
//			writer.flush();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				writer.close();
//				reader.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

//	protected String inputString(String msg) {
//		while (true) {
//			System.out.println(msg + " : ");
//			String input = scan.nextLine();
//
//			if (!input.equals(""))
//				return input;
//		}
//	}
}
