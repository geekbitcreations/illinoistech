# Sprint-02
## Due February 28, 2019
### Written by Deborah Barndt

#### 1. Describe the team members and their functions:
1. Project Manager - Deborah Barndt (dbarndt@hawk.iit.edu)
* Refined the goals and discussed revisions that are needed per the feedback given from sprint-01
* Delegated new sprint roles and tasks to team members using Trello
* Frequent communication for updates to team members virtually and in person via GroupMe and Slack
* Assisted team with installation and setup of MongoDB, MongoDB Compass, and Postman

2. Developer - Isabel Jaramillo (ijaramillo@hawk.iit.edu)
* Assist with vagrant build working together with jr. developer and IT Operations
* Troubleshoot computer to successfully deploy application on localhost
* Seek out Test Users.
* Research alternative options for database encryption at rest (after learning that we need Mongodb Enterprise to do this which will cost money). References below

3. JR Developer - Brigette Mora (bmora@hawk.iit.edu) & David Delgado (ddelgad5@hawk.iit.edu)
* Fix the error in the infrastructure file with React
* Set up the back-end of MongoDB and create instructions on how to deploy it to the server
* Assisted UI/UX with adding minimal functionality to the skeleton HTML and CSS pages and creating additional layouts for additional pages

4. IT Operations - Martae Marshall (mmarsha5@hawk.iit.edu) 
* Assisted team in creating Vagrant and deployment keys
* Search for security vulnerabilities
* Assist with troubleshooting to resolve deployment issues

5. UI/UX Designer - Erick Cruz (ecruz6@hawk.iit.edu)
* Researched and applied fonts
* Used color contrast checker with font color and background
* Tested vagrant environment if it worked on my machine, troubleshooted issues. 
* Create a visio flowchart to show flow of the web application. See Diagrams Directory
* Tested responsiveness with and without Dev tools

#### Architecture/infrastructure framework
* Language: Javascript (MERN STACK)
* Operation Systems: Linux/Ubuntu
* Datastore: MongoDB
* Task Management: Trello https://trello.com/b/ezTuZBxa/2019-team-04r

#### 2. Describe the groups stated (atomic) goals for the sprint
* Create UI/UX additional layout designs for every page such as font family, content layout, and color scheme
* Create skeletal HTML, CSS, and responsive design for the application
* Revise statement on data quality assurance (from feedback)
* Review authentication description from feedback
* Create a better description of encryption at rest
* Make sure to assign each user to their specific tasks and label them according to position on Trello
* Create a vagrant image for the MongoDB server and the viewing environment
* Add minimal functionality to the working skeleton HTML and CSS pages
* Create a Visio diagram to show flow of the web application
* Fix the error in the infrastructure file with React
* Set up the back-end of MongoDB

A. Describe how many of these initial goals you accomplished
* Make sure to assign each user to their specific tasks and label them according to position on Trello
* Fix the error in the infrastructure file with React
* Set up the back-end of MongoDB
* Create a vagrant image for the MongoDB server and the viewing environment
* Create a Visio diagram to show flow of the web application
* Revise statement on data quality assurance (from feedback)
* Review authentication description from feedback
* Create a better description of encryption at rest

![Visio Flowchart](/diagrams/website_flowchart2.png "Visio Website Flowchart")

![MERN](/diagrams/mern_stack.jpg "Mern_stack_solution")

A. MongoDB

* This database will hold all user and group data (and will probably need to be load balanced and replicated).

B. Node.js

* Node.js will be our runtime environment as our back-end server. Node.js can be handle all our API calls and authentication requests and will interact with our MongoDB server.

C. Express

* Express runs on top of Node.js as a module and can serve as the back-end framework to handle the routing of requests.

D. React

* React will be our front-end library and will take responses from Node.js and create our webpage with all the applicable user data.


B. Describe what you would change or adapt to complete more of these goals.
* Collaborate all resources to help development move along quicker
* Identify who needs help/who has completed tasks to assist those who need help

#### 3. Describe what was accomplished and why/how
A. List feature deployment
* Created vagrant file to set the environment for application deployment and made sure each team member successfully created deployment keys.
* Created a README file with instructions on how to use the vagrant file to set up the environment
* Each team member successfully created their own deployment keys and was able to deploy the web application on their localhost:8000
* Several team members also successfully deployed application on their host machines prior to vagrant 

B. List next Sprints goals
* Continue to work on HTML & CSS for website. (Ensure responsive design)
* Continue to add functionality (JS)
* Build test environment and database
* Create database schema
* Implement alternative data encryption at rest
* Improve npm script by removing unnecessary dependencies


#### 4. Explain and show how bugs were found, tracked, and delegated
* An error was discovered in our infrastructure of the app that included a hidden git file. To fix the error, the hidden file was deleted from the github repo and restarted.
* Application was crashing when trying to deploy it on several computers, leaving each team member to troubleshoot through their own systems.

#### 5. Explain any security assumptions made and explain how these were discovered and mitigated
##### Security considered for our application:
- Input validation: Since users are entering data that will be need to be saved in the database, we will need to scrub the data to make sure that there is no incorrect, incomplete, improperly formatted, or duplicated data in the database. This will include any data that is an input in a form, comment, image, etc.
- Authentication: Ensuring that users accessing the web application portal requires valid login credentials such as student ID and password.
- Encrypt and Protect Data: Storing sensitive data like student IDs, or restricting profile information, and use of HTTPS with an SSL certificate to encrypt traffic. MongoDB allows us to have data encryption at rest for out database. We will also encrypt the data stored on the server hard drives containing any access keys, this will make the hard drives unreadable by anyone who does not have access to the appropriate key or password and ensure that the data is protected.


#### 6. Each team member should comment on their own accomplishments and describe what they did and explain any decisions referencing any lectures or material from the textbook or web.

#### Isabel Jaramillo
- Troubleshoot to ensure application deployed successfully on my system
- Worked with jr. developers and IT operations to configure vagrant
- Seek out test users outside of our team.
- Started to research alternative options for database encryption at rest after learning that we need Mongodb Enterprise to do this which will cost money. References below

#### Martae Marshall
- Assisted with installation of Vagrant files and the deployment of the application to the localhost server, as well as creation of deployment keys
- Met with teammates to provide solutions on npm and node module issues
- Provided insight on MongoDB database functionality

#### Deborah Barndt
- Ensured frequent communication and had weekly meetings to get updates on progress and if anyone needs assistance
- Ensured that the tasks were addressed, assigned, and completed on the Trello board
- Revised select items from feedback on our sprint report for clarification for our next sprint report
- Assisted developers with using MongoDB and the setup of MongoDB Compass, MongoDB Community Edition, and Postman

#### David Delgado
- Created Vagrant configuration file to launch VirtualBox of Ubuntu and to allow bridged ports
- Created script to clone production repository and launch all services
- Created documentation to allow easy deployment of Vagrant
- Reviewed preseeding for Ubuntu Xenial for further Packer builds

#### Erick Cruz
- Applied fonts and used color contrast checker with font color and background.
- Tested vagrant environment if it worked on my machine troubleshoot issues.
- Created a visio flowchart to show flow of web application
- Tested responsiveness with and without Dev tools.

#### Brigette Mora
- Set Up MongoDB database for Client, Admin, and User
- Created Get functions for routes.js
- Developed the fix for package.json
- Tested in run environment


#### 7. Reference decisions from any of the videos, guest lectures, and class presentations, or text book.
- Cloudflare: https://www.cloudflare.com/lp/overview-x/?_bt=308976257439&_bk=cloudflare&_bm=e&_bn=g&_bg=59788572656&gclid=EAIaIQobChMIsqH1-YKp4AIVEbbACh0AmQoJEAAYASAAEgItMPD_BwE
- Install and secure MongoDB: https://www.digitalocean.com/community/tutorials/how-to-install-and-secure-mongodb-on-ubuntu-16-04#part-two-securing-mongodb
- MongoDB Security checklist: https://docs.mongodb.com/manual/administration/security-checklist/
- Software bundle: http://mern.io
- Resources that reflect alternative data encryption: https://docs.mongodb.com/manual/core/security-encryption-at-rest/
https://www.mongodb.com/download-center/enterprise/releases
https://info.townsendsecurity.com/introduction-to-encrypting-data-in-mongodb

