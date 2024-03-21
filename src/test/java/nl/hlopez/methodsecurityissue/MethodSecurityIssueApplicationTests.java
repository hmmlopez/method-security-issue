package nl.hlopez.methodsecurityissue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;

@SpringBootTest
@MockBean(classes = {JwtDecoder.class})
class MethodSecurityIssueApplicationTests {

    @Test
    void contextLoads() {
    }

}
