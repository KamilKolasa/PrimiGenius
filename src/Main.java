import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	private static int sumSquares(int number) {
		int result = 0;
		for (int i = 1; i <= number; i++) {
			result += (int) Math.pow(i, 2);
		}
		return result;
	}

	private static int squaresSum(int number) {
		int result = 0;
		for (int i = 1; i <= number; i++) {
			result += i;
		}
		return (int) Math.pow(result, 2);
	}

	private static int task_1(int numberPositive) {
		if (numberPositive <= 0)
			throw new NullPointerException();
		return Math.abs(sumSquares(numberPositive) - squaresSum(numberPositive));
	}

	private static Double task_2(Long number) {
		Long sum = 0L;
		Long numberHelp = number;
		while (numberHelp > 0) {
			sum += (numberHelp % 10);
			numberHelp /= 10;
		}
		return (double) number / sum;
	}

	private static int factorial(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	private static ArrayList<Integer> task_3() {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 10; i < 9999999; i++) {
			int helpResult = 0;
			for (Integer j : separateDigit(i)) {
				helpResult += factorial(j);
			}
			if (helpResult == i)
				result.add(i);
		}
		return result;
	}

	private static ArrayList<Integer> separateDigit(Integer n) {
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

	private static Integer task_6() {
		int result = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0) {
				result += i;
			}
			if (i % 5 == 0) {
				result += i;
			}
		}
		return result;
	}

	private static boolean divisors500(int n) {
		Set<Integer> divisors = new HashSet<>();
		divisors.add(n);
		divisors.add(1);
		for (int i = 2; i <= n / i; i++) {
			if (n % i == 0) {
				divisors.add(i);
			}
		}
		if (divisors.size() < 500)
			return false;
		else
			return true;
	}

	private static Integer task_8() {
		int result = 0;
		int i = 500;
		do {
			i++;
			result += i;
		} while (!divisors500(result));
		return result;
	}

	private static long reverse(long number) {
		long result = 0;
		while (number > 0) {
			result *= 10;
			result += (number % 10);
			number /= 10;
		}
		return result;
	}

	public static boolean palindromic(long number) {
		return number == reverse(number);
	}

	public static boolean lychrel(long number, int iteration) {
		for (int i = 0; i < iteration; i++) {
			if (palindromic(number)) {
				return false;
			}
			number = number + reverse(number);
		}
		return true;
	}

	private static Integer task_9() {
		int result = 0;
		for (int i = 1; i <= 10000; i++) {
			if (lychrel(i, 30)) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("-------------");
		System.out.println("Task 1");
		System.out.println(task_1(100));
		System.out.println("-------------");
		System.out.println("Task 2");
		System.out.println(task_2(1234567890123456789L));
		System.out.println("-------------");
		System.out.println("Task 3");
		task_3().stream().forEach(System.out::println);
		System.out.println("-------------");
		System.out.println("Task 4");
		System.out.println(task_4());
		System.out.println("-------------");
		System.out.println("Task 5");
		System.out.println(task_5(3, 4));
		System.out.println("-------------");
		System.out.println("Task 6");
		System.out.println(task_6());
		System.out.println("-------------");
		System.out.println("Task 7");
		System.out.println(task_1(100));
		System.out.println("-------------");
		System.out.println("Task 8");
		System.out.println(task_8());
		System.out.println("-------------");
		System.out.println("Task 9");
		System.out.println(task_9());
		System.out.println("-------------");
	}
}