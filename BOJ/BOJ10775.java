import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ #10775 ����
public class Main {
	static int[] uf;
	static int find(int x) {
		if(uf[x] == x) return x;
		else return uf[x] = find(uf[x]);
	}
	
	static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa < fb) uf[fb] = fa;
		else uf[fa] = fb;
	}
	
	public static void main(String[] args) throws IOException { // greedy �ð� �ʰ� > union & find (return �� ���� �ڸ� ��ȯ)
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine()); // ����Ʈ ��
		int P = Integer.parseInt(br.readLine()); // ����� ��
		uf = new int[G + 1];
		for(int i = 1 ; i <= G ; i ++) uf[i] = i;
		int answer = 0;
		while(P -- > 0) {
			int ftmp = find(Integer.parseInt(br.readLine()));
			if(ftmp > 0) {
				union(ftmp - 1, ftmp);
				answer ++;
			}
			else { // ��ŷ�� �ڸ��� ���� ��
				System.out.println(answer);
				return;
			}
		}
		System.out.println(answer);
	}
}
