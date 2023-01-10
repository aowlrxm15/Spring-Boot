package kr.co.bookstore.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.bookstore.vo.BookVO;

@Repository
public class BookDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBook1(BookVO vo) {
		mybatis.insert("book.insertBook1", vo);
	}
	
	public BookVO selectBook1(int bookId) {
		return mybatis.selectOne("book.selectBook1", bookId);
	}
	
	public List<BookVO> selectBook1s() {
		return mybatis.selectList("book.selectBook1s");
	}
	
	public void updateBook1(BookVO vo) {
		mybatis.update("book.updateBook1", vo);
	}
	
	public void deleteBook1(int bookId) {
		mybatis.delete("book.deleteBook1", bookId);
	}
}
