package CombArrayAndDate;

import java.util.*;

public class LottryDraw {
    public static void main(String[] agrs){
        Scanner in = new Scanner(System.in);     //从控制台输入所需参数
        System.out.println("How many numbers do you need to draw?");
        int n = in.nextInt();                    //数字总数
        System.out.println("What is the highest number you can draw?");
        int m = in.nextInt();                    //抽取个数
        int[] numbers = new int[n];
        for(int i=0;i<n;i++)
            numbers[i]=i+1;                      //被抽取集
        int[] result = new int[m];               //结果集
        for(int i =0;i<m;i++) {
            int r = (int) (Math.random() * n);   //产生0到n-1的随机整数
            result[i] = numbers[r];              //结果按抽取顺序存入结果集
            numbers[r] = numbers[n - 1];         //将抽取到的数字在抽取集中的位置与最后一位调换，为下一次在区间内等概率抽取做准备
            n--;                                 //减少抽取区间
        }
        Arrays.sort(result);                    //对结果集数列排序
        System.out.println(Arrays.toString(result));
        }
    }
