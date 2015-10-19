package deema.set1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AccountIntegrationTests {

	private AccountService accountService;

	@Test
	public void accountServiceShouldBeInjected() {

		Assert.assertNotNull(accountService);
	}
}
