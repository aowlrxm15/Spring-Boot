package kr.co.bookstore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.bookstore.service.BookService;
import kr.co.bookstore.vo.BookVO;
@Controller
public class BookController {
	@Autowired
	private BookService service;
	@GetMapping("/book/list")
	public String list(Model model) {
		List<BookVO> books = service.selectBook1s();
		model.addAttribute("books", books);
		return "/book/list";
	}
	@GetMapping("/book/register")
	public String register() {
		return "/book/register";
	}
	@PostMapping("/book/register")
	public String register(BookVO vo) {
		service.insertBook1(vo);
		return "redirect:/book/list";
	}
	@GetMapping("/book/modify")
	public String modify(int bookId, Model model) {
		BookVO book = service.selectBook1(bookId);
		model.addAttribute("book", book);
		return "/book/modify";
	}
	@PostMapping("/book/modify")
	public String modify(BookVO vo) {
		service.updateBook1(vo);
		return "redirect:/book/list";
	}
	@GetMapping("/book/delete")
	public String delete(int bookId) {
		service.deleteBook1(bookId);
		return "redirect:/book/list";
	}
}
