import java.util.*;
class OptimalBST
{
    static int sum(int freq[], int left, int right)
    {
        int sum = 0;
        for (int i=left; i <= right; ++i)
        {
            sum += freq[i];
        }
        return sum;
    }

    static int TotalMinCost(int freq[], int i, int j)
    {
        if (i > j) 
            return 0;
        
        int minTCost = Integer.MAX_VALUE;
        
        for (int k = i; k <= j; ++k)
        {
            int tCost = ( TotalMinCost(freq, i, k-1) 
                             + TotalMinCost(freq, k+1, j)
                             + sum(freq, i, j));
            
            if (tCost < minTCost)
                minTCost = tCost;
        }
        
        return minTCost;
    }

    static int computations(int keys[], int freq[], int num_keys)
    {
        return TotalMinCost(freq, 0, num_keys-1);
    }

    public static void main (String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of Keys : ");
        int keyCount = in.nextInt();

        System.out.print("Enter Keys : ");
        int[] keys = new int[keyCount];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = in.nextInt();
        }

        System.out.print("Enter Frequencies : ");
        int[] freq = new int[keyCount];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = in.nextInt();
        }
        System.out.println("-------------------------------------");

        System.out.print("Key Numbers : ");
        for (int i = 0; i < freq.length; i++) {
            System.out.print((i+1) + " ");
        }

        System.out.print("\nKeys : ");
        for (int i = 0; i < freq.length; i++) {
            System.out.print(keys[i] + " ");
        }

        System.out.print("\nFrequencies : ");
        for (int i = 0; i < freq.length; i++) {
            System.out.print(keys[i] + " ");
        }
    
        System.out.println("\n\nTotal cost of Optimal BST = " + computations(keys, freq, keyCount));
        System.out.println();
    }
}