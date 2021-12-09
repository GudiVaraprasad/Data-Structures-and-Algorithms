import java.util.*;

public class MatrixChainMultiplication
{
    void matrixchain(int a[])
    {
        int q;
        int n=a.length;
        int m[][]=new int[n][n];
        int s[][]=new int[n][n];
        for (int i=1;i<n;i++)
            m[i][i]=0;
        for (int l=2;l<n;l++)
        {
           for(int i=1 ;i<n-l+1;i++)
           {
             int j=i+l-1;
             m[i][j]=Integer.MAX_VALUE;
             for (int k=i ;k<=j-1;k++)
             {
                q=m[i][k]+m[k+1][j]+a[i-1]*a[k]*a[j];
                if(q<m[i][j])
                {
                    m[i][j]=q;
                    s[i][j]=k;
                }
             }
           }
        }
        
        System.out.println("\nMemoization Table : ");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(m[i][j]+" ");
           System.out.println();
        }
        System.out.println("\nMatrix Chain Multiplication Parenthesization : ");
        print_optimal(s,1,6);
    }
   void print_optimal(int s[][],int i,int j)
    {
        if (i==j)
            System.out.print("A"+i);
        else
        {
            System.out.print("(");
            print_optimal(s,i,s[i][j]);
            print_optimal(s,s[i][j]+1,j);
            System.out.print(")");
        }
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of matrices : ");
        int countChain = in.nextInt();
        countChain = countChain+1;

        int[] chain = new int[countChain];
        
        System.out.print("Enter the Matrix dimensions chain : ");
        for (int i = 0; i < chain.length; i++)
        {
            chain[i] = in.nextInt();
        }
        // 10 20 30 40 50 60 70
        
        /* A1:- 10x20, 
        A2:- 20x30, 
        A3:- 30x40, 
        A4:- 40x50 , 
        A5:- 50x60, 
        A6:- 60x70 */
        
        // 30, 35, 15, 5, 10, 20, 25
        // A1:- 30x35, A2:- 35x15, A3:- 15x5, A4:- 5x10 , A5:- 10x20, A6:- 20x25

        MatrixChainMultiplication obj=new MatrixChainMultiplication();
        obj.matrixchain(chain);
    }
}