package ConstructorAndInitialization;

public class Teacher {
    private String name;
   private String major;
   private int age;
   private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public static class Test{
        public static void main(String[] args) throws ReflectiveOperationException {
            Teacher t = new Teacher();
            t.setName("Wang li");
            t.setGender("Male");
            t.setMajor("Maths");
            t.setAge(18);
            System.out.println(new ObjectAnalyzer().toString(t));
            System.out.println(new ObjectAnalyzer().toString(new Object()));
            System.out.println(new ObjectAnalyzer().toString(new Employee()));
        }
    }
}
