import java.util.Scanner;

public class QA {

	public static int sort[];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		sort = new int[5000];

		for (int i = 0; i < n; i++)
			sort[in.nextInt() - 1]++;

		in.nextLine();
		in.nextLine();

		int k = in.nextInt();

		for (int i = 0; i < k; i++)
			System.out.println(whatElementInOrder(in.nextInt()));

	}

	public static int whatElementInOrder(int num) {

		int count = 0;

		for (int i = 0; i < 5000; i++) {

			count += sort[i];

			if (count >= num)
				return i + 1;

		}

		return 0;
	}

}