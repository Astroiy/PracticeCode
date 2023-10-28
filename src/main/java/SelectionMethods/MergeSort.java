package SelectionMethods;

import java.util.Arrays;

public class MergeSort {

    // 归并排序
    public static void mergeSort(int[] arr1,int start, int end) {
        if (arr1 == null || arr1.length == 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        // 认为mergeSort方法会把一个数组排好序，则将数组分成左右两部分，再调用mergeSort将两个子列排好序，然后使用将两个子列合并的方法
        mergeSort(arr1,start,(start + end)/2);
        mergeSort(arr1,(start + end)/2+1,end);
        // 将两个有序数组合并的方法 O (m+n)
        merge(arr1,start,(start + end)/2,end);
    }


    public static void merge (int[] arr, int start, int mid, int end) {
        // 认为start到mid有序，mid+1到end有序
        int[] copy = Arrays.copyOfRange(arr, start, end+1);
        // 指向左半区的指针和右半区起始的指针
        int i = start;
        int j = mid + 1;
        for (int k = start; k <end+1 ; k++) {
            // 左边处理完了
            if (i > mid + 1) {
                arr[k] = copy[j-start];
                j++;
                continue;
            }
            if (j > end){
                // 右边处理完了
                arr[k] = copy[i-start];
                i++;
                continue;
            }
            // 左边大于右边
            if (copy[i-start] > copy[j-start]) {
                arr[k] = copy[j-start];
                j++;
            } else {
                arr[k] = copy[i-start];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a  = {1,3,2,4,5,6,3,4,1};
        mergeSort(a,0,9);
        System.out.println(Arrays.toString(a));
    }
}
