-- Basic Update
UPDATE Employees SET Salary = 5000 WHERE EmployeeID = 1;

-- Update with TOP
UPDATE TOP (10) Inventory SET Status = 'Restock' WHERE Quantity < 5;

-- Update with FROM and JOIN
UPDATE T1
SET T1.Price = T2.NewPrice
FROM Products T1
JOIN PriceUpdates T2 ON T1.SKU = T2.SKU;

-- Update with OUTPUT
UPDATE Employees
SET Salary = Salary * 1.1
OUTPUT INSERTED.EmployeeID, DELETED.Salary, INSERTED.Salary
WHERE PerformanceRating = 'High';

-- Update with CTE
WITH HighSales AS (SELECT * FROM Sales WHERE Amount > 1000)
UPDATE HighSales SET Commission = Commission + 50;

-- Update with Compound Operators
UPDATE Accounts SET Balance += 100 WHERE AccountID = 505;

-- Multiple statements with semicolons
SELECT * FROM Employees;
UPDATE Employees SET Salary = 6000;
DELETE FROM TempData;