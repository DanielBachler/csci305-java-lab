package csci305.javalab;
public class Rock extends Element {
    //Rocks compareTo, they are all the same but must be implemented within the class
    public String compareTo(Element element) {
        Outcome outcome = new Outcome(this.getName(), element.getName());
        return outcome.stringOne + " -- " + outcome.stringTwo;
    }

    //The rock constructor, simply calls the super constructor to give itself a name.
    public Rock(String name){
        super(name);
    }
}
