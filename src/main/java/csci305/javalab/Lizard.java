package csci305.javalab;
public class Lizard extends Element {
    public Outcome compareTo(Element element) {
        Outcome outcome = new Outcome(this.getName(), element.getName());
        return outcome;
    }

    public Lizard(String name){
        super(name);
    }
}
