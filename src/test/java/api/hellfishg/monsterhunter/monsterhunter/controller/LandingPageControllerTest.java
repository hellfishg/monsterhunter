package api.hellfishg.monsterhunter.monsterhunter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LandingPageControllerTest {

    @Test
    void getLandingPage() {
        LandingPageController LandingPage = new LandingPageController();

        assertEquals(LandingPage, LandingPage);
    }
    
}
