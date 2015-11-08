CREATE TABLE departments
(
  department_id SERIAL,
  departmentName VARCHAR(255) NOT NULL,
  chief VARCHAR(255) NOT NULL,
  speciality VARCHAR(255) NOT NULL,
  primary key (department_id)
)

INSERT INTO departments  (departmentName, chief, speciality) 
VALUES ('Бухгалтерия', 'Иванов Иван Петрович', 'Финансовый учет');
 
INSERT INTO departments  (departmentName, chief, speciality) 
VALUES ('Отдел кадров', 'Степанова Лидия Ивановна', 'Управление персоналом');

INSERT INTO departments  (departmentName, chief, speciality) 
VALUES ('Отдел информационных технологий', 'Смирнов Игорь Васильевич', 'Информационные технологии');

CREATE TABLE employers
(
  employee_id SERIAL,
  firstName VARCHAR(255),
  surName VARCHAR(255),
  patronymic VARCHAR(255),
  dateOfBirth DATE NOT NULL,
  sex CHAR(1),
  department_id int references departments(department_id),
  primary key (employee_id)
);

SET CHARSET utf8;
INSERT INTO employers (firstname, surname, patronymic, dateofbirth, sex, department_id) 
VALUES ('Иван', 'Дмитриев', 'Владимирович','1982-03-12', 'M', 1);

INSERT INTO employers (firstname, surname, patronymic, dateofbirth, sex) 
VALUES ('Степан', 'Сколов', 'Иванович','1987-03-12', 'M');
 
INSERT INTO employers (firstname, surname, patronymic, dateofbirth, sex) 
VALUES ('Петр', 'Кремлев', 'Сергеевич','1978-05-18', 'M');
 
INSERT INTO employers (firstname, surname, patronymic, dateofbirth, sex) 
VALUES ('Татьяна', 'Васильева', 'Алексеевна','1988-06-14', 'Ж');
 
INSERT INTO employers (firstname, surname, patronymic, dateofbirth, sex, department_id) 
VALUES ('Григорий', 'Камаров', 'Владимирович','1987-06-22', 'M', 1);
 
INSERT INTO employers (firstname, surname, patronymic, dateofbirth, sex, department_id) 
VALUES ('Дмитрий', 'Голицин', 'Анатольевич','1986-08-15', 'M', 1);
 
INSERT INTO employers (firstname, surname, patronymic, dateofbirth, sex, department_id) 
VALUES ('Алексей', 'Кузнецов', 'Иванович','1981-03-11', 'M', 2);
 
INSERT INTO employers (firstname, surname, patronymic, dateofbirth, sex, department_id) 
VALUES ('Дмитрий', 'Карнаков', 'Владимирович','1982-04-12', 'M', 2);
 
INSERT INTO employers (firstname, surname, patronymic, dateofbirth, sex, department_id) 
VALUES ('Антон', 'Казаков', 'Сергеевич','1983-05-13', 'M', 2);
 
INSERT INTO employers (firstname, surname, patronymic, dateofbirth, sex, department_id) 
VALUES ('Кирилл', 'Ульянов', 'Константинович','1984-06-14', 'M', 2);

SELECT 
  employers.employee_id,
  employers.firstname,
  employers.surname,
  departments.department_id,
  departments.departmentname 
FROM employers
left join departments ON employers.department_id = departments.department_id;

SELECT * FROM Address AS a 
INNER JOIN city ON a.id=city.id
INNER JOIN country ON a.id=country.id;