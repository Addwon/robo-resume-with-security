package com.week4challange.roboresumewithsecurity;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    UserDataRepository userdataRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    CoverRepository coverRepository;

    @Autowired
    ReferenceRepository referenceRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;



    @RequestMapping("/")
    public String showIndex(Model model){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("login page returned");
        return "login";
    }

    //For user registration
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String showRegistrationPage(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }


    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String processRegistrationPage(@Valid @ModelAttribute("User") User user, BindingResult result, Model model){
//        MultipartFile f = request.getFile("file");
//        if(f.isEmpty()){
//            return "registration";
//        }
//        try{
//            Map uploadResult=cloudc.upload(f.getBytes(),
//                    ObjectUtils.asMap("resourcetype","auto"));
//            user.setImgUrl(uploadResult.get("url").toString());
//
//        }catch (IOException e){
//            e.printStackTrace();
//            return "registration";
//        }
////        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "registration";
        }else{
            userRepository.save(user);
//            model.addAttribute("message","User Account Successfully Created");
        }
        return "redirect:/";
    }

//    //Add contact info
//    @GetMapping("/contactinfo")
//    public String addContactInfo(Model model){
//        model.addAttribute("user",new UserData());
//        return "contactinfo";
//    }
//    @PostMapping("/addcontactinfo")
//    public String addContactInfoForm(@Valid @ModelAttribute("user") UserData user, @RequestParam("file")MultipartFile file, BindingResult result,
//                                 RedirectAttributes redirectAttributes){
//        if(file.isEmpty()){
//            return "contactinfo";
//        }
//        try{
//            Map uploadResult=cloudc.upload(file.getBytes(),
//                    ObjectUtils.asMap("resourcetype","auto"));
//            user.setImgUrl(uploadResult.get("url").toString());
//
//        }catch (IOException e){
//            e.printStackTrace();
//            return "contactinfo";
//        }
//        if(result.hasErrors()){
//            return "contactinfo";
//        }
//        else{
//            userdataRepository.save(user);
//            return "redirect:/";
//        }
//
//    }

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
    //Add reference
    @GetMapping("/reference")
    public String addReference(Model model){
        model.addAttribute("reference",new Reference());
        return "reference";
    }
    @PostMapping("/addreference")
    public String addReferenceForm(@Valid @ModelAttribute("reference") Reference reference, BindingResult result,
                                 RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "reference";
        }
        else{
            referenceRepository.save(reference);
            return "redirect:/";
        }
    }


//Post jobs
    @GetMapping("/postjob")
    public String postJob(Model model){
        model.addAttribute("job",new Job());
        return "postjob";
    }
    @PostMapping("/postjob")
    public String postJobForm(@Valid @ModelAttribute("job") Job job, BindingResult result,
                                   RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "postjob";
        }
        else{
            jobRepository.save(job);
            return "redirect:/";
        }
    }

    @RequestMapping("/completedresume")
    public String showCompleteResume(Model model){
        //model.addAttribute("users",userdataRepository.findAll());
        model.addAttribute("users",userRepository.findAll());
        model.addAttribute("educations",educationRepository.findAll());
        model.addAttribute("experiences",experienceRepository.findAll());
        model.addAttribute("skills",skillRepository.findAll());
        model.addAttribute("covers",coverRepository.findAll());
        return "completedresume";
    }
    @RequestMapping("/showcoverletter")
    public String ShowCoverLetter(Model model){
        model.addAttribute("covers",coverRepository.findAll());
        return"showcoverletter";
    }
    @RequestMapping("/showreference")
    public String ShowReference(User user,Principal p,Model model){
//        //user=userRepository.findOne(id);
//        model.addAttribute("references", referenceRepository.findAll());
//        String activeUserType="";
//        activeUserType=user.getUsertype();
//        System.out.println(user.getUsertype());
//
//        System.out.println(p.getName());
//        String activeUserType="";
//        activeUserType=user.getUsertype();
//        //activeUser=p.getName().toString();
//        //System.out.println(activeUser);
//        if(activeUserType=="Applicant") {
//            model.addAttribute("references", referenceRepository.findAll());
//            return "showreference";
//        }
//        else{
//            System.out.println("Access Denied");
//            return "redirect:/";
//        }
        model.addAttribute("references", referenceRepository.findAll());
        return "showreference";
    }

    @RequestMapping("/joblist")
    public String ShowJobList(Model model,Job job,Skill skill){
      //  model.addAttribute("job",jobRepository.findAllByRequiredSkillContainingIgnoreCase())
       model.addAttribute("job",jobRepository.findAll());
      model.addAttribute("organization",organizationRepository.findAll());
        return"joblist";
    }
    //Job search
    @GetMapping("/search")
    public String getSearch()
    {
        return "joblist";
    }

    @PostMapping("/search")
    public String showSearchResults(HttpServletRequest request, Model model)
    {
        //Get the search string from the result form
        String searchString = request.getParameter("search");
        model.addAttribute("search",searchString);
        model.addAttribute("jobs",jobRepository.findAllByRequiredSkillContainingIgnoreCase(searchString));
        return "jobsearchresult";
    }
//----------------------- Edit ---------------------------------
    @RequestMapping("/editcontact/{id}")
    public String editContact(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userRepository.findOne(id));
        return "contactinfo";
    }
    @RequestMapping("/editeducation/{id}")
    public String editEducation(@PathVariable("id") long id, Model model){
        model.addAttribute("education", educationRepository.findOne(id));
        return "education";
    }
    @RequestMapping("/editexperience/{id}")
    public String editExperience(@PathVariable("id") long id, Model model){
        model.addAttribute("experience", experienceRepository.findOne(id));
        return "experience";
    }
    @RequestMapping("/editskill/{id}")
    public String editSkill(@PathVariable("id") long id, Model model){
        model.addAttribute("skill", skillRepository.findOne(id));
        return "skill";
    }
}
