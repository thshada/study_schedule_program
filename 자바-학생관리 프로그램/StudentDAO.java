package GUIStudent;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUIStudent.Student;

public class StudentDAO {

public ArrayList<Student> list; //학생 리스트
 //등록된 학생수
public Scanner scan;
public String id;
public String name;
public int score;
public int flag=0;
public String str2="";
public String str3="";
public int tempIndex2;
public Student[] tmp_read;
public int cnt;
public boolean found2;
public int flag2=0;
public StudentDAO(){
	list=new ArrayList<Student>(); //등록가능한 학생수 100
	scan=new Scanner(System.in);
	
}

public ArrayList<Student> list() {
	
	return list;
}





	/*public void insert() {
		
		System.out.println("학번입력 >> ");
		String id=scan.nextLine();
		System.out.println("이름입력 >>");
		String name=scan.nextLine();
		
		System.out.println("성적입력 >> ");
		
		try {
			
		
		int x=Integer.parseInt(scan.nextLine());
		if(x>=0 && x<=100) {
			int Score=x;
		Student stu=new Student(id,name,Score);
		
		
		//id가 이미 존재하면 등록 안함.
		
		
		for(int i=0;i<cnt;i++) {
			if(stu.equals(list.get(i))) {
				System.out.println("이미 등록된 ID입니다.");
				
			}
		}
		
		list.add(stu);
		cnt++;
		System.out.println("등록이 완료됨");
		
		}
		
		else {
			System.out.println("0~100 까지의 숫자만 넣으세요");
		}
		
		}
		catch(Exception e) {
			System.out.println("오류발생");
			
		}
		
	}
	*/
	public boolean insert( String id, String name,int score) {
		int score1=score;
		
		if(score1<100) {
		for(int i=0;i<list.size();i++) {
			Student s=list.get(i);
			if(id.equals(s.getId())) 
				return false;
		}
			Student stu=new Student(id,name,score);
			list.add(stu);
		}
			return true;
		
		
		
	
	
	
	}
	//조회
	public String inquire() {
		String str="";
		for(int i=0;i<list.size();i++) {
			//System.out.println("ID : "+list.get(i).getId()+"이름 : "+list.get(i).getName()+"성적 : "+list.get(i).getScore());
			str=str+"ID : "+list.get(i).getId()+"\t"+" 이름 : "+list.get(i).getName()+"\t"+"성적 : "+list.get(i).getScore()+'\n';
			
		}
		return str;
	}

	public boolean update(String text) {
		
		String id=text;
		 found2=false;
		
		for(int i=0;i<list.size();i++) {
			if(id.equals(list.get(i).getId())) {
				 
				 tempIndex2=i;
				 found2=true;
					
				}
			
				
			}
		if(found2) {
			flag=1;
		}
		return found2;
	
		
		
	}
public void update1(String text,String name1,int score1) {
		
		String id=text;
		String name=name1;
		int score=score1;
		
		
		
				
			String new_id=text;
			
			
			String new_name=name;
			
			
			
			int new_score=score;
			Student new_stu=new Student(new_id,new_name,new_score) ;

			list.set(tempIndex2, new_stu);
			flag2=6;
			
			
			
			flag=0;
		
		
	}
public String FileSave() throws IOException {
	
	FileOutputStream fos=new FileOutputStream("c:\\Temp\\date1.txt");
	BufferedOutputStream bos=new BufferedOutputStream(fos);
	ObjectOutputStream oos=new ObjectOutputStream(bos);
	
	ArrayList<Student> Alist=new ArrayList<Student>();
	
	for(int i=0;i<list.size();i++) {
		Alist.add(list.get(i));
		flag=2;
	}
	oos.writeObject(Alist);
	oos.close();
	bos.close();
	fos.close();
	
	
	if(flag==2) {
	
	str2="저장되었습니다";
	
	}
	return str2;
}
public String FileInput()throws IOException, ClassNotFoundException{
	FileInputStream fis=new FileInputStream("c:\\Temp\\date1.txt");
	BufferedInputStream bis=new BufferedInputStream(fis);
	ObjectInputStream ois=new ObjectInputStream(bis);
	
	ArrayList<Student> stulist=(ArrayList<Student>)ois.readObject();
	
	  System.out.println(stulist);
		/*
		 * Iterator it=stulist.iterator(); 
		 * while(it.hasNext()) { 
		 * str3+=it.next();
		 * tmp_read=str3.split(":");
		 * 
		 * 
		 * 
		 * }
		 */
	 
	String str4="";
	for(int i=0;i<stulist.size();i++) {
	str4=str4+"ID : "+stulist.get(i).getId()+"\t"+" 이름 : "+stulist.get(i).getName()+"\t"+"성적 : "+stulist.get(i).getScore()+'\n';
	}
	
	ois.close();
	bis.close();
	fis.close();
	return str4;
	
	
	
	
	}
	public String namearray() {
		
		ArrayList<Student> Alist=new ArrayList<Student>();
		
		for(int i=0;i<list.size();i++) {
			Alist.add(list.get(i));
			
		}
		Collections.sort(Alist);
		
		String str5="";
		for(int i=0;i<Alist.size();i++) {
			str5=str5+"ID : "+Alist.get(i).getId()+"\t"+" 이름 : "+Alist.get(i).getName()+"\t"+"성적 : "+Alist.get(i).getScore()+'\n';
			}
		return str5;
	}
	public String studyArray() {
		ArrayList<Student> Alist=new ArrayList<Student>();
		
		for(int i=0;i<list.size();i++) {
			Alist.add(list.get(i));
		}
		Comparator comparator = new Student(id, name, score);
		Collections.sort(Alist,comparator);
		
		String str7="";
		for(int i=0;i<Alist.size();i++) {
			if(Alist.get(i).getScore()<=100 && Alist.get(i).getScore()>=95  ) {
				str7=str7+"ID : "+Alist.get(i).getId()+"\t"+" 이름 : "+Alist.get(i).getName()+"\t"+"성적 : "+Alist.get(i).getScore()+"\t"+"A+"+'\n';
			}
			else if(Alist.get(i).getScore()<95 && Alist.get(i).getScore()>=90) {
				str7=str7+"ID : "+Alist.get(i).getId()+"\t"+" 이름 : "+Alist.get(i).getName()+"\t"+"성적 : "+Alist.get(i).getScore()+"\t"+"A"+'\n';
			}
			else if(Alist.get(i).getScore()<90 && Alist.get(i).getScore()>=85) {
				str7=str7+"ID : "+Alist.get(i).getId()+"\t"+" 이름 : "+Alist.get(i).getName()+"\t"+"성적 : "+Alist.get(i).getScore()+"\t"+"B+"+'\n';
			}
			else if(Alist.get(i).getScore()<85 && Alist.get(i).getScore()>=80) {
				str7=str7+"ID : "+Alist.get(i).getId()+"\t"+" 이름 : "+Alist.get(i).getName()+"\t"+"성적 : "+Alist.get(i).getScore()+"\t"+"B"+'\n';
			}
			else if(Alist.get(i).getScore()<80 && Alist.get(i).getScore()>=75) {
				str7=str7+"ID : "+Alist.get(i).getId()+"\t"+" 이름 : "+Alist.get(i).getName()+"\t"+"성적 : "+Alist.get(i).getScore()+"\t"+"C+"+'\n';
			}
			else if(Alist.get(i).getScore()<75 && Alist.get(i).getScore()>=70) {
				str7=str7+"ID : "+Alist.get(i).getId()+"\t"+" 이름 : "+Alist.get(i).getName()+"\t"+"성적 : "+Alist.get(i).getScore()+"\t"+"C"+'\n';
			}
			else if(Alist.get(i).getScore()<70 && Alist.get(i).getScore()>=65) {
				str7=str7+"ID : "+Alist.get(i).getId()+"\t"+" 이름 : "+Alist.get(i).getName()+"\t"+"성적 : "+Alist.get(i).getScore()+"\t"+"D+"+'\n';
			}	
			else if(Alist.get(i).getScore()<65 && Alist.get(i).getScore()>=60) {
				str7=str7+"ID : "+Alist.get(i).getId()+"\t"+" 이름 : "+Alist.get(i).getName()+"\t"+"성적 : "+Alist.get(i).getScore()+"\t"+"D"+'\n';
			}
			else {
				str7=str7+"ID : "+Alist.get(i).getId()+"\t"+" 이름 : "+Alist.get(i).getName()+"\t"+"성적 : "+Alist.get(i).getScore()+"\t"+"F"+'\n';
			}
			
		}
		return str7;
	}
	


	public void delete(String text) {
	
		String del_id=text;
		boolean found=false;
		int tempIndex=0;
		try {
		for(int i=0;i<list.size();i++) {
			if(del_id.equals(list.get(i).getId())) {
				found=true;
				tempIndex=i;
				
			}
		}
		if(found) {
			list.remove(tempIndex);
			flag=5;
			JOptionPane.showMessageDialog(null,"삭제되었습니다");
		}
		else {
			System.out.println("삭제할 ID가 없음!!");
		}
		}catch(Exception e) {
			System.out.println("오류발생");
			e.printStackTrace(System.out);
		}
	}
	public String select(String text) {
		
		String text1=text;
		boolean found1=false;
		int tempIndex1=0;
		
		String str8="";
		for(int i=0;i<list.size();i++) {
			if(text1.equals(list.get(i).getId())) {
				found1=true;
				tempIndex1=i;
				
			}
		}
		if(found1) {
			str8=str8+"ID : "+list.get(tempIndex1).getId()+"\t"+" 이름 : "+list.get(tempIndex1).getName()+"\t"+"성적 : "+list.get(tempIndex1).getScore()+'\n';
			flag=15;
			
			
		}
			
			
		
		return str8;
		
		
		
		
	}
	

}
