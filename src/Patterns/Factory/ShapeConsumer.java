package Patterns.Factory;

public class ShapeConsumer {
    public static void main(String[] args) {
        Shape c = ShapeFactory.of("C");
        Shape r = ShapeFactory.of("R");
        Shape s = ShapeFactory.of("S");

        c.showAreaFormula();
        r.showAreaFormula();
        s.showAreaFormula();
    }
}
