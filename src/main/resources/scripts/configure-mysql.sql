create table beer (
	id bigint not null auto_increment, 
    name varchar(255),
    beer_type_id bigint,
    description_id bigint, 
    snack_id bigint, 
    primary key (id)) engine=InnoDB;
create table beer_fan (
	beer_id bigint not null, 
    fan_id bigint not null) engine=InnoDB;
create table beer_type (
	id bigint not null auto_increment, 
    description varchar(255), 
    primary key (id)) engine=InnoDB;
create table description (
	id bigint not null auto_increment, 
    text longtext, 
    beer_id bigint,
    primary key (id)) engine=InnoDB;
create table fan (
	id bigint not null auto_increment, 
	first_name varchar(255), 
    last_name varchar(255), 
    sex integer, 
    review_id bigint,
    primary key (id)) engine=InnoDB;
create table ingredient (
	id bigint not null auto_increment, 
    description varchar(255), 
    beer_id bigint, 
    primary key (id)) engine=InnoDB;
create table review (
	id bigint not null auto_increment,
    text longtext, 
    beer_id bigint, 
    fan_id bigint, 
    primary key (id)) engine=InnoDB;
create table snack (
	id bigint not null auto_increment, 
    description varchar(255), 
    type integer, 
    primary key (id)) engine=InnoDB;
alter table beer add constraint FK84suwemashjbw5o8x134dkmet foreign key (beer_type_id) references beer_type (id);
alter table beer add constraint FKaot0ng2u99w69q48kjy6xqcsv foreign key (description_id) references description (id);
alter table beer add constraint FKhv5nf39y8e1hgi7jx2iv09hrm foreign key (snack_id) references snack (id);
alter table beer_fan add constraint FKfqhxe3wnawl5uypi5hd7yu6p6 foreign key (fan_id) references fan (id);
alter table beer_fan add constraint FK75tv1eywhb2230qyvfx8vp755 foreign key (beer_id) references beer (id);
alter table description add constraint FKndiygminl4i68bare0u67oq5y foreign key (beer_id) references beer (id);
alter table fan add constraint FKg2vqb3erk6feldgopl2mvgw6d foreign key (review_id) references review (id);
alter table ingredient add constraint FK2lwbk5a6yvwob2awhf8jqpa7c foreign key (beer_id) references beer (id);
alter table review add constraint FKbwjo2uqvc7kcwiktemroulw61 foreign key (beer_id) references beer (id);
alter table review add constraint FKhtrcsmjbqojsy59c8n1yb7tmo foreign key (fan_id) references fan (id);


