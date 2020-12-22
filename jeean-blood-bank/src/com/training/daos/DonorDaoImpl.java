package com.training.daos;

import java.util.ArrayList;

import java.util.List;
import java.sql.*;
import java.time.LocalDate;

import com.training.entity.BloodDonor;
import com.training.ifaces.DataAccess;
import com.training.utils.DbConnectionUtil;

public class DonorDaoImpl implements DataAccess<BloodDonor> {
	
	private Connection con;
    private static final String ADDSQL="insert into donor values(?,?,?,?,?,?,?)";
	public DonorDaoImpl(Connection con) {
		super();
		this.con = con;
	}

	public DonorDaoImpl() {
		super();
		con=DbConnectionUtil.getMySqlConnection();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(BloodDonor t) {
		
		String sql= "insert into donor values (?,?,?,?,?,?,?)";
		int rowsAdded=0;
		try(PreparedStatement pstmt= con.prepareStatement(sql)) {
			
			pstmt.setString(1, t.getName());			
			pstmt.setInt(2,t.getAge());
			pstmt.setString(3, t.getGender());
			pstmt.setString(4, t.getBloodGroup());	
			pstmt.setInt(5,t.getPhoneNumber());
			pstmt.setString(6, t.getEmail());					
			pstmt.setDate(7, Date.valueOf(t.getDateOfBirth()));
			
			rowsAdded = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAdded;
	}

	@Override
	public List<BloodDonor> findAll() {
		String sql= "select * from donor";
		
		List<BloodDonor> donorList = new ArrayList<BloodDonor>();
		
		try(PreparedStatement pstmt= con.prepareStatement(sql)) {
			
			ResultSet rs= pstmt.executeQuery();
			
			//ResultSetMetaData rsmeta=rs.getMetaData();
			
			//System.out.println("NO. of Columns" +rsmeta.getColumnCount());
			//System.out.println("Table name of Column 1 "+rsmeta.getTableName(1));
			
			
			while(rs.next()) {
			
				 
				  String name=rs.getString("name");
				  int age=rs.getInt("age");
				  String gender=rs.getString("gender");
			      String bloodGroup=rs.getString("bloodGroup");
				  int phoneNumber=rs.getInt("mobileNumber");
				  String email=rs.getString("email");
				  LocalDate dateOfBirth=rs.getDate("dateOfBirth").toLocalDate();
				 
				 BloodDonor donor = new BloodDonor(name,age,gender,bloodGroup,phoneNumber,email,dateOfBirth);
				 donorList.add(donor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(donorList);
		return donorList;
	}




}
