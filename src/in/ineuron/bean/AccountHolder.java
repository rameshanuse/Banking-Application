package in.ineuron.bean;

public class AccountHolder {
	private String name;
	private Long mobileNumber;
	private String userId;
	private String password;
	private Account account;
	private Float balance;
	
	public AccountHolder(String name, Long mobileNumber, String userId, String password, Account account,
			Float balance) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.userId = userId;
		this.password = password;
		this.account = account;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	
	

}
