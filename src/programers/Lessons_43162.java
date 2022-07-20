package programers;

import java.util.*;

public class Lessons_43162 {

	public static void main(String[] args) {
		int answer = solution(3, new int[][]{{1,1,0}, {1,1,1}, {0,1,1}});
		System.out.println(answer);
	}

	static Map<Integer, Boolean> visited = new HashMap<>();
	static List<List<Integer>> link = new ArrayList<>();
	
	public static int solution(int n, int[][] computers) {
		for(int i=0; i<computers.length; i++) {
			link.add(new ArrayList<>());
			visited.put(i, false);
			for(int j=0; j<computers[i].length; j++) {
				if(i != j && computers[i][j]==1) link.get(i).add(j);
			}
		}
		link.stream().forEach(i -> System.out.println(i));
		int count = 0;
		for(int i=0; i<visited.size(); i++) {
			if(!visited.get(i)) {
				count++;
				dfs(i);
			}
		}
		return count;
	}
	
	public static void dfs(int n) {
		if(visited.get(n)) {
			return;
		}
		visited.put(n, true);
		for(int i=0; i<link.get(n).size(); i++) {
			dfs(link.get(n).get(i));
		}
	}
}
