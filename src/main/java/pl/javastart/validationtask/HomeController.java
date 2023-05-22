package pl.javastart.validationtask;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", new RegisterFormDto());
        return "home";
    }

    @PostMapping("/register")
    public String register(Model model, @Valid @ModelAttribute("data") RegisterFormDto registerFormDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("data", registerFormDto);
            return "home";
        } else {
            model.addAttribute("formData", registerFormDto);
            return "success";
        }
    }

    @GetMapping("/success")
    String success(Model model) {
        model.addAttribute("formData");
        return "success";
    }
}
