package DataSimulation.SInfo_Simulation;

import java.util.Random;

public class ReturnStudentInformation {
    public static String[][] getInfo(int n) throws InvalidGenderException {
        Random rand = new Random();
        String[][] info = new String[n][3];

        for(String[] student : info) {
            student[0] = nameCreator.getName();
            student[1] = String.valueOf(rand.nextInt(17, 20));
            student[2] = student[0].substring(student[0].length() - 1, student[0].length());
        }
        return info;
    }
    public static class Test{
        public static void main(String[] args) throws InvalidGenderException{
            String[][] result = ReturnStudentInformation.getInfo(50);
            for(String[] student : result) {
                    System.out.printf("('%s',%s,'%s'),\n",student[0],student[1],student[2]);
            }
        }
    }
}
