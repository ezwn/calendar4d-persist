package ezwn.calendar4d.persist;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ezwn.persist.service.info.ServiceInfoController;

@SpringBootTest
public class ApplicationTest {

	@Autowired
	private ServiceInfoController controller;
	
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
}
