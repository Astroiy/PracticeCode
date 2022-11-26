package SelectionMethods;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static double[] sort(double[] array){
        int n = array.length;
        double temp;
        for(int i=0;i<n-1;i++)
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        return array;
    }
    public static double[] sort(double[] array,String order){
        int n = array.length;
        if(order=="Desc"){
            sort(array);
            double[] arrayd = new double[n];
            for(int i=0;i<n;i++)
                arrayd[i] = array[n-i-1];
            array = arrayd;
            return array;
        }
        else
            return array;
    }
    public static class Test{
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            double[] a = {7,2,6,9,11,8,25};
            System.out.println(Arrays.toString(SelectionSort.sort(a,"Desc")));
            System.out.println(Arrays.toString(a));
        }
    }
}
