# SQL Joins Notes

## Types of Joins
1. INNER JOIN
2. LEFT JOIN
3. RIGHT JOIN
4. FULL JOIN (OUTER JOIN)

---

## 1. INNER JOIN
**Definition:**  
Returns only the **common matching records** between two tables.

## Example Tables
Table X and Table Y

| X.id | X.value | Y.id | Y.value |
|------|---------|------|---------|
| 1    | x1      | 1    | y1      |
| 2    | x2      | 2    | y2      |
| 3    | x3      | 4    | y4      |

### Query:
```sql
SELECT *
FROM X
INNER JOIN Y
ON X.id = Y.id;
```

## Output of INNER QUERY
| id | X.value | Y.value |
|----|---------|---------|
| 1  | x1      | y1      |
| 2  | x2      | y2      |