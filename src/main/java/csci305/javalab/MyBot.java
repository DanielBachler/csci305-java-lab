package csci305.javalab;

import java.util.HashMap;
import java.util.Random;

//Only plays moves that have yet to be played by opponent.  Its moves do not count for this check,
//other wise it may run out of moves before the game is over.
public class MyBot extends Player{
    //Hash Map of plays, by default all have not been played by opponent
    private HashMap<String, Boolean> plays = new HashMap<String, Boolean>() {{
       put("Rock", false);
       put("Paper", false);
       put("Scissors", false);
       put("Lizard", false);
       put("Spock", false);
    }};

    //Randomly picks move that has not yet been played
    public Element play() {
        //Random used to find value
        Random rand = new Random();
        //The key variable, since it is needed later
        int key;
        //Only needed as a seg-way for loop, hence name
        boolean temp;
        do {
            key = rand.nextInt(5);
            //Get whether or not the chosen element has been played
            temp = plays.get(Player.keyGetter(key));
        } while(!temp);
        //Returns the first found element that opponent has not played
        return Main.finalMap.get(Player.keyGetter(key));
    }

    //Calls super constructor
    public MyBot(String name) {
        super(name);
    }

    //Overrides super version, although name is slightly misleading.
    //Instead of only remembering last move, this bot which of the five moves has been played and randomly picks one.
    public void setLastPlay(Element lastPlay) {
        //This method is not effected if the value is already true, since it does not matter
        plays.put(lastPlay.getName(), true);
    }
}
