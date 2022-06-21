package Concurrency.Others;
import DataSimulation.SInfo_Simulation.InvalidGenderException;
import DataSimulation.SInfo_Simulation.nameCreator;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) throws InvalidGenderException {
        System.out.println("Enter number of people: ");
        Scanner in = new Scanner(System.in);
        Random rand = new Random(47);
        Integer number = Integer.valueOf(in.nextLine());
        String[] names = new String[1000];
        for (int i = 0; i < names.length; i++) {
            names[i]=nameCreator.getName();
            names[i]=names[i].replace("F","");
            names[i]=names[i].replace("M","");
        }

        var t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.print(names[rand.nextInt(1000)]);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        break;
                    }
                    System.out.print("\r");
                }
            }
        });
        t.start();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter enter to get name:");
            in.nextLine();
            t.interrupt();
            System.out.println();
        }
    }
}
