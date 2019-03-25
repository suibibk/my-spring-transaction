package cn.myforever.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void add(String name,String age) {
		String sql = "INSERT INTO user(username, age) VALUES(?,?);";
		int updateResult = jdbcTemplate.update(sql, name, age);
		System.out.println("updateResult:" + updateResult);
	}
}
