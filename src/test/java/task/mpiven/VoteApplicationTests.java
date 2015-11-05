package task.mpiven;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import task.mpiven.votesystem.VoteApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VoteApplication.class)
@WebAppConfiguration
public class VoteApplicationTests {

	@Test
	public void contextLoads() {
	}

}
