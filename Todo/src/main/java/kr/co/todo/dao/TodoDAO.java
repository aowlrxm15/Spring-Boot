package kr.co.todo.dao;

import kr.co.todo.vo.TodoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TodoDAO {
    public int insertTodoList(TodoVO vo);
    public List<TodoVO> selectTodoList();
    public int updateTodoList(Map<String, String> data);
    public int deleteTodoList(TodoVO vo);
}
