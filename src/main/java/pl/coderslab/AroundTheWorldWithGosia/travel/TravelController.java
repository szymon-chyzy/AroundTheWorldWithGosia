package pl.coderslab.AroundTheWorldWithGosia.travel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.AroundTheWorldWithGosia.user.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/travel")
@RequiredArgsConstructor
public class TravelController {

    private final TravelRepository travelRepository;

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("travel", new Travel());
        return "travel/form";
    }

    @PostMapping("/list")
    public String foobarPost(@Valid
            @ModelAttribute("command") Travel travel,
            Model model) {
        travelRepository.create(travel);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("travels", travelRepository.findAll());
        return "travel/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        travelRepository.delete(travelRepository.findById(id));
        return "redirect:/travel/list";
    }

    @GetMapping("/formedit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Travel travel = travelRepository.findById(id);
        model.addAttribute("travel", travel);
        return "travel/formedit";
    }

    @PostMapping("/formedit")
    public String update(@ModelAttribute @Valid Travel travel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "travel/formedit";
        }
        travelRepository.update(travel);
        return "redirect:/travel/list";
    }

}
