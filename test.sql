SELECT
  name,
  CASE
    WHEN age < 18 THEN 'minor'
    WHEN age >= 18 THEN 'adult'
  END AS status
FROM users;
