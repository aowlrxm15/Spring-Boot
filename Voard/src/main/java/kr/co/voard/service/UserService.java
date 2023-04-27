package kr.co.voard.service;

import java.util.List;

import kr.co.voard.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.voard.dao.UserDAO;
import kr.co.voard.vo.TermsVO;
import kr.co.voard.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UserRepo repo;

	
	public void insertUser(UserVO vo) {
		String passEncoded = encoder.encode(vo.getPass1());
		vo.setPass(passEncoded);
		dao.insertUser(vo);
	}

	public int countByUid(String uid){
		return repo.countByUid(uid);
	}
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
	public UserVO selectUser(String uid) {
		return dao.selectUser(uid);
	}
	public List<UserVO> selectUsers() {
		return dao.selectUsers();
	}
	public void updateUser(UserVO vo) {
		dao.updateUser(vo);
	}
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}
}
