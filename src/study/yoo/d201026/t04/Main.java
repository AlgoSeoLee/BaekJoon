package study.yoo.d201026.t04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//https://www.acmicpc.net/problem/1927
public class Main {

	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                if (queue.isEmpty()) {
                    bw.write("0\n");
                 } else {
                    bw.write(queue.poll() + "\n");
                 }
            } else {
                queue.add(a);
            }
        }

        bw.flush();
        br.close();
        bw.close();
	}
}



//
//Scanner sc = new Scanner(System.in);
//
//// 우선순위가 낮은 숫자 순
//PriorityQueue<Integer> queue = new PriorityQueue<>();
//int n = sc.nextInt();
//
//while (n-- > 0) {
//	int a = sc.nextInt();
//	if (a == 0) {
//		if (queue.isEmpty())
//			System.out.println(0);
//		else
//			System.out.println(queue.poll());
//	} else
//		queue.add(a);
//}


