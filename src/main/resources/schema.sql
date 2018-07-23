-- DROP DATABASE IF EXISTS manytomany;
-- CREATE DATABASE manytomany;

DROP TABLE IF EXISTS project_employee;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS employees;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
  START 1000;

CREATE TABLE projects
(
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR NOT NULL
);
CREATE UNIQUE INDEX projects_unique_name_idx ON projects (name);

CREATE TABLE employees (
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR NOT NULL
);
CREATE UNIQUE INDEX employees_unique_name_idx ON employees (name);

CREATE TABLE project_employee (

  project_id  INTEGER NOT NULL,
  employee_id INTEGER NOT NULL,
  FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE,
  FOREIGN KEY (employee_id) REFERENCES employees (id) ON DELETE CASCADE,
  PRIMARY KEY (project_id, employee_id)
);

