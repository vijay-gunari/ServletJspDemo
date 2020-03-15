package com.vijay.web.dao;

import java.sql.*;

import com.vijay.web.model.Alien;

public class AlienDao {
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "vijay";
	String pass = "vijay";

	public Alien getAlien(int aid) {

		Alien a = new Alien();

		/*
		 * a.setAid(101); a.setAname("Vijay"); a.setTech("java");
		 */

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select *  from vijay.Alien where aid=" + aid);

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
