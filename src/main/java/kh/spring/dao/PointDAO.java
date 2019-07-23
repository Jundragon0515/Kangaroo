package kh.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PointDAO {
	@Autowired
	private SqlSessionTemplate sst;
	public int insert(String email , int money) {
		Map<String, String> map = new HashMap<>();
		map.put("id", email);
		map.put("money", Integer.toString(money));
		return sst.insert("PointDAO.insert", map);
	}
	
}
