# Sprint-03
## Due March 14th 2019
### Written by Erick Cruz
#### Project Base Requirements  

Each Project will have additional specific details per job to be delivered once project subject is determined:

1. Language and framework of your choice (ITM 311, ITM 312, ITMD 361, ITMD 411) Suggestions:
* JavaScript – NodeJS/React/Express/Firebase
2. Operating System of Choice:
* Ubuntu Linux
- Process of Secrets management (ITMO 456 ITMS 448):
* Referencing:
https://www.hashicorp.com/resources/introduction-vault-whiteboard-armon-dadgar
- Capture of application metrics (ITMO 456):
* Crash Reporting: Crash Reporting creates detailed reports of the errors in your app. Errors are grouped into issues based on having similar stack traces, and triaged by the severity of impact on your users. In addition to automatic reports, you can log custom events to help capture the steps leading up to a crash.

* To report server-side errors, we are going to use Google Stackdriver Error Reporting, which supports Node.js errors.

* Development Status: Firebase allows us to take metrics by showing our development progress.
![Metrics_DB](/diagrams/sprint3_metrics.png "Database Metrics")

* User Analytics: Firebase allows us to view user analytics as shown in the image below.
![UA](/diagrams/sprint3_metrics_2.png "UA")

3. Use of Datastore: firebase
![Firebase](/diagrams/sprint3_firebase.png "Database")


- Realtime: Instead of typical HTTP requests, the Firebase Realtime Database uses data synchronization—every time data changes, any connected device receives that update within milliseconds. Provide collaborative and immersive experiences without thinking about networking code.

- Offline: Firebase apps remain responsive even when offline because the Firebase Realtime Database SDK persists your data to disk. Once connectivity is reestablished, the client device receives any changes it missed, synchronizing it with the current server state.

- Accessible from Client Devices:The Firebase Realtime Database can be accessed directly from a mobile device or web browser; there’s no need for an application server. Security and data validation are available through the Firebase Realtime Database Security Rules, expression-based rules that are executed when data is read or written.

- Scale across multiple database: With Firebase Realtime Database on the Blaze pricing plan, you can support your app's data needs at scale by splitting your data across multiple database instances in the same Firebase project. Streamline authentication with Firebase Authentication on your project and authenticate users across your database instances. Control access to the data in each database with custom Firebase Realtime Database Rules for each database instance.


4. Data encrypted at REST
* Using firebase, data is encrypted, but are currently reviewing docs to understand how encryption process works.
- https://firebase.google.com/docs/database/security/securing-data
- https://firebase.google.com/docs/database/security/user-security

5. Database makes use of master/slave replication (~ITMD 421, ITMD 411)
* Database Schema:
![DB_schema](/diagrams/sprint3_database_scehma.png "Database_schema")
* Relationship Diagrams
![DB_relational](/diagrams/sprint3_relationship_diagram.png "Database_relational")
* Caching layer implementation: Research in progress, Firebase caches the data (in memory) for as long as there is an active listener for that data. Firebase data is retrieved by attaching an asynchronous listener to afirebase.database.Reference.
The listener is triggered once for the initial state of the data and again anytime the data changes.
* Master for database writes & Slave for database reads: Referring to web docs to achieve these two: https://cloud.google.com/sql/docs/mysql/replication/configure-external-replica

6. Use of Responsive design (where applicable) (ITMD 361, ITMD 362)
- Website is consistently responsive.

7. Use of https (ITMS 448, ITMO 456)  
- Self-signed certs: implemented with Cloud flare
- Login authentication mechanism: Use of Google authentication for login
- Firewall
- Authentication Keys (if applicable)
- Seeding of usernames and passwords
- pre-seeding databases/datastores with schema and records (method of automating debian OS and how it stores)

8. Use of user authentication (ITMD 361): As mentioned in point 7, use of O-Auth https://firebase.google.com/docs/auth/web/firebaseui
![O_auth](/diagrams/sprint3_oauth.png "Oauth")
* Must use HTTP Session: NOT Applicable, Firebase uses realtime data synchronization.
* Different UI for Unauthenticated users :
* Must have read/only features for unauthenticated users:
- To achieve this, we will first create a moderator/admin with full CRUD access. From there, we will strip moderator/admin privileges for each individual user and create a whole new UI for the users.
* Different UI for Authenticated users:
* Must have a user account management page (EDIT Page)
* Different UI for Administrative users
* Must have an administrative database dump and restore feature
- As mentioned above, we will create a moderator/admin with a unique UI before we create new users.

https://firebase.google.com/docs/database/security/
* UI is modified per authenticated user via CSS

9. Creation of Dev Environment (local laptop), (ITMO 456)
* Production must always be working according to specification
- see build readme instructions
* Environment must be configurable via scriptable pre-deploy  
* No manual editing or installing
* Initial sprint will implement development via laptop using Packer, Vagrant, and VirtualBox
* Test and Production environments will be built in the next 2 Sprints
* Explanation of UI/UX testing methodology and bug reporting

10. Layout design (ITMD 361, 362, ITMM 471)
* Diagrams of site functionality need to match delivered features
* Diagrams of colors, fonts, and other usability features


11. Management of Visio (or comparable) diagram tool of work flow (ITM 301, ITMO 456)
- Must post at least 10 bugs in final sprint

![flowchart](/diagrams/sprint3_visio.png "flowchart_visio")
12. Management of project progress (ITMM 471)
* Trello / basecamp:
https://trello.com/b/ezTuZBxa/2019-team-04r
* Slack
https://itmt430team-who-group.slack.com
* Github
https://github.com/illinoistech-itm/2019-team-04r
* Github Issues to resolve bug posts from UI/UX tester

![issues](/diagrams/sprint3_issues.png "issues")

13. Team must generate at least 15 real “test” users and proper data to test functionality of a system
* Create multiple login accounts
* User Authentication (pass/fail), using O-Auth login
* Post to database from new user

<hr>

Sprint 3 Report

#### 1. Describe the team members and their functions:
1. Project Manager - Erick Cruz (ecruz6@hawk.iit.edu)* Refined the goals and discussed revisions that are needed per the feedback given from sprint-02
* Delegated new sprint roles and tasks to team members using Trello
* Frequent communication for updates to team members virtually and in person via GroupMe, Google Meet and Slack
* Made sure team members have the application running without any issues with Firebase

2. Developer - Deborah Barndt (dbarndt@hawk.iit.edu)
* Making the Prototype pages responsive
* Research and implement Bootstrap for social network templates
* Make sure Firebase was deployable on everyone's machine
* Finding out why the images do not load on page

3. JR Developer - Brigette Mora (bmora@hawk.iit.edu) & Isabel Jaramillo (ijaramillo@hawk.iit.edu)
* Transition for MongoDB to Firebase
* Database/Encryption Research
* Set up the back-end of Firebase and create instructions on how to deploy it to the server
* Assisted UI/UX with adding minimal functionality to the skeleton HTML and CSS pages and creating additional layouts for additional pages

4. IT Operations - David Delgado (ddelgad5@hawk.iit.edu)
* Assisted team in creating Vagrant and packer files
* Search for security vulnerabilities
* Assist with troubleshooting to resolve deployment issues

5. UI/UX Designer - Martae Marshall (mmarsha5@hawk.iit.edu)
* Created diagrams for database schema and the Entity-Relationship Diagrams
* Assisted in editing of prototype, creating responsive design for the initial page
* Deliberated and help edit updated Bootstrap design of the application
* Created additional page prototypes for the application: account settings, sign up, and post creation

#### Architecture/infrastructure framework
* Language: Javascript (FERN STACK)
* Operation System: Linux/Ubuntu
* Datastore: Firebase
* Task Management: Trello https://trello.com/b/ezTuZBxa/2019-team-04r

#### 2. Describe the groups stated (atomic) goals for the sprint
* Make a Prototype of Website/Account Settings
* Research/Implement use of Packer with Firebase
* Transition from MERN to FERN stack solution
* Adjust frame of pages to stretch entire width of page(if not, look into Bootstrap)
* Create Diagram for Database Schema and ERD
* Research Google Maps API and creating a frame
* Remove Illinois Tech, recommendations, and General Sections for QuadRangle home page application
* Research how to work with Search Bars and implement into QuadRangle app
* Test to ensure that the application with Firebase

A. Describe how many of these initial goals accomplished
* Create Diagrams for Database Schema and ERD
* Test to ensure that the application with Firebase
* Transition from MERN to FERN stack solution
* Adjusting frame of pages to stretch entire width of page

A. Firebase
* Realtime database that does so much heavy lifting for you, you might need to eat more protein.

B. Express
* The web framework used to work in a Node environment on the backend.

C. React
* Front-end Framework using the virtual DOM to make the user experience super fast.

D. Node
* The birthplace of Javascript’s backend experience

B. Describe what you would change or adapt to complete more of these goals.
* Research Firebase documentations (Read/Write for Master/Slave)
* Implement functionality of login page and home page with Firebase

### 3. Describe what was accomplished and why/how
A. List Feature Deployment
* Each member was successful on deploying with Firebase and was able to look at the web application on their localhost:5000.
* Moved from MongoDB to Firebase - Firebase REST endpoints support regular JSON, data was easily transitioned.

B. List Next Spring Goals
* Implementation of users in database
* Work on implementation on web pages with Firebase
* Login authentication using Google O-Auth
* Research on how Firebase is Encrypting/Securing data with Firebase


### 4. Explain and show how bugs were found, tracked, and delegated
* User information was not registration to the database
* Template Images and Custom images were not loading for the web page properly

### 5. Explain any security assumptions made and explain how these were discovered and mitigated

- Secure User Data: Firebase Realtime Database Rules determine who has read and write access to your database, how data is structured, and what indexes exist. These rules live on the Firebase servers and are enforced automatically at all times. Every read and write request will only be completed if your rules allow it. By default, your rules are set to allow only authenticated users full read and write access to your database. This is to protect your database from abuse until you have time to customize your rules or set up authentication.

- (Firebase takes care of this) Authentication: Ensuring that users accessing the web application portal requires valid login credentials such as student ID and password.

#### 6. Each team member should comment on their own accomplishments and describe what they did and explain any decision referencing any lectures or material from the textbook or web.

#### Isabel Jaramillo
- Worked with developers to research and implement new database (Firebase)
- Set up the back-end of Firebase and create instructions on how to deploy it to the server
- Documented additional security measures needed to be considered in project requirements document (see Resources below)  

#### Martae Marshall
- Edited HTML pages to ensure responsive design, pertaining to screen size
- Assisted in the development of Bootstrap design, adding personal logos and branding to it
- Created database schema and entity-relationship diagrams
-  Created additional page prototypes for the application: account settings, sign up, and post creation

#### Deborah Barndt
- Made the prototype html pages responsive to the correct screen sizes
- Researched on various Bootstrap, WordPress, and Open Source social network templates for our QuadRangle app
- Implemented test templates of our QuadRangle app pages to a separate branch
- Research to find out why custom image files and paths are not working on the templates
- Assisted everyone in successfully deploying to Firebase on their machines

#### David Delgado
- Reviewed Packer deployment of Ubuntu on Virtualbox
- Reviewed preseed implementation of unattended install on Ubuntu
- Reviewed Packer configured to deploy preseed
- Setup packer to post-process VM as a box for Vagrant
- Troubleshoot kernel panic on launching boot command for Ubuntu
- Troubleshoot partition prompt for volume size on Ubuntu

#### Erick Cruz
- Troubleshooted application on computer to start
- Worked with team members to see if they had any issues
- Research Firebase documentation on how data will be stores, encrypts, and authenticates users for future goals.

#### Brigette Mora
- Navigated the change from a mern stack to fern stack
- Created framework for the front end
- Troubleshoot the google api - self authenticate function
- Assisted the group on front-end tasks


#### 7. Reference decision from any of the videos, guest lecture, and class presentation, or text book
- Project Requirement Outline:
https://docs.google.com/document/d/1GcbyuxZwRvYTsf6y2E2xbUFYFl9CZlrI92OPa3QnSdU/edit
- HashiCorp Vault:
https://www.hashicorp.com/resources/introduction-vault-whiteboard-armon-dadgar
- Metrics:
https://stackify.com/application-performance-metrics/
- Firebase Documentation:
https://firebase.google.com/docs/auth/web/firebaseui
- Firebase Security Rules:
https://firebase.google.com/docs/database/security/
- Ubuntu Installation Guide:
https://help.ubuntu.com/16.04/installation-guide/amd64/apb.html
- Reference Packer build for Ubuntu 16.04:
https://github.com/geerlingguy/packer-ubuntu-1604
- Ubuntu Preseed Example:
https://help.ubuntu.com/16.04/installation-guide/example-preseed.txt
- Bootstrap Social Network Template:
https://themeforest.net/item/olympus-html-social-network-toolkit/19755363?ref=cirvitis
