package ba.unsa.etf.rpr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionEvaluator {
    public double evaluate(String q)
    {
        String[] str = q.split(" ");
        Queue<String> q1 = new LinkedList<>();
        q1.addAll(Arrays.asList(str));
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!q1.isEmpty()) { // Read s, push if operator.
            String s = q1.poll();
            if (s.equals("("))                 ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) { // Pop, evaluate, and push result if s is ")".
                // Replace the top exp with it' result.
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else
                try {
                    double h=Double.parseDouble(s);
                    vals.push(h);
                }
                catch (Exception e)
                {
                    throw new RuntimeException("Neispravan izraz!");
                }
        }
        return vals.pop();
    }
}
