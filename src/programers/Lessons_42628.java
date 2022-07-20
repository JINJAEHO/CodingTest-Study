package programers;

import java.util.*;

public class Lessons_42628 {

	public static void main(String[] args) {
		int[] a = solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
		for(int i=0; i<a.length; i++) System.out.print(a[i] + " ");
	}

	public static int[] solution(String[] operations) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		
		for(String s : operations) {
			String oper = s.split("\\s+")[0];
			int num = Integer.parseInt(s.split("\\s+")[1]);
			if(oper.equals("I")) {
				maxHeap.add(num);
				minHeap.add(num);
			}else if(num == -1 && !minHeap.isEmpty()) {
				int del = minHeap.poll();
				maxHeap.remove(del);
			}else if(!maxHeap.isEmpty()) {
				int del = maxHeap.poll();
				minHeap.remove(del);
			}
		}
		int[] answer = {};
		if(maxHeap.isEmpty()) answer = new int[]{0, 0};
		else {
			answer = new int[] {maxHeap.poll(), minHeap.poll()};
		}
		return answer;
	}
}
