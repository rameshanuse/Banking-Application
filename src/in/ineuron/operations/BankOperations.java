package in.ineuron.operations;

import java.util.List;

import in.ineuron.bean.AccountHolder;

public class BankOperations {
	public Float chechBalance(Integer accNo) {
		AccountHolder ah = getAccount(accNo);
		if(ah != null) {
			return ah.getBalance();
		}
		return -1.0f; 
	}
	
	public Float deposit(Integer accNo, Float amount) {
		AccountHolder ah = getAccount(accNo);
		if(ah != null) {
			Float balance = ah.getBalance();
			balance = balance + amount;
			ah.setBalance(balance);
			return ah.getBalance(); 
		}
		return -1.0f; 
	}
	
	public Float withdraw(Integer accNo, Float amount) {
		AccountHolder ah = getAccount(accNo);
		if(ah != null) {
			Float balance = ah.getBalance();
			if(balance >= amount) {
				balance = balance - amount;
				ah.setBalance(balance);
				return ah.getBalance(); 
			} else {
				return -2.0f;
			}
		}
		return -1.0f; 
	}
	
	public AccountHolder getAccount(Integer accNo) {
		List<AccountHolder> list = AccountOperation.list;
		
		for(AccountHolder ah : list) {
			if(ah.getAccount().getAccNo().equals(accNo)) {
				return ah;
			}
		}
		return null;
		
	}
}
