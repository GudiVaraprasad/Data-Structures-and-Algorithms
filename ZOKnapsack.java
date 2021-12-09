import java.util.*;

public class ZOKnapsack {
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static int knapSack(int W, int weight[], int value[], int n) {
		int i, w;
		int[][] K = new int[n + 1][W + 1];

		for (i = 0; i<= n; i++) {
			for (w = 0; w<= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (weight[i - 1]<= w)
					K[i][w] = max(value[i - 1] + K[i - 1][w - weight[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}
		return K[n][W];
	}
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter the no. of items : ");
		int n = in.nextInt();
		int[] value = new int[n];
		int[] weight = new int[n];
		System.out.print("\nEnter the item's weight and its value \n");
		for (int i = 0; i<n; i++) {
			weight[i] = in.nextInt();
			value[i] = in.nextInt();
		}
		System.out.print("\nEnter the capacity of the bag : ");
		int W = in.nextInt();
		System.out.print("\n\nMaximum allowance in bag : " + knapSack(W, weight, value, n));
		System.out.println();
	}
}