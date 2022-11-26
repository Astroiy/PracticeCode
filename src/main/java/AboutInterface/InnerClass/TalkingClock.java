package AboutInterface.InnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TalkingClock {
    /**当start方法不接受参数时
     private int interval;
     private boolean beep;

     public TalkingClock(int interval, boolean beep) {
     this.interval = interval;
     this.beep = beep;
     }*/

    /**
     * start接受参数并且使用局部内部类获得TimePrinter对象
     */
    public void start(int interval, boolean beep) {
        class TimePrinter implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("The time is " + Instant.ofEpochMilli(event.getWhen()));
                if (beep) Toolkit.getDefaultToolkit();
                System.out.println(getClass());
            }
        }

        var listener = new TimePrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }

    /**当start方法接受参数时，并且使用匿名内部类获得实现ActionListener接口的对象
     public void start(int interval,boolean beep) {

     var listener = new ActionListener(){
     public void actionPerformed(ActionEvent event){
     System.out.println("The time is "+Instant.ofEpochMilli(event.getWhen()));
     if(beep)
     Toolkit.getDefaultToolkit().beep();
     }
     };
     var timer = new Timer(interval, listener);
     timer.start();
     }*/

    /** start方法不接受参数，使用lambda表达式实现ActionListener接口实例
     public void start () {

     var timer = new Timer(interval, event -> {
     System.out.println("The time is " + Instant.ofEpochMilli(event.getWhen()));
     if (beep) {
     Toolkit.getDefaultToolkit().beep();
     }
     });
     timer.start();
     }*/

    /** 定义一般的内部类，用于提供ActionListener接口实例
     public class TimePrinter implements ActionListener {
     public void actionPerformed(ActionEvent event) {
     System.out.println("The time is " + Instant.ofEpochMilli(event.getWhen()));
     if (TalkingClock.this.beep) {
     Toolkit.getDefaultToolkit().beep();
     }
     }
     }*/

}


class Test {
    public static void main(String[] args) {
        /** TalkingClock clock = new TalkingClock(1000, true);
         clock.start();
         JOptionPane.showMessageDialog(null, "Quit Program?");
         System.exit(0);*/
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);
        JOptionPane.showMessageDialog(null, "Quit Program");
        System.exit(0);
    }
}



