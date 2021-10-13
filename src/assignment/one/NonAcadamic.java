package assignment.one;

public class NonAcadamic extends Employee
{
	private float hourlyRate;
	private String tostr=" ";
	//Constructors
	public NonAcadamic() 
	{
		super();
		this.hourlyRate=0;
	}

	public NonAcadamic(NonAcadamic nonacad)
	{
		super(nonacad);
		this.hourlyRate=nonacad.hourlyRate;
		
	}

	public NonAcadamic(int id, String name, int age, float basicSalary , float hourlyRate) 
	{
		super(id, name, age, basicSalary);
		this.hourlyRate=hourlyRate;
	}


	//Getter & Setter
	public float getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	//To String mathod
	public String toString()
	{
		tostr+=super.toString();
		tostr+="\nHourlyRate = "+this.hourlyRate;
		return tostr;
	}
	
	
	//Equals Method
	public boolean equals(NonAcadamic nonacad)
	{
		if(super.equals(nonacad) && this.hourlyRate==nonacad.hourlyRate )
			return true;
		return false;
	}
	//Compute Salary Method
	public float computeSalary()
	{
		return super.computeSalary();
	}

}
