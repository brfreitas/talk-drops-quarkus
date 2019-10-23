DROP TABLE IF EXISTS reasons;

CREATE TABLE reasons (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  message VARCHAR(250) NOT NULL
);
 
INSERT INTO reasons (message) VALUES
  ('¯\\_(ツ)_/¯'),
  ('No.'),
  ('No. Breathe and count to 10, start again');
