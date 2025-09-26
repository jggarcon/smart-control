package jggarcon.smartcontrol.web;

import jggarcon.smartcontrol.service.SmartControlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final SmartControlService smartControlService;

    public HomeController(SmartControlService smartControlService) {
        this.smartControlService = smartControlService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Smart Control");
        model.addAttribute("devices", smartControlService.getAll());
        return "index";
    }
}


