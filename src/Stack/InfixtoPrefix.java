package Stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixtoPrefix
{
    public static int prec(char c)
    {
        if(c=='^')
            return 3;
        else if(c=='/' || c=='*')
            return 2;
        else if(c=='+' || c=='-')
            return 1;
        else
            return -1;
    }
    public static String infixtopostfix(String str)
    {
        java.util.Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i= str.length()-1;i>=0;i--)
        {
            char c = str.charAt(i);
            if(c==' ')
                continue;
            else if(Character.isLetterOrDigit(c))
            {
                sb.append(c);
            }
            else if(c=='(')
            {
                st.push(c);
            }
            else if(c==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    sb.append(st.pop());
                }
                st.pop();
            }
            else
            {
                while(!st.isEmpty() && prec(c)<= prec(st.peek()))
                {
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }

        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = infixtopostfix(str);
        System.out.println(ans);
    }
}
