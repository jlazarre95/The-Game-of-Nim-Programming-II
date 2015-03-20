package Nim;


/**
 * An ancient game in which there are two players and a pile of marbles (from 10
 * to 100) and players must take turns and pick from 1 to n/2 marbles; the
 * player to pick up the last marble loses
 *
 * @author Jake
 */
public class Nim {

    Player player1;     //player that plays first
    Player player2;     //player that plays second
    Pile pile;          //pile of marbles

    /**
     * Constructs a game of Nim -- FOR HUMAN PLAYER(S): please pass human player
     * to player1 (will still prompt if player wants to go first) but for 
     * player2, ask for the player's request; if BOTH player1 AND player2 
     * are AI, player1 plays first automatically;
     *
     * @param player1 one of the players to be playing in this Nim game
     * @param player2 one of the players to be playing in this Nim game
     * @param pile pile of marbles to be used in this Nim game
     */
    public Nim(Player player1, Player player2, Pile pile) {

        this.pile = pile;           //pile of marbles

        //if player1 wants to play first, then let him/her
        if (player1.wantsFirstPlay()) {

            this.player1 = player1;
            this.player2 = player2;

        } //otherwise, player2 plays first
        else {

            this.player1 = player2;
            this.player2 = player1;

        }
    }

    /**
     * Plays the game of Nim until one player loses
     */
    public void play() {

        int amount;

        //keep the game going... (see 'while' condition at bottom)
        do {
            //prints remaining marbles that are in pile
            System.out.println("Number of marble(s) remaining in pile: "
                    + pile.getPileSize());
            //player 1 makes a move and removes amount from pile
            amount = player1.move(pile.getPileSize());

            pile.removeMarbles(amount);
            //prints how many marbles player 1 took from pile
            System.out.println("Player " + player1.getName() + " took " + amount
                    + " marble(s) from the pile.\n");
            //if after player 1's turn, there are no remaining marbles
            //in pile, print that player 2 wins -- otherwise, it is
            //player 2's turn: the same process repeats from here
            if (pile.getPileSize() == 0) {

                System.out.println("Player " + player2.getName() + " wins "
                        + "the game!\n\n");

                break;

            } else {

                System.out.println("Number of marble(s) remaining in pile: "
                        + pile.getPileSize());

                amount = player2.move(pile.getPileSize());

                pile.removeMarbles(amount);

                System.out.println("Player " + player2.getName() + " took " + amount
                        + " marble(s) from the pile.\n");

                if (pile.getPileSize() == 0) {

                    System.out.println("Player " + player1.getName() + " wins "
                            + "the game!\n\n");

                    break;

                }

            }
        } //...as long as there are still marbles in the pile after player1
        //and player 2's turns
        while (!(pile.getPileSize() == 0));

    }
}
