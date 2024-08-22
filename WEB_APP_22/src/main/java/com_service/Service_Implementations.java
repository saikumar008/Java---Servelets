package com_service;

import java.sql.SQLException;
import java.util.List;

import com_entity.Team;
import com_persistance.Team_Implementation;


public class Service_Implementations
{
	public List<Team> fetchAll() throws ClassNotFoundException, SQLException
	{
		return new Team_Implementation().displayAll();
	}

	public int insertion(Team team) throws ClassNotFoundException, SQLException
	{
		return new Team_Implementation().insert(team);
		
	}

	public int Update(Team team) throws ClassNotFoundException, SQLException
	{
		return new Team_Implementation().Updation(team);
		
	}

	public int deletion(int teamid) throws ClassNotFoundException, SQLException {
		return new Team_Implementation().delete(teamid);
	}
	public Team getTeamById(int teamid) throws ClassNotFoundException, SQLException
	{
		return new Team_Implementation().getTeamById(teamid);
	}
	
}
