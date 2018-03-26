package csci305.javalab;

//Always returns Spock
public class StupidBot extends Player{
    //Calls super constructor
    public StupidBot(String name) {
        super(name);
    }

    //Returns Spock every time
    public Element play() {
        return Main.finalMap.get("Spock");
    }
}
