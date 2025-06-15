package Stack;
import java.util.*;
import java.util.Stack;

public class BracketBalancing
{
    public static void main(String[] args)
    {
         Scanner sc=new Scanner(System.in);
         String str = sc.nextLine();
         Stack<Character> st = new Stack<>();
         for(char c:str.toCharArray())
         {
             if(c=='[' || c=='{' || c=='(')
                 st.push(c);
             else if(!st.isEmpty() && (
                     c=='}' && st.peek()=='{' ||
                             c==']' && st.peek()=='[' ||
                             c==')' && st.peek()=='('
                     ))
             {
                 st.pop();
             }
             else
                 st.push(c);
         }

         if(st.isEmpty())
         {
             System.out.println("Bracket Balanced");
         }
         else
         {
             System.out.println("Bracket Not Balanced");
         }
    }
}
