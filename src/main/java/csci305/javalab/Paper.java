package csci305.javalab;
public class Paper extends Element {

    public Outcome compareTo(Element element) {
        Outcome outcome = new Outcome(this.getName(), element.getName());
        return outcome;
    }

    public Paper(String name){
        super(name);
    }
}
