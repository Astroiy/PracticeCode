package AboutInterface.StrategyPatterns;

public class Applicator {
    public static void apply(Processor p, Object s){
        System.out.println("Using Processor "+p.getProcessName());
        System.out.println(p.process(s));
    }
    public static void main(String[] args) {
        String s = "We are such stuff as dreams are made on";
        Applicator.apply(new Lowercase(),s);
        Applicator.apply(new Uppercase(),s);
        Applicator.apply(new Splitter(),s);
    }
}
