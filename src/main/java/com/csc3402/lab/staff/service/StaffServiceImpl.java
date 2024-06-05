package com.csc3402.lab.staff.service;

import com.csc3402.lab.staff.model.Staff;
import com.csc3402.lab.staff.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    //Constructor Injection
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> listAllStaffs() {
        return staffRepository.findAll();
    }

    @Override
    public Staff addNewStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Optional<Staff> findStaffById(Integer staffId) {
        return staffRepository.findById(staffId);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(Staff staff) {
        staffRepository.delete(staff);
    }
}
