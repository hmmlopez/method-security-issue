package nl.hlopez.methodsecurityissue.controller;

import nl.hlopez.methodsecurityissue.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Import(SecurityConfig.class)
@MockBean(classes = {JwtDecoder.class})
@WebMvcTest(controllers = {MyController.class})
@WithMockUser(username = "superman", roles = {"SUPERPOWER"})
class MyControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void postAMessage() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/v1/message")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                                .content("Hello from test!")
                )
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

}