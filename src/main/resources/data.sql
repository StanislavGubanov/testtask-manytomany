INSERT INTO projects (id, name) VALUES
  (10, 'Project 1'),
  (11, 'Project 2'),
  (12, 'Project 3'),
  (13, 'Project 4'),
  (14, 'Project 5');

INSERT INTO employees (id, name) VALUES
  (100, 'Ada Lovelace'),
  (101, 'Donald Knuth'),
  (102, 'Brian Kernighan'),
  (103, 'Linus Torvalds'),
  (104, 'Tim Berners-Lee');

INSERT INTO project_employee (project_id, employee_id) VALUES
  (10, 100), (10, 103),
  (11, 103),
  (12, 104),
  (13, 102), (13, 103), (13, 104) ;

