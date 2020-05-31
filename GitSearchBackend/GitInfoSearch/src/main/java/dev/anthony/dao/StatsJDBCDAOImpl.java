package dev.anthony.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dev.anthony.entities.ProjStats;
import dev.anthony.util.ConnectionUtil;

public class StatsJDBCDAOImpl implements StatsDAO {

	// Used to save the object in the DataBase
	@Override
	public ProjStats createProjSts(ProjStats pro) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "INSERT INTO Stat VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setInt(2, pro.getRepoId());
			ps.setString(3, pro.getName());
			ps.setString(4, pro.getUrl());
			ps.setString(5, pro.getCreatedDate());
			ps.setString(6, pro.getLastPushDate());
			ps.setString(7, pro.getDescription());
			ps.setInt(8, pro.getNumOfStars());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}
}
