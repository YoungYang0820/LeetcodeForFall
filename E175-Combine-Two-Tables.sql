# Write your MySQL query statement below
SELECT FirstName, LastName, City, State from (Person left Join Address on Person.PersonId = Address.PersonId)
