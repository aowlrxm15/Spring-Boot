package kr.co.voard.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User1VO {

	private String uid;
	private String pass;
	private String name;
	private String nick;
	private String email;
	private String hp;
	private Integer grade;
	private String zip;
	private String addr1;
	private String addr2;
	private String regip;
	private String rdate;

}
