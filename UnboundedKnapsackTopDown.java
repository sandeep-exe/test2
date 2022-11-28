
public class UnboundedKnapsackTopDown {

	public static void main(String[] args) {
		int W = 100;
		int val[] = { 10, 30, 20 };
		int wt[] = { 5, 10, 15 };
		int n = val.length;

		int[][] dp = new int[n + 1][W + 1];

		// dp init
		for (int i = 0; i <= W; i++)
			dp[0][i] = 0;

		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;
		
		
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<W+1; j++) {
				if(wt[i-1] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i][j - wt[i-1]]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][W]);
	}

}
