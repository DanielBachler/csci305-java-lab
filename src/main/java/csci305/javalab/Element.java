package csci305.javalab;
public abstract class Element {
    private String name;

    public Element(String name) {
        this.name = name;
    }

    public Element() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Outcome compareTo(Element element);
}
