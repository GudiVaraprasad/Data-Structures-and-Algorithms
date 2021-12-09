import java.util.*;

class HuffmanNode {
  int item;
  char c;
  HuffmanNode left;
  HuffmanNode right;
}

// For comparing the nodes
class ImplementComparator implements Comparator<HuffmanNode> {
  public int compare(HuffmanNode x, HuffmanNode y) {
    return x.item - y.item;
  }
}

// IMplementing the huffman algorithm
public class Huffman {
  public static void printCode(HuffmanNode root, String s) {
    if (root.left == null && root.right == null && Character.isLetter(root.c)) {

      System.out.println(root.c + " \t " + s);

      return;
    }
    printCode(root.left, s + " 0 ");
    printCode(root.right, s + " 1 ");
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.print("\nEnter the Text : ");
    String txt = in.nextLine();
    int n = txt.length();
    char[] charArray = txt.toCharArray();

    System.out.print("\nCharacter Array is : ");
    for (int i = 0; i < charArray.length; i++)
    {
      System.out.print(charArray[i] + " ");
    }

    int[] charfreq = new int[n];
    System.out.print("\nEnter character frequencies : ");
    for (int i = 0; i < charfreq.length; i++) {
      charfreq[i] = in.nextInt();
    }

    PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

    for (int i = 0; i < n; i++) 
    {
      HuffmanNode hn = new HuffmanNode();
      hn.c = charArray[i];
      hn.item = charfreq[i];
      hn.left = null;
      hn.right = null;
      q.add(hn);
    }

    HuffmanNode root = null;
    while (q.size() > 1) 
    {
      HuffmanNode x = q.peek();
      q.poll();
      HuffmanNode y = q.peek();
      q.poll();
      HuffmanNode f = new HuffmanNode();
      f.item = x.item + y.item;
      f.c = '-';
      f.left = x;
      f.right = y;
      root = f;
      q.add(f);
    }
    System.out.println(" Char \t Huffman code ");
    System.out.println("-----------------------------");
    printCode(root, "");
  }
}