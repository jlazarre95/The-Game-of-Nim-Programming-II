package Nim;
import javax.swing.JOptionPane;

//  PROGRAMMER:  Jahkell Lazarre  
//
//  CLASS:       COP 3337   TU/TH 5:00
//
//  INSTRUCTOR:  Greg Shaw  
//
//  ASSIGNMENT:  #3 Nim   DUE Tuesday 10/14/14
//
// CERTIFICATION: I certify that this work is my own and that
//                 none of it is the work of any other person.
//
public class NimTester {

    public static void main(String[] args) {
        String input;

        do {
            System.out.println("**********New Game**********\n");
            HumanPlayer.resetHumanCount();
            HumanPlayer human = new HumanPlayer();

            //the A.I. can play against each other too! try it out!
            //Make sure to make line 16 an in-line comment though or
            //game will prompt you for player name & request your settings
            DumbComputer dumbAI = new DumbComputer();
            SmartComputer smartAI = new SmartComputer();

            Pile pile = new Pile();
            //pass any players to the Nim game here! (human, dumbAI, smartAI)
            Nim game = new Nim(human, getRequest(), pile);

            game.play();

            input = JOptionPane.showInputDialog("Play again?\nPress"
                    + " 'Y' to play again or any other key to quit.");
        } while (input.equalsIgnoreCase("y"));

    }
    
    private static Player getRequest() {
        
        Player playerRequest;

            String input2 = JOptionPane.showInputDialog("What type of player "
                    + "do you wish to play against?\nType 'D' for dumb"
                    + " AI\n'S' for smart AI\nor any other letter to play "
                    + "against another human player!");

            if (input2.equalsIgnoreCase("d")) {

                playerRequest = new DumbComputer();   

            } else if (input2.equalsIgnoreCase("s")) {

                playerRequest = new SmartComputer();   

            } else {

                playerRequest = new HumanPlayer();  

            }
            
            return playerRequest;

    }
}
