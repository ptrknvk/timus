import java.util.Scanner;

public class 1026 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		long x, y = 0, amntOfSqr = 0, r;

		r = in.nextLong();
		x = r;

		while (y < r) {
			while (x * x >= r * r - y * y && x >= 0)
				x--;
			amntOfSqr += (x + 1);
			y++;
		}

		amntOfSqr *= 4;
		System.out.println(amntOfSqr);

	}

}