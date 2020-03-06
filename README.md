Hibernate Advance
3/5/2020, Thurs

TRUNCATE TABLE student RESTART IDENTITY;
DROP TABLE student CASCADE;

CREATE TABLE student (
id SERIAL NOT NULL,
first_name CHAR(45),
last_name CHAR(45),
email CHAR(45),
PRIMARY KEY(id)
)

CREATE TABLE image (
student_id INT NOT NULL,
file_name CHAR(45)
)