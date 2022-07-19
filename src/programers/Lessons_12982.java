package programers;

import java.util.Arrays;

public class Lessons_12982 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,2,3,3}, 10));
	}

	public static int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);
		int sum = 0;
		for(int a : d) {
			sum += a;
			if(sum <= budget) answer++;
			else break;
		}
		return answer;
	}
}
