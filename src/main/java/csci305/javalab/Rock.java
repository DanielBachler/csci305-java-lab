package csci305.javalab;
public class Rock extends Element {
    public Outcome compareTo(Element element) {
        Outcome outcome = new Outcome(this.getName(), element.getName());
        return outcome;
    }

    public Rock(String name){
        super(name);
    }
}
