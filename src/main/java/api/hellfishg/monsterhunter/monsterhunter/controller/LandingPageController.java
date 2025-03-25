package api.hellfishg.monsterhunter.monsterhunter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import api.hellfishg.monsterhunter.monsterhunter.model.enums.MenusEnum;
import api.hellfishg.monsterhunter.monsterhunter.repository.BiomasRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "LandinPageController", description = "Endpoints para gestionar el API")
public class LandingPageController {

    private final BiomasRepository biomasRepository;

    public LandingPageController(BiomasRepository biomasRepository) {
        this.biomasRepository = biomasRepository;
    }

    @GetMapping("/")
    @Operation(summary = "Obtener todos los menus de la API", description = "Retorna una lista de categorias")
    public ResponseEntity<List<MenusEnum.MENUS>> getMenuOptionList() {
        List<MenusEnum.MENUS> optionsList = new ArrayList<>();
        optionsList.add(MenusEnum.MENUS.BIOMAS);
        optionsList.add(MenusEnum.MENUS.MONSTRUOS);
        optionsList.add(MenusEnum.MENUS.ARMAS);
        optionsList.add(MenusEnum.MENUS.ARMADURAS);
        optionsList.add(MenusEnum.MENUS.ITEMS);
        return ResponseEntity.ok(optionsList);
    }

    @GetMapping("/biomas/listNames")
    @Operation(summary = "Obtener todos los nombres de los biomas", description = "Retorna una lista de biomas")
    public ResponseEntity<List<String>> getBiomasListNames() {
            return ResponseEntity.ok(biomasRepository.findAllNames());
    }

}
