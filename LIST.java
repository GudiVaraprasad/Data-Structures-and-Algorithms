import java.util.*;
import java.io.*;
public class LIST
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) 
        {
            int value = scan.nextInt();
            list.add(value);
        }
        
        int Q = scan.nextInt();
        for (int i = 0; i < Q; i++) 
        {
            String action = scan.next();
            if (action.equals("Insert")) 
            {
                int index = scan.nextInt();
                int value = scan.nextInt();
                list.add(index, value);
            } 
            else 
            { 
                int index = scan.nextInt();
                list.remove(index);
            }
        }
        
        for (Integer num : list) 
        {
            System.out.print(num + " ");
        }
    }
}
