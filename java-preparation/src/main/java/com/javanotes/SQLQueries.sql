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

--26) Write an SQL query to show only odd rows from a table.
SELECT * FROM worker WHERE MOD(worker_id, 2) <> 0;

--27) Write an SQL query to show only even rows from a table.
SELECT * FROM worker WHERE MOD(worker_id, 2) = 0;

--28) Write an SQL query to clone a new table from another table.
SELECT * INTO workerclone FROM worker;
SELECT * INTO workerclone2 FROM worker WHERE 1 = 0;
CREATE TABLE workerclone3 (LIKE worker);
CREATE TABLE workerclone4 AS SELECT * FROM worker WHERE NOT EXISTS (SELECT 1 FROM worker);

--29) Write an SQL query to fetch intersecting records of two tables.
SELECT * FROM worker INTERSECT SELECT * FROM workerclone;

--30) Write an SQL query to show records from one table that another table does not have.
SELECT * FROM workerclone EXCEPT SELECT * FROM worker;

--31) Write an SQL query to show the current date and time.
SELECT CURRENT_TIME;
SELECT CURRENT_TIMESTAMP;
SELECT CURRENT_TIMESTAMP AT TIME ZONE 'America/New_York';
SELECT NOW();

--32) Write an SQL query to show the top 5 records of a table.
SELECT * FROM worker ORDER BY salary DESC LIMIT 5;

--33) Write an SQL query to determine the nth (say n=5) highest salary from a table.
SELECT salary FROM worker ORDER BY salary DESC OFFSET (5-1) FETCH FIRST 1 ROW ONLY;

--34) Write an SQL query to determine the 5th highest salary without using the TOP or limit method.
SELECT salary FROM worker w1 WHERE 4=( SELECT COUNT(DISTINCT (w2.salary)) FROM worker w2 WHERE w2.salary >= w1.salary);

--35) Write an SQL query to fetch the list of employees with the same salary.
SELECT DISTINCT w.worker_id, w.first_name || ' ' || w.last_name AS full_name, w.salary
FROM worker w, worker w1 WHERE w.salary = w1.salary AND w.worker_id != w1.worker_id;

--36) Write an SQL query to show the second-highest salary from a table.
SELECT MAX(salary) FROM worker WHERE salary NOT IN (SELECT MAX(salary) FROM worker);

--37) Write an SQL query to show one row twice in the results from a table.
SELECT first_name, department FROM worker w WHERE w.department = 'HR'
UNION ALL
SELECT first_name, department FROM worker w1 WHERE w1.department = 'HR';

--38) Write an SQL query to fetch intersecting records of two tables.
SELECT * FROM worker INTERSECT SELECT * FROM workerclone;

--39) Write an SQL query to fetch the first 50% of records from a table.
SELECT * FROM worker WHERE worker_id <= (SELECT count(worker_id)/2 FROM worker);

--40) Write an SQL query to fetch the departments that have less than five people in them.
SELECT department, count(worker_id) AS dept_count FROM worker GROUP BY department HAVING count(worker_id) < 5;

--41) Write an SQL query to show all departments along with the number of people in there.
SELECT department, count(worker_id) AS worker_count FROM worker GROUP BY department;

--42) Write an SQL query to show the last record from a table.
SELECT * FROM worker WHERE worker_id = (SELECT MAX(worker_id) FROM worker);

--43) Write an SQL query to fetch the first row of a table.
SELECT * FROM worker WHERE worker_id=(SELECT MIN(worker_id) FROM worker);

--44) Write an SQL query to fetch the last five records from a table.
SELECT * FROM worker ORDER BY worker_id DESC LIMIT 5;

--45) Write an SQL query to print the name of employees having the highest salary in each department.
SELECT t.department, t.first_name, t.Salary FROM ( SELECT MAX(salary) as total_salary,
    department from worker GROUP BY department) AS temp INNER JOIN worker t ON
    temp.department=t.department AND temp.total_salary=t.salary;


--46) Write an SQL query to fetch three max salaries from a table.
SELECT DISTINCT salary from worker w WHERE 3 >=
(SELECT count(DISTINCT salary) from worker w1 WHERE w.salary <= w1.Salary) order by w.salary DESC;

--47) Write an SQL query to fetch three min salaries from a table.
SELECT DISTINCT salary FROM worker w WHERE 3 >= (SELECT count(DISTINCT salary)
    FROM worker w1 WHERE w.salary >= w1.salary) ORDER BY w.salary DESC;

--48) Write an SQL query to fetch nth max salaries from a table.
SELECT DISTINCT salary from worker w WHERE n >=
(SELECT count(DISTINCT Salary) from worker w1 WHERE w.Salary <= w1.Salary) ORDER BY w.salary DESC;

--49) Write an SQL query to fetch departments along with the total salaries paid for each of them.
SELECT department, SUM(salary) from worker GROUP BY department;

--50) Write an SQL query to fetch the names of workers who earn the highest salary.
SELECT first_name, salary FROM worker WHERE salary=(SELECT max(salary) from worker);