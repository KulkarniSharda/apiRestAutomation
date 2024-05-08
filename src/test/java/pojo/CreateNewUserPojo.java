package pojo;

public class CreateNewUserPojo {
	
	private String name;	
	private String gender;
	private String email;
	private String status;
	
	private Integer id;
	
	

	public CreateNewUserPojo() {
		// TODO Auto-generated constructor stub
	}
	
	public CreateNewUserPojo(String name, String gender, String email, String status) {
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.status = status;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;//Amit
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
	
	

