package programers;

import java.util.Arrays;

public class Lessons_43238 {
	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		Arrays.sort(times);
		long mid, sum;
		long start = 0;
		long end = Long.MAX_VALUE;
		while(start <= end) {
			mid = (start + end) / 2;
			sum = 0;
			for(int i=0; i<times.length; i++) {
				sum += (mid / times[i]);
				if(sum >= n) break;
			}
			if(sum < n) {
				start = mid + 1;
			}else {
				end = mid - 1;
				answer = Math.min(answer, mid);
			}
		}
        return answer;
    }
	
}
