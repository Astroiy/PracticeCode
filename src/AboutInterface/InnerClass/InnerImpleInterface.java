package AboutInterface.InnerClass;

interface Contents{
    int value();
}
public class InnerImpleInterface {
    private int factor;
    public Contents contents(final int factor1,int factor2){
        return new Contents() {
            private int i = 10;
            public int value() {
                factor = factor2;
                return i * factor*factor1;
            }
        };
    }

    public static void main(String[] args) {
        InnerImpleInterface p = new InnerImpleInterface();
        Contents c1 = p.contents(1,5);
        Contents c2 = p.contents(2,3);
        Contents c3 = p.contents(0,3);
        System.out.println(c1.value());
        System.out.println(c2.value());
        System.out.println(c3.value());
    }
}
