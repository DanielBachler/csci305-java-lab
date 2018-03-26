package csci305.javalab;

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
    public abstract void play();
}
