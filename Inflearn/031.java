package codingTest_031;

import java.util.*;

public class Main {

	public char result(int student, String vote) {

		char answer = ' ';
		HashMap<Character, Integer> map = new HashMap<>();

		for (char x : vote.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1); // getOrDefault -- > ���� ������ ���ϴ� ���� ��ȯ
													// containsKey() Key ���� �����ϴ��� boolean ���� ��ȯ / size() Key���� � �ִ���
													// remove() Key ���� ==> key�� ������ �ִ� �� ��ȯ
		}
		int max = Integer.MIN_VALUE;
		for (char key : map.keySet()) {
			if (map.get(key) > max) {

				max = map.get(key);
				answer = key;
			}
		}

		return answer;
	}

	public static void main(String[] args) {

		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		int student = sc.nextInt();
		String vote = sc.next();

		System.out.println(T.result(student, vote));

	}
}
