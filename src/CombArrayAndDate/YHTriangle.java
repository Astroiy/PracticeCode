package CombArrayAndDate;

import java.util.*;
public class YHTriangle {
    public static int combination(int k,int l){  //组合数计算
        int result = 1;
        for(int c =1;c<=l;c++)
            result=result*(k-c+1)/c;
        return result;
    }
    public static void main(String[] args){    //构造杨辉三角
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = in.nextInt();                 //输入杨辉三角层数
        int [][] Tri = new int[n][];
        for(int i=1;i<=n;i++)
            Tri[i-1] = new int[i];            //声明每一个子数列的长度(每一行列数)
        for(int i=0;i<n;i++)
            for(int j = 0;j<=i;j++)
                Tri[i][j]=combination(i,j);
        for(int[] row:Tri) {
            for (int col : row)
                System.out.printf("%4d",col);
            System.out.println();
        }
        System.out.println(Arrays.deepToString(Tri));
    }
}
