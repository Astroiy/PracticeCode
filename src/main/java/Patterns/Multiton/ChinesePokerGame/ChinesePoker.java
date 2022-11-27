package Patterns.Multiton.ChinesePokerGame;

import java.util.*;

public class ChinesePoker {

    private static Pokers cards;

    private static List<Pokers.Poker> landLordTreasure;

    private static List<Pokers.Poker> getLandLordTreasure(){
        LinkedList<Pokers.Poker> treasure = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            treasure.add(cards.getRandomPoker());
        }
        return treasure;
    }

    private static void deal(Player...players){
        while(!cards.isEmpty()) {
            for (Player player : players) {
                if (!cards.isEmpty())
                    player.getPoker(cards);
            }
        }
    }

    private static void resetPokers(){
        cards = new Pokers();
    }

    private static void resetTreasure(){
        landLordTreasure = getLandLordTreasure();
    }

    private static void shuffle(){
        cards.shuffle();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--------------------欢乐斗地主----------------------");
        System.out.println("[1]开始游戏\t[2]退出游戏");
        Scanner in = new Scanner(System.in);
        int choose = in.nextInt();
        if(choose==2){
            System.out.println("Goodbye");
            System.exit(0);
        }else if(choose==1)
        {
            Player p1 = new Player("p1", 20000);
            Player p2 = new Player("p2", 20000);
            Player p3 = new Player("p3", 20000);
            System.out.println("----------发牌阶段----------");
            System.out.println("准备新牌组...");
            resetPokers();
            System.out.println("抽取地主牌...");
            resetTreasure();
            System.out.println("洗牌中...");
            shuffle();
            Thread.sleep(1000);
            System.out.println("发牌中...");
            deal(p1,p2,p3);
            Thread.sleep(1000);


            System.out.println("p1: "+p1.getOwnPokers());
            System.out.println("p2: "+p2.getOwnPokers());
            System.out.println("p3: "+p3.getOwnPokers());
            System.out.println("玩家理牌...");
            for (int i = 0; i < 3; i++) {
                p1.sortPoker();
                p2.sortPoker();
                p3.sortPoker();
            }
            System.out.println("p1: "+p1.getOwnPokers());
            System.out.println("p2: "+p2.getOwnPokers());
            System.out.println("p3: "+p3.getOwnPokers());

            System.out.println("展示地主牌:"+landLordTreasure);
        }
        else{
            throw new InputMismatchException("Undefined Operation");
        }
    }
}
