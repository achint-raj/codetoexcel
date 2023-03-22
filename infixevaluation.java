// 1. You are given an infix expression.
// 2. You are required to evaluate and print it's value.
// Constraints
// 1. Expression is balanced
// 2. The only operators used are +, -, *, /
// 3. Opening and closing brackets - () - are used to impact precedence of operations
// 4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
// 5. In two operators of equal precedence give preference to the one on left.
// 6. All operands are single digit numbers.

// Sample Input
// 2 + 6 * 4 / 8 - 3

// Sample Output
// 2
//link -- https://www.youtube.com/watch?v=cv_kPZnMxdA&list=TLGGpXt74PPja_YyNTAzMjAyMw

//Solution:
import java.util.*;
class infixevaluation {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
       // System.out.println("Enter the expression:");
        String exp = in.nextLine();

        //first of all we will make 2 stacks one which will contains all the operands, and another which contain all the operators.
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        //now 2nd we are going to scan each element and put it either in the operands stack or the operator stack
        for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);
        if(ch == '('){
        operators.push(ch);
        }
        else if(Character.isDigit(ch)){
        operands.push(ch - '0');
        }
        else if(ch == ')'){
        while(operators.peek()!=')'){
            char oprtr = operators.pop();
            int v2 = operands.pop();   //v2 wala upar wala value hai
            int v1 = operands.pop();   //v1 wala niche vala value hai
            int opval = operation(v1, v2, oprtr);
            operands.push(opval);
        }
        operators.pop();
        }
        else if(ch == '+' || ch == '-'|| ch == '*'|| ch == '/'){
            //ch is wanting higher priority to solve first
         while(operators.size()>0 && operators.peek()!='(' && precedence(ch) <= precedence(operators.peek())){
         char oprtr = operators.pop();
            int v2 = operands.pop();   //v2 wala upar wala value hai
            int v1 = operands.pop();   //v1 wala niche vala value hai
            int opval = operation(v1, v2, oprtr);
            operands.push(opval);
        }
        //ch is pushing itself now
        operators.push(ch); 
        }

        }
        while(operators.size()>0){
        char oprtr = operators.pop();
            int v2 = operands.pop();   //v2 wala upar wala value hai
            int v1 = operands.pop();   //v1 wala niche vala value hai
            int opval = operation(v1, v2, oprtr);
            operands.push(opval);   
        }
        System.out.println(operands.peek());

    }
    public static int precedence(char oprtr)// for solving the expression we need to keep in mind the precedence of operators , so for this we are making a function which helps to solve the expression       
    {
    if(oprtr == '+'){
    return 1;
    }
    else if(oprtr == '-')
    return 1;
    else if(oprtr == '*')
    return 2;
    else 
    return 2;
    }

    public static int operation(int v1, int v2, char oprtr)  //this function is created for solving 
     {   if(oprtr == '+')
    return v1 + v2;
    else if(oprtr == '-')
    return v1 - v2;
    else if(oprtr == '*')
    return v1 * v2;
    else 
    return v1 / v2;
    }
}