package assignment.one;
import java.util.Scanner;
import DB.Driver;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * ********************************************Shahid Zafar
 * ***************************************3515-FBAS/BSSE/F17"A"
 * 
 * ***********************************SOFTWARE ENGINEERING SECTION A
 * ******************************************Employee Database****************************
 * 
 * Here I have 1 unrelated class named Display FOr showing menu */
@SuppressWarnings("unused")


public class Client 
{
	public static void main(String[] args) throws IOException, SQLException
	{
		System.out.println("\n\n\t\t\t WELCOME TO THE EMPLOYEE MANAGMENT SYSTEM\n\n\n");
		
		//Employee emp[]=new Employee[10];
		List<Employee> emp=new ArrayList<Employee>();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		int choice=0;
		int abc;
		
		//Local Variables for Getting data from User
		int id=0;
		String name=" ";
		float basicSalary=0;
		int age=0;
		int totalHours=0;
		float hourlyRate=0;
		int totalCourses=0;
		float courseRate=0;
		
		
		int noOfObj;		// For checking no of Objects Already present in the Array
		boolean exitt=true;	
		// For Checking user's choice to no of times he want to Execute the program
		
		while(exitt)
		{
			Display d=new Display();
			d.Show();
			choice =s.nextInt();//Take choice from user
			noOfObj=Employee.count;
			switch(choice)
			{
				case 1:
				{
					
					if(noOfObj<=9)
					{
						//Get the data which are Common among Lecturer and Security Guard
						System.out.print("\n Enter id : ");
						id=s.nextInt();
						System.out.print("\n Enter Name: ");
						name=s.next();
						System.out.print("\n Enter age : ");
						age=s.nextInt();
						System.out.print("\n Enter Basic Salary : ");
						basicSalary=s.nextFloat();

				
						int ch=0;
						System.out.println("\n\t\t 1 for lecturer \n\t\t 2 for Security guard\n\n Enter Choice : ");
						ch =s.nextInt();
					
					
						if(ch==1)//for Lecturer
						{
							//Get data which is specific for Lecturer
							
							System.out.print("\n Course rate : ");
							courseRate=s.nextFloat();
							System.out.print("\n Enter Total Number Of Courses Taken : ");
							totalCourses=s.nextInt();
							emp.add(new Lecturer(id,name,age,basicSalary,courseRate,totalCourses));
							System.out.println("\n-------------------------------------------------------------\n");
						}
						else if(ch==2)//for Security Guard
						{
							
							//Get data which is specific for Lecturer
							System.out.print("\n Enter Hourly rate : ");
							hourlyRate=s.nextFloat();
							System.out.print("\n Enter Total Number Of Hours Worked : ");
							totalHours=s.nextInt();	
							emp.add(new SecurityGuard(id,name,age,basicSalary,hourlyRate,totalHours));
							System.out.println("\n-------------------------------------------------------------\n");
						}
						else
							System.out.println("Invalid choice");
						}
						else
							System.out.println("\nYou can add maximum of 10 Objects\n\n\n");
						break;
				}
				case 2:
				{
					System.out.println("********************You are in Secound Option of Menu-----------***************************************");
					System.out.println(Employee.count);
					
					System.out.println("----------------------------------------------------------------");
					System.out.println("--------------Displaying All Records----------------------------");
					System.out.println("----------------------------------------------------------------\n\n\n");
					
					int n=emp.size();
					for(int i=0;i<n;i++)
					{
						System.out.println(emp.get(i));
						System.out.println("Computed Salary : "+emp.get(i).computeSalary());
						System.out.println("----------------------------------------------------------------");
					}

					break;
				}
			
				case 3:
				{
					IdComparator ic=new IdComparator();
					Collections.sort(emp,ic);
					
					System.out.println("----------------------------------------------------------------");
					System.out.println("****  Displaying Sorted Data");
					System.out.println("----------------------------------------------------------------");
					int n=emp.size();
					for(int i=0;i<n;i++)
					{
						System.out.println(emp.get(i));
						System.out.println("\nComputed Salary : "+emp.get(i).computeSalary());
						System.out.println("----------------------------------------------------------------");
					}

					
					break;
				}
				case 4:
				{
					int idd;
					int n=0;
					int result=-1;
					System .out.print("Enter ID of Employee to b Searched : ");
					idd=s.nextInt();
					result=compareForSearch(idd,emp);
					if(result!=-1)
					{
						System.out.println("\n-------------------------------------------------------------\n");
						System.out.println("\n Search Successfull\n");
						System.out.println("\n\n Data of Searched Employee \n\n");
						System.out.println(emp.get(result));
						System.out.println("Total Salary : "+emp.get(result).computeSalary()+" \n");
						
					}
					if(result==-1)
						System.out.println("\nRecord not Found in the List");			
					break;
				}
				
				case 5:
				{
					noOfObj=emp.size();
					float sum=0;
					for(int j=0;j<noOfObj;j++)
					{
						sum+=emp.get(j).computeSalary();
					}
					System.out.println("\nTotal Salary result of All Employee is \t:"+sum);
					break;
				}	
				case 6:
				{
					float sumLect=0;
					float sumGuard=0;
					for(Employee e:emp)
					{
						if(e instanceof Lecturer)
							sumLect+=e.computeSalary();
						else if(e instanceof SecurityGuard)
							sumGuard+=e.computeSalary();
					}
					System.out.println("\n-------------------------------------------------------------\n");
					System.out.println("\n---------Total Salary Of lecturers------\n");
					System.out.println("\t\t "+sumLect);
					System.out.println("\n-------------------------------------------------------------\n");
					System.out.println("\n---------Total Salary Of Security Guard------\n");
					System.out.println("\t\t "+sumGuard);
					System.out.println("\n-------------------------------------------------------------\n");
					break;
				}
				case 7:
				{
					for(int i=0;i<noOfObj;i++)
					{
						 String fileContent = emp.get(i).toString();
					     
						    BufferedWriter writer = new BufferedWriter(new FileWriter("ABC.txt",true));
						    if(emp.get(i) instanceof Lecturer)
						    	 writer.write("l,");
						    else if(emp.get(i) instanceof SecurityGuard)
						    	writer.write("s,");
						    writer.write(fileContent);
						    writer.write("\r\n");
						    writer.close();
					}
					break;
				}
				case 8:
				{
					char c;
					BufferedReader rr;
					rr=new BufferedReader(new FileReader("ABC.txt"));
					while (noOfObj<=9 )
					{
						
						String line=rr.readLine();
						if(line == null)
						{
							System.out.println("File Data is finished\n");
							break;
						}
						else
						{
							String[] arrc=line.split(",",7);
							c=arrc[0].charAt(0);
							if(c=='l')
							{
								id=Integer.valueOf(arrc[1]);
								name=String.valueOf(arrc[2]);
								age=Integer.valueOf(arrc[3]);
								basicSalary=Float.valueOf(arrc[4]);
								courseRate=Float.valueOf(5);
								totalCourses=Integer.valueOf(arrc[6]);
								emp.add(new Lecturer(id,name,age,basicSalary,courseRate,totalCourses));
							}
							else if(c=='s')
							{
								id=Integer.valueOf(arrc[1]);
								name=String.valueOf(arrc[2]);
								age=Integer.valueOf(arrc[3]);
								basicSalary=Float.valueOf(arrc[4]);
								hourlyRate=Float.valueOf(5);
								totalHours=Integer.valueOf(arrc[6]);	
								emp.add(new SecurityGuard(id,name,age,basicSalary,hourlyRate,totalHours));
							}
							noOfObj=Employee.count;
						}

					}
					rr.close();
					break;
				}
				case 9:
				{
					Driver driv=new Driver(emp);
					driv.display();
				}
				case 10:
					System.exit(0);
				default :
					System.out.println("Invalid Choice Try Again");
			}
	
		System.out.print("\n\n\n\n\n Enter\n1: continue\n0: to exit \n");
		abc=s.nextInt();
		if(abc==0)
			exitt=false;
		}
		
	}


	

	public static int compareForSearch(int id,List<Employee> arr)
	{
		for (int i=0;i<arr.size();i++)
		{
			if(arr.get(i).getId()==id)
				return i;
		}
		return -1;
	}
}
