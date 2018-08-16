drop table if exists Course_Student;
drop table if exists Student;
drop table if exists Course;
drop table if exists Teacher;
create table Teacher (    
id int primary key not null auto_increment,    
first_name varchar(45) not null,    
last_name varchar(45) not null,    
designation varchar(45) not null );

create table Course (  
id int primary key not null auto_increment,  
name varchar(45) not null,  
credits int not null,  
Teacher_id int  null,  
CONSTRAINT FK_Teacher FOREIGN KEY (Teacher_id) REFERENCES Teacher(id) );

create table Student (    
id int primary key not null auto_increment,    
first_name varchar(45) not null,   
 last_name varchar(45) not null,    
enrolled_since long not null ); 

create table Course_Student (    
course_id int not null,    
student_id int not null,    
primary key(course_id, student_id),    
constraint Fk_Course foreign key (course_id) references Course(id),    constraint Fk_Student foreign key (student_id) references Student(id) );
