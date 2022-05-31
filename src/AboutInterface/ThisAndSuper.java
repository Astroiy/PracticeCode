package AboutInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Comparator;

public class ThisAndSuper {
    public static void main(String[] args) {
        new RepeatedGreeter().greet(null);
        JOptionPane.showMessageDialog(null,"quit?");
        System.exit(0);
    }
}
class Greeter{
    public void greet(ActionEvent event){
        System.out.println("The time is "+ Instant.ofEpochMilli(event.getWhen()));
    }
}

class RepeatedGreeter extends Greeter{
    @Override
    public void greet(ActionEvent event){
        var timer = new Timer(1000,super::greet);
        timer.start();
    }
}
