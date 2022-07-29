import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ #17143 ���ÿ�
class Shark{
	int r,c,s,d,z;  // �� �� �ӷ� ���� ũ��
	public Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
	
}
public class Main {
	static int [][] map ;
	static int R,C;
	static HashMap<Integer, Shark> hmap = new HashMap<>();
	static Queue<Integer> remove = new LinkedList<>();
	public static void moveShark(int key) {
		Shark tmp = hmap.get(key);
		map[tmp.r][tmp.c] = 0;
		int length = tmp.s;
		switch (tmp.d) {
			case 1: { // UP
				if(length < tmp.r) {
					tmp.r -= length;
				}
				else {
					length -= tmp.r;
					if((length / (R - 1)) % 2 == 0) {
						tmp.r = length % (R - 1);
						tmp.d = 2;
					}
					else {
						tmp.r = (R - 1) - length % (R - 1);
					}
				}
				break;
			}
			case 2: { // DOWN
				if(length < (R - 1) - tmp.r) {
					tmp.r += length;
				}
				else {
					length -= (R - 1) - tmp.r;
					if((length / (R - 1)) % 2 == 0) {
						tmp.r = (R - 1) - length % (R - 1);
						tmp.d = 1;
					}
					else {
						tmp.r = length % (R - 1);
					}
				}
				break;
			}
			case 3: { // RIGHT
				if(length < (C - 1) - tmp.c) {
					tmp.c += length;
				}
				else {
					length -= (C - 1) - tmp.c;
					if((length / (C - 1)) % 2 == 0) {
						tmp.c = (C - 1) - length % (C - 1);
						tmp.d = 4;
					}
					else {
						tmp.c = length % (C - 1);
					}
				}
				break;
			}
			case 4: { // LEFT
				if(length < tmp.c) {
					tmp.c -= length;
				}
				else {
					length -= tmp.c;
					if((length / (C - 1)) % 2 == 0) {
						tmp.c = length % (C - 1);
						tmp.d = 3;
					}
					else {
						tmp.c = (C - 1) - length % (C - 1);
					}
				}
				break;
			}
			 
		}
		hmap.put(key, tmp);
		
	}
	
	public static int solution() {
		int king = -1;
		int answer = 0;
		while(++king < C) {
			for(int i = 0 ; i < R ; i ++) { // ���ÿ��� �� ĭ �̵� �� �� ����
				if(map[i][king] > 0) {
					answer += hmap.get(map[i][king]).z;
					hmap.remove(map[i][king]);
					map[i][king] = 0;
					break;
				}
			}
			for(int x : hmap.keySet()) {
				moveShark(x); // ��� �̵�
			}
			for(int o : hmap.keySet()) { // ������ index��ȣ ���� �������� ��������� �� => index��ȣ�� ������� �񱳵��� ���� (HashMap�� key���� �Էµ� ���� ���� X) 
				Shark tmp = hmap.get(o);
				if(map[tmp.r][tmp.c] != 0) {
					if(hmap.get(map[tmp.r][tmp.c]).z > tmp.z) { 
						remove.offer(o);
					}
					else { 
						remove.offer(map[tmp.r][tmp.c]);
						map[tmp.r][tmp.c] = o;
					}
				}
				else map[tmp.r][tmp.c] = o;
				
			}
			
			int length = remove.size();
			for(int i = 0 ; i < length ; i ++) {
				hmap.remove(remove.poll());
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 1 ; i <= M ; i ++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if(d == 1 && r == 0) d = 2;
			else if(d == 2 && r == R - 1) d = 1;
			else if(d == 3 && c == C - 1) d = 4;
			else if(d == 4 && c == 0) d = 3;
			map[r][c] = i;
			hmap.put(i, new Shark(r,c,s,d,z));
		}
		System.out.println(T.solution());
	}
}
