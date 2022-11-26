package DataStructuresAndAlgorithm.Arrays;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Random;

public class ZeroDisplacement {
    public static void getZeroTailDblPointer(int[] values){
        if(values==null)
            System.out.println("Null Pointer!");
        else if(values.length==0)
            System.out.println("Empty array");
        else {
            for(int i=0;i<values.length-1;i++){
                if(values[i]==0){
                    for(int j=i+1;j < values.length;j++){
                        if(values[j]!=0){
                            int tmp=values[j];
                            values[j]=values[i];
                            values[i]=tmp;
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void getZeroTailByRecursive(@NonNull int[] values,int startIndex){
        if(startIndex==values.length-1)
            return;
        if(values[startIndex]!=0){
            getZeroTailByRecursive(values,startIndex+1);
        }else{
            boolean found= false;
            for(int i=startIndex+1;i<values.length;i++){
                if(values[i]!=0){
                    int tmp=values[i];
                    values[i]=values[startIndex];
                    values[startIndex]=tmp;
                    found=true;
                    break;
                }
            }
            if(!found)
                return;
            getZeroTailByRecursive(values,startIndex+1);
        }
    }

    public static Integer[] getZeroTailByStream(@NonNull Integer[] values){
        int n = values.length;
        return Arrays.stream(values).filter(x ->!x.equals(0)).toArray(l -> {
            Integer[] integers = new Integer[n];
            Arrays.fill(integers,0);
            return integers;
        });
    }

    public static void getZeroTailByBubble(@NonNull int[] values){
        int n = values.length;
        for(int i=0;i<n-1;i++){
            boolean done=true;
            for(int j=0;j<n-1-i;j++){
                if(values[j]==0){
                    int tmp=values[j];
                    values[j]=values[j+1];
                    values[j+1]=tmp;
                    done=false;
                }
            }
            if(done)
                return;
        }
    }

    private static class testDoublePointer{
        public static void main(String[] args){
            Random rand=new Random(47);
            int[] ints = new int[rand.nextInt(10, 20)];
            for (int i = 0; i < ints.length; i++) {
                ints[i]=rand.nextInt(-10,11);
            }
            for(int i=0;i<5;i++){
                ints[rand.nextInt(ints.length)]=0;
            }
            System.out.println(Arrays.toString(ints));
            getZeroTailDblPointer(ints);
            System.out.println(Arrays.toString(ints));

        }
    }
    private static class testRecursive{
        public static void main(String[] args){
            Random rand=new Random(47);
            int[] ints = new int[rand.nextInt(10, 20)];
            for (int i = 0; i < ints.length; i++) {
                ints[i]=rand.nextInt(-10,11);
            }
            for(int i=0;i<5;i++){
                ints[rand.nextInt(ints.length)]=0;
            }
            System.out.println(Arrays.toString(ints));
            getZeroTailByRecursive(ints,0);
            System.out.println(Arrays.toString(ints));

        }
    }
    private static class testStream{
        public static void main(String[] args) {
            Random rand=new Random(47);
            Integer[] ints = new Integer[rand.nextInt(10, 20)];
            for (int i = 0; i < ints.length; i++) {
                ints[i]=rand.nextInt(-10,11);
            }
            for(int i=0;i<5;i++){
                ints[rand.nextInt(ints.length)]=0;
            }
            System.out.println(Arrays.toString(ints));
            System.out.println(Arrays.toString(getZeroTailByStream(ints)));
        }
    }

    private static class testBubble{
        public static void main(String[] args) {
            Random rand=new Random(47);
            int[] ints = new int[rand.nextInt(10, 20)];
            for (int i = 0; i < ints.length; i++) {
                ints[i]=rand.nextInt(-10,11);
            }
            for(int i=0;i<5;i++){
                ints[rand.nextInt(ints.length)]=0;
            }
            System.out.println(Arrays.toString(ints));
            getZeroTailByBubble(ints);
            System.out.println(Arrays.toString(ints));
        }
    }
}
