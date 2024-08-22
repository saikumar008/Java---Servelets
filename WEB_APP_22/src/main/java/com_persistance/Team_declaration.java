package com_persistance;

import java.sql.SQLException;
import java.util.List;

import com_entity.Team;

public interface Team_declaration
{

public List<Team> displayAll() throws ClassNotFoundException, SQLException; //display

public int insert(Team team) throws ClassNotFoundException, SQLException;  //insert

public int Updation(Team team) throws ClassNotFoundException, SQLException;  //update 

public int delete(int teamid) throws ClassNotFoundException, SQLException; // delete

public Team getTeamById(int teamid) throws ClassNotFoundException, SQLException;  //get the team details based on id

}