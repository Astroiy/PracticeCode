package Patterns.Factory;

import java.security.InvalidParameterException;

public class ShapeFactory {
    public static Shape of(String shape){
        return switch (shape) {
            case "C" -> new Circle();
            case "R" -> new Rectangle();
            case "S" -> new Square();
            default -> throw new InvalidParameterException();
        };
    }
}

class Circle implements Shape{
    @Override
    public void showAreaFormula() {
        System.out.println("S=πr²");
    }
}

class Rectangle implements Shape{
    @Override
    public void showAreaFormula() {
        System.out.println("S=ab");
    }
}
class Square implements Shape{
    @Override
    public void showAreaFormula() {
        System.out.println("S=a²");
    }
}
