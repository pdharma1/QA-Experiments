package utils;

import java.math.BigDecimal;

import net.authorize.Environment;
import net.authorize.Merchant;
import net.authorize.TransactionType;
import net.authorize.aim.Result;
import net.authorize.aim.Transaction;
import net.authorize.data.creditcard.CreditCard;

public class AIMCardProcessing {

	public static void main(String[] args) {
		try {
			/*
			 * Get these by opening an Authorize.NET sandbox account. This may change after converting into a production
			 * account.
			 */
			String apiLoginId = "3qNd536c7N5";
			String transactionKey = "4CPA24j3h94txn3L";

			/*
			 * Test credit card - 4111 1111 1111 1111 = valid card number
			 */
			CreditCard cc = CreditCard.createCreditCard();
			cc.setCreditCardNumber("4111 1111 1111 1111");
			cc.setExpirationMonth("09");
			cc.setExpirationYear("2015");
			cc.setCardCodeVerification("123");
			Double amount = 124.99;

			Merchant merchant = Merchant.createMerchant(Environment.SANDBOX, apiLoginId, transactionKey);

			Transaction transaction = merchant.createAIMTransaction(TransactionType.AUTH_CAPTURE, new BigDecimal(amount));
			transaction.setCreditCard(cc);
			Result<Transaction> results = (Result<Transaction>) merchant.postTransaction(transaction);

			if (results.isApproved()) {
				System.out.println("Is Approved: " + results.isApproved());
				System.out.println("Response code: " + results.getResponseCode().getCode());
				System.out.println("Transaction id: " + results.getTarget().getTransactionId());
			} else if (results.isDeclined()) {
				System.out.println("Is Declined: " + results.isDeclined());
				System.out.println("Response code: " + results.getResponseCode().getCode());
				System.out.println("Transaction id: " + results.getTarget().getTransactionId());
			} else if (results.isError()) {
				System.out.println("Is Errored: " + results.isError());
				System.out.println("Response code: " + results.getResponseCode().getCode());
				System.out.println("Transaction id: " + results.getTarget().getTransactionId());
			} else if (results.isReview()) {
				System.out.println("Is Review: " + results.isReview());
				System.out.println("Response code: " + results.getResponseCode().getCode());
				System.out.println("Transaction id: " + results.getTarget().getTransactionId());
			} else {
				System.out.println("Result is NOT - " + results.isApproved() + " - NOR - " + results.isDeclined() + " - or - " + results.isError());
			}

			System.out.println("Results response text: " + results.getResponseText());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
