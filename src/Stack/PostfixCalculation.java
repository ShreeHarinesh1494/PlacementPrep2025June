package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixCalculation
{
    public static int Evaluation(String str)
    {
        Stack<Integer> st = new Stack<>();
        for(char c:str.toCharArray())
        {
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
