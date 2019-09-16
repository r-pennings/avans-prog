
public class Chess {

	String[][] board = new String[8][8];
	
	String possibleX = "abcdefgh";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chess chess = new Chess();
		
		chess.initializeBoard();
		chess.printBoard();
		
		chess.move("a2", "a4");
	}

	void initializeBoard() {
		System.out.println("Initializing chessboard...");
		System.out.println();
		
		board[0][0] = "T";
		board[0][1] = "R";
		board[0][2] = "B";
		board[0][3] = "Q";
		board[0][4] = "K";
		board[0][5] = "B";
		board[0][6] = "R";
		board[0][7] = "T";
		
		board[1][0] = "P";
		board[1][1] = "P";
		board[1][2] = "P";
		board[1][3] = "P";
		board[1][4] = "P";
		board[1][5] = "P";
		board[1][6] = "P";
		board[1][7] = "P";
		
		
		for(int x = 2; x <= 5; x++) {
			for(int y = 0; y <= 7; y++) {
				board[x][y] = " ";
			}
		}
		
		board[6][0] = "P";
		board[6][1] = "P";
		board[6][2] = "P";
		board[6][3] = "P";
		board[6][4] = "P";
		board[6][5] = "P";
		board[6][6] = "P";
		board[6][7] = "P";
	
		board[7][0] = "t";
		board[7][1] = "r";
		board[7][2] = "b";
		board[7][3] = "q";
		board[7][4] = "k";
		board[7][5] = "b";
		board[7][6] = "r";
		board[7][7] = "t";
	
	}
	
	void printBoard() {
		System.out.println("  | a b c d e f g h");
		System.out.println("  +----------------");
		
		for(int i = 0; i < 8; i++) {
			System.out.print((i + 1) + " | ");
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j]);
				System.out.print(" ");
				if (j == 7) {
					System.out.println();
				}
			}
		}
	}
	
	void move(String oldLocation, String newLocation) {
		char oldX = oldLocation.charAt(0);
		int oldY = Integer.parseInt(oldLocation.substring(1, 2));
		char newX = newLocation.charAt(0);
		int newY = Integer.parseInt(newLocation.substring(1, 2));
		
		System.out.println();
		System.out.println("Moving " + oldLocation + " to " + newLocation + "...");
		System.out.println();
		
		String item = board[oldY-1][possibleX.indexOf(oldX)];
		board[oldY-1][possibleX.indexOf(oldX)] = " ";
		board[newY-1][possibleX.indexOf(newX)] = item;	
		
		printBoard();
	}
}
