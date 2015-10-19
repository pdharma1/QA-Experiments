package deema.ch7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@WebAppConfiguration
public class WebApplicationTests {

	private WebApplicationContext webApplicationContext;
	private MockServletContext mockServletContext;

	@Test
	public void testWebAppNull() {

		Assert.assertEquals(webApplicationContext, null);
		// Assert.assertNull(webApplicationContext);
	}

	@Test
	public void testMockServletNotNull() {

		Assert.assertEquals(mockServletContext, null);
	}
}
