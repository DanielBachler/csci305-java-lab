package csci305.javalab;

import java.util.Random;

//Only plays the classic Rock Paper Scissors moves, at random
public class MyBot extends Player{
    public Element play() {
        //Sets up a random, and gets a random number bounded by 3
        Random rand = new Random();
        int randValue = rand.nextInt(3);
        String key = Player.keyGetter(randValue);
        return Main.finalMap.get(key);
    }

    //Calls super constructor
    public MyBot(String name) {
        super(name);
    }
}
