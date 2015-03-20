package Nim;


/**
 * An interface that represents a player in the game of Nim.
 *
 * @author Jake
 */
public interface Player {

    int move(int pileCount);             //player's move

    boolean wantsFirstPlay();   //returns whether player moves first

    String getName();           //gets name of player

}
