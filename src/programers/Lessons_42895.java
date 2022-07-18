package programers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lessons_42895 {
	static int answer;
    public static int solution(int N, int number){
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<9; i++){
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        if(number != N) {
            for (int i = 2; i < 9; i++) {
                list.add(new HashSet<>());
                Set<Integer> main = list.get(i);
                for (int j = 1; j < i; j++) {
                    Set<Integer> pre = list.get(j);
                    Set<Integer> post = list.get(i - j);
                    for (int preNum : pre) {
                        for (int postNum : post) {
                            main.add(preNum + postNum);
                            main.add(preNum - postNum);
                            main.add(preNum * postNum);
                            if (postNum != 0) main.add(preNum / postNum);
                        }
                    }
                }
                main.add(Integer.parseInt(String.valueOf(N).repeat(i)));
                for (int t : main) {
                    if (t == number) {
                        answer = i;
                        break;
                    }
                }
                if(answer == i) break;
            }
        }else answer = 1;

        if(answer == 0) answer = -1;

        return answer;
    }
}
