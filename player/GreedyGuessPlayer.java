package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Scanner;
import world.World;
import world.World.Coordinate;
import world.OppWorld;

/**
 * Greedy guess player (task B).
 * Please implement this class.
 *
 * @author Youhan Xia, Jeffrey Chan
 */
public class GreedyGuessPlayer extends Guesser implements Player{

    public List<Guess> checkerBoardGuesses;

    @Override
    public void initialisePlayer(World world) {
        // To be implemented.
        this.myWorld = world;
        this.opponentsWorld = new OppWorld(world.numRow, world.numColumn, true);
        this.hitsToMyFleet = new ArrayList<>();
        this.checkerBoardGuesses = new ArrayList<>();
        enumerateGuesses(checkerBoardGuesses);
    } // end of initialisePlayer()

    private void enumerateGuesses(List<Guess> list) {
        for(int row = 0; row < myWorld.numRow; ++row){
            for(int col = row%2; col < myWorld.numColumn; col+=2){
                Guess g = new Guess();
                g.row = row;
                g.column = col;
                list.add(g);
            }
        }
    }

    //@Override
    //public Answer getAnswer(Guess guess) {
        // To be implemented.
        
        // dummy return
    //    return null;
    //} // end of getAnswer()


    @Override
    public Guess makeGuess() {
        // To be implemented.
        Random random = new Random();
        System.out.println("PossibleTargets before check: "+opponentsWorld.possibleTargets.size());
        System.out.println(checkerBoardGuesses.size());
        Boolean isTarget = false;

        int directionNumber = random.nextInt(4);
        System.out.println(" ** Create a random #: " + directionNumber);

            Guess aimTarget = checkerBoardGuesses.get(random.nextInt(checkerBoardGuesses.size()));
            //getAnswer
            
            //aimTarget.row = 0;
            //aimTarget.column = 0; 
            System.out.println(getAnswer(aimTarget).isHit);
            System.out.println(getAnswer(aimTarget).toString());
            if (getAnswer(aimTarget).isHit)
            {
                 isTarget = true;
            }

        while (isTarget != false)
        {
            System.out.println("** Targeting mode **");
            Guess gShoot = new Guess();
            Coordinate tempCoordShoot = myWorld.new Coordinate();
            //tempCoord = opponentsWorld.possibleTargets.remove(0);
            gShoot.row = aimTarget.row;
            gShoot.column = aimTarget.column;

            switch (directionNumber)
            {
                case 0:
                    if(aimTarget.row != 9)
                    {
                        gShoot.row = aimTarget.row + 1;
                        break;
                    }
                case 1:
                    {
                        if(aimTarget.column != 9)
                        gShoot.column = aimTarget.column + 1;
                        break;
                    }
                case 2:
                    {
                        if(aimTarget.row != 0)
                        gShoot.row = aimTarget.row - 1;
                        break;
                    }
                case 3:
                    {
                        if(aimTarget.row != 0)
                        gShoot.column = aimTarget.column - 1;
                        break;
                    }
            }
            
            isTarget = false;
            //return gShoot;

            // ** Targeting mode **
            // if ( opponentsWorld.possibleTargets.size() > 0 )
            // {           
                // Guess g = new Guess();
                // Coordinate tempCoord = myWorld.new Coordinate();
                // tempCoord = opponentsWorld.possibleTargets.remove(0);

                // g.row = tempCoord.row;
                // g.column = tempCoord.column;
                
                // /*
                //  *  Check if this possible target is in the checkBoardGuesses list
                //  *  This is to avoid duplicate guesses
                //  */
                // Guess tempGuess = new Guess();
                // for ( int i = 0; i < checkerBoardGuesses.size(); i++ ) 
                // {
                //     tempGuess = checkerBoardGuesses.get(i);
                //     if ( ( tempGuess.row == g.row ) && ( tempGuess.column == g.column ) )
                //     {
                //         checkerBoardGuesses.remove(i);
                //         i = checkerBoardGuesses.size(); // TO EXIT LOOP
                //     }
                // }
                // return g;
            //}
        }


        System.out.println("** Hunting mode **");
        // ** Hunting mode **
        //Random random = new Random();
        //temp solution
        int index = 0;
        if (checkerBoardGuesses.size() == 0){
            index = 0;
            System.out.println("return dummy value here!");
            Guess g = new Guess();

            g.row = random.nextInt(10);
            g.column = random.nextInt(10);
            System.out.println(g.row+","+g.column);

            return g;
        }
        else if(checkerBoardGuesses.size() != 0){
            index = random.nextInt(1000) % checkerBoardGuesses.size();
        }
        System.out.println("print index before remove:" + index);
        System.out.println("print before remove: " + checkerBoardGuesses.get(index));
        return checkerBoardGuesses.remove(index);

        //if hit (isHit == true) go to ** Targeting mode **

        //if not hit (isHit != true) stay at ** Hunting mode **

        // dummy return
        //return null;
        
    } // end of makeGuess()


    @Override
    public void update(Guess guess, Answer answer) {
        // To be implemented.
    } // end of update()


    //@Override
    //public boolean noRemainingShips() {
        // To be implemented.

        // dummy return
    //    return true;
    //} // end of noRemainingShips()

} // end of class GreedyGuessPlayer
