package deema.set1;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class AccountDaoInMemoryImpl implements AccountDao {

	private Logger log = Logger.getLogger(AccountDaoInMemoryImpl.class);

	private Map<Long, Account> accountMap = new HashMap<Long, Account>();

	public void setAccountMap(Map<Long, Account> accountMap) {

		this.accountMap = accountMap;
	}

	{
		log.info("Initiating in-memory Account objects now..");

		Account account1 = new Account();
		account1.setId(1L);
		account1.setLocked(false);
		account1.setAccessTime(Calendar.getInstance().getTime());
		account1.setOwnerName("John Smith");
		account1.setBalance(250.00);
		this.accountMap.put(1L, account1);

		Account account2 = new Account();
		account2.setId(1L);
		account2.setLocked(true);
		account2.setAccessTime(Calendar.getInstance().getTime());
		account2.setOwnerName("Amanda Last");
		account2.setBalance(350.00);
		this.accountMap.put(2L, account2);

		Account account3 = new Account();
		account3.setId(1L);
		account3.setLocked(true);
		account3.setAccessTime(Calendar.getInstance().getTime());
		account3.setOwnerName("Aaron Smith");
		account3.setBalance(450.00);
		this.accountMap.put(3L, account3);
	}

	@Override
	public void insert(Account account) {

		log.info("** Performing Account insert **");
		this.accountMap.put(account.getId(), account);
	}

	@Override
	public void update(Account account) {

		log.info("** Performing Account update **");
		this.accountMap.put(account.getId(), account);
	}

	@Override
	public void update(List<Account> accounts) {

		log.info("** Performing Account(s) updates **");
		for (Account account : accounts) {
			this.accountMap.put(account.getId(), account);
		}
	}

	@Override
	public void delete(long accountId) {

		log.info("** Performing Account delete **");
		this.accountMap.remove(accountId);
	}

	@Override
	public Account find(long accountId) {

		log.info("** Performing Account find **");
		return this.accountMap.get(accountId);
	}

	@Override
	public List<Account> find(List<Long> accountIds) {

		log.info("** Performing Accounts finds **");
		List<Account> accounts = null;
		for (long accountId : accountIds) {
			accounts.add(this.accountMap.get(accountId));
		}

		return accounts;
	}

	@Override
	public List<Account> find(String ownerName) {

		log.info("** Performing Account find **");
		List<Account> accounts = null;
		Collection accountValues = this.accountMap.values();
		Iterator iterator = accountValues.iterator();
		while (iterator.hasNext()) {
			Account account = (Account) iterator.next();
			if (account.getOwnerName().contains(ownerName)) {
				accounts.add(account);
			}
		}

		return accounts;
	}

	@Override
	public List<Account> find(boolean locked) {

		log.info("** Performing locked Account find **");
		List<Account> accounts = null;
		Collection accountValues = this.accountMap.values();
		Iterator iterator = accountValues.iterator();
		while (iterator.hasNext()) {
			Account account = (Account) iterator.next();
			if (locked = account.isLocked()) {
				accounts.add(account);
			}
		}

		return accounts;
	}

}
