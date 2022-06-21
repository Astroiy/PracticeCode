package AggregationAndInheretance;

public class Actor {
    public void act(){}
}
class HappyActor extends Actor{
    public void act(){
        System.out.println("HappyActor's performing!");
    }
}
class SadActor extends Actor{
    public void act(){
        System.out.println("SadActor's performing!");
    }
}
