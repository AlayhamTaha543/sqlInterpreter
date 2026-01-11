INSERT INTO Employees (Name, Salary) VALUES ('Alice', 60000)
INSERT Employees (Name) VALUES ('Bob')
INSERT INTO Employees VALUES ('Ivy', 95000)
INSERT INTO Employees (Name, Salary, Dept) VALUES ('Frank', NULL, DEFAULT)
INSERT INTO Employees (Name, Salary) VALUES ('Charlie', 70000), ('Dana', 75000), ('Eve', 80000)
INSERT INTO Employees (Name, Salary) VALUES ('Henry', 90000 + 12345)
INSERT INTO Employees DEFAULT VALUES
INSERT INTO Employees (Name, Salary) SELECT Name, Salary FROM OldEmployees WHERE Salary > 80000
INSERT TOP (5) INTO Employees (Name, Salary) SELECT Name, Salary FROM SourceTable

WITH NewHires AS (SELECT 'Kelly' AS Name, 110000 AS Salary UNION ALL SELECT 'Liam', 115000) INSERT INTO Employees (Name, Salary) SELECT Name, Salary FROM NewHires
INSERT INTO Employees (Name, Salary) OUTPUT INSERTED.ID, INSERTED.Name, INSERTED.Salary VALUES ('Noah', 125000)

INSERT INTO Employees (Name, Salary) EXEC GetNewEmployees

INSERT INTO vActiveEmployees (Name, Salary) VALUES ('Quinn', 140000)


INSERT INTO RemoteServer.RemoteDB.dbo.Employees (Name, Salary) VALUES ('Sophia', 150000)

INSERT INTO Employees (Name, Salary) SELECT Name, Salary FROM StagingTable OPTION (LABEL = 'SynapseInsertJob')

BULK INSERT Employees FROM 'C:\Users\kaled\Desktop\plan.csv' WITH (FIELDTERMINATOR = ',', ROWTERMINATOR = '\n', ROWS_PER_BATCH = 10000, TABLOCK)

INSERT INTO Employees (Name) VALUES ('Uma')

INSERT INTO Employees VALUES ()

INSERT TOP (5) PERCENT Employees SELECT * FROM Source
INSERT INTO [Table    With     Spaces] (Column1) VALUES (42)


