-- 5. NOW TEST QUALIFIED NAMES (this might fail)
RENAME TABLE dbo.employees TO dbo.staff;

-- 6. FULLY QUALIFIED (3-part names)
RENAME TABLE mydb.dbo.employees TO mydb.dbo.staff;

-- 7. MIXED QUALIFICATION
RENAME TABLE 
    olddb.table1 TO newdb.table1,
    schema2.table2 TO schema3.table2;