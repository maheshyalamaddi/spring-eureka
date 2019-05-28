package org.sample.springeureka.poc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoginServiceApplicationTests.class)
public class LoginServiceApplicationTests {

	@Test
	public void whenSpringContextIsBootstrapped_thenNoExceptions() {
	}

}
