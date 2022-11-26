package DataSimulation.SC_Simulation.Version1;

import java.util.*;

public class ReturnStudentCourse {
    public static LinkedHashSet<SCArray> getSC(int n){
        Random rand = new Random();
        ArrayList<Integer> course = new ArrayList<Integer>(Arrays.asList(666001,666002,666003,666004,666005,666006,
                666007,666008));
        LinkedHashSet<SCArray> result = new LinkedHashSet<SCArray> ();

        for(int i=0;i<n;i++){
            //随机生成选课门数：至少选择2门，最多选择4门。
            int k = rand.nextInt(2,5);
            label1:for(int j=1;j<=k;j++){
                 SCArray tmp = new SCArray();
                 tmp.setPair(i+1,rand.nextInt(666001,666009));
                 for(SCArray obj : result){
                     if(tmp.equals(obj)){
                         j--;
                         continue label1;
                     }


                //随机生成课程id：最小为666001.最大为666008
                //Integer courseid = rand.nextInt(course.get(0),course.get(0)+m);
                //比较该同学是否重复选课:遍历该同学已有的课程号清单
                //for(SCArray obj:result){
                   //if(obj.getPair()[0]==i+1){
                       //判断是否选择到重复课程，是则重新选课
                       //if(obj.getPair()[1]==courseid) {
                          //j--;
                           //continue label1;
                       //}
                  // }
                }
                result.add(tmp);
                //SCArray tmp = new SCArray();
                //tmp.setPair(i+1,courseid);
               // result.add(tmp);
            }
        }
        return result;
    }
    public static class Test{
        public static void main(String[] args) {
            var s = ReturnStudentCourse.getSC(50);
            System.out.println(s);
        }
    }
}
