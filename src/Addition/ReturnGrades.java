package Addition;

import java.util.Random;

public class ReturnGrades {
    public static void getGrades(int n) throws InvalidGenderException {
        Random rand = new Random();

        String[] name = new String[n];
        double[] grade = new double[n];
        double[] makeup1 = new double[n];
        double[] makeup2 = new double[n];

        for(int i=0;i<n;i++){
            name[i] = nameCreator.getName();
        }
        /**第一次考试成绩录入 */
        for(int i=0;i<n;i++){
            double layer = rand.nextDouble(0,100);
            if(layer<15)
                grade[i] = -1;
            else if(layer>=15 && layer<=30)
                grade[i] = rand.nextDouble(0,60);
            else {
                grade[i] = rand.nextDouble(60, 100);
                makeup1[i] = -2;
                makeup2[i] = -2;
            }
        }
        /**第一次补考成绩录入*/
        for(int i=0;i<n;i++){
            double layer1 = rand.nextDouble(0,100);
            if(grade[i] <60){
                if(layer1<10)
                    makeup1[i] = -1;
                else if(layer1>=10 && layer1 <30)
                    makeup1[i] = rand.nextDouble(0,60);
                else {
                    makeup1[i] = rand.nextDouble(60, 100);
                    makeup2[i] =-2;
                }
            }
        }
        /**第二次补考成绩录入*/
        for(int i=0;i<n;i++){
            double layer2 = rand.nextDouble(0,100);
            if(makeup1[i]<60 && makeup2[i]!=-2){
                if(layer2<=40)
                    makeup2[i] = -1;
                else if(layer2>40 && layer2<=60)
                    makeup2[i] = rand.nextDouble(0,60);
                else
                    makeup2[i] = rand.nextDouble(60, 100);

            }
        }
        /**输出可用于mysql语句的成绩单*/
        for(int i=0;i<n;i++){
            System.out.printf("('%s',%.1f,%.1f,%.1f),\n",name[i],grade[i],makeup1[i],makeup2[i]);
        }

    }
    public static class Test{
        public static void main(String[] args) throws InvalidGenderException {
            getGrades(5);
        }
    }
}
