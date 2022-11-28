public class KnapsackTopDown {

	public static void main(String[] args) {
		int[] val = new int[] { 1, 4, 5, 7 };
		int[] wt = new int[] { 1, 3, 4, 5 };
		int W = 7;
		int n = val.length;
		int[][] dp = new int[n + 1][W + 1];

		// dp init
		for (int i = 0; i <= W; i++)
			dp[0][i] = 0;

		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n][W]);

//		for (int[] x : dp) {
//			for (int y : x) {
//				System.out.print(y + " ");
//			}
//			System.out.println();
//		}
	}
}
