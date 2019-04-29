import java.util.Scanner;

public class Ski {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int withoutTimeResults[] = new int[n];
		int bestResult[] = new int[n];
		int worstResult[] = new int[n];

		for (int i = 0; i < n; i++) {
			withoutTimeResults[i] = in.nextInt();
			bestResult[i] = 1;
			worstResult[i] = n;
		}

		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (withoutTimeResults[j] > withoutTimeResults[i])
					bestResult[withoutTimeResults[i] - 1]++;

		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (withoutTimeResults[j] < withoutTimeResults[i])
					worstResult[withoutTimeResults[i] - 1]--;

		for (int i = 0; i < n; i++)
			System.out.println(bestResult[i] + " " + worstResult[i]);
	}
}