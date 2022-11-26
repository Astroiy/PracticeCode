package Lombok;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String name;
    private int age;


    public static class Test{
        public static void main(String[] args) {
            Student tiny = new Student("tiny", 16);
            System.out.println(tiny.getName()+" "+tiny.getAge());
            System.out.println(tiny);
        }
    }
}


