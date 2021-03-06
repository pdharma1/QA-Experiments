package deema.set1;

public interface AccountService {

	public void transferMoney(long sourceAccountId, long targetAccountId, double amount);

	public void depositMoney(long accountId, double amount);

	public Account getAccount(long accountId);
}
