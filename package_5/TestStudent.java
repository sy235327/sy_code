package package_5;
import java.util.*;
public class TestStudent {
private static List<Student>list=new ArrayList<Student>();
	public static void main(String[] args) {
boolean done=true;
Scanner scan=new Scanner(System.in);
System.out.println("1,����ѧ������Ϣ��");
System.out.println("2,ɾ��ѧ������Ϣ��");
System.out.println("3,��ѯѧ����Ϣ��");
System.out.println("4,����ѧ����Ϣ��");
System.out.println("5,�˳�ϵͳ��");
while(done) {
System.out.print("����������еڼ���������");
int choice=scan.nextInt();
switch(choice) {
case 1:
	System.out.println("��ʼ����ѧ������Ϣ��");
	System.out.print("ѧ����������");
	String name=scan.next();
	System.out.print("ѧ�����Ա�");
	String sex=scan.next();
	System.out.print("ѧ�������䣺");
	int age=scan.nextInt();
	System.out.print("ѧ���ĵ绰���룺");
	String telephone=scan.next();
	list.add(new Student(name,sex,age,telephone));
	break;
case 2:
	System.out.println("��ʼɾ��ѧ������Ϣ��");
	System.out.println("��������Ҫɾ����ѧ�������֣�");
	String name1=scan.next();
	Iterator<Student>it=list.iterator();
	if(!it.next().getName().equals(name1)) {
		System.out.println("�������ѧ��������");
	}
	else
	delete(name1);
	break;
case 3:
	System.out.println("��ʼ����ѧ������Ϣ��");
	System.out.println("��������Ҫ���ҵ�ѧ����λ�ã�");
	int i1=scan.nextInt();
	if(i1<=0||i1>list.size()) {
		System.out.println("�������ѧ����λ��");
	}
	else {
		seacher(i1-1);
	}
	break;
case 4:
	System.out.println("��ʼ����ʣ���˵ĵ���Ϣ��");
	show(list);
		break;
case 5:
	System.out.println("�ټ�����ӭ�ٴ�ʹ�ñ�ϵͳ");
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
		System.out.print("�������ѯ�˵����֣�"+list.get(i).getName());
		System.out.print("\t�������ѯ�˵��Ա�"+list.get(i).getSex());
		System.out.print("\t�������ѯ�˵����䣺"+list.get(i).getAge());
		System.out.print("\t�������ѯ�����ֻ����룺"+list.get(i).getTelephone());
		System.out.println();
	}
public static void show(List<Student> L) {
	for(Student stu1:L) {
	System.out.print("ʣ���˵����֣�"+stu1.getName());
	System.out.print("\tʣ���˵��Ա�"+stu1.getSex());
	System.out.print("\tʣ���˵����䣺"+stu1.getAge());
	System.out.print("\tʣ�µ��˵��ֻ����룺"+stu1.getTelephone());
	System.out.println();
}	
}
}
