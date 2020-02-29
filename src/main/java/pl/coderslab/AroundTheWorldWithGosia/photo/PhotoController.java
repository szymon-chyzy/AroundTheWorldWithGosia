package pl.coderslab.AroundTheWorldWithGosia.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/travel")
@RequiredArgsConstructor
public class PhotoController {

    @Autowired
    PhotoRepository photoRepository;

    @GetMapping("/photoform")
    public String getPhotoForm(Model model) {
        model.addAttribute("photo", new Photo());
        return "travel/photoform";
    }

    @PostMapping("/photos")
    public String foobarPost3(@Valid
                             @ModelAttribute("command") Photo photo,
                             Model model) {
        photoRepository.create(photo);
        return "redirect:photos";
    }

    @GetMapping("/photos")
    public String getPhotos(Model model) {
        model.addAttribute("photos", photoRepository.findAll());
        return "travel/photos";
    }

    @GetMapping("/photodelete/{id}")
    public String delete(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        photoRepository.delete(photoRepository.findById(id));
        return "redirect:/travel/photos";
    }

//    @GetMapping("/formedit/{id}")
//    public String edit(@PathVariable long id, Model model) {
//        Travel travel = travelRepository.findById(id);
//        model.addAttribute("travel", travel);
//        return "travel/formedit";
//    }
//
//    @PostMapping("/formedit")
//    public String update(@ModelAttribute @Valid Travel travel, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "travel/formedit";
//        }
//        travelRepository.update(travel);
//        return "redirect:/travel/list";
//    }
}
