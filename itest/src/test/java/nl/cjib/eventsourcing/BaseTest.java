package nl.cjib.eventsourcing;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {EventsourcingApplication.class} )
public abstract class BaseTest {

    @LocalServerPort
    protected String port;
    protected TestRestTemplate testRestTemplate;

    @BeforeEach
    void setUp() {
        testRestTemplate = new TestRestTemplate();
    }
}

