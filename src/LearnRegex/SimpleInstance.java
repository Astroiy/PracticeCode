package LearnRegex;

public class SimpleInstance {
    public static void main(String[] args) {
        String s = "had";
        String regex = "had";
        System.out.println("1."+s.matches(regex));

        regex = "h[aeiou]d";
        System.out.println("2."+s.matches(regex));

        regex = "h[^aeiou]d";
        System.out.println("3."+s.matches(regex));

        regex = "h[a-z]d";
        System.out.println("4."+s.matches(regex));

        regex  = "h[1-9a-zA-Z]d";
        System.out.println("5."+s.matches(regex));

        regex = "h[a-z&&[^aeiou]]d";
        System.out.println("6."+s.matches(regex));

        regex = "h.d";
        System.out.println("7."+s.matches(regex));

        regex = "h\\.d";
        System.out.println("8."+"h.d".matches(regex));

        regex = "\\d\\d\\d\\d\\d";
        System.out.println("9."+"23424".matches(regex));

        regex = "\\D\\D\\D\\D\\D";
        System.out.println("10."+"abcde".matches(regex));
        System.out.println("11."+"abcdef".matches(regex));
        System.out.println("12."+"a1cde".matches(regex));

        regex = "[0-9]+";
        System.out.println("13."+"81723".matches(regex));

    }
}
