package com.vijay.web.dao;

import java.sql.*;

import com.vijay.web.model.Alien;

public class AlienDao {
	String url = "jdbc:mysql://localhost:3306/student";
	String user = "root";
	String pass = "root";

	public Alien getAlien(int aid) {

		Alien a = new Alien();

		/*
		 * a.setAid(101); a.setAname("Vijay"); a.setTech("java");
		 */

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select *  from Aliens where aid=" + aid);

			if (rs.next()) {
				a.setAid(rs.getInt("aid"));
				a.setAname(rs.getString("aname"));
				a.setTech(rs.getString("tech"));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return a;
	}

}
