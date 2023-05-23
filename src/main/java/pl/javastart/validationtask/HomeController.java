package pl.javastart.validationtask;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", new RegisterFormDto());
        return "home";
    }

    @PostMapping("/register")
    public String register(Model model,
                           @Valid @ModelAttribute("data") RegisterFormDto registerFormDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("data", registerFormDto);
            return "home";
        } else {
            redirectAttributes.addFlashAttribute("formData", registerFormDto);
            return "redirect:/success";
        }
    }

    @GetMapping("/success")
    String success(Model model,
                   RedirectAttributes redirectAttributes) {
        RegisterFormDto formData = (RegisterFormDto) redirectAttributes.getAttribute("formData");
        model.addAttribute("formData", formData);
        return "success";
    }
}
