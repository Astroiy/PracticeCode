package AboutException.Finally;

import java.util.List;
import java.util.ListIterator;

public class TestFinally {
    public static void main(String[] args) {
        int a = get();
        System.out.println(a);
    }
    public static int get(){
        int a = 10;
        try{
            a = 20 / 0;
            return a;
        }catch(Exception e){
            a = 30;
            return a;   //1.现将a的值复制一份 2.调用finally 3.执行return a;但a的值取之前复制的那个值
        }finally{
            a=40;
        }
    }
}
