
public class CountNumOfSubsetWithGivenDiff {

	public static void main(String[] args) {
		int[] wt = new int[] { 1, 1, 2, 3 };
		int n = wt.length;

		int diff = 1;
		int sum = 0;

		for (int i : wt) {
			sum += i;
		}
		
		if(Math.abs(diff) > sum || (diff + sum)%2 !=0 ) {
			System.out.println(0);
	     }

		int x = (diff + sum) / 2;

		int[][] dp = new int[n + 1][x + 1];

		// dp init
		for (int i = 0; i <= x; i++)
			dp[0][i] = 0;

		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;

		
		for (int i = 1; i < n + 1; i++) {
			// j = 0, To handle 0 as input in the array https://leetcode.com/problems/target-sum/
			for (int j = 0; j < x + 1; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - wt[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n][x]);
	}
}
