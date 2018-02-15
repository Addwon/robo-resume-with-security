package com.week4challange.roboresumewithsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillRepository skillRepository;
    @RequestMapping("/")
    public String showIndex(Model model){
        //model.addAttribute("rooms",roomRepository.findAllByListTypeContainingIgnoreCase("Public"));
        return "index";
    }

//    @RequestMapping("/summary")
//    public String summary(Model model){
//        //model.addAttribute("rooms",roomRepository.findAllByListTypeContainingIgnoreCase("Public"));
//        return "summary";
//    }
//
//    @RequestMapping("/contactinfo")
//    public String contactInfo(Model model){
//        //model.addAttribute("rooms",roomRepository.findAllByListTypeContainingIgnoreCase("Public"));
//        return "contactinfo";
//    }
//
//    @RequestMapping("/education")
//    public String education(Model model){
//        model.addAttribute("education",educationRepository.findAll());
//        return "education";
//    }
//
//    @RequestMapping("/skill")
//    public String skill(Model model){
//        //model.addAttribute("rooms",roomRepository.findAllByListTypeContainingIgnoreCase("Public"));
//        return "skill";
//    }
//
//    @RequestMapping("/experience")
//    public String experience(Model model){
//        //model.addAttribute("rooms",roomRepository.findAllByListTypeContainingIgnoreCase("Public"));
//        return "experience";
//    }
//
//    @RequestMapping("/references")
//    public String references(Model model){
//        //model.addAttribute("rooms",roomRepository.findAllByListTypeContainingIgnoreCase("Public"));
//        return "references";
//    }
//
//    @RequestMapping("/completedresume")
//    public String completedresume(Model model){
//        //model.addAttribute("rooms",roomRepository.findAllByListTypeContainingIgnoreCase("Public"));
//        return "completedresume";
//    }
//
//    @RequestMapping("/coverletter")
//    public String coverletter(Model model){
//        //model.addAttribute("rooms",roomRepository.findAllByListTypeContainingIgnoreCase("Public"));
//        return "coverletter";
//    }

}
