
public class Varargs {
    public static double max(double...args){
        double max=Double.NEGATIVE_INFINITY;
        for(double value : args){
            if(max<value)
                max=value;
        }
        return max;
    }


    public static class Test{
        public static void main(String[] args){

            double[] d1 = {1.1,2.2,3.3,2.22,1.11};
            double[] d2 = {2.7,5.6,1.2,3.4,2.71};

            //Varargs.max(d1,d2);
            //Varargs.max(d1,1.2,1.4,4.8);
            //Varargs.max(1.2,1.4,1.8,new double[]{1.1,2.2});

            Varargs.max(new double[]{1.1,2.2,3.3,4.4});
            Varargs.max(d1);

            System.out.println(Varargs.max(d1));
        }
    }
}
