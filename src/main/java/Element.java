public class Element {
    private String name;

    public Element(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Element element) {
        return 0;
    }
}
