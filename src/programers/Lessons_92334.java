package programers;

public class Lessons_92334 {
	public static void main(String[] args) {
		String [] id_list = {"con", "ryan"};
		String [] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 2;
		
		int[][] history = new int[id_list.length][id_list.length];
		
		for(int i=0; i<report.length; i++) {
			String[] reportSub = report[i].split("\\s+");
			String reporter = reportSub[0];
			String reported = reportSub[1];
			System.out.println(reporter + " " + reported);
			
			int reporter_index = -1;
			int reported_index = -1;
			for(int j=0; j<id_list.length; j++) {
				if(id_list[j].equals(reporter)) {
					reporter_index = j;
				}else if(id_list[j].equals(reported)) {
					reported_index = j;
				}
			}
			if(history[reporter_index][reported_index]!=1) {
				history[reporter_index][reported_index] = 1;
			}
		}
		
		int[] sum = new int[id_list.length];
		for(int z=0; z<history.length; z++) {
			for(int x=0; x<history[z].length; x++) {
				if(history[x][z] == 1) {
					sum[z] += 1;
				}
			}
		}
		
		int[] result = new int[id_list.length];
		for(int a=0; a<sum.length; a++) {
			if(sum[a] >= k) {
				for(int y=0; y<id_list.length; y++) {
					if(history[y][a] == 1) {
						result[y] += 1;
					}
				}
			}
		}
		
		for(int q=0; q<result.length; q++) {
			System.out.println(result[q]);
		}
	}
	
	public int[] solution(String[] id_list, String[] report, int k) {
		int[][] history = new int[id_list.length][id_list.length];
		
		for(int i=0; i<report.length; i++) {
			String[] reportSub = report[i].split("\\s+");
			String reporter = reportSub[0];
			String reported = reportSub[1];
			System.out.println(reporter + " " + reported);
			
			int reporter_index = -1;
			int reported_index = -1;
			for(int j=0; j<id_list.length; j++) {
				if(id_list[j].equals(reporter)) {
					reporter_index = j;
				}else if(id_list[j].equals(reported)) {
					reported_index = j;
				}
			}
			if(history[reporter_index][reported_index]!=1) {
				history[reporter_index][reported_index] = 1;
			}
		}
		
		int[] sum = new int[id_list.length];
		for(int z=0; z<history.length; z++) {
			for(int x=0; x<history[z].length; x++) {
				if(history[x][z] == 1) {
					sum[z] += 1;
				}
			}
		}
		
		int[] answer = {};
		for(int a=0; a<sum.length; a++) {
			if(sum[a] >= k) {
				for(int y=0; y<id_list.length; y++) {
					if(history[y][a] == 1) {
						answer[y] += 1;
					}
				}
			}
		}
        
        return answer;
    }
}