package assignment.one;

public class Employee 
{

	private int id;
	private String name;
	private int age;
	private float basicSalary;
	private String tostr=" ";//For tostring method
	public static int count=0;//For counting number of objects
	
	//Constructors
	public Employee(int id, String name, int age, float basicSalary)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.basicSalary = basicSalary;
		count++;
	}
	public Employee() 
	{
		this.id = 0;
		this.name = " ";
		this.age = 0;
		this.basicSalary = 0;
		count++;
		
	}
	public Employee(Employee emp)
	{
		this.id = emp.id;
		this.name = emp.name;
		this.age = emp.age;
		this.basicSalary = emp.basicSalary;
		count++;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	//Tostring method
	public String toString()
	{
		tostr+="Id="+this.id+"\nName="+this.name+"\nAge = "+this.age+"\nBasic salary = "+this.basicSalary;
		return tostr;
	}
	//IsEquals Method
	public boolean equals(Employee emp)
	{
		if(this.id==emp.id && this.name==emp.name && this.age==emp.age && this.basicSalary==emp.basicSalary)
			return true;
		return false;
	}
	//Compute Salary
	public float computeSalary()
	{
		return this.basicSalary;
	}
	public boolean idEquals(int idd) {
		// TODO Auto-generated method stub
		return false;
	}
}
