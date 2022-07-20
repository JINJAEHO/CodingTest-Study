package programers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Lessons_49189 {

	public static void main(String[] args) {
		solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
	}
	
	public static int solution(int n, int[][] edge) {
		List<Set<Integer>> list = new ArrayList<>();
		Map<Integer, Boolean> visited = new HashMap<>();
		Map<Integer, Integer> dis = new HashMap<>();
		for(int i=0; i<=n; i++) {
			list.add(new HashSet<>());
			visited.put(i, false);
		}
		for(int[] i : edge) {
			list.get(i[0]).add(i[1]);
			list.get(i[1]).add(i[0]);
		}
		Queue<Integer> queue = new LinkedList<>();
		dis.put(1, 0);
		queue.add(1);
		visited.put(1, true);
		while(!queue.isEmpty()) {
			int q = queue.poll();
			Set<Integer> s = list.get(q);
			for(int next : s) {
				if(!visited.get(next)) {
					queue.add(next);
					visited.put(next, true);
					dis.put(next, dis.get(q)+1);
				}
			}
		}
		int max = 0, count=0;
		for(int i=1; i<=n; i++) {
			if(max <= dis.get(i)) {
				max = dis.get(i);
			}
		}
		for(int i=1; i<=n; i++) {
			if(dis.get(i) == max) {
				count++;
			}
		}
		return count;
	}

}
