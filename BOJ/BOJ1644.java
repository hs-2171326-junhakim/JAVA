import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ #1644 �Ҽ��� ������
public class Main {
	public static int solution(int N) {
		int[] arr = new int[N + 1]; // �����佺�׳׽��� ü 
		ArrayList<Integer> prime = new ArrayList<>();
		int answer = 0;
		int lt = 0, rt = -1, sum = 0;
		for(int i = 2 ; i <= Math.sqrt(N) ; i ++) {
			for(int k = i * 2 ; k <= N ; k += i) {
				arr[k] = 1;
			}
		}
		for(int i = 2 ; i <= N ; i ++) {
			if(arr[i] == 0) prime.add(i);
		}
		while(rt < prime.size()) {
			if(sum < N) { // N ���� ���� ���� ��
				if(rt == prime.size() - 1) break;
				else sum += prime.get(++rt);
			}
			else if(sum == N) { // N�� ���� ��
				answer ++;
				sum -= prime.get(lt++);
			}
			else { // N ���� Ŭ ��
				sum -= prime.get(lt++);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(T.solution(N));
	}
}
