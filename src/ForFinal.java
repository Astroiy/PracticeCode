import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/** A {@code ForFinal} object represent a trail of final modifier.*/
public class ForFinal {

    static final int[] i = new int[3];
    final ArrayList<Object> array0 = new ArrayList<>();

    public void change_n(final int n){
    }

    public void exchange_ab(int n,int m){
        int tmp;
        tmp=n;
        n=m;
        m=tmp;
    }


    public static class Test{
        public static void main(String[] args){
            ForFinal f = new ForFinal();

            final StringBuilder builder = new StringBuilder();
            builder.append("String0");
            builder.append("String1");
            builder.append("String2");
            String s = builder.toString();
            System.out.println(s);

            final int[] array = new int[3];
            System.out.println(Arrays.toString(array));
            array[1]=1;
            System.out.println(Arrays.toString(array));

            final  Integer i ;
            final  int j;
            i=2;
            j=1;
            System.out.println(i);
            System.out.println(j);

            int a = 1;
            int b = 2;
            f.exchange_ab(a,b);
            System.out.println(a+""+b);

            System.out.println(Arrays.toString(f.i));
            System.out.println(f.array0);
        }
    }
}
