package CombArrayAndDate;

import java.util.Arrays;

public class TDArray {
    public static void main(String[] args){
        int[][][] result = new int[3][3][3];
        for(int i = 0;i<3;i++)
            for(int j =0;j<3;j++)
                for(int k = 0;k<3;k++)
                    result[i][j][k]=i+j+k;
        for(int[][] layer1 : result)
            for(int[] layer2 : layer1)
                for(int layer3: layer2)
                    System.out.print(layer3+" ");

        System.out.println();
        System.out.println(Arrays.deepToString(result));

    }
}
