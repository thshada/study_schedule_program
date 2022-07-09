package GUIStudent;

import java.io.Serializable;
import java.util.Comparator;



public class Student implements Comparable<Student>,Comparator<Student>, Serializable {
	private String id; //�л�ID
	private String name; //�л��̸�
	private int score;   //����
	
	
	
	
	public Student(String id, String name, int score) {
		this.id=id;
		this.name=name;
		this.score=score;
		
	
	}



//�ٸ� �������� ���� �ֵ��� �ϱ� ���� �� public ����
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
	//��ü������ ���ڿ��� ǥ���ϴ� �޼ҵ�
	
	public String toString() {
		return id+":"+name+":"+score;
	}
	//��ü�� ������ �Ǻ� 
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
