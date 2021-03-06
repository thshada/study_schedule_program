package GUIStudent;

import java.io.Serializable;
import java.util.Comparator;



public class Student implements Comparable<Student>,Comparator<Student>, Serializable {
	private String id; //학생ID
	private String name; //학생이름
	private int score;   //성적
	
	
	
	
	public Student(String id, String name, int score) {
		this.id=id;
		this.name=name;
		this.score=score;
		
	
	}



//다른 곳에서도 쓸수 있도록 하기 위한 것 public 시작
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getScore() {
		return score;
	}




	public void setScore(int score) {
		this.score = score;
	}
	//객체정보를 문자열로 표현하는 메소드
	
	public String toString() {
		return id+":"+name+":"+score;
	}
	//객체가 같은지 판별 
	public boolean equals(Student stu) {
		boolean result=false;
		
		if(id.equals(stu.id))
			return true;
		return result;
	}



	@Override
	public int compare(Student o1, Student o2) {
		return o2.getScore()-o1.getScore();
	}



	@Override
	public int compareTo(Student o) {
		return this.name.compareTo(o.name);
	}

}
