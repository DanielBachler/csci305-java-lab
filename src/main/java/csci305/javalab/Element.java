package csci305.javalab;
public abstract class Element {
    //The name of the object, used for comparision
    private String name;

    //The real constructor, used to give a name
    public Element(String name) {
        this.name = name;
    }

    //Dummy default constructor to avoid errors
    public Element() {

    }

    //Gets the name of the object
    public String getName() {
        return this.name;
    }

    //Sets the name of the object
    public void setName(String name) {
        this.name = name;
    }

    //Abstract compareTo method, implemented within child-classes
    public abstract String compareTo(Element element);
}
