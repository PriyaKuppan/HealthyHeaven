package DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin extends DBConnect{

	public void view () throws SQLException {
		
	String q="select * from food_menu";
	PreparedStatement pst=Con.prepareStatement(q);
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		int id=rs.getInt(1);
		String name=rs.getString(2);
		String type=rs.getString(3);
		String category=rs.getString(4);
		double price=rs.getDouble(5);
		System.out.println(id+"\t"+ name+"\t\t"+type+"\t\t\t"+category+"\t\t\tRs."+price);
	

	}
	}
	
	
public void update() throws SQLException {
		
		
		Scanner sc=new Scanner (System.in);
		System.out.println("What you want to update...? \n 1. Food_Name \n 2. Food_Type \n 3.Food_Category \n 4.Food_Price \n");
		int updateOption=sc.nextInt();
		System.out.println("Enter the id:");
		int fid = sc.nextInt();
		sc.nextLine();
		
		switch(updateOption) {
		case 1:
			
			//to Update the Food_name
			String q = "update food_menu set Food_Name = ? where Food_Id= ?";
			System.out.println("Enter the updated food name:");
			String fname = sc.nextLine();
			PreparedStatement pst = Con.prepareStatement(q);
			pst.setString(1, fname);
			pst.setInt(2, fid);
			int n = pst.executeUpdate();
			String r = (n > 0) ? "Updated Successfully" : "Please insert proper values";
			System.out.println(r);
			break;
			
		case 2:
		// to update the Food_Type
		
		System.out.println("Enter the updated Food Type:");
		String ftyp = sc.nextLine();
		String q1 = "update food_menu set Food_Type = ? where Food_Id=?";
		PreparedStatement pst1 = Con.prepareStatement(q1);
		pst1.setString(1, ftyp);
		pst1.setInt(2, fid);
		int n1 = pst1.executeUpdate();
		String r1 = (n1 > 0) ? "Updated Successfully" : "Please insert proper values";
		System.out.println(r1);
		break;
		
		
		case 3:
		//to update food_category
		
		System.out.println("Enter the updated food category :");
		String fcat = sc.nextLine();
		String q2 = "update customer set Food_Category = ? where Food_Id=?";
		PreparedStatement pst2 = Con.prepareStatement(q2);
		pst2.setString(1, fcat);
		pst2.setInt(2, fid);
		int n2 = pst2.executeUpdate();
		String r2 = (n2 > 0) ? "Updated Successfully" : "Please insert proper values";
		System.out.println(r2);
		
		default:
			System.out.println("Invalid input");
		}
	}
public void delete() throws SQLException {
		 Scanner sc=new Scanner(System.in);
		 String q="delete from food_menu where Food_Id= ?";	
		 System.out.println("Enter the id to be deleted");
		 int fid = sc.nextInt();
		 PreparedStatement pst=Con.prepareStatement(q);
		 pst.setInt(1,fid);
		 int n = pst.executeUpdate();
			String r = (n > 0) ? "Deleted Successfully" : "Please insert proper values";
			System.out.println(r);
		 
	 }
	 
public void search() throws SQLException {
		 String q="select *from food_menu where Food_Name like ?;";
		 Scanner sc=new Scanner (System.in);
		 System.out.println("Enter the food name to be searched:");
		 String fname= sc.next();
		 fname="%"+fname+"%";
		 PreparedStatement pst=Con.prepareStatement(q);
		 pst.setString(1, fname);
		 ResultSet rs=pst.executeQuery();
		 while(rs.next()) {
			 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5));
		 }
		 
		 
			}

}



