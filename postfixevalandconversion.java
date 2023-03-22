// 1. You are given a postfix expression.
// 2. You are required to evaluate it and print it's value.
// 3. You are required to convert it to infix and print it.
// 4. You are required to convert it to prefix and print it.

// Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
// Constraints
// 1. Expression is a valid postfix expression
// 2. The only operators used are +, -, *, /
// 3. All operands are single digit numbers.
// Format
// Input
// Input is managed for you

// Output
// value, a number
// infix
// prefix

// Sample Input

// 264*8/+3-

// Sample Output
// 2
// ((2+((6*4)/8))-3)
// -+2/*6483

import java.io.*;
import java.util.*;

public class postfixevalandconversion{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<Integer> vs = new Stack<>();   //vs is value stack
    Stack<String> is = new Stack<>();          //is here means infix stack    
    Stack<String> ps = new Stack<>();          //ps  here means prefix stack
    // code

    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);  //only two things possible whether it eill be an operand or an operator.
        if(ch == '+'|| ch == '-' || ch == '/'|| ch == '*'){  //this in case of operators
        int v2 = vs.pop();
        int v1 = vs.pop();
        int val = operation(v1,v2,ch);

        vs.push(val);


        String ival2 = is.pop();
        String ival1 = is.pop();
        String ival = "(" + ival1 + ch + ival2 + ")";
        is.push(ival);
         
        String pval2 = ps.pop();
        String pval1 = ps.pop();
        String pval = ch + pval1 + pval2;
        ps.push(pval);

        }
        else{// this in case of operands
            vs.push(ch - '0');
            is.push(ch + "");
            ps.push(ch + "");

        }
    }
    System.out.println(vs.pop());
    System.out.println(is.pop());
    System.out.println(ps.pop());

 }
 public static int operation(int v1, int v2, char op){
     if(op == '+'){
     return v1 + v2;
     }
     else if(op == '-'){
     return v1 - v2;
     }
     else if(op == '/'){
     return v1 / v2;
     }else if(op == '*'){
     return v1 * v2;
     }
     else return 0;
 }
}