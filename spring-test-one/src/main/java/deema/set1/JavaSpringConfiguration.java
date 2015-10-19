package deema.set1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaSpringConfiguration {

	@Bean
	public AccountService accountService() {

		AccountServiceImpl bean = new AccountServiceImpl();
		bean.setAccountDao(accountDao());

		return bean;
	}

	@Bean
	public AccountDao accountDao() {

		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		return bean;
	}
}
