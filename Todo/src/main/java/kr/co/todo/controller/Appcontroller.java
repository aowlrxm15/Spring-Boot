package kr.co.todo.controller;

import kr.co.todo.service.AppService;
import kr.co.todo.vo.TodoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Slf4j
public class Appcontroller {
    @Autowired
    private AppService svc;

    @GetMapping("/app/todos")
    public List<TodoVO> todos() {
        return svc.selectTodos();
    }

    @PostMapping("/app/todo")
    public void todo(@RequestBody TodoVO vo) {
        log.info("content : " + vo.getTodoContent());
        svc.insertTodo(vo);
    }

    @DeleteMapping("/app/clear")
    public void clear() {
        svc.deleteTodoAll();
    }
}
