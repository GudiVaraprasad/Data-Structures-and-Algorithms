import java.util.Scanner;
public class MergeSort
{
    public static void main(String args[])
    {
        System.out.print("Enter the size of array: ");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++)
        {
            a[i]=in.nextInt();
        }

        mergesort(a,n);
        System.out.println("Ascending Order - Merge Sort: ");
        for(int i=0;i<n;i++)
            System.out.println(a[i]);
    }
    
    public static void mergesort(int a[],int n)
    {
        int mid;
        int L[],R[];
        if(n<2)
        ;
        else
        {
            mid=n/2;
            L=new int[mid];
            R=new int[n-mid];
            for(int i=0;i<mid;i++)
                L[i]=a[i];
            for(int i=mid;i<n;i++)
                R[i-mid]=a[i];
            mergesort(L,mid);
            mergesort(R,n-mid);
            merge(a,L,mid,R,n-mid);  
        }
    }
    public static void merge(int a[],int L[],int l,int R[],int r)
    {
        int i,j,k;
        i=0;
        j=0;
        k=0;
        while(i<l&&j<r)
        {
            if(L[i]<R[j])
            {
                a[k]=L[i];
                i++;
            }
            else
            {
                a[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<l)
        {
            a[k]=L[i];
            i++;k++;
        }
         while(j<r)
        {
            a[k]=R[j];
            j++;k++;
        }
      
    }  
 }