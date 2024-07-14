package com.pranav.driveportal.userAuthapp.services;
import java.sql.*;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class JdbcDatabase {
	
	private String url="jdbc:mysql://localhost:3306/user_database";
	private String unamejdbc="root";
	private String password="admin@123";
	
	private static String genRanduname(int length) {
		
		var randinst = new Random();
		String randString="";
		int c=0;
		
		while(true) {
			int randint = randinst.nextInt(122);
			if((randint>=48 && randint<=57) || (randint>=65 && randint<=90) || (randint>=97 && randint<=122)) {
				char a = (char) randint;
				randString+=a;
				c++;
			}
			if(c==length)	
				break;
			
		}
		
		return randString;
	}
	
	private static Boolean authenticateUser(String enteredPass,String fetchedPass) {
		
		if(enteredPass.equals(fetchedPass))
			return true;
		return false;
		
	}
	
	public String signUP(String uname,String pwd,String mailid,Long phoneno,Date dob) throws Exception {
		
		String insQuery = "insert into users values(?,?,?,?,?,?)",randStr=genRanduname(uname.length()+3);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, unamejdbc, password);
		PreparedStatement prepStat = con.prepareStatement(insQuery);
		prepStat.setString(1, randStr);
		prepStat.setString(2, uname);
		prepStat.setString(3, pwd);
		prepStat.setString(4, mailid);
		prepStat.setDate(5, dob);
		prepStat.setLong(6, phoneno);
		int nofOfrowschanged = prepStat.executeUpdate();
		
		return randStr;
		
	}
	
	public Boolean signIN(String uname,String pass) throws Exception {
		
		String fetchQuery = "select * from users where UNAME=?",Password="";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, unamejdbc, password);
		PreparedStatement ps = con.prepareStatement(fetchQuery);
		
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Password = rs.getString("PASS");
		}
		Boolean res =  authenticateUser(pass,Password);
		
		return res;
		
	}
	
	public Boolean fetchEmail(String emailId) throws Exception {
		
		String fetchQuery = "select * from users where EMAILID=?",val="";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, unamejdbc, password);
		PreparedStatement ps = con.prepareStatement(fetchQuery);
		
		ps.setString(1, emailId);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			val = rs.getString("PASS");
		}
		
		if(!val.equals(""))  //to check if that emailid exists or not, using password to find if its null or not
			return true;
		return false;
	}
	
	public String changePass(String emailid) throws Exception {
		
		String Query = "UPDATE users SET PASS=? WHERE EMAILID=?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, unamejdbc, password);
		PreparedStatement ps = con.prepareStatement(Query);
		
		String newPass = genRanduname(emailid.length()-2);
		
		ps.setString(1, newPass);
		ps.setString(2, emailid);
		
		int nonZeroRowsAffected = ps.executeUpdate();
		
		return newPass;
		
	}

	public String addfileCriteria(String username,String fileid,String filetype,String filesize) throws ClassNotFoundException, SQLException {

		String insQuery = "insert into filevistadrive values(?,?,?,?)";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, unamejdbc, password);
		PreparedStatement prepStat = con.prepareStatement(insQuery);
		prepStat.setString(1, fileid);
		prepStat.setString(2, filetype);
		prepStat.setString(3, filesize);
		prepStat.setString(4, username);

		int nofOfrowschanged = prepStat.executeUpdate();

		return "Successfully added file onto the specified folder";

	}

}
