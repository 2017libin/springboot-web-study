package com.example.springbootwebstudy.controller;

import com.example.springbootwebstudy.dao.DepartmentDao;
import com.example.springbootwebstudy.dao.EmployeeDao;
import com.example.springbootwebstudy.pojo.Department;
import com.example.springbootwebstudy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    /**
     * 查询所有员工，返回列表页面
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        // 结果返回前端
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/add")
    public String add(Model model){
        // 查出所有的部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/add")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        // 添加员工
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/edit/{id}")
    public String toUpdateAll(@PathVariable("id") int id, Model model) {
        // 查询指定id的员工,添加到emp中,用于前端接收
        Employee employee = employeeDao.getEmployee(id);
        model.addAttribute("emp", employee);
        // 查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "/emp/update";
        // 返回到编辑员工页面
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        // 回到员工列表页面
        return "redirect:/emps";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}