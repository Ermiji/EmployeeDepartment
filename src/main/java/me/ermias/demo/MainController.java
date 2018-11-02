package me.ermias.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String listEmployee(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String departmentForm(Model model){
        model.addAttribute("department", new Department());
        model.addAttribute("employees", employeeRepository.findAll());
        return "depform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Department department, BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("employees", employeeRepository.findAll());
            return "depform";
        }
        departmentRepository.save(department);
        return "redirect:/";
    }

    @GetMapping("/addemployee")
    public String employeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee";
    }

    @PostMapping("processemployee")
    public String processEmployee(@Valid Employee employee, BindingResult result,
                                  Model model){
        if(result.hasErrors()){
            return "employee";
        }
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showEmployee(@PathVariable("id") long id, Model model){
        model.addAttribute("department", departmentRepository.findById(id).get());
        return "home";
    }

    @RequestMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") long id, Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("department", departmentRepository.findById(id).get());
        return "depform";
    }

    @RequestMapping("/delete/{id}")
    public String delEmployee(@PathVariable("id") long id){
        departmentRepository.deleteById(id);
        return "redirect:/";
    }
}
