package csci305.javalab;

//Plays the last move made by its opponent, if no last move is available creates a temp instance of random bot and uses that for one move.
public class LastPlayBot extends Player{
    //Last played move
    private Element lastPlay;

    //Plays the last played move, or a random one if no last move found
    public Element play() {
        //Checks if the lastPlay is null, if so returns a temp random bots move
        if(lastPlay == null) {
            RandomBot temp = new RandomBot("RandomBot");
            return temp.play();
        //Else returns the last play
        } else {
            return lastPlay;
        }
    }

    //Sets the last play
    public void setLastPlay(Element lastPlay) {
        this.lastPlay = lastPlay;
    }

    //Calls super constructor
    public LastPlayBot(String name) {
        super(name);
    }
}
