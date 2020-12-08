package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectExample {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("Hong", 80), new Student("Hwang", 90), new Student("Park", 87));
		List<Student> student80s = list.stream()
				.filter(s -> s.getScore() / 10 == 8)
				.sorted()// 정렬해주는메소드
				.collect(Collectors.toList());
		for (Student student : student80s) {
			System.out.println("이름: " + student.getName() + "/ 점수: " + student.getScore());
		}
//		.forEach(System.out::println);
		Map<String, Integer> map = list.stream()
				.filter(s -> s.getScore() / 10 == 8)
				.sorted()// 정렬해주는메소드
				.collect(
//							Collectors.toMap(
//							new Function<Student, String>(){
//
//								@Override
//								public String apply(Student t) {
//									return t.getName();
//								}},
//							new Function<Student, Integer>(){
//
//								@Override
//								public Integer apply(Student t) {
//									// TODO Auto-generated method stub
//									return t.getScore();
//								}})

						Collectors.toMap((t) -> t.getName(),
						(t) -> t.getScore())
						);
		Set<String> set = map.keySet();
		for(String key : set) {
			System.out.println("Key: " + key + ", Val: " + map.get(key));
		} 
	}

}
