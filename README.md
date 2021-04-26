# sharedTimeClock
Final Project for CS3200. 

## Overview:
I want to make a time clock for working remotely. I am responsible for reporting my own hours to my company. This program would allow me (and other employees) to track our hours in an intuitive way that can be viewed by higher ups for better project management. 

The benefit to the employee is they don't need to go back an calculate their hours, they just (voluntarily, this would be the worlds shittiest app if employers required this) indicate when they are or aren’t working.


I want an employee to be able to have a stop and start button ( or just console commands) to indicate when they are or aren’t working. When a stop command is issued, the user is prompted to select a Major task (just a reference to a string longer stored somewhere, perhaps on the jobs table) and enter a description of what was being worked on (to create a minor task). If left blank, it should be assumed that the person is continuing with the same minor task as before. 

A manager who is responsible for an employee can view this info. The managers should be able to see a screen with a breakdown of each day, a screen that shows how many hours per week, and one that shows totals for months and the year.

There should be multiple role types, like employees and managers, but also super users who can just see it all.

Projects should be created by managers and admins. 

Minor tasks are children of Projects and are created by anyone, they are a brief description of what is being worked on. 

## Tables:

###Users
⦁	firstName: String
⦁	lastName: String
⦁	username: String
⦁	password: String
⦁	email: String
⦁	dateOfBirth: Date

| Field Name  | Description | Data Type |
|-------------|-------------|-----------|
| firstName   |             | String    |
| lastName    |             | String    |
| userName    |             | String    |
| password    |             | String    |
| email       |             | String    |
| dateOfBirth |             | date      |

Projects
A Project is a long term task. The description is overarching, could be tied to a specific invoice for example. Minor tasks are the children of projects.

| Field Name  | Description                  | Data Type |
|-------------|------------------------------|-----------|
| description | A description of the project | string    |

Users to Projects
Mapping table between users and projects. The role indicates in what role the user is assigned to the project. A project has managers and assignees. Managers manage the project and can query durations of minor tasks to see time an assignee has put toward the project. Assignees work on the projects. There can be multiple managers and multiple assignees. A manager can be an assignee and vice versa. Any role can create a project and assign managers and assignees to it.

Essentially, this is used to dictate how users will be permitted to interact with a project in the final project.

| Field Name | Description                                    | Data Type   |
|------------|------------------------------------------------|-------------|
| role       | What role the user will play for this project. | role_levels |

Roles enum
Contains the different roles a user can have. Not sure what admin is for yet but I think I will use it later when I add more management functionality. This is a portable enum 


| Field Name | Description                                             | Data Type |
|------------|---------------------------------------------------------|-----------|
| level      | I have inserted the values, employee,manager, and admin | string    |


Minor Tasks
Minor tasks are the day to day things you work on for a project. A minor task is associated with a single user and many durations. Minor tasks are like a descriptive parent container for durations. The user who it is associated with is the one who creates it. No other users should be able to add durations to this minor task. 

| Field Name  | Description                     | Data Type |
|-------------|---------------------------------|-----------|
| description | A description of the minor task | string    |

Durations
Durations represent an amount of time spent working. A duration is created when a worker starts work on a minor task. When a user stops working, the duration's end time is updated.  Many durations can be created for a single minor task to allow for stopping and starting. This table will probably change as this project progresses. 


| Field Name    | Description                                                                                                                                                           | Data Type |
|---------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------|
| startTime     | When work was started and the duration was created (default value is current time)                                                                                    | datetime  |
| endTime       | When the work period is ended this time is updated. Probably will be updated via function. Function called, end time is updated. This avoids any time zone confusion. | datetime  |
| timedDuration | The length of time in seconds the client system recorded as work time. This allows for error checking and validation. I don't trust time operations.                  | int       |
 
