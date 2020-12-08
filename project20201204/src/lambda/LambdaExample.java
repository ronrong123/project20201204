package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class LambdaExample {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("Hong", "MALE", 70), new Student("Hwang", "FMALE", 80),
				new Student("Park", "MALE", 90), new Student("Choi", "FMALE", 85));

		// 1. 여학생정보: 이름 - 점수.

		for (Student fstu : list) {
			if (fstu.getSex().equals("FMALE")) {
				System.out.println(fstu.getName() + " - " + fstu.getScore());
			}
		}
		System.out.println("=================================" + "\n");
		// 2. 전체학생: 점수 80점 초과.
		for (Student stu : list) {
			if (stu.getScore() > 80) {
				System.out.println("이름: " + stu.getName() + ", 성별:" + stu.getSex() + ", 점수:" + stu.getScore());
			}
		}
		// 3. 남학생의 총점: 남학생총점: 160점.
		System.out.println("=================================" + "\n");
		int sum = 0;
		for (Student stu : list) {
			if (stu.getSex().equals("MALE")) {
				sum += stu.getScore();
			}
		}
		System.out.println("남학생 총점: " + sum);
		// 4. 여학생의 평균: 여학생평균:82.5
		System.out.println("=================================" + "\n");
		int count = 0, sum2 = 0;
		for (Student stu : list) {
			if (stu.getSex().equals("FMALE")) {
				count++;
				sum2 += stu.getScore();
			}
		}
		System.out.println("여학생 평균: " + (double) sum2 / count);

		System.out.println("==============스트림================" + "\n");
		// 반복문(반복자) : 스트림(반복자)
		// 스트림생성 -> 소진
		Stream<Student> stream = list.stream();
		stream.filter((t) -> t.getSex().equals("FMALE"))
				.forEach((Student t) -> System.out.println(t.getName() + "-" + t.getScore()));

		stream = list.stream();
		stream.filter(new Predicate<Student>() {
			@Override
			public boolean test(Student t) {
				// TODO Auto-generated method stub
				return t.getScore() > 80;
			}
		}).forEach(new Consumer<Student>() {
			@Override
			public void accept(Student t) {
				System.out.println(t.getName() + t.getScore());
			}			
		});
		
		int sum1 = list.stream().filter(t -> t.getSex().equals("MALE"))//
		.mapToInt(new ToIntFunction<Student>() {
			@Override
			public int applyAsInt(Student value) {
				return value.getScore();
			}			
		}).sum();
		System.out.println("남학생 총합점수: " + sum1);
		double avg = list.stream().filter(t -> t.getSex().equals("FMALE"))
		.mapToInt(s -> s.getScore())
		.average()
		.getAsDouble();
		System.out.println("평균: " + avg);
	}

}
