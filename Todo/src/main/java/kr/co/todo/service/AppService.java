package kr.co.todo.service;

import kr.co.todo.dao.AppDAO;
import kr.co.todo.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private AppDAO dao;
    public void insertTodo(TodoVO vo){
        dao.insertTodo(vo);
    }
    public List<TodoVO> selectTodos(){
        return dao.selectTodos();
    }
    public TodoVO selectTodo(int no){
        return dao.selectTodo(no);
    }
    public void deleteTodo(int no){
        dao.deleteTodo(no);
    }
    public void deleteTodoAll(){
        dao.deleteTodoAll();
    }
}
