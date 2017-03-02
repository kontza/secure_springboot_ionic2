package org.kontza.secure_spa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kontza.secure_spa.Greeting;
import org.kontza.secure_spa.UiApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UiApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(UiApplicationTests.class);

    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

    @Test
    public void testGreeting() {
        final ResponseEntity<Greeting> entity;
        entity = restTemplate.withBasicAuth("user", "password").getForEntity("/greeting", Greeting.class);
        logger.info("Entity status code: {}", entity.getStatusCodeValue());
        assertEquals(entity.getStatusCode(), HttpStatus.OK);
    }
}
