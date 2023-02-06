package map.busan.animal.hospital.vo;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultVO{
	private GetTblAnimalHospital getTblAnimalHospital;

	@Getter
	@Setter
	public class GetTblAnimalHospital {
		private Header header;
		private Body body;
		
		@Getter
		@Setter
		public class Header{
			private String resultMsg;
			private String resultCode;
		}
		
		@Getter
		@Setter
		public class Body {
			private items items;
			private int numOfRows;
			private int pageNo;
			private int totalCount;
			
			@Getter
			@Setter
			public class items {
				private List<ItemVO> item;
			}
		}
	}
}