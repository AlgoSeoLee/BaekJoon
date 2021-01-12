package study.yoo.live;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		int r = Character.getNumericValue(a.charAt(0));
		int c = Character.getNumericValue(a.charAt(2));
		
		char[][] arr = new char[r][c];
		
		for(int i = 0; i<r; i++) {
			String str = sc.nextLine();
			for(int j = 0; j<c; j++) {
				arr[i][j] = str.charAt(j); 
			}
		}
		
		Queue<Place> queue = new LinkedList<>();
		queue.add(new Place(0, 0));
		while(!queue.isEmpty()) {
			Place poll = queue.poll();
		}
		
		
		
		
		
	}

}
class Place {
	int x; 
	int y;
	Place(int x, int y){
		this.x = x;
		this.y = y;
	}
}