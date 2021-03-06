package com.week4challange.roboresumewithsecurity.Controller;

import com.cloudinary.utils.ObjectUtils;
import com.week4challange.roboresumewithsecurity.Configuration.CloudinaryConfig;
import com.week4challange.roboresumewithsecurity.Configuration.UserService;
import com.week4challange.roboresumewithsecurity.Model.*;
import com.week4challange.roboresumewithsecurity.Repository.*;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@Controller
public class HomeController {

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
    @RequestMapping(value="/registration",method=RequestMethod.GET)
    public String showRegistrationPage(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }


    @RequestMapping(value="/registration",method= RequestMethod.POST)
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user,@RequestParam("file")MultipartFile file, BindingResult result,
                                          RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "registration";
        }
        if(file.isEmpty()){
            return "registration";
        }
        try{
            Map uploadResult=cloudc.upload(file.getBytes(),
                    ObjectUtils.asMap("resourcetype","auto"));
            user.setImgUrl(uploadResult.get("url").toString());
            //actorRepository.save(actor);
        }catch (IOException e){
            e.printStackTrace();
            return "registration";
        }
//        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "registration";
        }else{
            userRepository.save(user);
//            model.addAttribute("message","User Account Successfully Created");
        }
        return "redirect:/";
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
    @GetMapping("/coverletterform")
    public String addCoverLetter(Model model){
        model.addAttribute("cover",new Cover());
        return "coverletterform";
    }
    @PostMapping("/coverletterform")
    public String addCoverLetterForm(@Valid @ModelAttribute("cover") Cover cover, BindingResult result,
                                 RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "coverletterform";
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
    public String showCompleteResume(Authentication auth,Authorization auto, Model model ){

        model.addAttribute("users",userRepository.findByUsername(auth.getName()));
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
        model.addAttribute("references", referenceRepository.findAll());
        return "showreference";
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;


   // public String ShowJobList(@RequestParam("jobs") String jobID, @PathVariable("skillID") long skillID,  @ModelAttribute("job") Job j, Model model){
    @RequestMapping("/joblist")
   public String ShowJobList(Model model,User user,Job job,Skill skill){
/*
        String s="Software Programmer";

        EntityManager session = entityManagerFactory.createEntityManager();

            String jobDes=(String)session.createNativeQuery("Select jobDescription  FROM Job WHERE jobTitle=s").getSingleResult();
            System.out.println(jobDes);
*/
        /*
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getAuthorities());
        System.out.println(auth.getCredentials());
        System.out.println(auth.getPrincipal());
        System.out.println(auth.getDetails());
        System.out.println(auth.isAuthenticated());
        System.out.println(auth.getName());
        */
      //  model.addAttribute("job",jobRepository.findAllByRequiredSkillContainingIgnoreCase())
//        model.addAttribute("job",jobRepository.)
//        Skill s=skillRepository.findOne(new Long(skillID));
//        s.
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
        //model.addAttribute("org",organizationRepository.findByOrganizationAndRequiredSkill(searchString));
        model.addAttribute("jobs",jobRepository.findAllByRequiredSkillContainingIgnoreCase(searchString));
        model.addAttribute("jobs",jobRepository.findAllBy_orgnizationContainingIgnoreCase(searchString));
        //model.addAttribute("jobs",organizationRepository.findAllByOrganizationNameContainingIgnoreCase(searchString));
        return "jobsearchresult";
    }
    //Applicant list
        @RequestMapping("/apply/{id}")
        public String listApplicant(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userRepository.findOne(id));
        return "applicantlist";
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
