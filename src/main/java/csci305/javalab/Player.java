package csci305.javalab;

//The abstract player class, provides the keyGetter method and super constructor for all player/bots
public abstract class Player {
    public String name;

    //Player constructor, takes a name and puts it in the field
    public Player(String name) {
        this.name = name;
    }

    //Dummy constructor to avoid errors
    public Player() {

    }

    //Gets the name
    public String getName() {
        return this.name;
    }

    //Sets the name
    public void setName(String name) {
        this.name = name;
    }

    //Abstract play method, to be implemented in child classes.
    public abstract Element play();

    //Switches the given int, with the default being lizard just in case, and to
    //avoid the "may not be initialized" error
    public static String keyGetter(int keyValue) {
        String key;
        switch (keyValue) {
            case 0:
                key = "Rock";
                break;
            case 1:
                key = "Paper";
                break;
            case 2:
                key = "Scissors";
                break;
            case 3:
                key = "Lizard";
                break;
            case 4:
                key = "Spock";
                break;
            default:
                key = "Lizard";
                break;
        }
        return key;
    }

    //For use with the lastPlay Bot and myBot
    public void setLastPlay(Element lastPlay) {}
}
