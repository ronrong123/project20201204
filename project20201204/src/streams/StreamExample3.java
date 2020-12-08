package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {

//		String[] strs = "Java8 lambda".split(" ");//split은 나누다는뜻
		List<String> strList = Arrays.asList("Java8 lambda", "stream mapping");
		strList.stream().flatMap(new Function<String, Stream<String>>() {

			@Override
			public Stream<String> apply(String t) {
				// TODO Auto-generated method stub
				return Arrays.stream(t.split(" "));
			}
		})
//		.filter(s -> s.startsWith("s"))
				.forEach(s -> System.out.println(s));

		strList.stream().map(new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		}).forEach(s -> System.out.println(s));

		List<Student> students = Arrays.asList(
				new Student("송다희", "F", 80),
				new Student("윤태현", "M", 75),
				new Student("이혜빈", "F", 85), 
				new Student("정병기", "M", 90));
		double avg = students.stream().mapToInt(new ToIntFunction<Student>() {
			@Override
			public int applyAsInt(Student s) {
				System.out.println(s.getName()+ "/" +s.getScore());
				// TODO Auto-generated method stub
				return s.getScore();
			}			
		}).average()
		.getAsDouble();
		System.out.println(avg);
	}

}
