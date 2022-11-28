
public class SubsetSum {

	public static void main(String[] args) {
		int[] wt = new int[] { 2, 3, 7, 8, 10 };
		int sum = 11;
		int n = wt.length;

		boolean[][] dp = new boolean[n + 1][sum + 1];

		for (int i = 0; i < sum + 1; i++)
			dp[0][i] = false;

		for (int i = 0; i < n + 1; i++)
			dp[i][0] = true;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - wt[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n][sum]);

//		for (boolean[] x : dp) {
//			for (boolean y : x) {
//				System.out.print(y + " ");
//			}
//			System.out.println();
//		}
	}

}
