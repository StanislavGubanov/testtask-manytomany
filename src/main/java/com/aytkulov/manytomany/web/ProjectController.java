package com.aytkulov.manytomany.web;

import com.aytkulov.manytomany.domain.Employee;
import com.aytkulov.manytomany.domain.Project;
import com.aytkulov.manytomany.repository.EmployeeRepository;
import com.aytkulov.manytomany.repository.ProjectRepository;
import com.aytkulov.manytomany.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String getOne(@RequestParam Integer id, Model model) {
        model.addAttribute("project", projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("not found project with id = " + id)));
        model.addAttribute("employees", employeeRepository.findAll());
        return "project";
    }

    @PostMapping(value = "/projects")
    @ResponseBody
    public String createOrUpdate(@RequestParam Integer id, @RequestParam String name, @RequestParam(value = "projectIds[]") Integer[] prrojectIds) {
        Project created = new Project(name);
        if(id!=null)
            created.setId(id);
        Set<Employee> employees = new HashSet<>();
        for (Integer employeeId : prrojectIds) {
            employees.add(employeeRepository.findById(employeeId).orElseThrow(() -> new NotFoundException("not found employee with id = " + id)));
        }
        created.setEmployees(employees);
        projectRepository.save(created);
        return created.getId().toString();
//        return "project/" + created.getId();
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestParam Integer id) {
        projectRepository.deleteById(id);
        return id.toString();
    }
}
