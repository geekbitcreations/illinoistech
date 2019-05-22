# Sprint-01
## Due February 8, 2019
### Written by Isabel Jaramillo

#### 1. Describe the team members and their functions:
1. Project Manager - Isabel Jaramillo (ijaramillo@hawk.iit.edu)
* Created goals and discussed functions and features of application
* Set up initial communication channel using GroupMe
* Delegated tasks to team members using Trello
* Set up meetings to give updates using poll
* Frequent communication for updates to team members via GroupMe
* Assisted developer in reviewing skeletal HTML pages for the web app

2. Developer - Brigette Mora (bmora@hawk.iit.edu)
* Complete first build of framework (MERN stack solution)
* Assist UI/UX Developer with logo and skeletal layout of page

3. JR Developer - Martae Marshall (mmarsha5@hawk.iit.edu) & David Delgado (ddelgad5@hawk.iit.edu)
* Researched and declared architecture/infrastructure model (MERN stack)
* Researched and identified security assumptions
* Assisted UI/UX with design recommendations

4. IT Operations - Erick Cruz (ecruz6@hawk.iit.edu)
* Researched development environments and frameworks
* Identified potential IDE's

5. UI/UX Designer - Deborah Barndt (dbarndt@hawk.iit.edu)
* Started initial app sketches and uploaded them to team drive
* Designed several application logos and started a poll on GroupMe
* Sketched UI for several user perspectives.
* Researched color scheme
<<<<<<< HEAD
=======

#### Architecture/infrastructure framework
* Language: Javascript (MERN STACK)
* Operation Systems: Linux/Ubuntu
* Datastore: MangoDB
* Task Management: Trello https://trello.com/b/ezTuZBxa/2019-team-04r
>>>>>>> 01d72568959759af788f8dce1c843f8fc00468ec

#### 2. Describe the groups stated (atomic) goals for the sprint
* Brainstorm scalable ideas and identify basic app. features
* Create skeletal drawings on sheet of main interface
* Select database & architecture model
* Draw out basic architecture model
* Implement responsive design
* Build Dev environment
* Build responsive skeleton HTML and CSS (Create a starting point)
* Document all work in progress and issues encountered.
* Identify risk factors (Security assumptions)

A. Describe how many of these initial goals you accomplished
* Voted on web app project including minimal features to consider
* Digital and paper sketches drawn out
* Identified risk factors
* Decided on architecture and solution stack (MERN)

![MERN](/diagrams/mern_stack.jpg "Mern_stack_solution")

A. MongoDB

* This database will hold all user and group data (and will probably need to be load balanced and replicated).

B. Node.js

* Node.js will be our run time environment as our back-end server. Node.js can be handle all our API calls and authentication requests and will interact with our MongoDB server.

C. Express

* Express runs on top of Node.js as a module and can serve as the back-end framework to handle the routing of requests.

D. React

* React will be our front-end library and will take responses from Node.js and create our webpage with all the applicable user data.


B. Describe what you would change or adapt to complete more of these goals.
* Collaborate all resources to help development move along quicker
* Identify who needs help/who has completed tasks to assist those who need help
* Host at least 1 or 2 in-person work session (all hands on) meeting with active developers for better communication and collaboration

#### 3. Describe what was accomplished and why/how
A. List feature deployment
* Basic sketches of the web application were presented in a team meeting, which led to recognized that we needed to talk about what features we wanted. (Logo, UI, Color scheme: Stick with blue or green to convey security)

B. List next Sprints goals
* Create general skeleton HTML & CSS page. (Ensure responsive design)
* Add minimal functionality
* Build test environment and database


#### 4. Explain and show how bugs were found, tracked, and delegated
* No bugs were identified yet

#### 5. Explain any security assumptions made and explain how these were discovered and mitigated
##### Security considered for our application:
- Input validation: Since users are entering data that will be need to be saved in the database, we will need to scrub the data to data quality. This includes anything that is an input (form, comment, image, etc).
- Authentication: Ensuring access to portal requires valid login credentials.
- Encrypt and Protect Data: Storing sensitive data like student IDs, or restricting profile information, and use of HTTPS with an SSL certificate to encrypt traffic. MongoDB allows us to have data encryption at rest for out database. We can also encrypt the hard drives of servers that contain any access keys.


#### 6. Each team member should comment on their own accomplishments and describe what they did and explain any decisions referencing any lectures or material from the text book or web.

#### Isabel Jaramillo
- Ensured consistent communication and exchanged up to date ideas, recommendations, and resources.
- Ensured tasks were addressed and completed in Trello
- Researched to learn more about stack solutions
- Brainstormed application security considerations
- Assisted developer in reviewing skeletal HTML pages for the web app
- Identified developer docs we can use to reference during our development time. (See references below)

#### Martae Marshall
- Used color theory to implement a branding scheme for our QuadRangle app
- Discussed project requirements and decided what technologies would be best to implement
- Engaged group interaction via polls to determine application name
- Created skeletal layout for the home page of the application

#### Deborah Barndt
- Researched on color schemes and branding with color theory for our QuadRangle app, and researched on similar applications such as Neighbors by Ring, Nextdoor, etc.
- Discussed the project requirements and technologies that we would want to use for our app
- Created quick hand sketches for layout of the app
- Researched on collaborative prototype apps to create our digital sketches
- Created several logo designs for our winning application name after the vote
- Created skeletal layout for the application pages

#### David Delgado
- Researched and review stack implementations to determine best use case for our project
- Reviewed environment languages to determine which languages allowed each member to work best
- Created project description for initial idea pitch
- Created dev environment notes to further discuss project requirements
- Reviewed mongodb encryption at rest

#### Erick Cruz
- Researched potential environments to deploy our web application.
- Depending on our language we picked and framework - the environment being deployed can be on AWS (Amazon Services), hosting the web application on Ubuntu server or hosting the server with React services.
- Testing environments can be one prod and one test if chosen on AWS. Keeping separate to not have a broken application.

### Brigette Mora
- developed infrastructure utilizing node.js/react/express/mongoDB
- created files/folders necessary for back end
- utilized multiple API's to run web client 

#### 7. Reference decisions from any of the videos, guest lectures, and class presentations, or text book.
- Cloudflare: https://www.cloudflare.com/lp/overview-x/?_bt=308976257439&_bk=cloudflare&_bm=e&_bn=g&_bg=59788572656&gclid=EAIaIQobChMIsqH1-YKp4AIVEbbACh0AmQoJEAAYASAAEgItMPD_BwE
- Install and secure MongoDB: https://www.digitalocean.com/community/tutorials/how-to-install-and-secure-mongodb-on-ubuntu-16-04#part-two-securing-mongodb
- MangoDB Security checklist: https://docs.mongodb.com/manual/administration/security-checklist/
- Software bundle: http://mern.io
