
public class CompanyInformation {
	
	private String name;
	private String since;
	private String ownerName;
	private int totleEmployee;
	
	private CompanyInformation() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSince() {
		return since;
	}
	public void setSince(String since) {
		this.since = since;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getTotleEmployee() {
		return totleEmployee;
	}
	public void setTotleEmployee(int totleEmployee) {
		this.totleEmployee = totleEmployee;
	}
	
	
	private static CompanyInformation com;
	
	public static synchronized CompanyInformation getInstance() {
		
		if(com == null) {
			synchronized (CompanyInformation.class) {
				com = new CompanyInformation();
			}
		}		
		return com;	
	}

	@Override
	public String toString() {
		return "CompanyInformation [name=" + name + ", since=" + since + ", ownerName=" + ownerName + ", totleEmployee="
				+ totleEmployee + "]";
	}
	
	
	

}
