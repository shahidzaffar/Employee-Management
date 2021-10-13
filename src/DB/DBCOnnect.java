package DB;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

import assignment.one.Employee;
import assignment.one.Lecturer;
import assignment.one.SecurityGuard;

public class DBCOnnect 
{

	//Premitive types Variables

		private int id=0;
		private int age=0;
		private String name=" ";
		private double basic=0.0;
		private int number_hc=0;
		private double hc_rate=0;
		
		
		//DBCONNECTION Variables
		
		Statement statement=null;
		Connection connection=null;
		ResultSet res=null;
		int r=0;//for resultset integer returning function
		boolean r_bol;
		ResultSetMetaData metadata=null;
		int n;
		Scanner s=new Scanner(System.in);
		Scanner ss=new Scanner(System.in).useDelimiter("\n");
		
		
		
		//Constructor
		
		public DBCOnnect() 
		{
			String path = "net.ucanaccess.jdbc.UcanaccessDriver";
			String path2 = "jdbc:ucanaccess://"+"E:\\5th Smester\\EmployeeManager.accdb";
		
			try
			{
				Class.forName(path);
				connection=DriverManager.getConnection(path2);
				statement=connection.createStatement();

				System.out.println("Connection Established");
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
				
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			} 
		
		}
		
		public void insertt(int abc)
		{
			System.out.println("Enter your ID please : ");
			id=s.nextInt();
			System.out.println("Enter your Name please : ");
			name=s.next();
			System.out.println("Enter your Age please : ");
			age=s.nextInt();
			System.out.println("Enter your Basic Salary please : ");
			basic=s.nextDouble();
			if(abc==1)
			{
				System.out.println("Enter your number of Courses please : ");
				number_hc=s.nextInt();
				System.out.println("Enter your CourseRate please : ");
				hc_rate=s.nextDouble();
				
			}
			if(abc==2)
			{	
				System.out.println("Enter your number of Hours please : ");
				number_hc=s.nextInt();
				System.out.println("Enter your HourlyRate please : ");
				hc_rate=s.nextDouble();
			
			}
			try 
			{                                
			
				if(abc==1)
					//r=statement.executeUpdate("INSERT into LECTURER(ID,lecName,age,basicSalary,courseRate,noOfCourses) values(3525,'Shahid',34,34,34,34)");                               
					r=statement.executeUpdate("INSERT into LECTURER(ID,lecName,age,basicSalary,courseRate,noOfCourses) values( '"+id+"','"+name+"','"+age+"','"+basic+"','"+hc_rate+"','"+number_hc+"')");                                     
				if(abc==2)
					r=statement.executeUpdate("INSERT into SecurityGuard(ID,secName,age,basicSalary,hourlyRate,noOfHours) values("+id+","+name+","+age+","+basic+","+hc_rate+","+number_hc+")");                                     
				
					
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		public void display(String tableName)
		{
			System.out.println("\n\n--------------------------------");
			System.out.println("--------------------------------");
			System.out.println("----------  "+tableName+"  ----------");
			System.out.println("--------------------------------");
			System.out.println("--------------------------------");
			try 
			{
				res=statement.executeQuery("SELECT * FROM "+tableName);
				
				metadata=res.getMetaData();
				int num=metadata.getColumnCount();
				int i=1;
				while(i<=num)
				{
					System.out.print(metadata.getColumnName(i++)+"\t");
				}
				System.out.println("\n---------------------------------------------------------------");
				System.out.println("");
				
				while(res.next())
				{
					i=1;
					while(i<=num)
					{
						if(i<=2)
							System.out.print(res.getObject(i)+"\t");
						if(i>2)
							System.out.print(res.getObject(i)+"       \t");
						i++;
					}
					System.out.println();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

		public void deletee(int id,int nam)
		{
			String tableName = null;
			if(nam==1)
				tableName="Lecturer";
			else
				tableName="SecurityGuard";
			try {
				r=statement.executeUpdate("DELETE FROM "+tableName+ " where ID="+id+" ");
				System.out.println(r+"Rows Are Effected ");
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		
		public void update(int abc) throws SQLException
		{
			@SuppressWarnings("unused")
			boolean flag =false;
			String table = null;
			if(abc==1)
				table="LECTURER";
			if(abc==2)
				table="SecurityGuard";
			System.out.println("Enter your ID please : ");
			id=s.nextInt();
			res=statement.executeQuery("SELECT * FROM "+table);
			while(res.next())
			{
				
				if((int)res.getObject(5)==id)
				{
					flag=true;
					break;
				}	
			}

			if(flag==false)
			{
				System.out.println("The Id you enter is not a valid ID... Try Again");
				return;
			}
			else
			{
				System.out.println("Enter your Name please : ");
				name=ss.next();
				System.out.println("Enter your Age please : ");
				age=s.nextInt();
				System.out.println("Enter your Basic Salary please : ");
				basic=s.nextDouble();
				if(abc==1)
				{
					System.out.println("Enter your number of Courses please : ");
					number_hc=s.nextInt();
					System.out.println("Enter your CourseRate please : ");
					hc_rate=s.nextDouble();
					
				}
				if(abc==2)
				{	
					System.out.println("Enter your number of Hours please : ");
					number_hc=s.nextInt();
					System.out.println("Enter your HourlyRate please : ");
					hc_rate=s.nextDouble();
				
				}
				try 
				{
					
					if(abc==1)
						r=statement.executeUpdate("Update LECTURER set ID = '"+id+"',lecName='"+name+"', age = '"+age+"' , basicSalary = '"+basic+"', courseRate = '"+hc_rate+"' , noOfCourses = '"+number_hc+"' where ID = "+id);                                     
					if(abc==2)
						r=statement.executeUpdate("Update SecurityGuard set ID = '"+id+"', secName='"+name+"', age = '"+age+"' , basicSalary = '"+basic+"', hourlyRateRate = '"+hc_rate+"' , noOfHours = '"+number_hc+"' where ID = "+id);                                     					
				}
				catch (SQLException e)
				{
					
					e.printStackTrace();
				}
			}

		
		}
		
		public void clos() throws SQLException
		{
			connection.close();
		}
		
		public void input(List<Employee> emp)
		{
			
			
			System.out.print("\nIn \n");
			
			int noOfObj=emp.size();
			
			for(int j=0;j<noOfObj;j++)
			{
				id=emp.get(j).getId();
				name=emp.get(j).getName();
				age=emp.get(j).getAge();
				basic=emp.get(j).getBasicSalary();
				System.out.print("\nABC\n");
				if(emp.get(j) instanceof Lecturer)
				{
					Lecturer lec;
					lec=(Lecturer)emp.get(j);
					number_hc=lec.getTotalCourses();
					hc_rate=lec.getCourseRate();
					try
					{
						r=statement.executeUpdate("INSERT into LECTURER(ID,lecName,age,basicSalary,courseRate,noOfCourses) values( '"+id+"','"+name+"','"+age+"','"+basic+"','"+hc_rate+"','"+number_hc+"')");
					}
					catch (SQLException e)
					{
						
						e.printStackTrace();
					}   
					
				}
				if(emp.get(j) instanceof SecurityGuard)
				{	
					SecurityGuard lec;
					lec=(SecurityGuard)emp.get(j);
					number_hc=lec.getTotalHours();
					hc_rate=lec.getHourlyRate();
					try
					{
						r=statement.executeUpdate("INSERT into SecurityGuard(ID,secName,age,basicSalary,hourlyRate,noOfHours) values("+id+","+name+","+age+","+basic+","+hc_rate+","+number_hc+")");
					} catch (SQLException e) 
					{
						
						e.printStackTrace();
					}                                     
					
					
				}
				
			}
			
		}
}
