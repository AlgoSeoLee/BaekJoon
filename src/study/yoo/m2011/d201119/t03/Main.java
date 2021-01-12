package study.yoo.m2011.d201119.t03;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {

		int[] truck_weights = {7,4,5,6};
		int[] truck_weights1 = {10};
		int[] truck_weights2 = {10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution(2, 10, truck_weights));
		System.out.println(solution(100, 100, truck_weights1));
		System.out.println(solution(100, 100, truck_weights2));
	}

	
	
	    public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int[] endTime = new int[truck_weights.length]; // 트럭이 다리를 모두 지나는 시간
	        
	        Queue<Integer> onBridge = new LinkedList<Integer>();
	        int time = 0 , cur=0; //현재 무게
	        while(true) {
	            // 도착한 버스 제거 
	            if(!onBridge.isEmpty() && endTime[onBridge.peek()] == time) {
	                weight += truck_weights[onBridge.poll()];
	            }
	            
	            // 대기하는 버스 추가 
	            if(cur < truck_weights.length && truck_weights[cur] <= weight) {
	                onBridge.add(cur);
	                endTime[cur] = time + bridge_length; // 다리에 올라가는 시간 + 다리 길이
	                weight -= truck_weights[cur];
	                cur++;
	            }
	            
	            time++;
	            if(onBridge.isEmpty())
	                break;
	        }
	        return time;
	    }

	
}
