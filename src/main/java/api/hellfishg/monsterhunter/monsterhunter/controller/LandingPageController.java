package api.hellfishg.monsterhunter.monsterhunter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import api.hellfishg.monsterhunter.monsterhunter.model.enums.MenusEnum;

@Controller
public class LandingPageController {

    @GetMapping("/")
    public String getOptionsList(@RequestParam String param) {
        Map<Integer, MenusEnum.MENUS> optionsList = new HashMap<>();
        optionsList.put(1, MenusEnum.MENUS.BIOMAS );
        optionsList.put(2, MenusEnum.MENUS.MONSTRUOS );
        optionsList.put(3, MenusEnum.MENUS.ARMAS );
        optionsList.put(4, MenusEnum.MENUS.ARMADURAS );
        optionsList.put(4, MenusEnum.MENUS.ITEMS );
        return "Rady to go";
    }

}
