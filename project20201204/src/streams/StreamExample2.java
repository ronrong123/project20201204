package streams;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		// 1~100
		// 짝수만 결과를 출력 . . .

		IntStream is = IntStream.rangeClosed(1, 100);
		// 람다식
		is.filter((t) -> t % 2 == 0).forEach((t) -> System.out.println(t));
		int sum = IntStream.rangeClosed(1, 100).filter(t -> 1 % 2 == 0).sum();

		// 풀이
//		is.filter(new IntPredicate() {
//			@Override
//			public boolean test(int value) {
//				return value%2==0;
//			}
//		}).forEach(new IntConsumer() {
//
//			@Override
//			public void accept(int value) {
//				System.out.println(value);				
//			}
//			
//		});
		int[] intAry = { 2, 6, 4, 8, 1, 9 };
		IntStream is2 = Arrays.stream(intAry);
		int max = is2.min().getAsInt();
		System.out.println(max);

		is2 = Arrays.stream(intAry);
		double avg = is2.average().getAsDouble();
		System.out.println(avg);

		// 조건(filter)
		Arrays.stream(intAry).filter(new IntPredicate() {
			@Override
			public boolean test(int value) {
				return value % 2 == 0;
			}
		}).forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.println(value);
			}
		});
	}
}
