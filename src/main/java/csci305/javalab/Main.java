package csci305.javalab;

import java.util.HashMap;

public class Main {
    //Creating the final elements and putting them into a map, which cannot be modified after creation
    //This will be used throughout the program instead of creating new Elements.
    public static final HashMap<String, Element> finalMap = new HashMap<String, Element>() {{
        put("Rock", new Rock("Rock"));
        put("Paper", new Paper("Paper"));
        put("Scissors", new Scissors("Scissors"));
        put("Lizard", new Lizard("Lizard"));
        put("Spock", new Spock("Spock"));
    }};

    //Driver method, used to execute the entire program.
    public static void main(String[] args) {
        test2();
    }

    //A method used for testing the initial outcome class
    public static void test() {
        Lizard lizard = new Lizard("Lizard");
        Rock rock = new Rock("Rock");
        System.out.println(lizard.compareTo(rock));
    }

    //A second method for testing, pulled straight from the readme.md
    public static void test2() {
        Element rock = new Rock("Rock");
        Element paper = new Paper("Paper");
        System.out.println(rock.compareTo(paper));
        System.out.println(paper.compareTo(rock));
        System.out.println(rock.compareTo(rock));
    }
}
