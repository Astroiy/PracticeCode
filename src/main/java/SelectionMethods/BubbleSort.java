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
            if(b)
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

    // 给定两个不降序数组，把它合并成一个不降序数组
    // 冒泡的思想就是通过一个两位的滑动窗口，在移动过程中始终保持局部有序，则每一次滑到尾部都一定会捕获最值而且使最值处于尾部
    public static void merge (int[] arr1 ,int m, int[]arr2, int n) {

        // 将arr1扩容
//        int[] newArr1 = new int[m + n];
//        System.arraycopy(arr1,0,newArr1,0,arr1.length);
//        arr1 = newArr1;

        // 从arr2写入的下标开始，依次比较相邻数大小，如果不满足升序，交换位置
        for (int i=0;i<n;i++) {
            arr1[i+m] = arr2[i];
            for (int j = i + m; j > 0; j--) {
                if (arr1[j] < arr1[j-1]) {
                    // 交换位置
                    int temp = arr1[j];
                    arr1[j] = arr1[j-1];
                    arr1[j-1] = temp;
                } else {
                    //否则就说明前方已经是不降序子列,不再循环，进行下一次前推
                    break;
                }
            }
        }
    }

    // O(m+n)的实现方式
    public static void mergeV2(int[] arr1 ,int m, int[]arr2, int n) {
        // m,n有可能不大于0
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException();
        }
        int i = m-1;
        int j = n-1;
        int[] copy = Arrays.copyOf(arr1, m);
        for (int k = 0; k< n+m; k++) {
            if (i < 0 && j < 0) {
                break;
            }
            if (i < 0){
                arr1[n+m-1-k] = arr2[j];
                j--;
                continue;
            }
            if (j < 0){
                arr1[n+m-1-k] = copy[i];
                i--;
                continue;
            }
            if (copy[i] > arr2[j]) {
                arr1[n+m-1-k] = copy[i];
                i--;
            } else {
                arr1[n+m-1-k] = arr2[j];
                j--;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 5, 0, 0, 0, 0, 0, 0};
        int[] arr2  ={0, 1, 2, 2, 4, 6};

        merge(arr1,5,arr2,6);

        System.out.println(Arrays.toString(arr1));

        arr1 = new int[]{1, 2, 2, 3, 5, 0, 0, 0, 0, 0, 0};
        arr2  =new int[]{0, 1, 2, 2, 4, 6};

        mergeV2(arr1,5,arr2,6);
        System.out.println(Arrays.toString(arr1));
    }
}
