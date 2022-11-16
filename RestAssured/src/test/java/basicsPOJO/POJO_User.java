package basicsPOJO;

import java.util.List;

public class POJO_User {
	
	private String name;
	private String job;
	private POJO_UserCompany company;
	List<POJO_UserContact> contact;
	

	//Fazer um GET e um SET pra cada variavel
	//GET pegar o valor da variavel
	//SET mudar o valor da variavel
	
	public List<POJO_UserContact> getContact() {
		return contact;
	}
	public void setContact(List<POJO_UserContact> contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public POJO_UserCompany getCompany() {
		return company;
	}
	public void setCompany(POJO_UserCompany company) {
		this.company = company;
	}

	
}
