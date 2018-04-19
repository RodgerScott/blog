USE dogs_persons_db;

TRUNCATE dogs;
TRUNCATE persons;

INSERT INTO dogs (age, name, state_residing)
VALUES
  (2, 'Chuck', 'TX'),
  (5, 'Fred', 'OH'),
  (2, 'Bud', 'TN'),
  (2, 'Bailey', 'AL'),
  (4, 'Lexie', 'TX'),
  (10, 'Snickers', 'TX'),
  (6, 'Red', 'FL'),
  (8, 'Barney', 'CA'),
  (1, 'Bowser', 'TX');

INSERT INTO persons (age, name, state_residing)
VALUES
  (22, 'John', 'TX'),
  (35, 'Kyle', 'OH'),
  (12, 'Kevin', 'TN'),
  (52, 'Daniel', 'AL'),
  (74, 'Sharon', 'TX'),
  (10, 'Michael', 'TX'),
  (46, 'Sam', 'FL'),
  (48, 'Cathy', 'CA'),
  (31, 'Bowser', 'TX');