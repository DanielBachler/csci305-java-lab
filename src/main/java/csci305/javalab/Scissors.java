package csci305.javalab;
public class Scissors extends Element {
    //Scissor's compareTo method, same as all others but must be implemented since parent version is abstract
    public String compareTo(Element element) {
        Outcome outcome = new Outcome(this.getName(), element.getName());
        return outcome.stringOne + " -- " + outcome.stringTwo;
    }

    //Scissor's constructor, calls super to give itself a name
    public Scissors(String name){
        super(name);
    }
}
