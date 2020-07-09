import java.io.*;

import java.util.*;

public class Main
{

  static char input[] = new char[20];

  static char stack[] = new char[20];

  static int top;


  public static void main (String args[]) throws IOException
  {

    int i, f = 0;

    InputStreamReader a = new InputStreamReader (System.in);

    BufferedReader br = new BufferedReader (a);

      System.out.println ("enter the parenthesis string ends with $");

      br.read (input);

      top = -1;

      push ('$');

    {

      for (i = 0; input[i] != '$'; i++)

	{

	  if (input[i] == '{')

	    {

	      push (input[i]);

	    }


	  else if (input[i] == '}' & stack[top] == '{')

	    {

	      pop ();

	    }

	  else if (input[i] == '}' & stack[top] == '$')

	    {

	      break;

	    }

	}

    }

    if (input[i] == '$' & stack[top] == '$')

      System.out.println ("balanced parenthesis");

    else

      {

	System.out.println ("unbalanced parenthesis");

      }

  }


  public static void push (char ch)
  {

    top++;

    stack[top] = ch;

    System.out.println ("pushed" + stack[top]);

  }
  public static void pop ()
  {


    System.out.println ("popped" + stack[top]);

    top--;

  }
}
