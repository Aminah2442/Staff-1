insert into department(dept_name, address, phone) values ('Department of Computer Science', 'Block C, FSKTM UPM', '03-89477435');
insert into department(dept_name, address, phone) values ('Department of Software Engineering', 'Block A, FSKTM UPM', '03-89477436');
insert into department(dept_name, address, phone) values ('Department of Multimedia', 'Block C, FSKTM UPM', '03-89477437');
insert into department(dept_name, address, phone) values ('Department of Network', 'Block A, FSKTM UPM', '03-89477438');

insert into staff(first_name, last_name, salary) values ('James', 'Dean', 10000);
insert into staff(first_name, last_name, salary) values ('Mawar', 'Adenan', 12500);
insert into staff(first_name, last_name, salary) values ('Adam', 'Gray', 17000);
insert into staff(first_name, last_name, salary) values ('Steve', 'Jobs', 25000);

update staff set dept_id = 1
where staff_id = 1;

update staff set dept_id = 2
where staff_id = 2;

update staff set dept_id = 1
where staff_id = 3;

update staff set dept_id = 4
where staff_id = 4;
