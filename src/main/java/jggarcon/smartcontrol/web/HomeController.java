package jggarcon.smartcontrol.web;

import jggarcon.smartcontrol.service.SmartControlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    private final SmartControlService smartControlService;

    public HomeController(SmartControlService smartControlService) {
        this.smartControlService = smartControlService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Medavie's Smart Control Dashboard");
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

    @PostMapping("/ac/{id}/power")
    public String setAcPower(@PathVariable String id, @RequestParam boolean on) {
        smartControlService.setAcPower(id, on);
        return "redirect:/";
    }

    @PostMapping("/ac/{id}/temperature")
    public String setAcTemperature(@PathVariable String id,
                                   @RequestParam("temp") String tempStr,
                                   RedirectAttributes ra) {
        if (tempStr == null || tempStr.isBlank()) {
            ra.addFlashAttribute("error", "Please enter a temperature between 16 and 30 °C.");
            return "redirect:/";
        }
        try {
            int tempC = Integer.parseInt(tempStr.trim());
            smartControlService.setAcTemperature(id, tempC);
            ra.addFlashAttribute("info", "AC set to " + tempC + "°C");
        } catch (NumberFormatException nfe) {
            ra.addFlashAttribute("error", "Temperature must be a number between 16 and 30 °C.");
        } catch (IllegalArgumentException ex) {
            ra.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/";
    }

}


