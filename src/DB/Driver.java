package DB;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import assignment.one.Employee;

import java.util.Scanner;

	@SuppressWarnings("unused")
	public class Driver 
	{
		DBCOnnect sm;
		int n;
		List <Employee> l;
		public Driver(List<Employee> e)
		{
			l=e;
			sm=new DBCOnnect();
		}

		
		public void display() throws SQLException
		{
			boolean nn=true;
			while(nn)
			{
				@SuppressWarnings("resource")
				Scanner s=new Scanner(System.in);
				System.out.println("\n\n1:Insert new row in table\n2:Display Records\n3:Update\n4:Delete Record\n5:Inset complete arraylist\n6:Exit\n\t");
				System.out.println("Enter choice :");
				n=s.nextInt();
				switch(n)
				{
				case 1: 
					sm.insertt(1);
					break;
				case 2:
					sm.display("Lecturer");
					sm.display("SecurityGuard");
					break;
				case 3:
				{
					int ch;
					System.out.println("1:Lecturer\n2:Security Guard\nEnter Your Choice\n");
					ch=s.nextInt();
					sm.update(ch);
					break;
				}
				case 4:
				{
					int ch;
					int cid;
					System.out.println("1:Lecturer\n2:Security Guard\nEnter Your Choice\n");
					ch=s.nextInt();
					System.out.println("Enter your Registration Number or ID\n");
					cid=s.nextInt();
					
					sm.deletee(cid,ch);
					break;
				}
				case 5:
				{
					sm.input(l);
					System.out.println("In driver");
					break;
				}
				case 6:
					System.exit(-1);
				
			}
				System.out.println("Enter false to exit or True to repeat\n");
				nn=s.nextBoolean();
		}		
	}
		
		public void clos() throws SQLException
		{
			sm.clos();
		}
			

}

	

