package AboutInterface.ProccessingLambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VariableScope {
       public static ActionListener listener;
    public static void repeatMessage(String text,int delay){
        listener = event->{
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
        new Timer(delay,listener).start();
    }

    public static void main(String[] args) {
        VariableScope.repeatMessage("Hello",1000);
        JOptionPane.showMessageDialog(null,"quit now?");
        new Timer(1000,listener).start();
        JOptionPane.showMessageDialog(null,"quit now?");
        System.exit(0);

    }
}
