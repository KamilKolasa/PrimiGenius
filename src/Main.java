import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

	private static ArrayList<Integer> separateDigit(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		do {
			list.add(n % 10);
			n /= 10;
		} while (n > 0);
		return list;
	}

	private static boolean requirements(int number) {
		if (separateDigit(number).size() != separateDigit(number * 6).size())
			return false;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 1; i <= 6; i++) {
			list.add(separateDigit(number * i).stream().sorted().collect(Collectors.toCollection(ArrayList::new)));
		}

		for (int i = 0; i < list.get(0).size(); i++) {// select a number
			for (int j = 1; j < 6; j++) {// select a digit
				if (list.get(0).get(i) != list.get(j).get(i)) {
					return false;
				}
			}
		}
		return true;
	}

	private static Integer task_4() {
		int i = 0;
		do {
			i++;
		} while (!requirements(i));
		return i;
	}

	private static Integer task_5(int m, int n) {
		if (m == 0) {
			return n + 1;
		} else if (m > 0 && n == 0) {
			return task_5((m - 1), 1);
		} else {
			return task_5((m - 1), task_5(m, (n - 1)));
		}
	}

	public static void main(String[] args) {
		System.out.println("-------------");
		System.out.println("Task 4");
		System.out.println(task_4());
		System.out.println("-------------");
		System.out.println("Task 5");
		System.out.println(task_5(3, 4));
		System.out.println("-------------");
	}
}