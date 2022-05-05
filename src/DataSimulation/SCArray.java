package DataSimulation;

public class SCArray {
    //此类的一个实例域为:学生id和课程号组成的二元数对
    private Integer[] pair = new Integer[2];


    public void setPair(int n,int m){
          pair[0]=n;
          pair[1]=m;
    }

    public Integer[] getPair(){
        return pair;
    }


    public String toString(){
        String result = String.join("","(",String.valueOf(this.pair[0]),",",String.valueOf(this.pair[1]), ")");
        return result;
    }
    public boolean equals (SCArray array){
        return (this.pair[0].equals(array.pair[0]) && this.pair[1].equals(array.pair[1]));
    }
    public static class Test{
        public static void main(String[] args){
            var s1 = new SCArray();
            var s2 = new SCArray();
            s1.setPair(1,2);
            s2.setPair(1,2);
            System.out.println(s1.equals(s2));
        }
    }

}
