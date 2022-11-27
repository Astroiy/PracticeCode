package Patterns.Multiton.ChinesePokerGame;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Player {

    private final LinkedList<Pokers.Poker> ownPokers = new LinkedList<>();
    private final String name;
    private Integer joyBeans;
    private boolean isLandLord = false;

    public Player(String name,Integer joyBeans){
        this.name = name;
        this.joyBeans = joyBeans;
    }

    public void getLandLord(){
        isLandLord =true;
    }

    public boolean isLandlord(){
        return isLandLord;
    }

    public void sortPoker(){
        Collections.sort(ownPokers);
    }

    public void getPoker(Pokers pokers){
        ownPokers.add(pokers.getAPoker(true));
    }

    public List<Pokers.Poker> showPoker(int...index){
        LinkedList<Pokers.Poker> pokers = new LinkedList<>();
        for (int i : index) {
            pokers.add(ownPokers.remove(i));
        }
        Collections.sort(pokers);
        return pokers;
    }

    public LinkedList<Pokers.Poker> getOwnPokers() {
        return ownPokers;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\t"+"JoyBeans: "+joyBeans;
    }
}
