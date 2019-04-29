import java.io.IOException;
import java.io.InputStreamReader;

public class q {

	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		StringBuilder buf = new StringBuilder();
		int l = 0;

		while (true) {
			boolean b = false;
			buf = new StringBuilder();
			int ret;
			while (true) {
				ret = in.read();
				if (ret == -1)
					break;
				char c = (char) ret;
				buf.append(c);
				if (!((c != '!') && (c != '?') && (c != '.')))
					break;
			}

			for (int i = 0; i < buf.length(); i++) {
				if ((!b) && (Character.isAlphabetic(buf.charAt(i)))) {
					b = true;
					if (!Character.isUpperCase(buf.charAt(i)))
						l++;
				} else {
					if ((Character.isUpperCase(buf.charAt(i)) && (Character.isAlphabetic(buf.charAt(i - 1)))))
						l++;
				}
			}
			if (ret == -1)
				break;
		}
		System.out.println(l);
	}
}