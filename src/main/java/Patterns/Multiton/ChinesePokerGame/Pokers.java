package Patterns.Multiton.ChinesePokerGame;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Pokers{
    private final LinkedList<Poker> pokerList = new LinkedList<>();

    public Pokers(){
        for (Colors color : Colors.values()) {
            for (Numbers number : Numbers.values()) {
                if(number!=Numbers.BLACK_JOKER && number != Numbers.RED_JOKER)
                    pokerList.add(new Poker(color, number));
            }
        }
        pokerList.add(Poker.getBlackJoker());
        pokerList.add(Poker.getRedJoker());
        Collections.sort(pokerList);
    }

    public Poker getAPoker(boolean fromTop){
        return fromTop? pokerList.pollFirst(): pokerList.pollLast();
    }
    public Poker getRandomPoker(){
        Random rand = new Random();
        return pokerList.remove(rand.nextInt(pokerList.size()));
    }

    public int restPokersNum(){
        return pokerList.size();
    }

    public void shuffle(){
        Collections.shuffle(pokerList);
    }
    public boolean isEmpty(){
        return pokerList.isEmpty();
    }


    //Poker的单牌对象
    public static class Poker implements Comparable<Poker>{
        private final Colors color;
        private final Numbers number;


        private Poker(Colors color, Numbers number){
            this.color=color;
            this.number=number;
        }

        private static Poker getRedJoker(){
            return new Poker(null, Numbers.RED_JOKER);
        }

        private static Poker getBlackJoker(){
            return new Poker(null, Numbers.BLACK_JOKER);
        }


        @Override
        public int compareTo(Poker pair) {
            return number.compareTo(pair.number)==0
                    ? color.compareTo(pair.color)
                    :number.compareTo(pair.number);
        }

        @Override
        public String toString() {
            return number==Numbers.BLACK_JOKER || number==Numbers.RED_JOKER
                    ?number.abbreviation: color.design+number.abbreviation;
        }

        //与compareTo相适配的equals方法
        @Override
        public boolean equals(Object obj) {
            if(obj == this){
                return true;
            }
            if(obj == null){
                return false;
            }
            if(getClass()!=obj.getClass()){
                return false;
            }
            int result = compareTo((Poker) obj);
            return result == 0;
        }

        @Override
        public int hashCode() {

            return color==null?number.hashCode()*3:number.hashCode()*3+color.hashCode()*5;
        }

    }

    //花色枚举类
    private enum Colors{
        SPADE("♢"),HEARTS("♧"),CLUB("♥"),DIAMOND("♠");
        private final String design;
        Colors(String design){
            this.design=design;
        }
        public String getDesign() {
            return design;
        }
        @Override
        public String toString() {
            return design;
        }
    }


    //牌数枚举类
    private enum Numbers{
        THREE("3"),FOUR("4"),FIVE("5"),SIX("6"),SEVEN("7"),EIGHT("8"),NIGHT("9"),TEN("10"),KNIGHT("J"),QUEEN("Q"),
        KING("K"),
        ACE("A"),TWO("2"),
        BLACK_JOKER("BlackJoker"),RED_JOKER("RedJoker");
        private final String abbreviation;
        Numbers(String abbreviation){
            this.abbreviation=abbreviation;
        }
        public String getAbbreviation() {
            return abbreviation;
        }

        @Override
        public String toString() {
            return abbreviation;
        }
    }

    @Override
    public String toString() {
        return pokerList.toString();
    }
}

