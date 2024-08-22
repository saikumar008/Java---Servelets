package com_persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com_entity.Team;

public class Team_Implementation implements Team_declaration
{

	@Override
	public List<Team> displayAll() throws ClassNotFoundException, SQLException 
	{
	ArrayList<Team> teamList=new ArrayList<Team>();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunnysai","root","root");
	PreparedStatement ps=con.prepareStatement("select * from ipl2023");
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		Team t=new Team();
		t.setTeamid(rs.getInt(1));
		t.setName(rs.getString(2));
		t.setCity(rs.getString(3));
		t.setState(rs.getString(4));
		teamList.add(t);
	}
		return teamList;
	}

	@Override
	public int insert(Team team) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunnysai","root","root");
		PreparedStatement ps=con.prepareStatement("insert into ipl2023(Name,City,state) values(?,?,?)");
		ps.setString(1,team.getName());
		ps.setString(2,team.getCity());
		ps.setString(3,team.getState());
		int r=ps.executeUpdate();
		return r;
	}

	@Override
	public int Updation(Team team) throws ClassNotFoundException, SQLException {
		
		int r =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunnysai","root","root");
		PreparedStatement ps=con.prepareStatement("update ipl2023 set Name=?,City=?,State=? where Teamid=?");
		ps.setString(1,team.getName());
		ps.setString(2,team.getCity());
		ps.setString(3,team.getState());
		ps.setInt(4, team.getTeamid());
		r=ps.executeUpdate();
		return r;
	}

	@Override
	public int delete(int teamid) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunnysai","root","root");
		PreparedStatement ps=con.prepareStatement("delete from ipl2023 where teamid=?");
		ps.setInt(1,teamid);
		int r=ps.executeUpdate();
		return r;
	}

	@Override
	public Team getTeamById(int teamid) throws ClassNotFoundException, SQLException {
		Team team=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sunnysai","root","root");
		PreparedStatement ps=con.prepareStatement("select * from ipl2023 where teamid=?");
		ps.setInt(1,teamid);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			team=new Team();
			team.setTeamid(rs.getInt(1));
			team.setName(rs.getString(2));
			team.setCity(rs.getString(3));
			team.setState(rs.getString(4));
		}
		return team;
	}

}