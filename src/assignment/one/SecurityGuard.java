package assignment.one;

public class SecurityGuard extends NonAcadamic
{
	private int totalHours;
	private String tostr=" ";
	
	//Constructors
	public SecurityGuard() {
		super();
		totalHours=0;
	}

	public SecurityGuard(int id, String name, int age, float basicSalary, float hourlyRate,int totalHours) {
		super(id, name, age, basicSalary, hourlyRate);
		this.totalHours=totalHours;
	}

	public SecurityGuard(SecurityGuard sgard) {
		super(sgard);
		this.totalHours=sgard.totalHours;
		
	}

	//Getter and Setter

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}
	
	//ToString method
	
	public String toString()
	{
		tostr=tostr+super.toString();
		tostr+="\nTotal Hours= "+this.totalHours+"\n\n------------------------------------------------------------------------\n";
		return tostr;
	}
	
	//Equals Method
	
	public boolean equals(SecurityGuard sgard)
	{
		if(super.equals(sgard) && this.totalHours==sgard.totalHours )
			return true;
		return false;
	}
	
	//Compute Salary method
	public float computeSalary()
	{
		return(super.computeSalary()+super.getHourlyRate()*this.totalHours);
	}
	
	
	boolean idEqual(int id)
	{
		if(this.getId()==id)
			return true;
		else
			return false;
	}
}