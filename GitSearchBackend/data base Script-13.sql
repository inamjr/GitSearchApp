CREATE table Stat(
S_ID int Primary key AUTO_INCREMENT,
Repo_ID int,
Name varchar(2000),
url varchar (10000),
CREATEDdate varchar (2000),
LASTPUSHdate varchar (2000),
DESCRIPTION varchar(10000),
NumOFstars int
); 

Drop Table Stat;

TRUNCATE TABLE Stat;