package kr.co.farmstory.controller;

import kr.co.farmstory.entity.UserEntity;
import kr.co.farmstory.security.MyUserDetails;
import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IAttribute;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private ArticleService service;
    @GetMapping("board/list")
    public String list(Model model, String group, String cate, @AuthenticationPrincipal MyUserDetails myUser, String pg){
        //UserEntity user = myUser.getUser();
        int currentPage = service.getCurrentPage(pg);
        int start 		= service.getLimitStart(currentPage);
        long total 		= service.getTotalCount();
        int lastPage 	= service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPage);

        List<ArticleVO> articles = service.selectArticles(start);

        //model.addAttribute("user", user);
        model.addAttribute("articles", articles);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("pageStartNum", pageStartNum);
        model.addAttribute("groups", groups);

        return "board/list";
    }
    @GetMapping("board/modify")
    public String modify(){
        return "board/modify";
    }
    @GetMapping("board/view")
    public String view(){
        return "board/view";
    }
    @GetMapping("board/write")
    public String write(){
        return "board/write";
    }
}
