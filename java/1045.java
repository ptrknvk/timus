import java.util.Scanner;

public class Terr {

	public static void main(String[] args) {
		new Terr().run();
	}

	public static int gr[][];
	public static boolean _isWin[];
	public static boolean haveBeenHere[];
	public static int n;

	public void run() {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		int q = in.nextInt() - 1;

		gr = new int[n][n];

		_isWin = new boolean[n];

		haveBeenHere = new boolean[n];

		for (int i = 0; i < n; i++)
			haveBeenHere[i] = false;

		for (int i = 0; i < n - 1; i++) {
			int a = in.nextInt() - 1, b = in.nextInt() - 1;
			gr[a][b] = 1;
			gr[b][a] = 1;
		}

		for (int i = 0; i < n; i++) {
			int l = 0;
			for (int j = 0; j < n; j++)
				l += gr[i][j];

			if (l == 1 && i != q) {
				haveBeenHere[i] = true;
				_isWin[i] = false;
			}

		}

		// System.out.println(condition(q));
//
//		for (int j = 0; j < n; j++) {
//			if (q != j) {
//				if (gr[q][j] == 1 && q != j) {
//					boolean c = isWin(j);
//					System.out.println(c + " " + (j + 1));
//
//					if (!c) {
//						System.out
//								.println("First player wins flying to airport "
//										+ (j + 1));
//						return;
//					}
//				}
//			}
//		}
//		System.out.println("First player loses");

		// System.out.println(isWin(q, -1));
		for (int i = 0; i < n; i++) {
			if (gr[q][i] == 1 && q != i)
				if (!isWin(i, q)) {
					System.out.println("First player wins flying to airport " + (i + 1));
					return;
				}
		}
		System.out.println("First player loses");
	}

	public static boolean isWin(int i, int par) {

		if (haveBeenHere[i])
			return _isWin[i];

		haveBeenHere[i] = true;

		_isWin[i] = false;
		for (int j = 0; j < n; j++)
			if (gr[i][j] == 1)
				if (j != par)
					_isWin[i] |= !isWin(j, i);

		return (_isWin[i]);

	}
}