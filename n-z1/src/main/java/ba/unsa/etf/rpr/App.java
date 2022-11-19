package ba.unsa.etf.rpr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        ExpressionEvaluator e=new ExpressionEvaluator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {

            try {
                System.out.println("Unesite izraz:");
                String k=reader.readLine();
                String[] str = k.split(" ");
                int t=0;
                boolean t1=false;
                for(int i=0;i<str.length;i++)
                {
                    String reg = "([0-9]*).*([0-9]*)";
                    t1 = Pattern.matches(reg, str[i]);
                    if (str[i].equals("("))              continue   ;
                    else if (str[i].equals("+")) continue;
                    else if (str[i].equals("-")) continue;
                    else if (str[i].equals("*")) continue;
                    else if (str[i].equals("/")) continue;
                    else if (str[i].equals("sqrt")) continue ;
                    else if (str[i].equals(")")) continue;
                    else if(t1) continue;;
                    System.out.println("Nesipravni parametri!");
                    t=1;
                }
                if(t==0)
                {
                    System.out.println(  e.evaluate( k));
                    break;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            catch (RuntimeException e3)
            {
                e3.printStackTrace();
            }
        }
    }
}
