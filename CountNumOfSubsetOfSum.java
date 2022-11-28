
public class CountNumOfSubsetOfSum {

	public static void main(String[] args) {
		int[] wt = new int[] { 2, 3, 5, 6, 8, 10 };
		int sum = 10;
		int n = wt.length;

		int[][] dp = new int[n + 1][sum + 1];

		// dp init
		for (int i = 0; i <= sum; i++)
			dp[0][i] = 0;
		
		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;		

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - wt[i - 1]] +  dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n][sum]);

		for (int[] x : dp) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}
}
