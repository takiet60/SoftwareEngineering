use new_java_servlet;

create table role (
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
    created_date timestamp null,
    modified_date timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

create table user (
	id bigint not null primary key auto_increment,
    username varchar(150) not null,
    password varchar(150) not null,
    fullname varchar(150) not null,
    status int not null,
    role_id bigint not null,
    created_date timestamp null,
    modified_date timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);


alter table user add constraint fk_userrole_user foreign key (role_id) references role(id);


create table news (
	id bigint not null primary key auto_increment,
    title varchar(255) null,
    thumbnall varchar(255) null,
    sortdescription text null,
    content text null,
    categoryid bigint not null,
    created_date timestamp null,
    modified_date timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

create table category (
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
    created_date timestamp null,
    modified_date timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table news add constraint fk_news_category foreign key (categoryid) references category(id);


create table comment (
	id bigint not null primary key auto_increment,
    content text not null,
    userid bigint not null,
    newsid bigint not null,
    created_date timestamp null,
    modified_date timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table comment add constraint fk_cmt_user foreign key (userid) references user(id);
alter table comment add constraint fk_cmt_news foreign key (newsid) references news(id);