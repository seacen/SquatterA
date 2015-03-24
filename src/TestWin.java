
public class TestWin {
	
	private static String winPlayer="None";
	private static int blackCaptured=0,whiteCaptured=0;


	public static void test(String[] input) {
		int dimension=Integer.parseInt(input[0]);
		boolean winState=true;
		for (int i=0;i<dimension;i++) {
			int capturedCount=0;
			for (int x=0;x<dimension;x++) {
				char c=input[i+1].charAt(x);
				if (c=='-') {
					capturedCount++;
				}
				else if (c=='+') {
					winState=false;
				}
				else {
					if (c=='B') {
						blackCaptured+=capturedCount;
						capturedCount=0;
					}
					else {
						whiteCaptured+=capturedCount;
						capturedCount=0;
					}
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
	}
	
	public static void print() {
		System.out.println(winPlayer);
		System.out.println(whiteCaptured);
		System.out.println(blackCaptured);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestWin.test(args);
		TestWin.print();
	}

}
