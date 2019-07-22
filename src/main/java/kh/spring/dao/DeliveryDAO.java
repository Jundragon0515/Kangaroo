package kh.spring.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.DeliveryDTO;

@Component
public class DeliveryDAO {
	@Autowired
	private SqlSessionTemplate sst;
	public int deli_insert(DeliveryDTO dto) { // 회원가입 
        return sst.insert("DeliveryDAO.deli_insert",dto);
     }
}
