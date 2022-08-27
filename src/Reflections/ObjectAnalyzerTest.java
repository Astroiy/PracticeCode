package Reflections;

import ConstructorAndInitialization.Teacher;
import Reflections.ObjectAnalyzer;

public class ObjectAnalyzerTest {
        public static void main(String[] args) throws ReflectiveOperationException{
            /**var squares = new ArrayList<Integer>();
            for(int i=1;i<=5;i++){
                squares.add(i*i);
            }
            System.out.println(new ObjectAnalyzer().toString(squares));
        }*/
            int[] i = {1,2,3,4,5};
            Teacher[] t = new Teacher[]{new Teacher(),new Teacher(),new Teacher()};
            System.out.println(new ObjectAnalyzer().toString(i));
            System.out.println(new ObjectAnalyzer().toString(t));

        }
}
