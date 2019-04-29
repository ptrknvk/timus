import java.util.Scanner;

public class T1404 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i;
		String s1 = "", s0 = in.next();
		int a[][] = new int[3][s0.length()];
		char b[] = new char[s0.length()];
		for (i = 0; i < s0.length(); i++)
			a[0][i] = s0.charAt(i) - 97;
		if (a[0][0] >= 5)
			a[1][0] = a[0][0];
		else
			a[1][0] = a[0][0] + 26;
		a[2][0] = a[1][0] - 5;
		for (i = 1; i < s0.length(); i++) {
			a[1][i] = a[0][i] + 26;
			a[2][i] = ((a[1][i] - a[1][i - 1]) + 26) % 26;
		}
		for (i = 0; i < s0.length(); i++) {
			int z = a[2][i] + 97;
			b[i] = 0;
			for (int k = 0; k < z; k++)
				b[i]++;
			s1 = s1 + b[i];
		}
		System.out.println(s1);
	}

}