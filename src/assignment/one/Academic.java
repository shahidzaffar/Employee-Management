package assignment.one;

public class Academic extends Employee
{
	private float courseRate;

	private String tostr="";
	
	public Academic() 
	{
		super();
		this.courseRate=0;
	}

	public Academic(int id, String name, int age, float basicSalary, float courseRate)
	{
		super(id, name, age, basicSalary);
		this.courseRate=courseRate;
	}
	
	public Academic(Academic acad) 
	{
		super(acad);
		this.courseRate=acad.courseRate;
	}
	
	
	//Getter and Setter

	public float getCourseRate() 
	{
		return courseRate;
	}

	public void setCourseRate(float courseRate) 
	{
		this.courseRate = courseRate;
	}
	
	//Tostring method;
	
	public String toString()
	{
		tostr+=super.toString();
		tostr+="\nCourseRate = "+this.courseRate;
		return tostr;
	}

	//Equals Method 
	
	public boolean equals(Academic acad)
	{
		if(super.equals(acad) && this.courseRate==acad.courseRate )
			return true;
		return false;

	}
	//Compute Salary
	public float computeSalary()
	{
		return super.computeSalary();
	}
	
}
