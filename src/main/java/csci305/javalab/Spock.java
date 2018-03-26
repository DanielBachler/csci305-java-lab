package csci305.javalab;
public class Spock extends Element {
    //Spock's compareTo method, same as the others, but must be implemented since parents is abstract
    public String compareTo(Element element) {
        Outcome outcome = new Outcome(this.getName(), element.getName());
        return outcome.stringOne + " -- " + outcome.stringTwo;
    }

    //Spock's constructor, calls super to give itself a name
    public Spock(String name){
        super(name);
    }
}
