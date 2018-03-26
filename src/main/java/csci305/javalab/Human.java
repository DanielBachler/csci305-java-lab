package csci305.javalab;

import java.util.Scanner;

//Is a human player, gives the player choices for what to do instead of choosing with a given method
public class Human extends Player {
    public Element play() {
        //Scanner for human input
        Scanner playerInput = new Scanner(System.in);
        //Prints choice menu
        System.out.println("(1) : Rock\n" +
                "(2) : Paper\n" +
                "(3) : Scissors\n" +
                "(4) : Lizard\n" +
                "(5) : Spock\n");
        //The int that hold player input
        int input;
        //Until a valid number is given loops asking for proper input
        do {
            //Prints message
            System.out.print("Enter your move: ");
            //Gets input
            input = playerInput.nextInt();
            //Checks if input is valid, if not prints error message for next loop
            if (input > 5 || input < 1) {
                System.out.println("Invalid move. Please try again.");
            }
        //If the input number is not valid loops again, else exits loop
        } while (input > 5 || input < 1);
        //Closes scanner
        playerInput.close();
        //Uses player keyGetter to get the right key, then returns it as an element
        return Main.finalMap.get(Player.keyGetter(input-1));
    }

    //Calls the super constructor
    public Human(String name){
        super(name);
    }
}
