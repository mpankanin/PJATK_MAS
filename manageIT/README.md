### manageIT - web application

This project is based on a GitHub [manageIT](https://github.com/mpankanin/PJATK_MAS.git).


### CI/CD with Auto DevOps

This template is compatible with [Auto DevOps](https://docs.gitlab.com/ee/topics/autodevops/).

If Auto DevOps is not already enabled for this project, you can [turn it on](https://docs.gitlab.com/ee/topics/autodevops/#enabling-auto-devops) in the project settings.

### Database

This project uses PostgreSQL placed in a docker container.

Port: 5432 
Password: dbconnect

### MAS - Mini-project 2

Plain association (OneToMany)
    ProjectTeam - Project 

Association with an attribute (ManyToMany)
    Customer - CustomerOrder - Order

Qualified association (OneToMany)
    Project - Task

Composition (OneToMany)
    Order - Document

### MAS - Mini-project 3

Abstraction and polymorphism
    Person {abstract} - Customer / Employer
    polymorphism - getType() method

Overlapping


Multiple inheritance


Multiple aspect inheritance


Dynamic inheritance