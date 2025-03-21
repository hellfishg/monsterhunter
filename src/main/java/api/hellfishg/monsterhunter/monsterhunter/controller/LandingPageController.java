package api.hellfishg.monsterhunter.monsterhunter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import api.hellfishg.monsterhunter.monsterhunter.model.enums.MenusEnum;
import api.hellfishg.monsterhunter.monsterhunter.repository.BiomasRepository;

@RestController
public class LandingPageController {

    @Autowired
    BiomasRepository biomasRepository;
    
    @GetMapping("/")
     public ResponseEntity<List<MenusEnum.MENUS>> getOptionsList() {
        List<MenusEnum.MENUS> optionsList = new ArrayList<>();
        optionsList.add(MenusEnum.MENUS.BIOMAS);
        optionsList.add(MenusEnum.MENUS.MONSTRUOS);
        optionsList.add(MenusEnum.MENUS.ARMAS);
        optionsList.add(MenusEnum.MENUS.ARMADURAS);
        optionsList.add(MenusEnum.MENUS.ITEMS);
        return ResponseEntity.ok(optionsList);
    }

    @GetMapping("/biomasName")
    public List<String> getMethodName() {
        //TODO: Implemetar el manejo de errores.
        return biomasRepository.findAllNames();
    }
    
}
