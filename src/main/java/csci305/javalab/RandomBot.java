package csci305.javalab;

import java.util.Random;

//Returns a random element from the possible moves
public class RandomBot extends Player{
    //Returns a random element
    public Element play() {
        //Creates a new random
        Random rand = new Random();
        //Gets a random int from 0-4, since there are 5 choices
        int picker = rand.nextInt(5);
        //The string that will become the key
        String key = Player.keyGetter(picker);
        //Returns the given key as an element
        return Main.finalMap.get(key);
    }

    //Calls super constructor
    public RandomBot(String name) {
        super(name);
    }
}
