# Rock-Paper-Scissors-Lizard-Spock
## Java Programming Lab

## Concepts of Programming Languages
## CSCI 305, Spring 2018

# Due: April 13, 2018 at Midnight (MDT)

Table of Contents
=================

   * [Troubleshooting](#troubleshooting)
   * [Java](#java)
   * [Game Overview](#game-overview)
   * [<em>Step -1:</em> Fork and Clone this Repository](#step--1-fork-and-clone-this-repository)
   * [<em>Step 0:</em> Familiarize yourself with Gradle](#step-0-familiarize-yourself-with-gradle)
      * [Implementation](#implementation)
        * [Element Class](#element-class)
        * [Self-Check](#self-check)
        * [csci305.javalab.Player Class](#player-class)
        * [Stupid Bot](#stupid-bot)
        * [Random Bot](#random-bot)
        * [Iterative Bot](#iterative-bot)
        * [LastPlay Bot](#lastplay-bot)
        * [csci305.javalab.Human csci305.javalab.Player](#human-player)
           * [Sample output of a move from the csci305.javalab.Human csci305.javalab.Player](#sample-output-of-a-move-from-the-human-player)
        * [My Bot](#my-bot)
        * [Self Check](#self-check-1)
        * [Main Class](#main-class)
   * [Lab Questions](#lab-questions)
      * [Figure 2. Sample Game Output](#figure-2-sample-game-output)
   * [Submission](#submission)
   * [Grading](#grading)

# Troubleshooting
This lab requires an independent study of the Java language. You are encouraged to use any web tutorials and resources to learn Java beyond those in the book and provided by me (i.e. you will need to find them).
- ### **Given the size of the class, I will not be able to debug your code for you**
- ### **Please do not send panicked emails requesting I fix your bug for you.**
- ### **Allow yourself plenty of time, and use patience, perseverance, and the internet to debug your code.**

I will gladly answer **clarifying questions about the goals and instructions of the Lab assignment**. What this means is that if you come to my office hours or email me with questions concerning the following items or their derivatives, the provided stock answer applies. When it comes to these assignments, think of me more as your client/customer who is acquiring your product. **Before coming to me with a question regarding the assignment, ask whether you would ask a client/customer that question.**
* Can you take a look at this code and tell me what I'm doing wrong? No.
* Can you help me debug this program? No.
* Can you help me get XXX running on my computer? No.
* Can you tell me why my code isn't working? No.

# Java

For this lab you will use Java. Java is already install on all machines in the lab, if you wish to install Java yourself, please visit [Java Website](http://www.oracle.com/java).

All students should use **Java 8 Standard Edition** for this lab.

# Game Overview

Rock-paper-scissors-lizard-Spock is a five-gesture expansion of the classic game rock-paper-scissors. The game was invented by Sam Kass, but popularized in the clip from the TV show `Big Bang Theory`: [Click to see a clip](https://www.youtube.com/watch?v=x5Q6-wMx-K8). You may also find the Wikipedia page [on the game](http://en.wikipedia.org/wiki/Rock-paper-scissors-lizard-Spock) useful as well.

This diagram explains the outcomes of the game:

![Image of RPSLS](https://vignette.wikia.nocookie.net/bigbangtheory/images/7/7d/RPSLS.png/revision/latest?cb=20120822205915)

# *Step -1:* Fork and Clone this Repository
1. Using the Fork button above fork your own version of this repository.
2. On your system, use your installation of Git to clone **your fork** of this repo on your local machine.
3. Once you have the repository cloned, you can continue on.

# *Step 0:* Familiarize yourself with Gradle
This project uses gradle to manage dependencies and to build the project. Thus you should learn the basic commands.

1. **Building the project:** From the project root directory, in the terminal/console run the following command:
  * On Mac and Linux:
  ```
    ./gradlew clean build
  ```
  * On Windows
  ```
    .\gradlew.bat clean build
  ```
2. **Testing the project:** Again, from the project root directory, in the terminal/console run the following command:
  * On Mac and Linux:
  ```
    ./gradlew clean test
  ```
  * On Windows:
  ```
    .\gradlew.bat clean test
  ```

## Implementation

For this lab, you will implement this game, in Java, in an object-oriented way.

Failure to implement the game using an Object Oriented approach (as described below) will result in a significant loss of points.

#### All classes developed as a part of this project should be located in the package: `csci305.javalab`
This package starts in the folder `src/main/java`

## Element Class
First create a class named `Element`. This class will serve as the superclass to five subclasses: `Rock, Paper, Scissors,` `Lizard, Spock`.

The `Element` class has one instance variable `name`, which will store the name of the Element (e.g., ``Rock'', ``Lizard'', etc). The constructor will take a name as a parameter and will save it to the instance variable `name`. Next, create a getter method called `getName()` that returns the instance variable `name`. Lastly, create an abstract method `compareTo` that takes an instance of the class `Element` as an argument. You will instantiate the method in the five concrete subclasses.

As the next step, create your five subclasses: `Rock, Paper, Scisssors, Lizard, Spock`. For each you should only need to implement (override) the `compareTo` method. Since Java does not allow you to return multiple types, you will need a small class called `Outcome`. `Outcome` has two instance variables representing the outcome of the `compareTo` method.

The first value contained in the `Outcome` class contains a string describing one of the following outcomes:

* Scissors cut Paper
* Paper covers Rock
* Rock crushes Lizard
* Lizard poisons Spock
* Spock smashes Scissors
* Scissors decapitate Lizard
* Lizard eats Paper
* Paper disproves Spock
* Spock vaporizes Rock
* Rock crushes Scissors

For a tie, you should output a string such as ``Rock equals Rock''.

The second value the `Outcome` should contain the value of the round outcome:

* Win
* Lose
* Tie

Now create one concrete instance of each of the five Elements and store these in a `static final` Map named `moves`, which is keyed by the name of the move and which contains values of type `Element` in the `Main` class. Throughout the lab, you will reuse these instances of the moves, rather than creating new instances as needed.

## Self-Check
You can now test your Element classes. For example, the code:

```java
public class TestElements {

  public static void main(String args[]) {
    Element rock = new Rock("Rock");
    Element paper = new Paper("Paper");
    System.out.println(rock.compareTo(paper));
    System.out.println(paper.compareTo(rock));
    System.out.println(rock.compareTo(rock));
  }
}
```

Should yield the following output:

```
  Paper covers rock -- Lose
  Paper covers rock -- Win
  Rock equals rock -- Tie
```

## csci305.javalab.Player Class

Next you will create a series of classes for the Players. Begin with a superclass named `csci305.javalab.Player`. This class has one instance variable `name`. Create a getter method called `getName()` that returns the variable `name`, which is set via the constructor. Also, create a abstract method `play()`. Now you are ready to create the concrete csci305.javalab.Player classes.

## Stupid Bot
Begin with a class named `csci305.javalab.StupidBot`. For this class, define the `play()` method to return the same move every time (e.g., `Rock, Paper`, etc.). Just pick a single move of your choice and have your `csci305.javalab.StupidBot` play this move each and every time.

## Random Bot
Next, create the class `csci305.javalab.RandomBot`. This csci305.javalab.Player will randomly pick and return one of the five possible moves from your `moves` list.

## Iterative Bot
Your next, csci305.javalab.Player, `csci305.javalab.IterativeBot`, begins with one move and cycles through all the moves, one by one, repeating the sequence only after having played all five moves.

## LastPlay Bot
csci305.javalab.Player `csci305.javalab.LastPlayBot` will always play the move that the opponent played on the previous move. You may implement this feature however you choose, but you will explain in your Lab Report. For this csci305.javalab.Player's first move, you may arbitrarily pick any move.

## csci305.javalab.Human csci305.javalab.Player
Next, you will define a `csci305.javalab.Human` class. This csci305.javalab.Player will ask the user to determine the move. For each turn, the `play()` method will print the options and request input from the user, as in Figure 1. Be sure to only accept valid moves from the user.

### Sample output of a move from the `csci305.javalab.Human` csci305.javalab.Player
```
  (1) : Rock
  (2) : Paper
  (3) : Scissors
  (4) : Lizard
  (5) : Spock
  Enter your move: 6
  Invalid move. Please try again.
  Enter your move: 2
```

## My Bot
Lastly, define a class `csci305.javalab.MyBot`. This csci305.javalab.Player can employ any strategy you determine that **differs** from the other Players described above. You will describe your strategy in your Lab Report.


## Self Check

You can now test your csci305.javalab.Player classes. For example, the code:

```java
public class TestPlayers {

    public static void main(String args[]) {
      csci305.javalab.Player p1 = new StudpidBot("csci305.javalab.StupidBot");
      csci305.javalab.Player p2 = new csci305.javalab.RandomBot("csci305.javalab.RandomBot");
      Element p1move = p1.play()
      Element p2move = p2.play()
      System.out.println(p1move.compareTo(p2move));
    }
}
```

might yield the following output:

```
  Rock crushes Scissors -- Lose
```

## Main Class

You will define a main class that will simulate a game of Rock-Paper-Scissors-Lizard-Spock. Your game will play five rounds between two players, determining the winner (or a draw) at the conclusion of the game. A sample output is shown in Figure 2.

Begin with a welcome message that also displays your name. Next have the user select `Player1` and `Player2` from a list. Again ensure that the user can only make valid selections of one of your six Players. Since all the Players implement the `play` method, the actual csci305.javalab.Player class instantiated will not be determined until runtime.

Now, using a loop structure, play five rounds of Rock-Paper-Scissors-Lizard-Spock. For each player, print out the move selected. Also, print out the result description (e.g., Rock crushes Scissors) and determine the round winner. Your output should resemble the example output in Figure 2. You should be keeping score so that you can determine the game winner after the five rounds. Print out the game winner.

# Lab Questions (50 Points)

1. Describe your csci305.javalab.Player `csci305.javalab.LastPlayBot`. How did you implement this strategy? (5 points)
2. Describe your csci305.javalab.Player `csci305.javalab.MyBot`, explaining the strategy you employed and how you accomplished it. (5 points)
3. Using the course notes and any web resources of your choosing, explain the type system of Java, giving attention to the concepts of binding time, dynamic vs. static typing, strong vs. weak typing, and user-defined types (classes). Cite any sources you used other than class discussion or the textbook. (15 points)
4. Play a number of games, selecting your various players. Do you notice any trends? Are you, as the csci305.javalab.Human csci305.javalab.Player, able to beat any of the Bots on a consistent basis? (5 points)
5. Read the wikipedia entry on [Normal Form Games](http://en.wikipedia.org/wiki/Normal-form_game). Also, review the Wikipedia page on [Rock-paper-scissors-lizard-Spock](http://en.wikipedia.org/wiki/Rock-paper-scissors-lizard-Spock). Is it possible to design a csci305.javalab.Player strategy that is more likely to succeed? Why or why not? Explain in a paragraph. It is possible to answer this question even if you did not finish the Lab. (10 points)

The following questions are for feedback and evaluation purposes. Points are awarded for any sincere answer. (1 point per question)

6. Name something you like about Java. Explain.
7. Name something you dislike about Java. Explain.
8. Did you enjoy this lab? Which aspects did you like and/or dislike?
9. Approximately how many hours did you spend on this lab?
10. How much experience have you had in Java prior to this course?

Finally, 5 points will be given upon evaluation of your code for the following:
* Appropriate comments for each non-overridden public method.
* Appropriate comments for each class defined.
* Code is well formatted and easy to read.
* All types defined the assignment are defined in your code.
* All methods and fields mentioned in the assignment are defined in your code.

#### Figure 2. Sample Game Output
```
  Welcome to Rock, Paper, Scissors, Lizard, Spock, implemented by <Your Name Here>.

  Please choose two players:
     (1) csci305.javalab.Human
     (2) csci305.javalab.StupidBot
     (3) csci305.javalab.RandomBot
     (4) csci305.javalab.IterativeBot
     (5) csci305.javalab.LastPlayBot
     (6) csci305.javalab.MyBot

  Select player 1: 2
  Select player 2: 3

  csci305.javalab.StupidBot vs csci305.javalab.RandomBot. Go!

  Round 1:
    csci305.javalab.Player 1 chose Scissors
    csci305.javalab.Player 2 chose Rock
    Rock crushes Scissors
    csci305.javalab.Player 2 won the round

  Round 2:
    csci305.javalab.Player 1 chose Scissors
    csci305.javalab.Player 2 chose Spock
    Spock smashes Scissors
    csci305.javalab.Player 2 won the round

  Round 3:
    csci305.javalab.Player 1 chose Scissors
    csci305.javalab.Player 2 chose Paper
    Scissors cut Paper
    csci305.javalab.Player 1 won the round

  Round 4:
    csci305.javalab.Player 1 chose Scissors
    csci305.javalab.Player 2 chose Lizard
    Scissors decapitate Lizard
    csci305.javalab.Player 1 won the round

  Round 5:
    csci305.javalab.Player 1 chose Scissors
    csci305.javalab.Player 2 chose Scissors
    Scissors equals Scissors
    Round was a tie

  The score is 2 to 2.
  Game was a draw
```

# Submission
Each student will complete and submit this assignment individually. Do not consult with others. However, you are encouraged to use the Internet to learn any aspect of Java you need to complete the assignment.

Comment your program appropriately.

Save the final version of your program and zip the source code into a file named `[lastname]_[firstname].java_lab.zip`. Type your lab questions in plain text as `[lastname]_[firstname].java_lab.txt`. Include your name in the text file.

We must be able to run your program from the command line with no arguments.

Submit your files to the Java Lab dropbox folder on BrightSpace. Submit your files before the due date as late submissions will not be accepted.

# Grading
Total Assignment Points: 90, Total Grade Points: 7.5

The rubric for this assignment is as follows:
* 5 points each for questions 1 - 9, Total 45 points
  - Questions 1 - 5, will be graded on partial credit
  - Questions 6 - 9, will be given full credit for reasonable answers
* 20 points for working code, with no errors: All or nothing
* 15 points for documented code
  - 2 points per class
  - 1 point for overall quality
