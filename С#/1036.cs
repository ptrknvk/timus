using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;


namespace ConsoleApplication1
{
	class Pair
	{

		public BigInteger A;
		public BigInteger B;
		public override int GetHashCode()
		{
			return (int)((A + B * 1233211) % 500000);
		}
		public override bool Equals(object obj)
		{
			return ((Pair)(obj)).A == A && ((Pair)(obj)).B == B;
		}
	}
	class Program
	{

		public static BigInteger dfs(Pair a, Dictionary<Pair, BigInteger> d)
		{
			if (a.B < 0)
				return 0;

			if (d.ContainsKey(a))
				return d[a];

			if (a.A == 0 && a.B == 0)
			{
				d[a] = 1;
				return 1;
			}

			if (a.A == 0 && a.B != 0)
			{ d[a] = 0;
				return 0;
			}

			BigInteger ans = 0;

			for (int i = 0; i < 10; i++)
				ans += dfs(new Pair() { A = a.A - 1, B = a.B - i }, d);

			d[a] = ans;

			return ans;

		}

		static void Main(string[] args)
		{
			String[] input = Console.ReadLine().Split();
			BigInteger n = BigInteger.Parse(input[0].ToString());
			BigInteger m = BigInteger.Parse(input[1].ToString());

			if (m % 2 == 1)
				Console.WriteLine(0);
			else
			{
				m /= 2;

				Dictionary<Pair,BigInteger> d = new Dictionary<Pair, BigInteger>();
				var x = (dfs(new Pair() { A = n, B = m }, d));
				Console.WriteLine (x * x);
			}
		}
	}
}