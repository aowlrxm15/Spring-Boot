package kr.co.ch06.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch06.vo.UserVO;


@Controller
public class MainController {

	@GetMapping(value = {"/", "index"})
	public String index(Model model) {
		
		String tit1 = "스프링부트!";
		String tit2 = "타임리프!";
		
		UserVO user1 = new UserVO();
		user1.setUid("a101");
		user1.setName("홍길동");
		user1.setHp("010-1234-1002");
		user1.setAge(23);
		
		UserVO user2 = null;
		
		List<UserVO> users = new ArrayList<>();
		users.add(new UserVO("a101", "홍길동", "010-1234-1002", 23));
		users.add(new UserVO("a101", "김춘추", "010-1234-1003", 24));
		users.add(new UserVO("a101", "장보고", "010-1234-1004", 25));
		users.add(new UserVO("a101", "강감찬", "010-1234-1005", 26));
		users.add(new UserVO("a101", "이순신", "010-1234-1006", 27));
		
		model.addAttribute("tit1", tit1);
		model.addAttribute("tit2", tit2);
		model.addAttribute("user1", user1);
		model.addAttribute("user2", user2);
		
		
		return "/index";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "/hello";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "/welcome";
	}
	
	@GetMapping("/greeting")
	public String greeting() {
		return "/greeting";
	}
	
	
	
	
	
}
