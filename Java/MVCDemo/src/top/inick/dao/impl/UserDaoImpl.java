package top.inick.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import top.inick.dao.UserDao;
import top.inick.domain.User;
import top.inick.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	public boolean addUser(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO users(username, password, email,birthday) VALUES (?, ?, ?, ?)"; 
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBirthday());
			ps.setString(4, date);
			
			int i = ps.executeUpdate();
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加失败");
		} finally {
			DBUtils.closeAll(null, ps, conn);
		}
		return false;
		
	}

	@Override
	public User findUser(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users WHERE username=? and password=?";
		User u = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setBirthday(rs.getDate("birthday"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return u;
		
		
	}

}
