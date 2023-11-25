package com.example.hardwarestore.api.controller;

import com.example.hardwarestore.model.University;
import com.example.hardwarestore.model.User;
import com.example.hardwarestore.persist.db.postgres.UniversityRepository;
import com.example.hardwarestore.persist.db.postgres.UserRepository;
import com.example.hardwarestore.persist.db.postgres.entity.UniversityEntity;
import com.example.hardwarestore.persist.db.postgres.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UniversityRepository universityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("message", "Открыта главная страница магазина");
        model.addAttribute("universities", universityRepository.findAll());

        return "home";
    }

    @GetMapping("/university/new")
    public String newHardwareForm(Model model) {
        model.addAttribute("university", new University());

        return "universityForm";
    }

    @PostMapping("/university/new")
    public String addHardware(@Valid @ModelAttribute University university, BindingResult result) {
        if (result.hasErrors()) {
            return "universityForm";
        }

        universityRepository.save(new UniversityEntity(
            null,
            university.getName(),
            university.getLocation(),
            university.getFoundationYear(),
            university.getDescription(),
            university.getTotalStudents()
        ));

        return "redirect:/home";
    }

    @GetMapping("/register")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "userForm";
    }

    @PostMapping("/register")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "userForm";
        }

        userRepository.save(new UserEntity(
            null,
            user.getUsername(),
            passwordEncoder.encode(user.getPassword()),
            "rol"
        ));

        return "redirect:/home";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
