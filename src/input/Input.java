package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static String readString() {
		String inputLine = "";
		try {
			inputLine = reader.readLine();
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		return inputLine;
	}

	public static String readString(String msg) {
		System.out.print(msg);
		String inputLine = readString();
		return inputLine;
	}

	public static int readInt() {
		String inputString = readString();
		inputString = inputString.trim();
		int n = Integer.parseInt(inputString);
		return n;
	}

	public static int readInt(String msg) {
		System.out.print(msg);
		int n = readInt();
		return n;
	}

}
