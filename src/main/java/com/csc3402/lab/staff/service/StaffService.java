package com.csc3402.lab.staff.service;

import com.csc3402.lab.staff.model.Staff;


import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<Staff> listAllStaffs();
    Staff addNewStaff(Staff staff);

    Optional<Staff> findStaffById(Integer staffId);
    void updateStaff(Staff staff);
    void deleteStaff(Staff staff);

}


