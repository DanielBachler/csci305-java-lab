package csci305.javalab;
public class Spock extends Element {
    public Outcome compareTo(Element element) {
        Outcome outcome = new Outcome(this.getName(), element.getName());
        return outcome;
    }

    public Spock(String name){
        super(name);
    }
}
