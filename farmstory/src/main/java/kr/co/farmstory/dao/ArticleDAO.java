package kr.co.farmstory.dao;

import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ArticleDAO {
    public int insertFile(FileVO vo);
    public int insertArticle(ArticleVO vo);
    public ArticleVO selectArticle(int no);
    public FileVO selectFile(int fno);
    public int selectCountTotal();
    public List<ArticleVO> selectArticles(@Param("cate") String cate, @Param("start") int start);
    public int updateArticle(ArticleVO vo);
    public int updateDownload(int fno);
    public int deleteArticle(int no);
}
