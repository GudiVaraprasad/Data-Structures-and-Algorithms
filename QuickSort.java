import java.util.*;

public class QuickSort
{
    public void quickSort(int[] array, int start, int end)
    {
        if(start<end)
        {
            int j = partition(array, start, end);
            quickSort(array, start, j-1);
            quickSort(array, j+1, end);
        }
    }

    public int partition(int[] array, int start, int end)
    {
        int pivot = array[end];
        int i = start-1;
        for(int j=start;j<=end-1; j++)
        {
            if(array[j]<pivot)
            {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, end);
        return (i+1);
    }

    public void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void display(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");  
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of Elements : ");
        int size = in.nextInt();

        int[] array = new int[size];
        System.out.print("Enter elements of array : ");
        for (int i = 0; i < array.length; i++)
        {
            array[i] = in.nextInt();
        }
        QuickSort qsObj = new QuickSort();
        qsObj.quickSort(array, 0, size-1);
        System.out.println("Quick Sorted Array : ");
        qsObj.display(array);
    }
}