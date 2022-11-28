public class KnapsackRecursive {

	public static void main(String[] args) {
		int[] val = new int[] { 1, 4, 5, 7 };
		int[] wt = new int[] { 1, 3, 4, 5  };
		int W = 7;
        int n = val.length;
        System.out.println(knapSack(wt, val, W, n));
	}
	
	public static int knapSack(int[] wt, int[] val, int W, int n) {
		// Base Condition 
		if(n == 0 || W == 0) return 0;
		
		if(wt[n-1] <= W) {
			return  Math.max(val[n-1] + knapSack(wt, val, W - wt[n-1], n-1), knapSack(wt, val, W, n-1) );
		}
		
		return knapSack(wt, val, W, n-1);
	}

}
