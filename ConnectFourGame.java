package Connect4Game;

import java.util.Scanner;

public class ConnectFourGame {
	private Board board;
	private String color1;
	private String color2;
	public int r;
	public int c;
	public int n;
	private boolean is1Playing;//if it is True(PLAYER 1) and if it is false(PLAYER 2) 

	public ConnectFourGame() {}
	//Constructor 
	public ConnectFourGame(String color1 , String color2, int r,int c,int n) {
	
		
		this.color1=color1;
		this.color2=color2;
		System.out.println(r+" "+c);
		this.r=r;
		this.c=c;
		this.n=n;
		this.board=new Board(r,c,n);
		//is1Playing=(new Random()).nextBoolean();
		is1Playing=true;
	}//Constructor
	
	public boolean checkwinner(int columnToAdd) {
		String winnercolor;
		if(is1Playing) {
			winnercolor=color1;
		}
		else {
			winnercolor=color2;
		}
		return board.checkForWinner(columnToAdd,winnercolor);
	}
	
	public void startGame() {
	  //TO check Game is going or not 
		boolean running=true;
		
		while(running) {
			
		    //Printing the board before Insert
			board.printBoard() ;
			
			//Select the color to choose player
			String color ;
			if(is1Playing) {
				color=color1;
				System.out.println("Player "+  color1  +" turn");
			}
			else {
				color=color2;
				System.out.println("Player "+ color2 +" turn");
			}
			
			int c1=c-(c-1);
			System.out.print("Select the column between"+c1+" to " +c+ ":" );
			
			Scanner input1=new Scanner(System.in);
			int columnToAdd = input1.nextInt();
		    if(running == false) {
		    	input1.close();
		    }
			
		   boolean success= board.addPiece(columnToAdd-1, color); //here we columnToadd-1 bcz we put 1 to 7 value , 1-1=0
			
			if(success) {
				
				if(checkwinner(columnToAdd-1)) {
					board.printBoard();
					 running=false;
					if(is1Playing) {
					System.out.println("Player "+color1+ " won");
					}
					else {
						System.out.println("Player "+color2+ " won");
					}
					System.out.println("You want to play again");
					System.out.print("Press Y for Play AND N for No  : ");
					Scanner sc=new Scanner (System.in);
					String y=sc.next();
					if(y.equals("Y")) {
					  //this.board=new Board();
					  //is1Playing=true;
						Main.main(null);
					}
					else {
						System.exit(1);
					}
					sc.close();
				}
				is1Playing= !is1Playing;
			}	
		}
	}	
}
