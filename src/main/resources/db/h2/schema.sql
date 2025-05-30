DROP TABLE IF EXISTS course ;

CREATE TABLE course (
	course_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	course_name varchar(50)  NOT NULL,
	duration INT NOT NULL
);