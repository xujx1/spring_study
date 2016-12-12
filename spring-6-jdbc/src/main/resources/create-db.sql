CREATE TABLE user (
  id        IDENTITY PRIMARY KEY,
  username VARCHAR(30),
  enabled INT (1),
  password  VARCHAR(50),
  role  VARCHAR(50)
);