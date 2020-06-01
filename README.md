# GitSearchApp
![GitHub issues](https://img.shields.io/github/issues/inamjr/GitSearchApp)
![GitHub stars](https://img.shields.io/github/stars/inamjr/GitSearchApp)
![GitHub forks](https://img.shields.io/github/forks/inamjr/GitSearchApp)

An app Which uses the GitHub API to retrieve statistics of the top 25 most starred public Python projects.
The stored data includes the repository ID, name, URL, created date, last push date, description, and the number of stars.

## Installation/SetUp

The project is loosly coupled so the Backend and the Frontend can run independently.

Backend
The sql database was bult with Dbeaver(ide) on an Amazone RDS

The application is a maven project implementing the Spring boot framework.

1) Install Eclipse or any other IDE that Can Run a java file.
2) Clone a copy of the project and open it in your IDE. 
3) click Run to start the application.

Frontend
Its an angular project .
1) Install Visual Studio Code or any other IDE .
2) Clone a copy of the project and open it in your IDE. 
3) Run the application 

```angular
ng serve
```

## Usage

......Backend

All you need to do is connect the Backend to any DataBase of your choice, with the help of anotations.
 Object relational mapping enables you to bind columns to the fields of the entities with this anotations

```java
// Fields Mapped to the Table Columns in the DataBase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="S_ID")
	private int sid;
	
	@Column(name ="Repo_ID")
	private int repoId;
	
	@Column(name ="Name")
	private String name;
	
	@Column( name ="url")
	private String url;
	
	@Column(name ="CREATEDdate")
	private String createdDate;
	
	@Column(name ="LASTPUSHdate")
	private String lastPushDate;
	
	@Column(name ="DESCRIPTION")
	private String description;
	
	@Column(name="NumOFstars")
	private int numOfStars;
```

After connection is established, run the app to populate the database you should have this (as shown below)

![](ImgOfdb.PNG)


......Frontend

When you run this command you should get a web page showing this localhost:4200

```angular
ng serve
```
![](firstpage.PNG)

You can get information from the Database or from the github's rest api when 
you click on the button to fetch the information you should get this table 

![](Gitdata.PNG)
