package assignment.one;

public class Lecturer extends Academic
{
	private int totalCourses;
	private String tostr=" ";//For to String method
	//Constructors
	public Lecturer()
	{
		super();
		this.totalCourses=0;
	}

	public Lecturer(Lecturer lecObj)
	{
		super(lecObj);
		this.totalCourses=lecObj.totalCourses;
	}

	public Lecturer(int id, String name, int age, float basicSalary, float courseRate, int totalCourses) {
		super(id, name, age, basicSalary, courseRate);
		this.totalCourses=totalCourses;
	}
	//Getter and Setter

	public int getTotalCourses() {
		return totalCourses;
	}

	public void setTotalCourses(int totalCourses) {
		this.totalCourses = totalCourses;
	}
	
	//Tostring Method
	public String toString()
	
	{
		tostr+=super.toString();
		tostr+="\nTotal Courses = "+this.totalCourses;
		return tostr;
	}

	//Equals Method
	public boolean equals(Lecturer lec)
	{
		if(super.equals(lec) && this.totalCourses==lec.totalCourses )
			return true;
		return false;
	}
	//Compute Salary method
	public float computeSalary()
	{
		return(super.computeSalary()+super.getCourseRate()*this.totalCourses);
	}
	
	boolean idEqual(int id)
	{
		System.out.println("Pasha Bhai");
		if(this.getId()==id)
			return true;
		else
			return false;
	}
}
