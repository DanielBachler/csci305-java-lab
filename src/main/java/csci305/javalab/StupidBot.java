package csci305.javalab;

//Always returns Lizard
public class StupidBot extends Player{
    //Calls super constructor
    public StupidBot(String name) {
        super(name);
    }

    //Returns Lizard every time
    public Element play() {
        return Main.finalMap.get("Lizard");
    }
}
