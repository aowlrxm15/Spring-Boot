package kr.co.farmstory.service;

import kr.co.farmstory.dao.UserDAO;
import kr.co.farmstory.repo.UserRepo;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO dao;
    @Autowired
    private UserRepo repo;
    @Autowired
    private PasswordEncoder encoder;

    public int insertUser(UserVO vo){
        vo.setPass(encoder.encode(vo.getPass1()));
        return dao.insertUser(vo);
    }
    public UserVO selectUser(String uid){
        return dao.selectUser(uid);
    }
    public List<UserVO> selectUsers(){
        return dao.selectUsers();
    }
    public int updateUser(UserVO vo){
        return dao.updateUser(vo);
    }
    public int deleteUser(String uid){
        return dao.deleteUser(uid);
    }
    public TermsVO selectTerms(){
        return dao.selectTerms();
    }
    public int countByuid(String uid){
        return repo.countByUid(uid);
    }
    public int countBynick(String nick){
        return repo.countByNick(nick);
    }
}
