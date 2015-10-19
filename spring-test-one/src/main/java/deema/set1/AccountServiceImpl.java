package deema.set1;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {

		this.accountDao = accountDao;
	}

	@Override
	public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {

		Account sourceAccount = accountDao.find(sourceAccountId);
		Account targetAccount = accountDao.find(targetAccountId);

		sourceAccount.setBalance(sourceAccount.getBalance() - amount);
		targetAccount.setBalance(targetAccount.getBalance() + amount);

		accountDao.update(sourceAccount);
		accountDao.update(targetAccount);
	}

	@Override
	public void depositMoney(long accountId, double amount) {

		Account sourceAccount = accountDao.find(accountId);
		sourceAccount.setBalance(sourceAccount.getBalance() + amount);
		accountDao.update(sourceAccount);
	}

	@Override
	public Account getAccount(long accountId) {

		return null;
	}

}
