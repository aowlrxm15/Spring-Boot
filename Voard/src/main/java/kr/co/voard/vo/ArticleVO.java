package kr.co.voard.vo;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVO {

	private int no;
	private int parent;
	private int comment;
	private String cate;
	private String title;
	private String content;
	private int file;
	private MultipartFile fname;
	private int hit;
	private String uid;
	private String regip;
	private String rdate;
	
	// 추가 필드
	private String nick;
	private FileVO fileVO;
	
	
}
