package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PrefixCalculation
{
    public static int Evaluation(String str)
    {
        java.util.Stack<Integer> st = new Stack<>();
        for(int i = str.length() - 1; i >= 0; i--)
        {
            char c = str.charAt(i);
            if(Character.isDigit(c))
            {
                st.push(c-'0');
            }
            else
            {
                int a = st.pop();
                int b = st.pop();

                switch(c)
                {
                    case '+':
                        st.push(b+a);
                        break;
                    case '-':
                        st.push(b-a);
                        break;
                    case '*':
                        st.push(b*a);
                        break;
                    case '/':
                        st.push(b/a);
                        break;
                    case '%':
                        st.push(b%a);
                        break;
                }
            }
        }
        return st.pop();

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = Evaluation(str);
        System.out.println(ans);
    }
}
