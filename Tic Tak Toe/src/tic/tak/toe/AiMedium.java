/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tak.toe;

import java.util.Random;

/**
 *
 * @author El Mansy
 */
public class AiMedium extends GamePlay implements ModulesInterface {
    
     protected String bestmove;
    private String[] board;
    int count;
    String randomElement;
    
    
        public String getbestmove(String[] board)
    {
        
        int move = 0;
                
	//Set types of positions (used for prioritizing move choice)
        int[] corners = new int[] {0, 2, 6, 8};
	int[] sides = new int[] {1, 3, 5, 7};
		
         this.board=board;
        String bestmove=null;
        
        for(int i=0;i<board.length;i++)
        {
            if(board[i]==null)
            {
            
                // if the ai can win
                if(isWinnerWith("o",Integer.toString(i)))
                {
                    bestmove=Integer.toString(i);
                    if(can_put_here(bestmove)==true){
                        set_player2_pos(bestmove);
                       }
                    return bestmove;
                }
                
            
            }
        }
        
          for(int i=0;i<board.length;i++)
        {
            if(board[i]==null)
            {
            
                // if the player can win
                if(isWinnerWith("x",Integer.toString(i)))
                {
                    bestmove= Integer.toString(i);
                    if(can_put_here(bestmove)==true){
                    set_player2_pos(bestmove);
                   }
                    return bestmove;
                }
                
            
            }
        }
          
          move = randomFromArray(corners); //Pick a random corner
		if(move != -1){
                    bestmove=Integer.toString(move);
                         if(can_put_here(bestmove)==true){
                        set_player2_pos(bestmove);
                         
			return bestmove;
			}
                }
		//Test if the center is open (in general better than sides)
		if(null==board[4]){
			move = 4; //I know I could just return 4, but I'd rather use move
                        bestmove=Integer.toString(move);
                         if(can_put_here(bestmove)==true){
                        set_player2_pos(bestmove);
			return bestmove;
                    }
                }
		//Test if any sides are open (last option)
		move = randomFromArray(sides); //Pick a random side
		if(move != -1){
                    bestmove=Integer.toString(move);
                    
                    if(can_put_here(bestmove)==true){
                        set_player2_pos(bestmove);
                         
			return bestmove;
			}
                }
		//There's nothing open...we should never reach this point (World should have realized
		//this earlier)
		return "12";
	}
        
        
         
        private boolean isWinnerWith(String turn,String move)
        {
            String[] tempboard=new String[9];

            for(int i=0;i<9;i++)
            {
                tempboard[i]=this.board[i];   
            }

            tempboard[Integer.parseInt(move)]= turn;
            boolean win=isWinner(turn,tempboard);

            return win;
        }

        public boolean isWinner(String turn,String[] tb)
        {
            return ((tb[0] == turn && tb[1] == turn && tb[2] == turn) || //Across Top
                                    (tb[3] == turn && tb[4] == turn && tb[5] == turn) || //Across Mid
                                    (tb[6] == turn && tb[7] == turn && tb[8] == turn) || //Across Bottom
                                    (tb[0] == turn && tb[3] == turn && tb[6] == turn) || //Down Left
                                    (tb[1] == turn && tb[4] == turn && tb[7] == turn) || //Down Mid
                                    (tb[2] == turn && tb[5] == turn && tb[8] == turn) || //Down Right
                                    (tb[0] == turn && tb[4] == turn && tb[8] == turn) || //Diag TL -> BR
                                    (tb[2] == turn && tb[4] == turn && tb[6] == turn)    //Diag TR -> BL
                                    );
        }
        
        
        
        private int randomFromArray(int[] list)
        {        // System.out.println("rrrrr");
		int[] okMoves = new int[4]; //List of moves that are not already filled
		int move = -1;
		Random choose = new Random(); //Create a new random number generator
		
		//Run through each member of the list and test it to see if it is usable.
		//If it is, put it into the list of ok moves. If it is not, put -1 in its place (NOK)
		for(int i=0; i<4; i++)
                {
			//Test if it's free
			if(isFree(list[i]))
				//It is, put it in the ok list
                        { //  System.out.println(board[i]+"ggggg"+list[i]);
				okMoves[i] = list[i];
                        }
			//It is not, put -1 in its place
			else
				okMoves[i] = -1;
		}
		
		//Brute force check to make sure there is at least one valid value
		if(okMoves[0] == -1 && okMoves[1] == -1 && okMoves[2] == -1 && okMoves[3] == -1){
			return -1; //If there isn't, return a bad status
		//If there is at least one valid value
		} else {
			//Brute force until we get a choice that's not -1.
			do{
				move = choose.nextInt(okMoves.length);
			} while(okMoves[move] == -1);
			return okMoves[move]; //Return the valid move
		}
	}
        public boolean isFree(int move){
		String[] tempboard = board;
		//If the space is empty, return true
		if(null==tempboard[move]){
			return true;
		}
		else{
			return false;
		}
	}

    @Override
    public String test() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set_player2_pos(String pos) {
       bestmove=pos; 
    }

    @Override
    public String get_player2_pos() {
        return bestmove;
    }

    @Override
    public boolean other_player_can_play() {
        if(bestmove != null)
        {
            return true;
        }
        return false;
    }
    
    @Override
    public String emptySpots(String[] board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getmove(String[] board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

          
    
}
