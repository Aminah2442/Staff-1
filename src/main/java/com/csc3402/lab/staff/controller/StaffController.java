package com.csc3402.lab.staff.controller;

import com.csc3402.lab.staff.model.Staff;
import com.csc3402.lab.staff.service.StaffService;
import com.csc3402.lab.staff.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    private final StaffService staffService;
    private final DepartmentService departmentService;


    public StaffController(StaffService staffService, DepartmentService departmentService) {
        this.staffService = staffService;
        this.departmentService = departmentService;
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("staffs", staffService.listAllStaffs());
        return "list-staff";
    }

    @GetMapping("signup")
    public String showSignUpForm(Staff staff,Model model) {
        model.addAttribute("departments", departmentService.listAllDepartments());
        return "add-staff";
    }

    @PostMapping("add")
    public String addStaff(@Valid Staff staff, BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "add-staff";
        }

        staffService.addNewStaff(staff);
        return "redirect:list";
    }

    // UPDATE STAFF
    @GetMapping("update")
    public String showUpdateMainForm(Model model) {
        model.addAttribute("staffs", staffService.listAllStaffs());
        return "choose-staff-to-update";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Staff staff = staffService.findStaffById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        model.addAttribute("staff", staff);
        model.addAttribute("departments", departmentService.listAllDepartments());
        return "update-staff";
    }


    @PostMapping("update/{id}")
    public String updateStaff(@PathVariable("id") long id, @Valid Staff staff, BindingResult result, Model model) {
        if (result.hasErrors()) {
            staff.setStaffId((int) id);
            return "index";
        }

        model.addAttribute("staffs", staffService.listAllStaffs());
        staffService.updateStaff(staff);
        return "list-staff";
    }


    // DELETE STAFF
    @GetMapping("delete")
    public String showDeleteMainForm(Model model) {
        model.addAttribute("staffs", staffService.listAllStaffs());
        return "choose-staff-to-delete";
    }

    @GetMapping("delete/{id}")
    public String deleteStaff(@PathVariable("id") long id, Model model) {
        Staff staff = staffService.findStaffById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        staffService.deleteStaff(staff);
        model.addAttribute("staffs", staffService.listAllStaffs());
        return "list-staff";
    }


}

