package com.week4challange.roboresumewithsecurity;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

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

    @Autowired
    CoverRepository coverRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String showIndex(Model model){
        return "index";
    }
    //Add contact info
    @GetMapping("/contactinfo")
    public String addContactInfo(Model model){
        model.addAttribute("user",new User());
        return "contactinfo";
    }
    @PostMapping("/addcontactinfo")
    public String addContactInfoForm(@Valid @ModelAttribute("user") User user, @RequestParam("file")MultipartFile file, BindingResult result,
                                 RedirectAttributes redirectAttributes){
        if(file.isEmpty()){
            return "contactinfo";
        }
        try{
            Map uploadResult=cloudc.upload(file.getBytes(),
                    ObjectUtils.asMap("resourcetype","auto"));
            user.setImgUrl(uploadResult.get("url").toString());

        }catch (IOException e){
            e.printStackTrace();
            return "contactinfo";
        }
        if(result.hasErrors()){
            return "contactinfo";
        }
        else{
            userRepository.save(user);
            return "redirect:/";
        }

    }

    //Add educational achievements
    @GetMapping("/education")
    public String addEducation(Model model){
        model.addAttribute("education",new Education());
        return "education";
    }
    @PostMapping("/addeducation")
    public String addEducationForm(@Valid @ModelAttribute("education") Education education, BindingResult result,
                                 RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "education";
        }
        else{
            educationRepository.save(education);
            return "redirect:/";
        }
    }
    //Add work experience
    @GetMapping("/experience")
    public String addExperience(Model model){
        model.addAttribute("experience",new Experience());
        return "experience";
    }
    @PostMapping("/addexperience")
    public String addExperienceForm(@Valid @ModelAttribute("experience") Experience experience, BindingResult result,
                                   RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "experience";
        }
        else{
            experienceRepository.save(experience);
            return "redirect:/";
        }
    }
    //Add skills
    @GetMapping("/skill")
    public String addSkill(Model model){
        model.addAttribute("skill",new Skill());
        return "skill";
    }
    @PostMapping("/addskill")
    public String addSkillForm(@Valid @ModelAttribute("skill") Skill skill, BindingResult result,
                                    RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "skill";
        }
        else{
            skillRepository.save(skill);
            return "redirect:/";
        }
    }

    //Add summary
    @GetMapping("/summary")
    public String addSummary(Model model){
        model.addAttribute("cover",new Cover());
        return "summary";
    }
    @PostMapping("/addsummary")
    public String addSummaryForm(@Valid @ModelAttribute("cover") Cover cover, BindingResult result,
                               RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "summary";
        }
        else{
            coverRepository.save(cover);
            return "redirect:/";
        }
    }

    @RequestMapping("/completedresume")
    public String showCompleteResume(Model model){
        model.addAttribute("users",userRepository.findAll());
        model.addAttribute("educations",educationRepository.findAll());
        model.addAttribute("experiences",experienceRepository.findAll());
        model.addAttribute("skills",skillRepository.findAll());
        model.addAttribute("covers",coverRepository.findAll());
        return "completedresume";
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
