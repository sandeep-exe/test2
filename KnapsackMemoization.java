import java.util.Arrays;

public class KnapsackMemoization {
	static int[][] dp;

	public static void main(String[] args) {
		int[] val = new int[] { 60, 100, 120 };
		int[] wt = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;

		dp = new int[n + 1][W + 1]; // [row][col]

		// dp init
		Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

		System.out.println(knapSack(wt, val, W, n));

//		for (int[] x : dp) {
//			for (int y : x) {
//				System.out.print(y + " ");
//			}
//			System.out.println();
//		}
	}

	public static int knapSack(int[] wt, int[] val, int W, int n) {
		// Base Condition
		if (n == 0 || W == 0)
			return 0;

		if (dp[n][W] != -1)
			return dp[n][W];

		if (wt[n - 1] <= W) {
			return dp[n][W] = Math.max(val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1),
					knapSack(wt, val, W, n - 1));
		}

		return dp[n][W] = knapSack(wt, val, W, n - 1);
	}

}
