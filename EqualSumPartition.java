
public class EqualSumPartition {

	public static void main(String[] args) {
		int[] wt = new int[] { 2, 3, 7, 8, 10 };
		int sum = 0; 
		
		for(int i: wt) {
			sum+=i;
		}
		
		if(sum%2 == 1) {
			System.out.println(false);
			return;
		}
		
		System.out.println(subsetSum(wt, sum/2));
	}
	
	public static boolean subsetSum(int[] wt, int sum) {
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
		
		return dp[n][sum];
	}
}
 