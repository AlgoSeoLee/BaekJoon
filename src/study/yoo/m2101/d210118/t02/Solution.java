package study.yoo.m2101.d210118.t02;

//가장 큰 정사각형 찾기
class Solution{
    public int solution(int [][]board){  
        int answer = 1234;
        int up, left, upleft;
		for(int y = 1 ; y < board.length; y++) {
			for(int x = 1 ; x < board[y].length; x++) {
				if(board[y][x] == 1) {
					up = board[y-1][x];
					left = board[y][x-1];
					upleft = board[y-1][x-1];
                    
					int min = Math.min(up, left);
					min = Math.min(min , upleft);
					board[y][x] = min+1;
				}
			}
		}
		int side = 0;
		for(int y = 0 ; y < board.length; y++) {
			for(int x= 0 ; x < board[0].length ; x++) {
				if(board[y][x] > 0) {
					side = Math.max(side, board[y][x]);
				}
			}
        }
        answer = side * side;
        System.out.println(answer);
        return answer;
    }
}