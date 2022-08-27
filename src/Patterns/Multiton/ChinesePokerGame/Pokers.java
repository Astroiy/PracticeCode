package Patterns.Multiton.ChinesePokerGame;

import java.net.URLDecoder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class Pokers{
    private final LinkedList<Poker> pokers = new LinkedList<>();

    public Pokers(){
        for (Colors color : Colors.values()) {
            for (Numbers number : Numbers.values()) {
                if(number!=Numbers.BLACK_JOKER && number != Numbers.RED_JOKER)
                    pokers.add(new Poker(color,number));
            }
        }
        pokers.add(new Poker(Colors.HEARTS,Numbers.RED_JOKER));
        pokers.add(new Poker(Colors.SPADE,Numbers.BLACK_JOKER));
        Collections.sort(pokers);
    }

    public Poker getAPoker(boolean random){
        return random?pokers.pollFirst():pokers.pollLast();
    }
    public Poker getRandomPoker(){
        return pokers.remove((int)(Math.random()*pokers.size()));
    }

    public int RestPokers(){
        return pokers.size();
    }

    public void shuffle(){
        Collections.shuffle(pokers);
    }
    public boolean isEmpty(){
        return pokers.size()==0;
    }

    public static class Poker implements Comparable<Poker>{
        private Colors color;
        private Numbers number;

        private Poker(Colors color, Numbers number){
            this.color=color;
            this.number=number;
        }

        @Override
        public int compareTo(Poker pair) {
            return (this.number.ordinal()-pair.number.ordinal())==0
                    ?this.color.ordinal()-pair.color.ordinal()
                    :(this.number.ordinal()-pair.number.ordinal());
        }

        @Override
        public String toString() {
            return number==Numbers.BLACK_JOKER || number==Numbers.RED_JOKER
                    ?number.abbreviation: color.design+number.abbreviation;
        }
    }
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

    private enum Numbers{
        THREE("3"),FOUR("4"),FIVE("5"),SIX("6"),SEVEN("7"),EIGHT("8"),NIGHT("9"),TEN("10"),KNIGHT("J"),QUEEN("Q"),
        KING("K"),
        ACE("A"),
        RED_JOKER("RedJoker"),BLACK_JOKER("BlackJoker");
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
        return pokers.toString();
    }
}

