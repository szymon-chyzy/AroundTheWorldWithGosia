package pl.coderslab.AroundTheWorldWithGosia.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/travel")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/userform")
    public String getUserForm(Model model) {
        model.addAttribute("user", new User());
        return "travel/userform";
    }

    @PostMapping("/users")
    public String foobarPost2(@Valid
                             @ModelAttribute("command") User user,
                             Model model) {
        userRepository.create(user);
        return "redirect:users";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "travel/users";
    }

    @GetMapping("/userdelete/{id}")
    public String delete(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        userRepository.delete(userRepository.findById(id));
        return "redirect:/travel/users";
    }

    @GetMapping("/useredit/{id}")
    public String edit(@PathVariable long id, Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "travel/useredit";
    }

    @PostMapping("/useredit")
    public String update(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "travel/useredit";
        }
        userRepository.update(user);
        return "redirect:/travel/users";
    }

}
