public class output_q{
    static int method(int num){
        if(num == 1)
        return 1;
        else 
        return(method(num)+method(num-1));
    }
    public static void main(String args[]){
        System.out.print(method(3));
    }
}
// just for checking whether it shoes stack overflow error or not , it shows it.