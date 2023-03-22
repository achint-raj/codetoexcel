// 1. You are given an infix expression.
// 2. You are required to convert it to postfix and print it.
// 3. You are required to convert it to prefix and print it.
// Constraints
// 1. Expression is balanced
// 2. The only operators used are +, -, *, /
// 3. Opening and closing brackets - () - are used to impact precedence of operations
// 4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
// 5. In two operators of equal precedence give preference to the one on left.
// 6. All operands are single digit numbers.
// Sample Input
// a*(b-c+d)/e
// Sample Output
//  abc-d+*e/
//  /*a+-bcde


//soved successfully on gfg I did it:-- link-->  https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article


import java.util.*;

//import javax.lang.model.util.*;
public class infixconversion {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);
        if(ch == '('){
            operators.push(ch);
        }
        else if((ch >= '0' && ch <= '9')||(ch >= 'a' && ch <= 'z')||(ch >= 'A' && ch <= 'Z')){
        pre.push(ch+"");
        post.push(ch+"");
        }
        else if(ch == ')'){
        while(operators.size()>0 && operators.peek()!='('){    //operators.size()>0 condition must be added otherwise it will not give appropriate results in some of the test cases.

            char oprtr = operators.pop();
            String prev2 = pre.pop();
            String prev1 = pre.pop();
            String preval = oprtr + prev1 + prev2;
            pre.push(preval);
        
            String postv2 = post.pop();
            String postv1 = post.pop();
            String postval = postv1 + postv2 + oprtr;
            post.push(postval);
            
        }if(operators.size()>0)   //this conditions need to be added otherwise it will not give appropriate results in some cases.
        operators.pop();
        }
        else if(ch == '+'  || ch == '-'|| ch == '*' || ch == '/'){
        while(operators.size()>0 && operators.peek()!='(' && precedence(ch) <= operators.peek()){
            char oprtr = operators.pop();
            String prev2 = pre.pop();
            String prev1 = pre.pop();
            String preval = oprtr + prev1 + prev2;
            pre.push(preval);

            String postv2 = post.pop();
            String postv1 = post.pop();
            String postval = postv1 + postv2 + oprtr;
            post.push(postval);
        }
        operators.push(ch);
        }
        }
        while(operators.size()>0){
            char oprtr = operators.pop();
            String prev2 = pre.pop();
            String prev1 = pre.pop();
            String preval = oprtr + prev1 + prev2;
            pre.push(preval);

            String postv2 = post.pop();
            String postv1 = post.pop();
            String postval = postv1 + postv2 + oprtr;
            post.push(postval);
        }
        System.out.println(post.peek());
        System.out.println(pre.peek());
    }
    public static int precedence(char ch){
        if(ch == '+')
        return 1;
        else if(ch == '-')
        return 1;
        else if(ch == '*')
        return 2;
        else if(ch == '/')
        return 2;
        else 
        return 0;
    }
}
