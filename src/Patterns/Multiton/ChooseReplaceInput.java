package Patterns.Multiton;
public class ChooseReplaceInput {
    public static void main(String[] args) {
        Property pro1 = new Property("Pro1", Choice.FIRST);
        Property pro2 = new Property("Pro2", Choice.SECOND);
        System.out.println(pro1);
        System.out.println(pro2);
    }
}
class Property{
    private String pro1;
    private Choice pro2;

    public Property(String pro1, Choice pro2) {
        this.pro1 = pro1;
        this.pro2 = pro2;
    }

    public String getPro1() {
        return pro1;
    }

    public void setPro1(String pro1) {
        this.pro1 = pro1;
    }

    public Choice getPro2() {
        return pro2;
    }

    public void setPro2(Choice pro2) {
        this.pro2 = pro2;
    }

    @Override
    public String toString() {
        return "Property{" +
                "pro1='" + pro1 + '\'' +
                ", pro2=" + pro2 +
                '}';
    }
}
class Choice{
    private String contents;

    private Choice(String contents){
        this.contents=contents;
    }

    public static final Choice FIRST = new Choice("Choice One");
    public static final Choice SECOND = new Choice("Choice Two");

    @Override
    public String toString() {
        return contents;
    }
}

