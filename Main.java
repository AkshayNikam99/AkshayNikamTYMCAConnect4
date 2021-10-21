package Connect4Game;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Rows and Colums and ConnectPieceNUmber : ");
		ConnectFourGame gameStart=new ConnectFourGame("R","Y",sc.nextInt(),sc.nextInt(),sc.nextInt());
        gameStart.startGame();
        
        sc.close();
	}
}
