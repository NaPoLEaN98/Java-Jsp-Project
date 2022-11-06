package com.cdac.met;

import java.sql.*;
import java.util.*;

public class EmployeeBean implements java.io.Serializable{
 private String id;
 private String password;
 
  
 public final String getId() {return id;}
  public final void setId(String value){ id = value;}
 


  public final String getPassword() {return password;}
  public final void setPassword(String value){password = value;}

  public boolean authenticate () throws SQLException {
   try(var con = DB.getConnection()){
        var stmt = con.prepareStatement("select count(id) from admin WHERE id=? and pwd=?");
	stmt.setString(1, id);
	stmt.setString(2, password);

	var rs = stmt.executeQuery();
	rs.next();
	int count = rs.getInt(1);
	rs.close();
	stmt.close();
	if (count == 1)
		return true;
	 id=password = null;
	return false;
   }
  }


  
	public List<EmployeeEntry> getEmployee() throws SQLException {
		var orders = new ArrayList<EmployeeEntry>();
		try(var con = DB.getConnection()){
			var pstmt = con.prepareStatement("select emp_id, ename, sal, comm, dept_no, age from emp ");
			var rs = pstmt.executeQuery();
			while(rs.next())
				orders.add(new EmployeeEntry(rs));
			rs.close();
			pstmt.close();
		}
		return orders;
	}


  public static class EmployeeEntry{
	private int empId;
	private String empName;
	private double salary;
	private double commission;
	private int	deptNo;
	private int age;

	public int  getEmpId(){ return empId;}
	
	
	public String  getEmpName(){ return empName;}
	
	
	public double  getSalary(){ return salary;}
	
	
	public double  getCommission(){ return commission;}
	
	public int  getDeptNo(){ return deptNo;}
	
	public int  getAge(){ return age;}

	public EmployeeEntry(ResultSet rs) throws SQLException{	
		empId = rs.getInt("emp_id");
		empName = rs.getString("ename");
		salary = rs.getDouble("sal");
		commission = rs.getDouble("comm");
		deptNo = rs.getInt("dept_no");
		age = rs.getInt("age");
	}


  }
}
