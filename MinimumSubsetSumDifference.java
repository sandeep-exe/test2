import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDifference {

	public static void main(String[] args) {
		int[] wt = new int[] { 1, 1, 4, 2, 2 };
		int n = wt.length;

		int sum = 0;

		for (int i : wt) {
			sum += i;
		}
		
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

//		for (boolean[] x : dp) {
//			for (boolean y : x) {
//				System.out.print(y + " ");
//			}
//			System.out.println();
//		}

		List<Integer> list = new ArrayList<>();

		for (int j = 1; j <= sum / 2; j++) {
			if (dp[n][j]) {
				list.add(j);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i : list) {
			min = Math.min(min, sum - 2 * i);
		}

		System.out.println(min);
	}
}
