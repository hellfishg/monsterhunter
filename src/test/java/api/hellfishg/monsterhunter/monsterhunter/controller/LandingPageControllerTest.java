package api.hellfishg.monsterhunter.monsterhunter.controller;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import api.hellfishg.monsterhunter.monsterhunter.repository.BiomasRepository;

@WebMvcTest(LandingPageController.class) // Aísla solo el controlador y nada más de la aplicación (no levanta la BD ni los servicios reales).
public class LandingPageControllerTest {

    @Autowired
    private MockMvc MockRequestHttp;

    @MockitoBean
    private BiomasRepository biomasRepository;

    @Test
    public void getLandingPage() throws Exception {
        String responseMenuItemsJson = "[\"BIOMAS\", \"MONSTRUOS\", \"ARMAS\", \"ARMADURAS\", \"ITEMS\"]";
        MockRequestHttp.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().json(responseMenuItemsJson));
    }

    @Test
    public void getBiomasName() throws Exception {
        //List<String> mockNameBiomasList = Arrays.asList("BIOMAS", "MONSTRUOS", "ARMAS", "ARMADURAS", "ITEMS");
        //String mockBiomasJson = "[\"Templo Olvidado\", \"Islas Heladas\",\"Bosque Inundado\",\"LLanos Arenosos\",\"Grutas de Lava\",\"La Jungla\",\"Bastion\"]";
        List<String> mockNameBiomasList = List.of("Templo Olvidado", "Islas Heladas", "Bosque Inundado");

        Mockito.when(biomasRepository.findAllNames()).thenReturn(mockNameBiomasList);
    
        MockRequestHttp.perform(get("/biomas/listNames"))
                .andExpect(status().isOk())
                .andExpect(content().json("[\"Templo Olvidado\", \"Islas Heladas\",\"Bosque Inundado\"]"));

        Mockito.verify(biomasRepository, Mockito.times(1)).findAllNames();
        
    }
}
