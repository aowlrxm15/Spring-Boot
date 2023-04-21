package kr.co.todo.dao;

import kr.co.todo.vo.TodoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AppDAO {
    public void insertTodo(TodoVO vo);
    public List<TodoVO> selectTodos();
    public TodoVO selectTodo(int no);
    public void deleteTodo(int no);
    public void deleteTodoAll();

}
