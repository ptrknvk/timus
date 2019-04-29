import java.io.IOException;
import java.io.InputStreamReader;

public class q {

	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		StringBuilder buf = new StringBuilder();
		while (true) {
			int ret = in.read();
			if (ret == -1)
				break;
			char c = (char) ret;
			if (Character.isAlphabetic(c))
				buf.append(c);
			else {
				for (int i = buf.length() - 1; i > -1; i--)
					System.out.print(buf.charAt(i));
				System.out.print(c);
				buf = new StringBuilder();
			}
		}
		for (int i = buf.length() - 1; i > -1; i--)
			System.out.print(buf.charAt(i));
	}
}