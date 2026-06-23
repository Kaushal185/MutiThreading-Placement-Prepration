# SQL Interview Preparation Guide

## Level 1: Basic Queries

SELECT e.emp_name, d.dept_name
FROM employee e
JOIN department d ON e.dept_id = d.dept_id;

SELECT emp_name, salary
FROM employee
ORDER BY salary DESC;

SELECT *
FROM project
WHERE budget > 100000;

SELECT e.emp_name
FROM employee e
JOIN department d ON e.dept_id = d.dept_id
WHERE d.dept_name = 'IT';

SELECT dept_id, COUNT(*) AS total_employees
FROM employee
GROUP BY dept_id;

## Level 2: Joins

SELECT e.emp_name, d.dept_name
FROM employee e
LEFT JOIN department d ON e.dept_id = d.dept_id;

SELECT e.emp_name AS employee, m.emp_name AS manager
FROM employee e
INNER JOIN employee m ON e.manager_id = m.emp_id;

SELECT e.emp_name, p.project_name
FROM employee e
LEFT JOIN employee_project ep ON e.emp_id = ep.emp_id
LEFT JOIN project p ON ep.project_id = p.project_id;

SELECT e.emp_name
FROM employee e
LEFT JOIN employee_project ep ON e.emp_id = ep.emp_id
WHERE ep.project_id IS NULL;

SELECT p.project_name, COUNT(ep.emp_id) AS employee_count
FROM project p
LEFT JOIN employee_project ep ON p.project_id = ep.project_id
GROUP BY p.project_id, p.project_name;

## Level 3: GROUP BY

SELECT dept_id, AVG(salary) FROM employee GROUP BY dept_id;

SELECT dept_id, COUNT(*) FROM employee GROUP BY dept_id HAVING COUNT(*) > 2;

SELECT dept_id, MAX(salary) FROM employee GROUP BY dept_id;

SELECT dept_id, AVG(salary) FROM employee GROUP BY dept_id HAVING AVG(salary) > 50000;

SELECT project_id, COUNT(emp_id) FROM employee_project GROUP BY project_id;

## Level 4: Subqueries

SELECT emp_name FROM employee WHERE salary > (SELECT AVG(salary) FROM employee);

SELECT MAX(salary) FROM employee WHERE salary < (SELECT MAX(salary) FROM employee);

SELECT e.emp_name
FROM employee e
WHERE e.salary > (
SELECT m.salary FROM employee m WHERE e.manager_id = m.emp_id
);

SELECT * FROM employee
WHERE dept_id = (
SELECT dept_id FROM employee GROUP BY dept_id ORDER BY AVG(salary) DESC LIMIT 1
);

SELECT * FROM project
WHERE budget > (SELECT AVG(budget) FROM project);

## Level 5: Advanced

SELECT e.emp_id, e.emp_name
FROM employee e
JOIN employee_project ep ON e.emp_id = ep.emp_id
GROUP BY e.emp_id, e.emp_name
HAVING COUNT(ep.project_id) > 1;

SELECT d.dept_name
FROM department d
LEFT JOIN employee e ON d.dept_id = e.dept_id
WHERE e.emp_id IS NULL;

SELECT emp_id, emp_name, salary
FROM employee
ORDER BY salary DESC
LIMIT 3;

SELECT emp_id FROM employee_project GROUP BY emp_id ORDER BY COUNT(project_id) DESC LIMIT 1;

SELECT project_id FROM employee_project GROUP BY project_id ORDER BY COUNT(emp_id) DESC LIMIT 1;

SELECT DISTINCT e.emp_id, e.emp_name
FROM employee e
JOIN employee d ON e.emp_id = d.manager_id;

SELECT emp_name FROM employee WHERE manager_id IS NULL;

SELECT dept_id, SUM(salary) FROM employee GROUP BY dept_id ORDER BY SUM(salary) DESC LIMIT 1;

SELECT emp_id
FROM employee_project
GROUP BY emp_id
HAVING COUNT(DISTINCT project_id) = (SELECT COUNT(*) FROM project);

## Level 6: Very Advanced

SELECT dept_id, salary, COUNT(*) FROM employee GROUP BY dept_id, salary HAVING COUNT(*) > 1;

SELECT salary, COUNT(*) FROM employee GROUP BY salary HAVING COUNT(*) > 1;

SELECT salary FROM employee ORDER BY salary DESC LIMIT 1 OFFSET 1;

SELECT e.*
FROM employee e
JOIN (SELECT dept_id, AVG(salary) avg_salary FROM employee GROUP BY dept_id) d
ON e.dept_id = d.dept_id
WHERE e.salary > d.avg_salary;

SELECT dept_id FROM employee GROUP BY dept_id HAVING MIN(salary) >= 30000;

SELECT e.emp_id, e.emp_name
FROM employee e
JOIN employee_project ep ON e.emp_id = ep.emp_id
WHERE e.salary > 50000
GROUP BY e.emp_id, e.emp_name
HAVING COUNT(ep.project_id) >= 2;
