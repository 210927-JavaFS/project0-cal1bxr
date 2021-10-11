package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			List<User> list = new ArrayList<>();

			while (result.next()) {
				User user = new User(result.getString("first_name"), result.getString("last_name"),
						result.getString("user_name"), result.getString("user_password"), result.getString("roles"),
						result.getBoolean("acccount_active"));
				list.add(user);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findUser(String username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * From users WHERE user_name = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			User user = new User();
			
			if(result.next()) {
				user.setFirstName(result.getString("first_name"));
				user.setLastName(result.getString("last_name"));
				user.setUsername(result.getString("user_name"));
				user.setPassword(result.getString("user_password"));
				user.setRole(result.getString("roles"));
				user.setAccountActive(result.getBoolean("account_active"));
			}
			
			return user;			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO users (first_name, last_name, user_name, user_password, user_role, account_active) "
					+ "VALUES (?,?,?,?,?,?);";
			int count = 0;
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(++count, user.getFirstName());
			statement.setString(++count, user.getLastName());
			statement.setString(++count, user.getUsername());
			statement.setString(++count, user.getPassword());
			statement.setString(++count, user.getRole());
			statement.setBoolean(++count, user.isAccountActive());
			
			statement.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
