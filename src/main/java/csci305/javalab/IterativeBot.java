package csci305.javalab;

//Iterates through all the moves, utilizing a counter field.
public class IterativeBot extends Player{
    //Counter for iteration
    private int counter = 0;
    //Iterates over the moves, in this order: rock, paper, scissors, lizard, spock
    public Element play() {
        //Uses the static player method keyGetter to get the right key for a value
        String key = Player.keyGetter(counter);
        //If the counter is less than 5, iterates up by one, else resets to 0
        if (counter < 5) {
            counter++;
        } else {
            counter = 0;
        }
        //Returns the key as an element
        return Main.finalMap.get(key);
    }

    //Calls super constructor
    public IterativeBot(String name) {
        super(name);
    }
}
