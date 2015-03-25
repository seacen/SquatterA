import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Test if a player has won and count number of captured cells for each player for a given input
 * 
 * @author Xichang Zhao
 */
public class TestWin {

	/** test and print the output 
	 * @param input		a bufferedReader type input containing the board state and structure
	 * */
	public static void test(BufferedReader input) {
		
		String winPlayer="None";
		int dimension,blackCaptured=0,whiteCaptured=0;
		
		// if the game is won by players
		boolean winState=true;
		
		try {
			
			//read the dimension of the board for future iteration counts
			dimension = Integer.parseInt(input.readLine());
			
			for (int i=0;i<dimension;i++) {
				
				String line=input.readLine();
				
				//an integer indicates the current number of unclaimed captured cells
				int capturedCount=0;
				
				//iterate through each of the cells in a row
				for (int x=0;x<dimension;x++) {
					char c=line.charAt(x);
					if (c=='-') {
						capturedCount++;
					}
					else if (c=='+') {
						winState=false;
					}
					else {
						if (c=='B') {
							blackCaptured+=capturedCount;
						}
						else {
							whiteCaptured+=capturedCount;
						}
						capturedCount=0;
					}
				}
			}
			
			if (winState) {
				if (blackCaptured>whiteCaptured) {
					winPlayer="Black";
				}
				else if (blackCaptured<whiteCaptured) {
					winPlayer="White";
				}
				else {
					winPlayer="Draw";
				}
			}
			
			System.out.println(winPlayer);
			System.out.println(whiteCaptured);
			System.out.println(blackCaptured);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TestWin.test(br);
	}

}
