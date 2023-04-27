package kr.co.voard.controller;

import kr.co.voard.entity.UserEntity;
import kr.co.voard.service.ArticleService;
import kr.co.voard.vo.ArticleVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RestController
public class ArticleController {
    @Autowired
    private ArticleService service;
    @PostMapping("/write")
    public void write(HttpServletRequest req,@RequestBody ArticleVO vo){

        service.insertArticle(req, vo);
    }
    @GetMapping("/list")
    public Map<String, Object> list(String pg) {

        int currentPage = service.getCurrentPage(pg);
        int start 		= service.getLimitStart(currentPage);
        long total 		= service.getTotalCount();
        int lastPage 	= service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPage);

        List<ArticleVO> articles = service.selectArticles(start, "free");

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("articles", articles);
        resultMap.put("currentPage", currentPage);
        resultMap.put("lastPage", lastPage);
        resultMap.put("pageStartNum", pageStartNum);
        resultMap.put("groups", groups);
        return resultMap;
    }

}
