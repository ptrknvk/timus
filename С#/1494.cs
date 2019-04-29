	using System;
	using System.Collections.Generic;

	namespace monobilliard
	{
		class MainClass
		{
			public static void Main (string[] args)
		{

			if (!isCheater())
				Console.WriteLine ("Not a proof");
			else
				Console.WriteLine ("Cheater");

		}

		public static bool isCheater(){
			int n = int.Parse (Console.ReadLine ());
			billiardStack bStack = new billiardStack ();
			bStack.max = 0;
			bStack.isCheater = false;

			for (int i = 0; i < n; i++) {
				int current = int.Parse (Console.ReadLine ());

				bStack.check (current);
				}

			return bStack.isCheater;
		}
			
	}

	public class billiardStack
	{

		public int max;
		public Stack<int> stack = new Stack<int> ();
		public bool isCheater;

		public void check(int current){
			if (stack.Count == 0)
				for (int j = max + 1; j < current; j++)
					stack.Push (j);
			else if (current < stack.Peek ())
				isCheater = true;
			else if (current == stack.Peek ())
				stack.Pop ();
			else {
				for (var j = max + 1; j < current; j++)
					stack.Push (j);
			}


			if (current > max)
				max = current;
				
		}
	}


}