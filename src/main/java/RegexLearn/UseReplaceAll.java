package RegexLearn;

public class UseReplaceAll {
    public static void main(String[] args) {
        String msg = "awudhusahouhd1928h182y3y1heuwqh92ye1h0dwh10dha";
        String s = msg.replaceAll("\\d+","*");
        System.out.println(s);
        System.out.println(msg.replaceAll("\\d","*"));
    }
}
