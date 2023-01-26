package kr.co.farmstory.service;

import kr.co.farmstory.dao.ArticleDAO;
import kr.co.farmstory.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDAO dao;
    public int insertArticle(ArticleVO vo){
        return dao.insertArticle(vo);
    }
    public ArticleVO selectArticle(int no){
        return dao.selectArticle(no);
    }
    public List<ArticleVO> selectArticles(int start){
        return dao.selectArticles(start);
    }
    public int updateArticle(ArticleVO vo){
        return dao.updateArticle(vo);
    }
    public int deleteArticle(int no){
        return dao.deleteArticle(no);
    }

    // 페이지 시작값
    public int getLimitStart(int currentPage) {
        return (currentPage - 1) * 10;
    }
    // 현재 페이지
    public int getCurrentPage(String pg) {
        int currentPage = 1;

        if(pg != null) {
            currentPage = Integer.parseInt(pg);
        }
        return currentPage;
    }

    // 전체 게시물 갯수
    public long getTotalCount() {
        return dao.selectCountTotal();
    }

    // 마지막 페이지 번호
    public int getLastPageNum(long total) {
        int lastPage = 0;
        if(total % 10 == 0) {
            lastPage = (int) (total / 10);
        }else {
            lastPage = (int) (total / 10) + 1;
        }
        return lastPage;
    }

    // 페이지 시작번호
    public int getPageStartNum(long total, int start) {
        return (int) (total - start);
    }

    // 페이지 그룹
    public int[] getPageGroup(int currentPage, int lastPage) {
        int groupCurrent = (int) Math.ceil(currentPage / 10.0);
        int groupStart	 = (groupCurrent - 1) * 10 + 1;
        int groupEnd 	 = groupCurrent * 10;
        if(groupEnd > lastPage) {
            groupEnd = lastPage;
        }
        int[] groups = {groupStart, groupEnd};
        return groups;
    }
}
