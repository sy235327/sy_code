package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.StudentDAO;
import model.Student;

public class StudentAction extends ActionSupport  {
	private Student student;

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	StudentDAO dao=new StudentDAO();
	public String add(){
		dao.add(student);
		return "main";
	}
}