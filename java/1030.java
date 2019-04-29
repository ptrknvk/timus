import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class T1030 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s[] = new String[4];
		double d[] = new double[4];
		double pi = 3.1415926535897932384626433832795028841971, R = 6875 * (1.0 / 2.0);
		NumberFormat n = NumberFormat.getInstance(Locale.UK);
		n.setMaximumFractionDigits(2);
		n.setMinimumFractionDigits(2);
		in.nextLine();
		in.nextLine();
		in.nextLine();
		String a = in.nextLine();
		int index = a.indexOf("^");
		double lat1 = ((Integer.parseInt(a.substring(0, index))
				+ Integer.parseInt(a.substring(index + 1, index + 3)) / 60.0
				+ Integer.parseInt(a.substring(index + 4, index + 6)) / 3600.0) * pi / 180.0)
				* (a.charAt(index + 8) == 'N' ? 1 : -1);
		a = in.nextLine();
		index = a.indexOf("^");
		double long1 = ((Integer.parseInt(a.substring(a.indexOf(" ") + 1, index))
				+ Integer.parseInt(a.substring(index + 1, index + 3)) / 60.0
				+ Integer.parseInt(a.substring(index + 4, index + 6)) / 3600.0) * pi / 180.0)
				* (a.charAt(index + 8) == 'W' ? -1 : 1);
		in.nextLine();
		a = in.nextLine();
		index = a.indexOf("^");
		double lat2 = ((Integer.parseInt(a.substring(0, index))
				+ Integer.parseInt(a.substring(index + 1, index + 3)) / 60.0
				+ Integer.parseInt(a.substring(index + 4, index + 6)) / 3600.0) * pi / 180.0)
				* (a.charAt(index + 8) == 'N' ? 1 : -1);
		a = in.nextLine();
		index = a.indexOf("^");
		double long2 = ((Integer.parseInt(a.substring(a.indexOf(" ") + 1, index))
				+ Integer.parseInt(a.substring(index + 1, index + 3)) / 60.0
				+ Integer.parseInt(a.substring(index + 4, index + 6)) / 3600.0) * pi / 180.0)
				* (a.charAt(index + 8) == 'W' ? -1 : 1);
		in.nextLine();
		double L = R * Math
				.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2));
		System.out.println("The distance to the iceberg: ".concat(n.format(L).replace(",", "")).concat(" miles."));
		if (100.00 - L > 0.005) {
			System.out.println("DANGER!");
		}

	}
}