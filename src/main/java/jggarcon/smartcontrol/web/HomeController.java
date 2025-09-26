package jggarcon.smartcontrol.web;

import jggarcon.smartcontrol.service.SmartControlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/light/{id}/toggle")
    public String toggleLight(@PathVariable String id) {
        smartControlService.toggleLight(id);
        return "redirect:/";
    }

    @PostMapping("/fan/{id}/speed")
    public String setFanSpeed(@PathVariable String id, @RequestParam int speed) {
        smartControlService.setFanSpeed(id, speed);
        return "redirect:/";
    }
}


