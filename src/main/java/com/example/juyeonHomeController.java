package com.example;

import com.example.model.Class;
import com.example.model.Classroom;
import com.example.model.Department;
import com.example.model.Major;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class juyeonHomeController {

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    MajorRepository majorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/")
    public String home() {
        return "index";
    }
//classroom
    @GetMapping("/addclassroom")
    public String addclassroom(Model model){
        model.addAttribute("classroom", new Classroom());
        return "addclassroom";
    }

    @PostMapping("/processclassroom")
    //public String processclassroom(@ModelAttribute("classroom") Classroom classroom){
    public String processclassroom(@ModelAttribute("classrooms") Classroom classroom, Model model){
        classroomRepository.save(classroom);

        model.addAttribute("classrooms", classroomRepository.findAll());
        //return "index";
        return "classlist";
    }
//login
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    //major
    @GetMapping("/addmajor")
    public String addmajor(Model model) {
        model.addAttribute("major", new Major());

        model.addAttribute("departments", departmentRepository.findAll());

        return "addmajor";
    }

     //@RequestMapping("/processmajor")
    @PostMapping("/processmajor")
    public String processmajor(@ModelAttribute("majors") Major major, Model model) {
        majorRepository.save(major);

        //model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("major", majorRepository.findAll());

        model.addAttribute("class", classRepository.findAll());
        model.addAttribute("classrooms", classroomRepository.findAll());

        return "classlist";
    }
    //class
    @GetMapping("/addclass")
    public String addclass(Model model) {

        //

        model.addAttribute("course", courseRepository.findAll());
        model.addAttribute("aclass", new Class());
        return "addclass";
    }
//    @RequestMapping("/processclass")
////    public String processclass(@ModelAttribute("classses") Class class) {
////        classRepository.save(class);
////        return "classlist";
////    }
    //@RequestMapping("/processclass")
    @PostMapping("/processclass")
    public String processclass(@ModelAttribute("class") Class aclass){
//    public String processclass(@ModelAttribute("aclass") Class aclass){
        //classRepository.save(aclass);
        classRepository.save(aclass);
        return "classlist";
    }

    @RequestMapping("/delete/{id}")
    public String delClass(@PathVariable("id") long id) {
        classRepository.deleteById(id);
        return "classlist";

    }
    //department
    @GetMapping("/adddepartment")
    public String adddepartment(Model model){
        model.addAttribute("department", new Department());

        //model.addAttribute("categories", categoryRepository.findAll());
        //model.addAttribute("categories", categoryRepository.findAll());

        return "adddepartment";
    }

    @PostMapping("/processdepartment")
    public String processdepartment(@ModelAttribute("department") Department department){
        departmentRepository.save(department);
        //return "index";
        return "classlist";
    }
}
