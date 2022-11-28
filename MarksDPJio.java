
public class MarksDPJio {
	public static void main(String[] args) {
		int D = 5, M = 3, n = 4;
		int[] marks = {1, 2, 3, 4};
		int[] time = {1, 1, 1, 1};
		int[][] dp = new int[n+1][D+1];
		
		// dp init
		for (int i = 0; i <= D; i++)
			dp[0][i] = 0;

		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < D + 1; j++) {
				if(time[i-1] <= j) {
					dp[i][j] = Math.max(marks[i-1] + dp[i-1][j-time[i-1]], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][D]);
		
		if(dp[n][D] <=M) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

		for (int[] x : dp) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}
}
