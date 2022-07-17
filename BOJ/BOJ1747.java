import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ #1747 �Ҽ�&�Ӹ����
public class Main {
	public static int solution(int N) {
		int[] ch = new int[1100001]; // 1000000�� �� 1003001
		ch[1] = 1; // 1�� �Ҽ� X
		for(int i = 2 ; i <= Math.sqrt(1100000) ; i ++) { // �����佺�׳׽��� ü 
			if(ch[i] == 0) {
				for(int k = i * 2 ; k <= 1100000 ; k += i) { 
					if(ch[k] == 0) ch[k] = 1;
				}
			}
		}
		for(int i = N ; i <= 1100000; i ++) {
			if(ch[i] == 0) {
				String tmp = String.valueOf(i);
				int lt = 0, rt = tmp.length() - 1;
				boolean flag = true;
				while(lt < rt) {
					if(tmp.charAt(lt) != tmp.charAt(rt))
						{	
							flag = false;
							break;
						}
					lt ++;
					rt --;
				}
				if(flag) return i;
			}
		}
		return -1; 
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(T.solution(N));
	}
}
