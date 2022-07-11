package programers;

public class Lessons_1835 {
	private int answer = 0;
	private String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
	//dfs용 방문 기록 배열
	private boolean[] visited = new boolean[friends.length];
	
	public int solution(int n, String[] data) {
		//dfs 최초 호출
		dfs("", data);
		System.out.print(answer);
		return answer;
	}
	
	private void dfs(String position, String[] data) {
		if(position.length() == 7) {
			if(check(position, data)) answer++; // 사진 위치 조건 만족 시
			//재귀 함수 탈출
			return;
		}
		for(int i=0; i<friends.length; i++) {
			//노드를 방문한 적이 없다면
			if(!visited[i]) {
				//방문한 노드 재방문 방지
				visited[i] = true;
				String pos = position + friends[i];
				dfs(pos, data);
				//새로운 경우의 수를 위해 방문 기록 삭제
				visited[i] = false;
			}
		}
	}
	
	private boolean check(String position, String[] data) {
		int from, to, dis;
		char oper;
		for(String d: data) {
			from = position.indexOf(d.charAt(0)); //포지션 1
			to = position.indexOf(d.charAt(2)); // 포지션 2
			oper = d.charAt(3); // 조건(=, <, >)
			dis = Character.getNumericValue(d.charAt(4)); // 희망 거리
			if(oper == '=') {
				if(!(Math.abs(from - to) == dis+1)) return false; // from과 to의 거리(절대값) dis는 인덱스 형식이었으므로 +1을 해줘야한다.
			}else if(oper == '>') {
				if(!(Math.abs(from - to) > dis+1)) return false;
			}else {
				if(!(Math.abs(from - to) < dis+1)) return false;
			}
		}
		return true;
	}
}
