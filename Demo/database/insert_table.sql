use new_java_servlet;

insert  into role(code, name) values('ADMIN', 'Quản trị hệ thống');
insert into role(code, name) values('USER', 'Người dùng');

insert into user(name, password, fullname, status) values ('admin', '123','admin', 1);
insert into user(name, password, fullname, status) values ('nguyenvana', '123', 'Nguyễn Văn A', 1);
insert into user(name, password, fullname, status) values ('nguyenvanb', '123', 'Nguyễn Văn B', 1);