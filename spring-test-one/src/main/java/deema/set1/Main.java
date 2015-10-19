package deema.set1;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		Logger log = Logger.getLogger(Main.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaSpringConfiguration.class);

		AccountDao accountDao = context.getBean(AccountDao.class);
		Account account = accountDao.find(1);

		log.info("Account holder name: " + account.getOwnerName());

		context.close();
	}
}
