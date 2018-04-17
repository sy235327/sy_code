package package_5;
import java.util.*;
public class TestStudent {
private static List<Student>list=new ArrayList<Student>();
	public static void main(String[] args) {
boolean done=true;
Scanner scan=new Scanner(System.in);
System.out.println("1,输入学生的信息：");
System.out.println("2,删除学生的信息：");
System.out.println("3,查询学生信息：");
System.out.println("4,导出学生信息：");
System.out.println("5,退出系统：");
while(done) {
System.out.print("输入你想进行第几步操作：");
int choice=scan.nextInt();
switch(choice) {
case 1:
	System.out.println("开始输入学生的信息：");
	System.out.print("学生的姓名：");
	String name=scan.next();
	System.out.print("学生的性别：");
	String sex=scan.next();
	System.out.print("学生的年龄：");
	int age=scan.nextInt();
	System.out.print("学生的电话号码：");
	String telephone=scan.next();
	list.add(new Student(name,sex,age,telephone));
	break;
case 2:
	System.out.println("开始删除学生的信息：");
	System.out.println("请输入你要删除的学生的名字：");
	String name1=scan.next();
	Iterator<Student>it=list.iterator();
	if(!it.next().getName().equals(name1)) {
		System.out.println("你输错了学生的名字");
	}
	else
	delete(name1);
	break;
case 3:
	System.out.println("开始查找学生的信息：");
	System.out.println("请输入你要查找的学生的位置：");
	int i1=scan.nextInt();
	if(i1<=0||i1>list.size()) {
		System.out.println("你输错了学生的位置");
	}
	else {
		seacher(i1-1);
	}
	break;
case 4:
	System.out.println("开始导出剩下人的的信息：");
	show(list);
		break;
case 5:
	System.out.println("再见！欢迎再次使用本系统");
	done=false;
	scan.close();
	}
}
}
public static void delete(String name) {
	for(int i=0;i<list.size();i++) {
		if(list.get(i).getName().equals(name))
			list.remove(i);
	}
}
public static void seacher(int i) {
		System.out.print("这个被查询人的名字："+list.get(i).getName());
		System.out.print("\t这个被查询人的性别："+list.get(i).getSex());
		System.out.print("\t这个被查询人的年龄："+list.get(i).getAge());
		System.out.print("\t这个被查询的人手机号码："+list.get(i).getTelephone());
		System.out.println();
	}
public static void show(List<Student> L) {
	for(Student stu1:L) {
	System.out.print("剩下人的名字："+stu1.getName());
	System.out.print("\t剩下人的性别："+stu1.getSex());
	System.out.print("\t剩下人的年龄："+stu1.getAge());
	System.out.print("\t剩下的人的手机号码："+stu1.getTelephone());
	System.out.println();
}	
}
}
