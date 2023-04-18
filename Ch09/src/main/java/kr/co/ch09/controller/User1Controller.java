package kr.co.ch09.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import kr.co.ch09.service.User1Service;
import kr.co.ch09.vo.User1VO;

@Controller
public class User1Controller {

	@Autowired
	private User1Service service;
	
	@ResponseBody
	@CrossOrigin(origins = "*") // 모든요청을 허용 개발단계에서 실험할때 사용
	@GetMapping("/user1")
	public List<User1VO> list1() {
		List<User1VO> users = service.selectUser1s();
		return users;
	}
	
	@ResponseBody
	@GetMapping("/user1/{id}")
	public User1VO list2(@PathVariable("id") String uid) {
		return service.selectUser1(uid);
	}
	
	@ResponseBody
	@PostMapping("/user1")
	public Map<String, Integer> register(User1VO vo) {
		int result = service.insertUser1(vo);
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	@ResponseBody
	@PutMapping("/user1")
	public Map<String, Integer> modify(User1VO vo) {
		int result =  service.updateUser1(vo);
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	@ResponseBody
	@DeleteMapping("/user1/{id}")
	public Map<String, Integer> delete(@PathVariable("id") String uid) {
		int result = service.deleteUser1(uid);
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}
	
}
