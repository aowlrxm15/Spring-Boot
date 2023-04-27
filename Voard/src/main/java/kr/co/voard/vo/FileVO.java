package kr.co.voard.vo;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileVO {
	
	private int fno;
	private int parent;
	private String newName;
	private String oriName;
	private int download;
}
