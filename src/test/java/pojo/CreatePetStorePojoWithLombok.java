package pojo;

import java.util.List;

import org.junit.jupiter.api.Tags;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreatePetStorePojoWithLombok {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	private Category category;
	private List<String> photoUrls;
	private List<Tags> tags;
	private String status;

	public CreatePetStorePojoWithLombok(Integer id, String name, Category category, List<String> photoUrls,
			List<Tags> tags, String status) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Data
	@NoArgsConstructor
	@AllArgsConstructor

	public class Category {
		@JsonProperty("id")
		private Integer id;
		@JsonProperty("name")
		private String name;

		public Category(Integer id, String name) {
			this.id = id;
			this.name = name;
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@Data
		@NoArgsConstructor
		@AllArgsConstructor
		public class Tags {
			@JsonProperty("id")
			private Integer id;
			@JsonProperty("name")
			private String name;

			public Tags(Integer id, String name) {

				this.id = id;
				this.name = name;
			}

		}

	}

}
