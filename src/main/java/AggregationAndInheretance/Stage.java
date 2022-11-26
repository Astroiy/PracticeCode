package AggregationAndInheretance;

public class Stage {
    private Actor actor = new HappyActor();

    public void change(){
        actor = new SadActor();
    }
    public void performPlay(){
        actor.act();
    }
}

class TestAggregation{
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
