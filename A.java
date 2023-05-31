//checking for error non- static variable s cannot be referenced from a static context

public class A {
    static class R{
        String s = "RA!";
        R A;
        R(){
            System.out.print(A.s);
        }

    }
    public static void main(String args[]){
System.out.print(R.s);
    }
}
