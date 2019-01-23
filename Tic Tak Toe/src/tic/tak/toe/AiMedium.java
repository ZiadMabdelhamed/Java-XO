/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tak.toe;

import java.util.ArrayList;
import java.util.List;
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


                List<String> list = new ArrayList<>();
          
                count =0;
               for(int i=0;i<board.length;i++)
               {
                   if(board[i]==null)
                   {
                       count++;
                       list.add(Integer.toString(i));
                   }
               }

               
               if(count >0)
               {
                   Random rand = new Random();
                    randomElement = list.get(rand.nextInt(list.size()));
               }
               else if(count==9)
               {
                    randomElement = "12";
               }

               bestmove= randomElement;
               if(can_put_here(bestmove)==true){
                set_player2_pos(bestmove);
               }
               return bestmove;
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
