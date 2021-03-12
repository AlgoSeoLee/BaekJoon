package baekjoon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Baekjoon16170 {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		String time = now.format(DateTimeFormatter.ofPattern("yyyy\nMM\ndd"));
		
		System.out.println(time);
		
	}
}