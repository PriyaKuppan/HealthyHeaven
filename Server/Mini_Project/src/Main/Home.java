package Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import DBConnect.Admin;
import DBConnect.Customer;
import DBConnect.DBConnect;

public class Home extends DBConnect {

	public void start() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Login as---- \n 1. Admin \n 2. Customer");
		int login = sc.nextInt();
		sc.nextLine();
		switch (login) {
		case 1:
			System.out.println("Enter your Email Id : ");
			String adminEmail = sc.nextLine();
			System.out.println("Enter Your Password : ");
			String adminPassword = sc.nextLine();
			String q1 = "select Admin_Email,Admin_Password from admin where Admin_Email=? AND Admin_Password=?;";
			PreparedStatement pst1 = Con.prepareStatement(q1);
			pst1.setString(1, adminEmail);
			pst1.setString(2, adminPassword);
			ResultSet rs1 = pst1.executeQuery();
			while (rs1.next()) {
				String user = rs1.getString(1);
				String password = rs1.getString(2);
				if ((adminEmail.equals(user)) && (adminPassword.equals(password))) {
					Admin a = new Admin();
					while (true) {
						System.out.println(
								"What action do you wanna perform----? \n 1.View Food_Menu \n 2. Search Food_Menu \n 3. UPDATE Food_Menu \n 4. DELETE Food_Menu ");
						int performAction = sc.nextInt();
						switch (performAction) {
						case 1:
							a.view();
							break;
						case 2:
							a.search();
							break;
						case 3:
							a.update();
							break;
						case 4:
							a.delete();
							break;
						default:
							System.out.println("Invalid Option");
							break;
						}

					}

				}

				else {
					System.out.println("Invalid credentials");
				}
			}
			break;

		case 2:
			System.out.println("Enter your Email Id : ");
			String customerEmail = sc.nextLine();
			System.out.println("Enter Your Password : ");
			String customerPassword = sc.nextLine();
			String q2 = "select Cust_EmailId,Cust_Passwrd from customer where Cust_EmailId=? AND Cust_Passwrd =?;";
			PreparedStatement pst2 = Con.prepareStatement(q2);
			pst2.setString(1, customerEmail);
			pst2.setString(2, customerPassword);
			ResultSet rs2 = pst2.executeQuery();
			while (rs2.next()) {
				String user = rs2.getString(1);
				String password = rs2.getString(2);
				if ((customerEmail.equals(user)) && (customerPassword.equals(password))) {
					Customer cs = new Customer();
					while (true) {
						System.out.println(
								"What action do you wanna perform----? \n 1.Insert customer details \n 2.View customer details \n 3.Update customer details \n 4.Delete customer details ");
						int performAction = sc.nextInt();
						switch (performAction) {

						case 1:
							cs.insert();
							break;
						case 2:
							cs.view();
							break;
						case 3:
							cs.update();
							break;
						case 4:
							cs.delete();
							break;
						default:
							System.out.println("Invalid Option");
							break;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		Home h = new Home();
		h.start();
	}

}
