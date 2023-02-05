package kr.co.farmstory.controller;

import kr.co.farmstory.entity.UserEntity;
import kr.co.farmstory.security.MyUserDetails;
import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IAttribute;

import java.io.IOException;
import java.util.List;
@Slf4j
@Controller
public class BoardController {

    @Autowired
    private ArticleService service;
    @GetMapping("board/list")
    public String list(Model model, String group, String cate, @AuthenticationPrincipal MyUserDetails myUser, String pg){
        //UserEntity user = myUser.getUser();
        int currentPage = service.getCurrentPage(pg);
        int start 		= service.getLimitStart(currentPage);
        long total 		= service.getTotalCount(cate);
        int lastPage 	= service.getLastPageNum(total);
        int pageStartNum = service.getPageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPage);

        List<ArticleVO> articles = service.selectArticles(start, cate);

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
    public String modify(int no, Model model, String group, String cate){

        ArticleVO article = service.selectArticle(no);

        model.addAttribute("article", article);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/modify";
    }

    @PostMapping("board/modify")
    public String modify(ArticleVO vo,Model model){

        service.updateArticle(vo);

        return "redirect:/board/view?group="+vo.getGroup()+"&cate="+vo.getCate()+"&no="+vo.getNo();
    }
    @GetMapping("board/view")
    public String view(int no, Model model, String group, String cate){
        ArticleVO article = service.selectArticle(no);
        model.addAttribute("article", article);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/view";
    }
    @GetMapping("board/write")
    public String write(String cate, String group,Model model){
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/write";
    }
    @PostMapping("board/write")
    public String write(ArticleVO vo, @RequestParam("cate") String cate, @RequestParam("group") String group){
        log.info("vo" + vo);
        service.insertArticle(vo);
        return "redirect:/board/list?group="+group+"&cate="+cate;
    }
    @GetMapping("board/delete")
    public String delete(int no, String group, String cate){

        service.deleteArticle(no);

        return "redirect:/board/list?group="+group+"&cate="+cate;
    }
    @GetMapping("download")
    public ResponseEntity<Resource> download(int fno) throws IOException {

        FileVO vo = service.selectFile(fno);
        ResponseEntity<Resource> respEntity = service.fileDownload(vo);
        return respEntity;

    }
}
