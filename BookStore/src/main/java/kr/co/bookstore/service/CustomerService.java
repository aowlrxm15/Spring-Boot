package kr.co.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bookstore.dao.CustomerDAO;
import kr.co.bookstore.vo.CustomerVO;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO dao;

	public void insertCustomer1(CustomerVO vo) {
		dao.insertCustomer1(vo);
	}
	
	public CustomerVO selectCustomer1(int custId) {
		return dao.selectCustomer1(custId);
	}
	
	public List<CustomerVO> selectCustomer1s() {
		return dao.selectCustomer1s();
	}
	
	public void updateCustomer1(CustomerVO vo) {
		dao.updateCustomer1(vo);
	}
	
	public void deleteCustomer1(int custId) {
		dao.deleteCustomer1(custId);
	}
}
