import java.util.*;     //implementation of queue
public class impq {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        //implementation of queue
        Queue<Integer> que = new ArrayDeque<>();
        que.add(10);
        System.out.println(que);
        que.add(20);
        System.out.println(que);
        que.add(30);
        System.out.println(que);
        que.add(40);
        System.out.println(que.peek());
        System.out.println(que);
        System.out.println(que.remove());
        System.out.println(que);
    }
}
