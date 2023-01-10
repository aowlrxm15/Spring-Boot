package kr.co.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.bookstore.dao.BookDAO;
import kr.co.bookstore.vo.BookVO;

@Service
public class BookService {

	@Autowired
	private BookDAO dao;

	public void insertBook1(BookVO vo) {
		dao.insertBook1(vo);
	}
	
	public BookVO selectBook1(int bookId) {
		return dao.selectBook1(bookId);
	}
	
	public List<BookVO> selectBook1s() {
		return dao.selectBook1s();
	}
	
	public void updateBook1(BookVO vo) {
		dao.updateBook1(vo);
	}
	
	public void deleteBook1(int bookId) {
		dao.deleteBook1(bookId);
	}
}
