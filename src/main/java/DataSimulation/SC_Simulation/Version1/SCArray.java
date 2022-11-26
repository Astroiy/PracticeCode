package DataSimulation.SC_Simulation.Version1;

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

}
