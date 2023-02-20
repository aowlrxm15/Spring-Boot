package kr.co.todo.service;

import kr.co.todo.dao.TodoDAO;
import kr.co.todo.vo.TodoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoDAO dao;
    public int insertTodoList(TodoVO vo) {
        return dao.insertTodoList(vo);
    }
    public Map<Integer, List<TodoVO>> selectTodoList() {
        List<TodoVO> list = dao.selectTodoList();
        return list.stream().collect(Collectors.groupingBy(TodoVO::getTodoStatus));
    }
    public int updateTodoList(Map<String, String> data) {
        return dao.updateTodoList(data);

    }
    public int deleteTodoList(TodoVO vo) {
        return dao.deleteTodoList(vo);
    }

}
