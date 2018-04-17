package package_5;

public class Student {
private String name;
private String sex;
private int age;
private String telephone;
public Student() {
	
}
public Student(String name,String sex,int age,String telephone) {
	this.age=age;
	this.name=name;
	this.sex=sex;
	this.telephone=telephone;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getTelephone() {
	return telephone;
}
public void Telephone(String telephone) {
	this.telephone= telephone;
}
}
