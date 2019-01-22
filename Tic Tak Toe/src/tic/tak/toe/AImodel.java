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
 * @author Ziad
 */
class AImodel extends GamePlay implements ModulesInterface {
    
protected String compMove;
protected String move;
protected String val;
//board at the start of the game of ai mode intialized with the number of panes
//public String [] origBoard;

protected String [] preferred_moves={"4","0","2","8","1","3","5","7"};
//protected String [] origBoard={"0","1","2","3","4","5","6","7","8"};
String huPlayer="O";
String aiPlayer="X";
int count;

@Override
public String emptySpots(String [] board){
     List<String> list = new ArrayList<>();
//    String [] emptySpots=new String[9];
//    for(int i=0;i<9;i++){
//        if(board[i]!="o"&&board[i]!="x"){
//            //add the available spot in a new array
//          emptySpots[i]=board[i];
//        }
//    }
count =0;
    for(int i=0;i<board.length;i++)
    {
        if(board[i]==null)
        {
            count++;
            list.add(Integer.toString(i));
        }
    }
    
    String randomElement;
    if(count >0)
    {
        Random rand = new Random();
         randomElement = list.get(rand.nextInt(list.size()));
    }
    else
    {
         randomElement = "12";
    }
     
    
//    
//    for(int k=0;k<emptySpots.length;k++)
//    {
////        System.out.print(emptySpots[k]);
//        if(emptySpots[k]!= null)
//        {
//             val= emptySpots[k];
//            
//        }
//        
//    }
    return randomElement;


    
}
//check terminal state 
public int getState(GamePlay gameObj){
    String whoWon=gameObj.checkWinner();
    if(whoWon=="x"){
        return 10;
    }
    if(whoWon=="o"){
        return -10;
    }else{
        return 0;
    }
}
    
// minimax function
//public String miniMax(String [] board){
//    String [] validSpots=emptySpots(board);
//    String []moves=new String[validSpots.length];
//    for(int i=0;i<validSpots.length;i++){
//        moves[i]=validSpots[i];
//    }
//    //get best move and apply the minimax incompleted
//    return compMove;
//}


AImodel(){
 
for(int i=0;i<9;i++)
{
    compMove=preferred_moves[i];
    if(can_put_here(compMove)==true){
        set_player2_pos(compMove);
        break;
       
    }
}
}

    @Override
    public String test() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set_player2_pos(String pos) {
       move=pos; 
    }

    @Override
    public String get_player2_pos() {
        return move;
    }

    @Override
    public boolean other_player_can_play() {
        if(move != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public String getmove(String[] board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getbestmove(String[] board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

