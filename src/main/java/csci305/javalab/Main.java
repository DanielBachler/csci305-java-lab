package csci305.javalab;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;
import java.util.Scanner;

//TODO: redo mybot, comment, and clean, finish main method (figure out how to cut compareTo message down and track wins)
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
        //Prints welcome message
        System.out.println("Welcome to Rock, Paper, Scissors, Lizard, Spock, implemented by Daniel Bachler.");
        //Prints menu of choices
        System.out.println("Please choose two players:\n" +
                "     (1) csci305.javalab.Human\n" +
                "     (2) csci305.javalab.StupidBot\n" +
                "     (3) csci305.javalab.RandomBot\n" +
                "     (4) csci305.javalab.IterativeBot\n" +
                "     (5) csci305.javalab.LastPlayBot\n" +
                "     (6) csci305.javalab.MyBot\n");
        //Setting up players
        Player playerOne;
        Player playerTwo;
        //Making the scanner for input
        Scanner playerInput = new Scanner(System.in);
        //Ints for both player numbers
        int playerOneNum;
        int playerTwoNum;
        //Logic to make sure the num picked for player 1 is correct.
        do {
            System.out.print("Select player 1: ");
            playerOneNum = playerInput.nextInt();
            if(playerOneNum < 1 || playerOneNum > 6) {
                System.out.println("Please pick a valid number");
            }
        } while(playerOneNum < 1 || playerOneNum > 6);
        //Logic to make sure the num picked for player 2 is correct.
        do {
            System.out.print("Select player 2: ");
            playerTwoNum = playerInput.nextInt();
            if(playerTwoNum < 1 || playerTwoNum > 6) {
                System.out.println("Please pick a valid number");
            }
        } while(playerTwoNum < 1 || playerTwoNum > 6);
        //Sets both players to their respective types
        playerOne = getPlayer(playerOneNum);
        playerTwo = getPlayer(playerTwoNum);

        //Prints fight message
        System.out.println(playerOne.getName() + " VS " + playerTwo.getName() + ". GO!");
        //Plays the 5 rounds, and calculates winner
        for(int i = 1; i < 6; i++) {
            //Prints the round number
            System.out.printf("Round %d:", i);
            //Gets the moves of both players
            Element moveOne = playerOne.play();
            Element moveTwo = playerTwo.play();

            //Logic for last play bot
            if(playerOne.getName().equals("csci305.javalab.LastPlayBot")) {
                playerOne.setLastPlay(moveTwo);
            }
            if(playerTwo.getName().equals("csci305.javalab.LastPlayBot")) {
                playerTwo.setLastPlay(moveOne);
            }

            //Prints the chosen moves
            System.out.println("Player 1 chose: " + moveOne.getName());
            System.out.println("Player 2 chose: " + moveTwo.getName());


        }
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

    //A method to test the player classes
    public static void testPlayers() {
        csci305.javalab.Player p1 = new StupidBot("csci305.javalab.StupidBot");
        csci305.javalab.Player p2 = new csci305.javalab.RandomBot("csci305.javalab.RandomBot");
        Element p1move = p1.play();
        Element p2move = p2.play();
        System.out.println(p1move.compareTo(p2move));
    }

    //A method to test human player against stupid bot
    public static void testHuman() {
        Human human = new Human("Human");
        StupidBot stupidBot = new StupidBot("StupidBot");
        Element humanMove = human.play();
        Element botMove = stupidBot.play();
        System.out.println(humanMove.compareTo(botMove));
    }

    //Switches the given num to return a player type
    //Returns a stupid bot in the rare case an improper number is passed
    private static Player getPlayer(int num) {
        switch (num) {
            case 1:
                return new Human("csci305.javalab.Human");
            case 2:
                return new StupidBot("csci305.javalab.StupidBot");
            case 3:
                return new RandomBot("csci305.javalab.RandomBot");
            case 4:
                return new IterativeBot("csci305.javalab.IterativeBot");
            case 5:
                return new LastPlayBot("csci305.javalab.LastPlayBot");
            case 6:
                return new MyBot("csci305.javalab.MyBot");
        }
        return new StupidBot("csci305.javalab.StupidBot");
    }
}
