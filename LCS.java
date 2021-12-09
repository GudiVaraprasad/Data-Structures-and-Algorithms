import java.util.*;

class LCS
{
	public void lcs(String X, String Y, int m, int n)
	{
		int[][] L = new int[m+1][n+1];
		for (int i=0; i<=m; i++)
		{
			for (int j=0; j<=n; j++)
			{
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X.charAt(i-1) == Y.charAt(j-1))
					L[i][j] = L[i-1][j-1] + 1;
				else
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
			}
		}
		int index = L[m][n];
		int temp = index;
		char[] lcs = new char[index+1];
		lcs[index] = '\u0000';
		int i = m;
		int j = n;
		while (i > 0 && j > 0)
		{
			if (X.charAt(i-1) == Y.charAt(j-1))
			{
				lcs[index-1] = X.charAt(i-1);
				i--;
				j--;
				index--;	
			}
			else if (L[i-1][j] > L[i][j-1])
				i--;
			else
				j--;
		}
		System.out.print("\nLongest Common Subsequence is : ");
		for(int k=0;k<=temp;k++)
        {
			System.out.print(lcs[k]);
        }
        System.out.print("\nLength of LCS is : " + temp);
	}
	public static void main (String[] args)
	{
        Scanner in = new Scanner(System.in);
        System.out.print("Enter String 1 : ");
        String text1 = in.nextLine();
        int len1 = text1.length();
        
        System.out.print("\nEnter String 2 : ");
        String text2 = in.nextLine();
        int len2 = text2.length();

        LCS obj = new LCS();
		obj.lcs(text1, text2, len1, len2);
	}
}
