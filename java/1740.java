import java.util.Scanner;

public class Olen {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int k = in.nextInt();
		int h = in.nextInt();
		int min = 0, max = 0;

		if (l % k == 0) {
			min = l / k * h;
			max = min;
		} else {
			min = l / k * h;
			max = (l / k + 1) * h;
		}

		System.out.println(min + " " + max);

	}

}