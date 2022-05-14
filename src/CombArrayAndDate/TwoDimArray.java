package CombArrayAndDate;

import java.util.*;

public class TwoDimArray {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter row n:");
        int n = in.nextInt();
        System.out.println("Enter col m:");
        int m = in.nextInt();
        int[][] result = new int[n][m];
        for(int i=0;i<n;i++)                 //利用普通的嵌套循环为二维数组result赋值
            for(int j=0;j<m;j++)
                result[i][j]=i+j;
        for(int[] row:result) {              //利用foreach语句输出二维数组,foreach只能遍历一维数组。
            for (int col : row)
                System.out.printf("%4d", col);
            System.out.println();
        }
        System.out.println(Arrays.deepToString(result));
    }
}
