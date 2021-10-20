package Connect4Game;

public class Board {

	/*public  int rows=super.getRow();
	public  int columns=super.getColumn();
	public String[][] myboard=new String[rows][columns];*/
	public int rows;
	public int columns;
	String[][] myboard;

	

	public boolean checkForWinner(int columnToAdd , String winnercolor) {
		
		//First we check on which row piece get inserted
		for(int row=0; row < rows ; row++) {
			
			if(myboard[row][columnToAdd]!=null) {
				//Here we Create the variable for streak 
				int winnerstreak=3;
				
				//-----------------------------------------------------------------------------
				//Check For downWard
				for(int winrow=row+1 ; winrow<rows ; winrow++ ) {
					if(myboard[winrow][columnToAdd]==winnercolor) {
						winnerstreak--;
						System.out.println(winnerstreak);
						if(winnerstreak==0) {
							return true;
						}	
					}//if
					else {
					winnerstreak=3;
				   }
				}//for end of downward
				//----------------------------------------------------------------------------------
				
				
				winnerstreak=4;
				//-----------------------------------------------------------------------------
				//Check For Horizontal 
			  for(int winCol = columnToAdd - 3; winCol <= columnToAdd + 3; winCol++) {
	                    if(winCol < 0) continue;
	                    if(winCol >= columns) break;

	                    if(myboard[row][winCol] != null && myboard[row][winCol]==winnercolor) {
	                        winnerstreak--;
	                        if(winnerstreak == 0) { 
	                        	return true;
	                        }
	                    } else {
	                    	winnerstreak = 4;
	                    }
	                }

			   //-----------------------------------------------------------------------------
			  winnerstreak=4;
               //check for left diagonal
			  
			  for(int winrow=row-3 ,  wincol=columnToAdd-3 ; winrow<=row+3  &&  wincol<=columnToAdd+3 ; winrow++,wincol++) {
				  if(winrow<0 || wincol<0)continue;
				  if(winrow>=rows || wincol>=columns)break;
				  
				  if(myboard[winrow][wincol] != null && myboard[winrow][wincol]==winnercolor) {
					  winnerstreak--;
					  if(winnerstreak==0) {
						  return true;
					  }
				  }
				  else {
					  winnerstreak=4;
				  }
			  }
			  
			  
			  
			  //-----------------------------------------------------------------------------
			  winnerstreak=4;
               //check for right diagonal
			  
			  for(int winrow=row-3 ,  wincol=columnToAdd+3 ; winrow<=row+3  &&  wincol<=columnToAdd+3 ; winrow++,wincol--) {
				  if(winrow<0 || wincol<0)continue;
				  if(winrow>=rows || wincol>=columns)break;
				  
				  if(myboard[winrow][wincol] != null && myboard[winrow][wincol]==winnercolor) {
					  winnerstreak--;
					  if(winnerstreak==0) {
						  return true;
					  }
				  }
				  else {
					  winnerstreak=4;
				  }
			  }  
				
			}//if
		}//for
		return false;
	}//checkForWinner() method
	
	
	//TO add a piece into Board , return boolean value
	//returns true if it succesfull
	//returns false if it not succesfull
	public boolean addPiece(int columnToAdd , String Color) {
	
		//This check Column between Range or Not
		if(columnToAdd >= 0 && columnToAdd < columns) {
			
			//We can add now
			if(myboard[0][columnToAdd]==null) {
				
				boolean addToPiece = false; //it return ,is it succes or not
				for(int row = rows-1 ; row>=0  ; row--) {
					if(myboard[row][columnToAdd]==null) {
						//myboard[row][columnToAdd]=new Piece();
						myboard[row][columnToAdd]=Color;
						addToPiece = true;
						break;
					}//if
				}//for
				return addToPiece; //it get success
			}//1st If
			System.out.println("The column is full , please choose another Column");
		}
	  System.out.println("Please Choose Column Range between 1 To 7 ");
	  
	  return false; // not success
	}//addPiecemethod
	
	
	//TO PRINT BOARD
	public void printBoard() {
		
		//To print HeaderLine for myboard
		for(int upline=0 ; upline <10; upline ++ ) {
	    	 System.out.print("---");
	     }
	     System.out.println();
	   
	     for(int row= 0 ; row<rows ; row++) {
	    	 System.out.print(" | ");
	    	 for(int col=0 ; col<columns ; col++) {
	    		 if(myboard[row][col]==null) {
	    			 System.out.print("_");
	    		 }
	    		 else {
	    			 System.out.print(myboard[row][col]); 
	    		 }//else
	    		 System.out.print(" | ");
	    	 }//2nd For loop
	    	 System.out.println();
	     }//1st for Loop
	     for(int downline=0 ; downline<10; downline++ ) {
	    	 System.out.print("---");
	     }
	     System.out.println(); 
	}//printBoard()
	
	public Board(int r, int c) {
		 rows=r;
		 columns=c;
		 myboard=new String[rows][columns];
		 for(int row = 0 ;row<rows;row++) {
			for(int col1=0 ;col1<columns;col1++) {
				myboard[row][col1]=null;
			}
		}
	}		
}
