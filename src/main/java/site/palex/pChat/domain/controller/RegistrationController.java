package site.palex.pChat.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import site.palex.pChat.domain.Role;
import site.palex.pChat.domain.User;
import site.palex.pChat.domain.repos.UserRepo;

import javax.persistence.CollectionTable;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registraion(){
        return "registraion";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER)); //Создает сет с одним единственным значением
        userRepo.save(user);

        return "redirect:/login";
    }
}
