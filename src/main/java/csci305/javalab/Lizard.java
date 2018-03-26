package csci305.javalab;
public class Lizard extends Element {
    //Lizard's compareTo method, same as all others but must be implemented since it is an abstract method
    public String compareTo(Element element) {
        Outcome outcome = new Outcome(this.getName(), element.getName());
        return outcome.stringOne + " -- " + outcome.stringTwo;
    }

    //Lizard's constructor, calls super to give itself a name
    public Lizard(String name){
        super(name);
    }
}
