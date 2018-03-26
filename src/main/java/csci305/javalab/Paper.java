package csci305.javalab;
public class Paper extends Element {
    //Paper's compareTo method, same as all others but must be implemented here since it is abstract
    public String compareTo(Element element) {
        Outcome outcome = new Outcome(this.getName(), element.getName());
        return outcome.stringOne + " -- " + outcome.stringTwo;
    }

    //Paper constructor, calls super constructor to give a name to itself
    public Paper(String name){
        super(name);
    }
}
