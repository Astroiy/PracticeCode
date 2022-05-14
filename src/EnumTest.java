import java.util.Arrays;
import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args){

        var in = new Scanner(System.in);

        System.out.print("Enter a spiciness:");
        String input = in.next().toUpperCase();
        Spiciness spici = Spiciness.valueOf(Spiciness.class,input);
        System.out.println("Spiciness="+spici);
        System.out.println("abbreviation="+spici.getAbbreviation());

        Spiciness[] all = Spiciness.values();
        System.out.println(Arrays.toString(all));
        for(Spiciness s :all){
            int order = s.ordinal();
            System.out.print(order+" ");
            System.out.println(s.compareTo(Spiciness.MEDIUM));
        }
    }
}

enum Spiciness{
    NOT("N"),MILD("MD"),MEDIUM("MM"),HOT("H"),FLAMING("F");
    private String abbreviation;
    private Spiciness(String abbreviation){
       this.abbreviation=abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }
}
