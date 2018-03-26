package csci305.javalab;
public class Scissors extends Element {
    public Outcome compareTo(Element element) {
        Outcome outcome = new Outcome(this.getName(), element.getName());
        return outcome;
    }

    public Scissors(String name){
        super(name);
    }
}
