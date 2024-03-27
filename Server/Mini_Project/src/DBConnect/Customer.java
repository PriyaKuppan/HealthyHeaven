package DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer extends DBConnect {

	public void insert() throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Name");
		String name = sc.next();
		System.out.println("Enter your EmailID:");
		String Eid = sc.next();
		System.out.println("Enter your Password:");
		String pass = sc.next();
		System.out.println("Enter your Address");
		String adr = sc.next();
		System.out.println("Enter your contact");
		long cont = sc.nextLong();

		String q = "insert into customer(Cust_Name,Cust_EmailId,Cust_Passwrd,Cust_Address,Cust_Contact_Num) values(?,?,?,?,?)";

		PreparedStatement pst = Con.prepareStatement(q);
		pst.setString(1, name);
		pst.setString(2, Eid);
		pst.setString(3, pass);
		pst.setString(4, adr);
		pst.setLong(5, cont);
		int n = pst.executeUpdate();
		if (n > 0) {
			System.out.println("Successfully registered");
		}

		else {
			System.out.println("Invalid register");
		}
		sc.close();

	}

	public void view() throws SQLException {
		String q = "select * from customer";
		PreparedStatement pst = Con.prepareStatement(q);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String Eid = rs.getString(3);
			String pass = rs.getString(4);
			String adr = rs.getString(5);
			long cont = rs.getLong(6);
			System.out.println("Id: " + id + "\t" + "Name: " + name + "\t" + "EmailId: " + Eid + "\t" + "Passwrd: "
					+ pass + "\t" + "Address: " + adr + "\t" + "Contact: " + cont);

		}
	}

	public void update() throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("What you want to update...? \n 1. Name \n 2. Email \n 3. Password \n");
		int updateOption = sc.nextInt();
		System.out.println("Enter the id");
		int uid = sc.nextInt();
		sc.nextLine();
		switch (updateOption) {
		case 1:

			// to Update the name
			String q = "update customer set Cust_Name=? where Cust_Id=?;";
			System.out.println("Enter your Updated Name:");
			String uname = sc.nextLine();
			PreparedStatement pst = Con.prepareStatement(q);
			pst.setString(1, uname);
			pst.setInt(2, uid);
			int n = pst.executeUpdate();
			String r = (n > 0) ? "Updated Successfully" : "Please insert proper values";
			System.out.println(r);
			break;

		case 2:
			// to update the emailid

			String q1 = "update customer set Cust_EmailId = ? where Cust_Id=?;";
			System.out.println("Enter your Updated Email Id:");
			String ueid = sc.nextLine();
			PreparedStatement pst1 = Con.prepareStatement(q1);
			pst1.setString(1, ueid);
			pst1.setInt(2, uid);
			int n1 = pst1.executeUpdate();
			String r1 = (n1 > 0) ? "Updated Successfully" : "Please insert proper values";
			System.out.println(r1);
			pst1.executeUpdate();
			break;

		case 3:
			// to update password

			String q2 = "update customer set Cust_Password = ? where Cust_Id=?";
			System.out.println("Enter your Updated Password:");
			String upass = sc.nextLine();
			PreparedStatement pst2 = Con.prepareStatement(q2);
			pst2.setString(1, upass);
			pst2.setInt(2, uid);
			int n2 = pst2.executeUpdate();
			String r2 = (n2 > 0) ? "Updated Successfully" : "Please insert proper values";
			System.out.println(r2);
			pst2.executeUpdate();

		default:
			System.out.println("Invalid input");
		}
	}
      //to delete
	public void delete() throws SQLException {
		Scanner sc = new Scanner(System.in);
		String q = "delete from customer where Cust_EmailId= ?";
		System.out.println("Enter the id to delete the details:");
		int uid = sc.nextInt();
		PreparedStatement pst = Con.prepareStatement(q);
		pst.setInt(1, uid);
		pst.executeUpdate();

	}

}
