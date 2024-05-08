package pojo;

import java.util.List;

public class CreateNewUserPojo2 {
	
	private Integer id;	
	private Category category;
	private String name;
	private List<Tags> tags;
	private String status;
	private List<String> photoUrls;
	
	public CreateNewUserPojo2(Integer id, Category category, String name, List<Tags> tags, String status,List<String> photoUrls) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.tags = tags;
		this.status = status;
		this.photoUrls = photoUrls;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public class Category{
		
		private Integer id;
		private String name;
		
		public Category(Integer id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public class Tags{
		private Integer id;
		private String name;
		
		public Tags(Integer id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
	
	
	
}
	
	

