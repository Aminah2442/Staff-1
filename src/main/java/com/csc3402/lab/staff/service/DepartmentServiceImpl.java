package com.csc3402.lab.staff.service;

import com.csc3402.lab.staff.model.Department;
import com.csc3402.lab.staff.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public List<Department> listAllDepartments() {
        return departmentRepository.findAll();
    }
}
