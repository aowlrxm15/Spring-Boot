package kr.co.ch07.vo;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "user3")
public class User3VO {
	// 오토인크리먼트일때 해주면됨 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String uid;
	private String name;
	private String hp;
	private int age;

}
