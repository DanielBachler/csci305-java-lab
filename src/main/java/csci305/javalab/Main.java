package csci305.javalab;
public class Main {
    public static void main(String[] args) {
        Lizard lizard = new Lizard("Lizard");
        Rock rock = new Rock("Rock");
        Outcome temp = lizard.compareTo(rock);
        System.out.printf("String 1: %s\nString 2: %s", temp.stringOne, temp.stringTwo);
    }
}
