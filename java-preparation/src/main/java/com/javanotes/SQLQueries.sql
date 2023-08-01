--https://www.techbeamers.com/sql-query-questions-answers-for-practice/
--Language: PostgreSQL

CREATE TABLE worker (
    worker_id INTEGER PRIMARY KEY,
    first_name VARCHAR(25),
    last_name VARCHAR(25),
    salary INTEGER,
    joining_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    department VARCHAR(25)
);

INSERT INTO worker
(worker_id, first_name, last_name, salary, joining_date, department) VALUES
                                                                         (001, 'Monika', 'Arora', 100000, '2014-02-14 09:00:00', 'HR'),
                                                                         (002, 'Niharika', 'Verma', 80000, '2014-06-11 09:00:00'::timestamp, 'Admin'),
                                                                         (003, 'Vishal', 'Singhal', 300000, '2014-02-20 09:00:00'::timestamp, 'HR'),
                                                                         (004, 'Amitabh', 'Singh', 500000, '2014-02-20 09:00:00'::timestamp, 'Admin'),
                                                                         (005, 'Vivek', 'Bhati', 500000, '2014-06-11 09:00:00'::timestamp, 'Admin'),
                                                                         (006, 'Vipul', 'Diwan', 200000, '2014-06-11 09:00:00'::timestamp, 'Account'),
                                                                         (007, 'Satish', 'Kumar', 75000, '2014-01-20 09:00:00'::timestamp, 'Account'),
                                                                         (008, 'Geetika', 'Chauhan', 90000, '2014-04-11 09:00:00'::timestamp, 'Admin');


CREATE TABLE bonus (
    worker_ref_id INTEGER,
    bonus_amount INTEGER,
    bonus_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (worker_ref_id) REFERENCES worker(worker_id) ON DELETE CASCADE
);

INSERT INTO bonus
(worker_ref_id, bonus_amount, bonus_date) VALUES (001, 5000, '2016-02-20'),
                                                 (002, 3000, '2016-06-11'),
                                                 (003, 4000, '2016-02-20'),
                                                 (001, 4500, '2016-02-20'),
                                                 (002, 3500, '2016-06-11');

CREATE TABLE title (
    worker_ref_id INTEGER,
    worker_title VARCHAR,
    affected_from TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (worker_ref_id) REFERENCES worker(worker_id) ON DELETE CASCADE
);

INSERT INTO title
(worker_ref_id, worker_title, affected_from) VALUES
                                                 (001, 'Manager', '2016-02-20 00:00:00'),
                                                 (002, 'Executive', '2016-06-11 00:00:00'),
                                                 (008, 'Executive', '2016-06-11 00:00:00'),
                                                 (005, 'Manager', '2016-06-11 00:00:00'),
                                                 (004, 'Asst. Manager', '2016-06-11 00:00:00'),
                                                 (007, 'Executive', '2016-06-11 00:00:00'),
                                                 (006, 'Lead', '2016-06-11 00:00:00'),
                                                 (003, 'Lead', '2016-06-11 00:00:00');


--Ques
-----

--1) Write an SQL query to fetch “FIRST_NAME” from the Worker table using the alias name <WORKER_NAME>.
SELECT first_name AS WORKER_NAME FROM worker;

--2) Write an SQL query to fetch “FIRST_NAME” from the Worker table in upper case.
SELECT UPPER(first_name) FROM worker;

--3) Write an SQL query to fetch unique values of DEPARTMENT from the Worker table.
SELECT distinct(department) FROM worker;

--4) Write an SQL query to print the first three characters of FIRST_NAME from the Worker table.
SELECT substring(first_name, 1,3) FROM worker;

--5) Write an SQL query to find the position of the alphabet (‘a’) in the first name column ‘Amitabh’ from the Worker table.
SELECT position('a' IN first_name) FROM worker WHERE first_name='Amitabh';

--6) Write an SQL query to print the FIRST_NAME from the Worker table after removing white spaces from the right side.
SELECT TRIM(first_name) FROM worker;

--7) Write an SQL query to print the DEPARTMENT from the Worker table after removing white spaces from the left side.
SELECT LTRIM(department) FROM worker;

--8) Write an SQL query that fetches the unique values of DEPARTMENT from the Worker table and prints its length.
SELECT DISTINCT LENGTH(department) FROM worker;

--9) Write an SQL query to print the FIRST_NAME from the Worker table after replacing ‘a’ with ‘A’.
SELECT replace(first_name, 'a', 'A') FROM worker;

--10) Write an SQL query to print the FIRST_NAME and LAST_NAME from the Worker
    --table into a single column COMPLETE_NAME. A space char should separate them.
SELECT first_name ||' '|| worker.last_name AS full_name FROM worker;

--11) Write an SQL query to print all Worker details from the Worker table order by FIRST_NAME Ascending.
SELECT * FROM worker ORDER BY first_name;

--12) Write an SQL query to print all Worker details from the Worker table order by FIRST_NAME Ascending and DEPARTMENT Descending.
SELECT * FROM worker ORDER BY first_name, department DESC;

--13) Write an SQL query to print details for Workers with the first names “Vipul” and “Satish” from the Worker table.
SELECT * FROM worker WHERE first_name IN('Vipul','Satish');

--14) Write an SQL query to print details of workers excluding first names, “Vipul” and “Satish” from the Worker table.
SELECT * FROM worker WHERE first_name NOT IN ('Vipul','Satish');

--15) Write an SQL query to print details of Workers with DEPARTMENT name as “Admin”.
SELECT * FROM worker WHERE department='Admin';

--16) Write an SQL query to print details of the Workers whose FIRST_NAME contains ‘a’.
SELECT * FROM worker WHERE first_name LIKE '%a%';

--17) Write an SQL query to print details of the Workers whose FIRST_NAME ends with ‘a’.
SELECT * FROM worker WHERE first_name LIKE '%a';

--18) Write an SQL query to print details of the Workers whose FIRST_NAME ends with ‘h’ and contains six alphabets.
SELECT * FROM worker WHERE first_name LIKE '_____h';

--19) Write an SQL query to print details of the Workers whose SALARY lies between 100000 and 500000.
SELECT * FROM worker WHERE salary BETWEEN 100000 AND 500000;

--20) Write an SQL query to print details of the Workers who joined in Feb’2014.
SELECT * FROM worker WHERE EXTRACT(YEAR FROM joining_date)='2014' AND EXTRACT(MONTH FROM joining_date)='2';

--21) Write an SQL query to fetch the count of employees working in the department ‘Admin’.
SELECT count(*) AS admin_department_count FROM worker where department='Admin';

--22) Write an SQL query to fetch worker names with salaries >= 50000 and <= 100000.
SELECT * FROM worker WHERE salary>=50000 AND salary<=100000;

--23) Write an SQL query to fetch the no. of workers for each department in descending order.
SELECT DISTINCT department, count(worker_id) AS dep_count FROM worker GROUP BY department ORDER BY dep_count DESC;

--24) Write an SQL query to print details of the Workers who are also Managers.
SELECT worker_id, first_name, last_name, salary, joining_date, department, worker_title FROM worker
    INNER JOIN title ON worker.worker_id = title.worker_ref_id WHERE worker_title='Manager';


--25) Write an SQL query to fetch duplicate records having matching data in some fields of a table.
SELECT worker_title, affected_from, COUNT(*) FROM title GROUP BY worker_title, affected_from HAVING COUNT(*) > 1;