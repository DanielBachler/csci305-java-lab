package csci305.javalab;

import java.util.HashMap;
import java.util.Scanner;

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

    //Scanner for human input
    static Scanner playerInput = new Scanner(System.in);

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
        //Ints for both player numbers
        int playerOneNum;
        int playerTwoNum;
        //Logic to make sure the num picked for player 1 is correct.
        do {
            System.out.print("Select player 1: ");
            //Gets input from user
            playerOneNum = playerInput.nextInt();
            //Error checks input, prints message if check fails
            if(playerOneNum < 1 || playerOneNum > 6) {
                System.out.println("Please pick a valid number");
            }
        } while(playerOneNum < 1 || playerOneNum > 6);
        //Logic to make sure the num picked for player 2 is correct.
        do {
            System.out.print("Select player 2: ");
            //Gets user input
            playerTwoNum = playerInput.nextInt();
            //Error check, prints message if check fails
            if(playerTwoNum < 1 || playerTwoNum > 6) {
                System.out.println("Please pick a valid number");
            }
        } while(playerTwoNum < 1 || playerTwoNum > 6);
        //Sets both players to their respective types
        playerOne = getPlayer(playerOneNum);
        playerTwo = getPlayer(playerTwoNum);

        //Sets up win counters
        int playerOneWins = 0;
        int playerTwoWins = 0;

        //Prints fight message
        System.out.println(playerOne.getName() + " VS " + playerTwo.getName() + ". GO!");
        //Plays the 5 rounds, and calculates winner
        for(int i = 1; i < 6; i++) {
            //Prints the round number
            System.out.printf("\nRound %d:\n", i);
            //Gets the move for player 1
            Element moveOne = playerOne.play();

            //Since default method does nothing, passing to classes that do not use it is not important
            //With the exception of last play bot, if this executes it will always draw so it is called after
            if(!playerTwo.getName().equals("csci305.javalab.LastPlayBot")) {
                playerTwo.setLastPlay(moveOne);
            }


            //Gets move for player 2
            Element moveTwo = playerTwo.play();

            //Since default method does nothing, passing to classes that do not use it is not important
            playerOne.setLastPlay(moveTwo);

            //Last play bot only call
            if(playerTwo.getName().equals("csci305.javalab.LastPlayBot")) {
                playerTwo.setLastPlay(moveOne);
            }


            //Prints the chosen moves
            System.out.println("Player 1 chose: " + moveOne.getName());
            System.out.println("Player 2 chose: " + moveTwo.getName());

            //Gets the result
            String result = moveOne.compareTo(moveTwo);
            //Gets the spot to cut string
            int cutSpot = result.indexOf('-')-1;
            //The needed string
            String trueResult = result.substring(0,cutSpot);
            System.out.println(trueResult);

            //Gets the winner
            String condition = result.substring(cutSpot+3);
            if(condition.contains("Win")) {
                System.out.println("csci305.javalab.Player 1 won the round");
                playerOneWins++;
            } else if(condition.contains("Lose")){
                System.out.println("csci305.javalab.Player 2 won the round");
                playerTwoWins++;
            } else {
                System.out.println("Round was a tie");
            }
        }
        //Prints score and winner
        System.out.printf("\nThe score was %d to %d\n", playerOneWins, playerTwoWins);
        //If player 1 has more points, declares them winner, else if player 2 has more points declares them the winner
        //Finally only other option is a tie so prints that.
        if(playerOneWins > playerTwoWins) {
            System.out.println("Player 1 wins!");
        } else if(playerOneWins < playerTwoWins) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Game was a draw");
        }
        playerInput.close();
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
