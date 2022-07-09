package GUIStudent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

 class DialogEx extends JDialog {
	private JTextField tf=new JTextField(10);
	private JLabel Jt=new JLabel("삭제할 ID");
	public JButton d_Button=new JButton("삭제");
	private JButton c_Button=new JButton("취소");
	
	public StudentDAO dao;
	
	 DialogEx(JFrame frame,String title) {
		super(frame,title);
		
		this.dialogDesign();
		this.dialogEvent();
	
		setSize(200,100);
		
	 }
	 public void dialogDesign() {
		 this.setLayout(new FlowLayout());
		 this.add(Jt);
		 this.add(tf);
		 this.add(d_Button);
		 this.add(c_Button);
		
	
	}
	 public String getInput() {
			if(tf.getText().length()==0)
				return null;
			else return tf.getText();
			
		}
	 public void dialogEvent() {
		 c_Button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
				
			});
		 
	 }
	 
}
 class DialogEx2 extends JDialog {
	private JTextField tf=new JTextField(10);
	private JLabel Jt=new JLabel("수정할 ID");
	public JButton u_Button=new JButton("수정1");
	private JButton c_Button=new JButton("취소");
	private StudentDAO dao;
	
	 DialogEx2(JFrame frame,String title) {
		super(frame,title);
		
		this.dialogDesign();
		this.dialogEvent();
	
		setSize(200,100);
		
	 }
	 public void dialogDesign() {
		 this.setLayout(new FlowLayout());
		 this.add(Jt);
		 this.add(tf);
		 this.add(u_Button);
		 this.add(c_Button);
		
	
	}
	 public String getInput() {
			if(tf.getText().length()==0)
				return null;
			else return tf.getText();
			
		}
	 public void dialogEvent() {
		 c_Button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
				
			});
		 
	 }
	 
}
 class DialogEx3 extends JDialog {
		public JTextField tf=new JTextField(10);
		private JLabel Jt=new JLabel("ID : ");
		public JTextField jtf=new JTextField(10);
		public JLabel name=new JLabel("이름: ");
		public JTextField jtf2=new JTextField(10);
		private JLabel score=new JLabel("성적: ");
		public JTextField jtf3=new JTextField(10);
		
		public JButton up_Button=new JButton("수정완료");
		private JButton c_Button=new JButton("취소");
		private StudentDAO dao;
		
		 DialogEx3(JFrame frame,String title) {
			super(frame,title);
			
			this.dialogDesign();
			this.dialogEvent();
		
			setSize(180,160);
			
		 }
		 public void dialogDesign() {
			 this.setLayout(new FlowLayout());
			 this.add(Jt);
			 this.add(tf);
			 this.add(name);
			 this.add(jtf);
			 this.add(score);
			 this.add(jtf2);
			 this.add(up_Button);
			 this.add(c_Button);
			
		
		}
		 public String getInput() {
				if(tf.getText().length()==0)
					return null;
				else return tf.getText();
				
				
				
				
			}
		 public String getInput1() {
			 if(jtf.getText().length()==0)
				 return null;
			 else return jtf.getText();
		 }
		 public String getInput2() {
			 if(jtf2.getText().length()==0)
				 return  null;
			 else return jtf2.getText();
		 }
		 public void dialogEvent() {
			 c_Button.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
					
				});
			 
		 }
		 
	}
class DialogEX4 extends JDialog{
	private JTextField tf=new JTextField(10);
	private JLabel Jt=new JLabel("검색할 ID");
	public JButton s_Button=new JButton("검색");
	private JButton c_Button=new JButton("취소");
	
	public StudentDAO dao;
	
	 DialogEX4(JFrame frame,String title) {
		super(frame,title);
		
		this.dialogDesign();
		this.dialogEvent();
	
		setSize(200,100);
		
	 }
	 public void dialogDesign() {
		 this.setLayout(new FlowLayout());
		 this.add(Jt);
		 this.add(tf);
		 this.add(s_Button);
		 this.add(c_Button);
		
	
	}
	 public String getInput() {
			if(tf.getText().length()==0)
				return null;
			else return tf.getText();
			
		}
	 public void dialogEvent() {
		 c_Button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
				
			});
		 
	 }
}

public class StudentGUI extends JFrame implements FocusListener,ActionListener {
	private JPanel west_P,input_P,south_P,north_P,array_P;
	private JLabel id_L,name_L,score_L;
	private JTextField id_T,name_T,score_T;
	
	private JButton regist_B,view_B,exit_B,select_B;
	private JTextArea output_T;
	
	//삭제버튼 추가
	private JButton delete_Button,update_Button,save_Button,File_Button,array_Button,Study_Button;
	DialogEx dialog=new DialogEx(this,"삭제");
	DialogEx2 dialog2=new DialogEx2(this,"수정");
	DialogEx3 dialog3=new DialogEx3(this,"수정");
	DialogEX4 dialog4=new DialogEX4(this,"검색");
	//등록된 학생데이터를 저장
	private StudentDAO dao;
	private ArrayList<Student> al;
	
	
	StudentGUI() throws IOException{
		this.setTitle("학생관리프로그램");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.formDesign();
		this.eventHandler();
		this.setSize(500,230);
		this.setVisible(true);
		
		
		dao=new StudentDAO();
		al=new ArrayList<Student>();
		
		
	}
	private void eventHandler() {
		id_T.addFocusListener(this);
		name_T.addFocusListener(this);
		score_T.addFocusListener(this);
		
		regist_B.addActionListener(this);
		view_B.addActionListener(this);
		exit_B.addActionListener(this);
		
		save_Button.addActionListener(this);
		File_Button.addActionListener(this);
		delete_Button.addActionListener(this);
		update_Button.addActionListener(this);
		array_Button.addActionListener(this);
		Study_Button.addActionListener(this);
		select_B.addActionListener(this);
		
	}
	private void formDesign() {
		west_P=new JPanel();
		input_P=new JPanel();
		south_P=new JPanel();
		north_P=new JPanel();
		array_P=new JPanel();
		
		
		id_L=new JLabel("   ID");
		name_L=new JLabel(" 이름");
		score_L=new JLabel(" 성적:");
		
		id_T=new JTextField();
		name_T=new JTextField();
		score_T=new JTextField();
		
		regist_B=new JButton("등록");
		view_B=new JButton("보기");
		exit_B=new JButton("종료");
		delete_Button=new JButton("삭제");
		update_Button = new JButton("수정");
		save_Button=new JButton("저장");
		File_Button=new JButton("불러오기");
		array_Button=new JButton("이름정렬");
		Study_Button=new JButton("성적정렬");
		select_B=new JButton("검색");
		output_T=new JTextArea();
		
		//---------디자인
		
		this.add(west_P,BorderLayout.WEST);
		west_P.setLayout(new GridLayout(2,1));
		west_P.setSize(100,230);
		west_P.add(input_P);
		
		input_P.setLayout(new GridLayout(3,2));
		
		input_P.add(id_L);
		input_P.add(id_T);
		input_P.add(name_L);
		input_P.add(name_T);
		input_P.add(score_L);
		input_P.add(score_T);
		
		
		
		this.add(south_P,BorderLayout.SOUTH);
		south_P.add(regist_B);
		south_P.add(view_B);
		south_P.add(exit_B);
		south_P.add(delete_Button);
		south_P.add(update_Button);
		south_P.add(save_Button);
		south_P.add(File_Button);
		
		
		
		
		
		
		
		this.add(north_P,BorderLayout.CENTER);
		north_P.setLayout(new BorderLayout());
		north_P.add(array_P,BorderLayout.NORTH);
		array_P.setLayout(new FlowLayout(FlowLayout.LEFT));
		array_P.add(array_Button);
		array_P.add(Study_Button);
		array_P.add(select_B);
		
		north_P.add(output_T,BorderLayout.CENTER);
		
		
		name_T.setEditable(false);
		score_T.setEditable(false);
		
		regist_B.setEnabled(false);
		view_B.setEnabled(false);
		
		
	}
	public static void main(String[] args) throws IOException,ClassNotFoundException {
		new StudentGUI();
	}
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource().equals(id_T)) {
			output_T.setText("ID를 입력해주세요");
		}
		else if(e.getSource().equals(name_T)) {
			output_T.setText("이름을 입력해주세요");
		}
		else if(e.getSource().equals(score_T)) {
			output_T.setText("성적을 입력해주세요");
		}
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource().equals(id_T)) {
			if(id_T.getText()=="") {
				output_T.setText("ID가 입력되지 않았습니다.");
			}
			else {
				name_T.setEditable(true);
			}
		}
		else if(e.getSource().equals(name_T)) {
			if(name_T.getText()=="") {
				output_T.setText("이름이 입력되지 않았습니다");
				
			}else {
				score_T.setEditable(true);
				
			}
		}
		else if(e.getSource().equals(score_T)) {
			if(score_T.getText()=="") {
				output_T.setText("성적이 입력되지 않았습니다");
				
			}
			else {
				regist_B.setEnabled(true);
				regist_B.requestFocus();
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("ACTION :" +e.getActionCommand());
		
		if(e.getActionCommand().equals("등록")) {
			if(dao.insert(id_T.getText(),name_T.getText(),Integer.parseInt(score_T.getText()))) {
				output_T.setText("등록이 완료되었습니다");
			}
			else {
				output_T.setText("ID가 존재합니다");
			}
			//등록이 완료되면 텍스트 필드의 데이터를 삭제
			id_T.setText("");
			name_T.setText("");
			score_T.setText("");
			view_B.setEnabled(true);
			
			
		}
		else if(e.getActionCommand().equals("보기")) {
			output_T.setText(dao.inquire());
		}
		else if(e.getActionCommand().equals("종료")) {
			this.setVisible(false);
		}
		else if(e.getActionCommand().equals("삭제")) {
			dialog.setVisible(true);
			
			dialog.d_Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String text=dialog.getInput();
					
					if(text==null) 
						return;
					
						dao.delete(text);
						if(dao.flag==5) {
							dialog.setVisible(false);
						}
						

				}
				
			});
			
			
			}
		else if(e.getActionCommand().equals("수정")) {
			dialog2.setVisible(true);
			dialog2.u_Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e1) {
					JButton b=(JButton)e1.getSource();
					
					System.out.println("수정"+e1.getSource());
					if(b.getText().equals("수정1")) {
					String text=dialog2.getInput();
					if(text==null)
						return;
					
					dao.update(text);
					}
				
					if(dao.found2==true) {
						System.out.println(e.getActionCommand());
						dialog3.setVisible(true);
						dialog3.up_Button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e2) {
							JButton c=(JButton)e2.getSource();
							if(c.getText().equals("수정완료")) {
							System.out.println(e2.getActionCommand());
							String id=dialog3.getInput();
							String name=dialog3.getInput1();
							int score= Integer.parseInt(dialog3.getInput2());
							
							dao.update1(id,name,score);	
							JOptionPane.showMessageDialog(null,"수정되었습니다");
							if(dao.flag2==6) {
								
								dialog3.setVisible(false);
								dialog2.setVisible(false);
								
								}
							}
						}});}}});
			
		
		
		
		
		
		
		
		
		}
		
		
		
		
		
	  
		else if(e.getActionCommand().equals("저장")) {
		
			
			
			try {
				output_T.setText(dao.FileSave());
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	
		
		}
		else if(e.getActionCommand().equals("불러오기")) {

					try {
						System.out.println("불러오기 성공");
						output_T.setText(dao.FileInput());
						
						
						
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

		}
		else if(e.getActionCommand().equals("이름정렬")) {
			output_T.setText(dao.namearray());
		}
		else if(e.getActionCommand().equals("성적정렬")) {
			output_T.setText(dao.studyArray());
		}
		else if(e.getActionCommand().equals("검색")) {
			dialog4.setVisible(true);
			
			dialog4.s_Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String text1=dialog4.getInput();
					
						
					output_T.setText(dao.select(text1));
					if(dao.flag==15) {
						dialog4.setVisible(false);
					}
					
					
					
				}
				
				
			});
			
		}
		
	}

	
	}




