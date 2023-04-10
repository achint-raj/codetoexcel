import java.util.*;

public class oopsswapgame2 {
    public static class person{
    int age;
    String name;

    void sayHi(){
        System.out.println(name+"["+ age + "] sayshi");
    }
    }
    public static void main(String args[]){
       person p1 = new person();
       p1.age = 10;
       p1.name = "A";
      // p1.sayHi();

       person p2 = new person();
       p2.age = 20;
       p2.name = "B";
      // p2.sayHi();

      p1.sayHi();
      p2.sayHi();

       swap1(p1,p2);
       p1.sayHi();
       p2.sayHi();
    }
    public static void swap1(person pr1, person pr2){
        int age = pr1.age;
        pr1.age = pr2.age;
        pr2.age = age;

        String name = pr1.name;
        pr1.name = pr2.name;
        pr2.name = name;


    
    }
}
