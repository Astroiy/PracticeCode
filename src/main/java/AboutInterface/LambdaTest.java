package AboutInterface;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class LambdaTest {
    public static class ArraySortTest {
        public static void main(String[] args) {
            String[] planet = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
            String[] planet_cloned = planet.clone();
            Arrays.sort(planet);
            System.out.println("Sorted in dictionary order: ");
            System.out.println(Arrays.toString(planet));
            Arrays.sort(planet_cloned, Comparator.comparingInt(String::length));
            //Arrays.sort(planet_cloned, (first, second) -> first.length() - second.length());
            System.out.println("Sorted by length: ");
            System.out.println(Arrays.toString(planet_cloned));
        }
    }
    public static class TimerTest{
        public static void main(String[] args) {
            Timer timer = new Timer(1000,event->{
                System.out.println("At the tone, the time is "+ Instant.ofEpochMilli(event.getWhen()));
                Toolkit.getDefaultToolkit().beep();
            });
            timer.start();
            JOptionPane.showMessageDialog(null,"Quit program?");
            System.exit(0);
        }
    }
    public static class AnotherTest{
        public static void main(String[] args) {
            Random rand = new Random();
            var integers = new Integer[10];
            for (int j = 0; j < 10; j++) {
                integers[j]=rand.nextInt(50);
            }
            System.out.println(Arrays.toString(integers));
            Arrays.sort(integers,(a,b)->b-a);
            System.out.println(Arrays.toString(integers));
        }
    }
}


