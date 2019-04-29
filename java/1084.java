import java.util.Scanner;

public class kozel {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		double d = in.nextDouble() / 2;
		double r = in.nextDouble();
		double s = Math.PI * r * r;

		if (d >= r) {
			System.out.printf("%1$.3f", s);
			return;
		}

		if (r >= d * Math.sqrt(2)) {
			System.out.printf("%1$.3f", 4 * d * d);
			return;
		}

		// double f = 2 * Math.acos(d / r);
		// double sSeg = 0.5 * r * r * (f - Math.sin(f));
		// s -= 4 * sSeg;

		double l = 2 * Math.sqrt(r * r - d * d);
		double sTr = 0.5 * d * l;
		double f = Math.asin(2 * sTr / (r * r));
		double sSec = r * r * f / 2;
		double sSeg = sSec - sTr;

		System.out.printf("%1$.3f", s - 4 * sSeg);

	}
}