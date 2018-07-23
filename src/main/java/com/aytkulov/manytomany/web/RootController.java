package com.aytkulov.manytomany.web;

import com.aytkulov.manytomany.repository.EmployeeRepository;
import com.aytkulov.manytomany.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;


    @GetMapping("/")
    public String employeeList(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());
        return "index";
    }

}
