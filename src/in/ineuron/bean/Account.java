package in.ineuron.bean;

public class Account {
	private Integer accNo;
	private String accBranch;
	private String accType;

	public Integer getAccNo() {
		return accNo;
	}

	public String getAccBranch() {
		return accBranch;
	}

	public String getAccType() {
		return accType;
	}

	public Account(Integer accNo, String accBranch, String accType) {
		this.accNo = accNo;
		this.accBranch = accBranch;
		this.accType = accType;
	}

}
