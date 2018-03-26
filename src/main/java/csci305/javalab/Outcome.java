package csci305.javalab;

public class Outcome {
    String stringOne;
    String stringTwo;

    //Takes in two strings, the two items, and then decides who wins out of them.  The second string pertains to the first item
    //Meaning that if thing1 loses, thing2 wins.
    public Outcome(String thing1, String thing2) {
        switch (thing1) {
            case "Scissors":
                if (thing2.equals("Paper")) {
                    stringOne = "Scissors cut Paper";
                    stringTwo = "Win";
                } else if (thing2.equals("Lizard")) {
                    stringOne = "Scissors decapitate Lizard";
                    stringTwo = "Win";
                } else if(thing2.equals("Scissors")) {
                    stringOne = "Scissors equals Scissors";
                    stringTwo = "Tie";
                } else if(thing2.equals("Rock")) {
                    stringOne = "Rock crushes Scissors";
                    stringTwo = "Lose";
                } else if(thing2.equals("Spock")) {
                    stringOne = "Spock smashes Scissors";
                    stringTwo = "Lose";
                }
                break;
            case "Paper":
                if (thing2.equals("Paper")) {
                    stringOne = "Paper equals Paper";
                    stringTwo = "Tie";
                } else if (thing2.equals("Lizard")) {
                    stringOne = "Lizard eats Paper";
                    stringTwo = "Lose";
                } else if(thing2.equals("Scissors")) {
                    stringOne = "Scissors cut Paper";
                    stringTwo = "Lose";
                } else if(thing2.equals("Rock")) {
                    stringOne = "Paper covers Rock";
                    stringTwo = "Win";
                } else if(thing2.equals("Spock")) {
                    stringOne = "Paper disproves Spock";
                    stringTwo = "Win";
                }
                break;
            case "Rock":
                if (thing2.equals("Paper")) {
                    stringOne = "Paper covers Rock";
                    stringTwo = "Lose";
                } else if (thing2.equals("Lizard")) {
                    stringOne = "Rock crushes Lizard";
                    stringTwo = "Win";
                } else if(thing2.equals("Scissors")) {
                    stringOne = "Rock crushes Scissors";
                    stringTwo = "Win";
                } else if(thing2.equals("Rock")) {
                    stringOne = "Rock equals Rock";
                    stringTwo = "Tie";
                } else if(thing2.equals("Spock")) {
                    stringOne = "Spock vaporizes Rock";
                    stringTwo = "Lose";
                }
                break;
            case "Lizard":
                if (thing2.equals("Paper")) {
                    stringOne = "Lizard eats Paper";
                    stringTwo = "Win";
                } else if (thing2.equals("Lizard")) {
                    stringOne = "Lizard equals Lizard";
                    stringTwo = "Tie";
                } else if(thing2.equals("Scissors")) {
                    stringOne = "Scissors decapitate Lizard";
                    stringTwo = "Lose";
                } else if(thing2.equals("Rock")) {
                    stringOne = "Rock crushes Lizard";
                    stringTwo = "Lose";
                } else if(thing2.equals("Spock")) {
                    stringOne = "Lizard poisons Spock";
                    stringTwo = "Win";
                }
                break;
            case "Spock":
                if (thing2.equals("Paper")) {
                    stringOne = "Paper disproves Spock";
                    stringTwo = "Lose";
                } else if (thing2.equals("Lizard")) {
                    stringOne = "Lizard poisons Spock";
                    stringTwo = "Lose";
                } else if(thing2.equals("Scissors")) {
                    stringOne = "Spock smashes Scissors";
                    stringTwo = "Win";
                } else if(thing2.equals("Rock")) {
                    stringOne = "Spock vaporizes Rock";
                    stringTwo = "Win";
                } else if(thing2.equals("Spock")) {
                    stringOne = "Spock equals Spock";
                    stringTwo = "Tie";
                }
                break;
            default:
                stringTwo = "Error";
                stringOne = "Error";
                break;
        }
    }
}
