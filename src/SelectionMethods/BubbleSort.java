package SelectionMethods;
import java.util.Arrays;

public class BubbleSort {
    public static double[] sort(double[] array){
        int n = array.length;
        for(int i=0;i<n-1;i++){
            boolean b = true;
            for(int j=0;j<n-i-1;j++){
                if(array[j]>array[j+1]){
                    var temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    b = false;
                }
            }
            if(b == true)
                break;
        }
        return array;
    }
    public static class Test{
        public static void main(String[] args){
            double[] a = {7,12,6,9,11,8,25};
            System.out.println(Arrays.toString(BubbleSort.sort(a)));
        }
    }
}
