package top.inick.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import top.inick.dao.UserDao;
import top.inick.domain.User;
import top.inick.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	public void addUser(User user) throws Exception {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加失败");
		} finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
	}

}
