package AboutInterface;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import static AboutInterface.Constants.print;
import static java.lang.Math.*;

public class InterfaceTest implements Constants{
    public static void main(String[] args) {
        System.out.println(pi);
        print("Welcome home");
    }
}
class InterfaceTest1 {
    public static void main(String[] args) {
        System.out.println(Constants.pi);
        print("Imported usage");
        System.out.println(PI);
        System.out.println(E);
        System.out.println(sqrt(-1.2));
        System.out.println(log(2.71));
        System.out.println(max(PI,E));
    }
}
class InterfaceTest2{
    public static void main(String[] args) {
        Runnable task1 = System.out::println;
        Runnable task2 = ()->System.out.println();
        task1.run();
        task2.run();
    }
}
class InterfaceTest3{
    public static void main(String[] args) {
        ActionListener listener = System.out::println;
        var timer = new Timer(1000,listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"Quit Program?");
        System.exit(0);
    }
}
class InterfaceTest4{
    public static void main(String[] args) {
        Comparator<String> comp = String::compareToIgnoreCase;
        String[] ignoreCase = {"aBAcd","AbAc","BaBB","baBbd","ABa"};
        String[] ignoreCase_cloned = ignoreCase.clone();

        System.out.println(Arrays.toString(ignoreCase));
        Arrays.sort(ignoreCase,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(ignoreCase));

        System.out.println(Arrays.toString(ignoreCase_cloned));
        Arrays.sort(ignoreCase_cloned,comp);
        System.out.println(Arrays.toString(ignoreCase_cloned));
    }
}

class InterfaceTest5{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(null);
        list.add(5);
        list.add(null);
        list.add(null);
        list.add(7);
        list.add(9);
        ArrayList<Integer> list_cloned = (ArrayList<Integer>) list.clone();
        System.out.println(list);
        list.removeIf(x->x==null);
        System.out.println(list);
        list_cloned.removeIf(Objects::isNull);
        System.out.println(list_cloned);
    }
}
