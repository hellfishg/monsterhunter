package api.hellfishg.monsterhunter.monsterhunter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(LandingPageController.class)
public class LandingPageControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    LandingPageController landingPageController = new LandingPageController();

    @Test
    public void getLandingPage() throws Exception{
        String respuestaMenuItemsJson = "[\"BIOMAS\", \"MONSTRUOS\", \"ARMAS\", \"ARMADURAS\", \"ITEMS\"]";
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().json(respuestaMenuItemsJson));
    }
}
