
package com.globeshanghai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.globeshanghai.PhotoappBackendApplicationTests.class)
@ComponentScan("com.globeshanghai")
public class PhotoappBackendApplicationTests {

	@Test
	public void contextLoads() {
	}

}

