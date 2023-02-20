package kr.co.todo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoVO {
    private int todoNum;
    private String todoContent;
    private String todoRdate;
    private int todoStatus;
}
