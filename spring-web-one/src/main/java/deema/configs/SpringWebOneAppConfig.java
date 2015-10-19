package deema.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = { "deema.controller" })
public class SpringWebOneAppConfig {

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view");
		resolver.setSuffix(".jsp");

		return resolver;
	}
}
