package programers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lessons_42627 {

	public static void main(String[] args) {
		
	}
	
	public static int solution(int[][] jobs) {
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); //요청이 들어온 시간을 오름차순 정렬
		PriorityQueue<int[]> hp = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 최소힙
		int answer = 0;
		int end = 0;
		int count = 0;
		int idx = 0;
		while(count < jobs.length) {
			for(int i=idx; i<jobs.length; i++) {
				if(jobs[i][0] <= end) {
					hp.add(jobs[i]);
					idx++;
				}
			}
			if(!hp.isEmpty()) {
				int[] cur = hp.poll();
				answer += end - cur[0] + cur[1];
				end += cur[1];
				count++;
			}else {
				end = jobs[idx][0];
			}
		}
		
		return answer / jobs.length;
	}
}
