package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class ReduceExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("Hong", 80), 
											new Student("Hwang", 90),
											new Student("Park", 87));
		
		int sum = //학생점수합계...
				list.stream().mapToInt(t -> t.getScore()).sum();
		System.out.println(sum);
		
		// reduce
		int result = list.stream()
		.mapToInt(t -> t.getScore())
		.reduce(new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				System.out.println(left + ", " + right);
				return left + right;
			}			
		}).getAsInt();
		System.out.println("결과값: " + result);
		result = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce(0, (left, right) ->left + right);
		System.out.println("결과값: " + result);
		result = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce((left, right) -> left > right ? left:right)
				.getAsInt();
		System.out.println("최대값: " + result);
		result = list.stream()
				.mapToInt(t -> t.getScore())
				.reduce((left, right) ->(left + right)/2)
				.getAsInt();
		System.out.println("평균값: " + result);
		
		
	}
}
