package com.example;

import com.example.model.Classroom;
import com.example.repository.ClassRepository;
import com.example.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class juyeonHomeController {

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    ClassRepository classRepository;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/addclassroom")
    public String addclassroom(Model model){
        model.addAttribute("classroom", new Classroom());
        return "addclassroom";
    }

    @PostMapping("/processclassroom")
    public String processclassroom(@ModelAttribute("classroom") Classroom classroom){
        classroomRepository.save(classroom);
        //return "index";
        return "classlist";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
