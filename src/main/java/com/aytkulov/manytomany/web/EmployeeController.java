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
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getOne(@RequestParam Integer id, Model model) {
        model.addAttribute("employee", employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("not found employee with id = " + id)));
        model.addAttribute("projects", projectRepository.findAll());
        return "employee";
    }

    @PostMapping(value = "/employees")
    @ResponseBody
    public String createOrUpdate(@RequestParam Integer id, @RequestParam String name, @RequestParam(value = "projectIds[]") Integer[] prrojectIds) {
        Employee created = new Employee(name);
        if (id != null)
            created.setId(id);
        Set<Project> projects = new HashSet<>();
        for (Integer projectId : prrojectIds) {
            projects.add(projectRepository.findById(projectId).orElseThrow(() -> new NotFoundException("not found project with id = " + projectId)));
        }
        created.setProjects(projects);
        employeeRepository.save(created);
        return created.getId().toString();
//        return "employee/" + created.getId();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestParam Integer id) {
        employeeRepository.deleteById(id);
        return id.toString();
    }

}
