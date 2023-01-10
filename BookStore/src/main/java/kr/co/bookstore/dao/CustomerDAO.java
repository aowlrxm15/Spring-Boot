package kr.co.bookstore.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bookstore.vo.CustomerVO;

@Repository
public class CustomerDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertCustomer1(CustomerVO vo) {
		mybatis.insert("customer.insertCustomer1", vo);
	}
	
	public CustomerVO selectCustomer1(int custId) {
		return mybatis.selectOne("customer.selectCustomer1", custId);
	}
	
	public List<CustomerVO> selectCustomer1s() {
		return mybatis.selectList("customer.selectCustomer1s");
	}
	
	public void updateCustomer1(CustomerVO vo) {
		mybatis.update("customer.updateCustomer1", vo);
	}
	
	public void deleteCustomer1(int custId) {
		mybatis.delete("customer.deleteCustomer1", custId);
	}
}
