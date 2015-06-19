import java.util.Arrays;

/**
 * This is a very basic task when you start to program using
 * for loop. Here, I just print triangle fancily... 
 * @author luca
 * @version 1.1
 * */
public class PrintTriangleBasic {

	public static void main(String [] args) {
		printTriangle(6);
	}
	
	public static void printTriangle(int n) {
		
		char [][] triangle = new char[n][n];
		for (int i = 1; i <= n; i++) {	
			for(int j = 0; j < i; j++) {
				triangle[i-1][j] = '0';
			}
		}
		for(int i = 0; i < triangle.length; i++) {
			System.out.println(Arrays.toString(triangle[i]));
		}
		System.out.println();
		
		triangle = new char[n][n];
		for (int i = 1; i <= n; i++) {	
			for(int j = 0; j < i; j++) {
				triangle[i-1][triangle.length-1-j] = '0';
			}
		}
		for(int i = 0; i < triangle.length; i++) {
			System.out.println(Arrays.toString(triangle[i]));
		}
		System.out.println();
		
		triangle = new char[n][n];
		for (int i = 1; i <= n; i++) {	
			for(int j = triangle[i-1].length-i; j >= 0; j--) {
				triangle[i-1][j] = '0';
			}
		}
		for(int i = 0; i < triangle.length; i++) {
			System.out.println(Arrays.toString(triangle[i]));
		}
		System.out.println();
		
		triangle = new char[n][n];
		for (int i = 1; i <= n; i++) {	
			for(int j = triangle[i-1].length-i; j >= 0; j--) {
				triangle[i-1][triangle.length-1-j] = '0';
			}
		}
		for(int i = 0; i < triangle.length; i++) {
			System.out.println(Arrays.toString(triangle[i]));
		}
		System.out.println();
	}
	
}

