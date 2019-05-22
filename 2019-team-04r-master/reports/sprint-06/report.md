# Sprint-06
## Due May 1st 2019
### Written by Brigette Mora
#### Project Base Requirements 

Each Project will have additional specific details per job to be delivered once project subject is determined and require you to explain your implementation and decisions in these categories:
Each element here where applicable needs a git commit SHA and URL and or a Trello card




1. Language and framework of your choice (ITM 311, ITM 312, ITMD 361, ITMD 411)
* JavaScript is the main language used for this project.  Since we need to use various application solutions, we wanted to make the language is the same throughout the application.  We use Node, Express, Angular, and Firebase which all use JavaScript to operate.  This allows easy of use for every developer on our team.
* For our framework we are using Firebase Hosting to load our web pages.  The initial html file will load all the proper css and js needed to operate the various features of the application.

2. Operating System Platform of Choice (ITM 301, ITMO 456)
* Operating System and Why Chosen
   * Ubuntu 16.04 LTS - We decided to use a popular Linux distribution due to our existing familiarity with it and the abundance of support discussion for the OS.  We also decided to use the [LTS](https://wiki.ubuntu.com/LTS) release of the OS for a safer OS updates.
* Packages:
   * nvm - Node version manager allows us to select a specific relase of Node and node package manager (npm). 
   * Node - Node allows us to use its runtime engine to serve our application content.
   * npm - Node package manager allows our development server to install the required dependencies to run our application.
* Language/Framework packages:
   * Bootstrap - Bootstrap allows the easy sytlizing of web pages using classes that have been preconfigured.  This allows for easier UI/UX design.
   * Firebase - The Firebase dependency allows us to communicate with our cloud functions and databse.
* Implementation and Collection of Application Metrics and Monitoring
   * Firebase allows us to take metrics by showing our development progress.
   ![Metrics_DB](/diagrams/sprint3_metrics.png "Database Metrics")
   * Firebase allows us to view user analytics as shown in the image below.
   * ![UA](/diagrams/sprint3_metrics_2.png "UA")

3. Use of Data Store/Storage (ITMD 421, ITMD 411, ITMO 456)
* Database or similar storage technology
   * With [Firebase](https//firebase.google.com), we can use its NoSQL database that will hold our user and application storage and account preferences.  

4. Data encrypted at rest (ITMS 448)
* Using Google Cloud Technologies, data on the cloud will be encrypted at rest
- https://firebase.google.com/support/privacy/#data_encryption
- https://cloud.google.com/security/encryption-at-rest/

5. Database makes use of master/slave replication (ITMD 421, ITMD 411)
* Schema Creation
   ![DB_schema](/diagrams/sprint3_database_scehma.png "Database_schema")
   ![DB_relational](/diagrams/sprint3_relationship_diagram.png "Database_relational")
* Caching Layer Implementation
   * Firebase resolves this as it is a Backend-as-a-Service (BAAS).
   - https://howtofirebase.com/what-is-firebase-fcb8614ba442
* Master for database writes
   * Firebase resolves this as it is a Backend-as-a-Service (BAAS).
* Slave for database reads
   * Firebase resolves this as it is a Backend-as-a-Service (BAAS).

6. Use of Responsive design (where applicable) (ITMD 361, ITMD 362)
* Explain what framework allows for responsive design in your project
   * Bootstrap allows the stylizing of CSS that contains media queries, and adjusted page layouts based on specific screen sizes.
![Responsive Design](/diagrams/responsive1.png "Responsive Design")
![Responsive Design](/diagrams/responsive2.png "Responsive Design")
![Responsive Design](/diagrams/responsive3.png "Responsive Design")
![Responsive Design](/diagrams/responsive4.png "Responsive Design")
![Responsive Design](/diagrams/responsive5.png "Responsive Design")
![Responsive Design](/diagrams/responsive6.png "Responsive Design")
![Responsive Design](/diagrams/responsive7.png "Responsive Design")

7. Use of https (ITMS 448, ITMO 456)
* Firebase Hosting
- Our production environment is hosted with Firebase Hosting.  Because of this, Firebase automatically provides us with an SSL certificate to allow the use of HTTPS connections to our application.
https://firebase.google.com/docs/hosting/#key_capabilities
* Login authentication mechanism
   * Google Sign-In
     * Describe how you are doing this.
       * We have a button that triggers an event in Javascript that will use Google's authentication API to handle the authentication process for us.  A new window will open loading a Google Sign-in page.  When the user logs in to their account, they will directed to the posts page.
     * Describe how you are securing this.
		   * Using Google Cross-Account Protection, offered through Google
		   * Our security technology helps detect suspicious events to better protect your Google Account. With Cross-Account Protection, we can share security notifications about suspicious events with apps and sites you’ve connected to your Google Account. That way, third-party apps and sites can use Google’s suspicious event detection to help keep you safer online. 
https://support.google.com/accounts/answer/112802?co=GENIE.Platform%3DDesktop&hl=en&oco=1
* Explanation of security assumptions relating to:
	* Firewall – list what ports are open and why
    * In our production environment, we do not need to worry about configuring a firewall as Firebase resolves all our infrastructure needs
    * For our development environement, we need to allow Vagrant to passthrough ports 5000 and 9005.
      * 9005 - Allows the authentication of our admin accounts to Firebase.  This allows us to run commands like `firebase serve` to locally host the application.
      * 5000 - Allows connection to Firebase, allowing the application to be accessible by a web browser.
	* Authentication keys – explain how they are being distributed securely
		* Authentication keys are currently not part of this project scope. If we were to implement auth keys onto our project, we would use them to send unique password reset urls via email. These tokens would be a one-time use only to prevent the reuse of the same key. 
	* Seeding of usernames and passwords – demonstrate with code snippets
		* ![Password Hashing](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/password_hash_parameters.png)
    * With Firebase, we are able to set custom hash parameters to secure our passwords.
	* Pre-seeding databases/datastores with schema and records - demonstrate with cod e snippets
		* ![Firebase Initialize](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/firebaseInitialize.PNG )
    * In order to initialize Firebase, we use a config object in our code to send over the information that is required.
		* ![Firebase pre-seeding](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/preseedingDatabase.PNG )
    * Since our database is hosted on Firebase, we do not need to preseed the database multiple times.  We only need to do it once since the database is persistant.  This allows us to test our developments with actual data.

8. Use of user authentication (ITMD 361)
* Must use HTTP/webserver Session (This controls an authenticated user’s session)
* Different UI for Unauthenticated users - NOT Applicable, as our application will be focused on user authentication
- Must have read/only features for unauthenticated users - NOT Applicable, as our application will be focused on authenticated users.
* Different UI for Authenticated users
![QuadRangle News Feed Page](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/newsfeeduserfinal.png)
![QuadRangle News Feed Page](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/quadfinaluserview.png)
- Must have a user account management page (EDIT Page)
![QuadRangle User Account Management Page](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/userAccountManagement.PNG)
* Different UI for Administrative users
- Must have an administrative database dump and restore feature 
	* With Firebase console, admins are able to reset, disable, and delete user accounts.
  * Additionally, an admin is able to delete posts.
	![Admin News Feed](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/newsfeedadminfinal.png)
	![Admin News Feed](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/newsfeedadminfinaladduser.png)
	![Admin News Feed](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/newsfeedadminfinaledituser.png)
* UI is modified per authenticated user via CSS

9. Creation of Dev Environment (local laptop), (ITMO 456)
* Must work according to specification and have accurate build and access instructions (how I get to your first page) in the root of the repo in the Readme.md
https://github.com/illinoistech-itm/2019-team-04r see “README.md”
* Environment must be configurable via script pre-deploy
- We currently have a script (launch\_app.sh) that goes into the correct directory and launches Firebase after the developer has been authenticated.  The developer is authenticated by opening a URL with a unique key to login to their account.
* No manual editing or installing
- Our Vagrant script (/vagrant/appsetup.sh) is able to install the appropriate packages and download our repository from GitHub.
* Explanation of UI/UX testing methodology
- When a UI/UX developer makes any changes to files, the dev is able to run `firebase serve` (after being authenticated) in order to host the web application locally.  This allows the dev to see their changes without making any commits.  After the dev is satisfied with their changes, they are able to push their commits to the master branch.  Once commited, Vagrant is ready to be deployed for the last testing phase.  Once it has been confirmed that there is no existing VM, the
  dev is able to run `vagrant up` to get a VM prepped with our application.  
* Demonstration of bug reports being filed, tracked, fixed, and closed via Trello cards and GitHub commits
  * https://github.com/illinoistech-itm/2019-team-04r/issues?utf8=%E2%9C%93&q=is%3Aissue+updated%3A%3E2019-04-11
  * ### Issues reported/updated since last sprint:
    - [launch_app.sh missing - build fail](https://github.com/illinoistech-itm/2019-team-04r/issues/46) - Resolved
    - [Firebase serve Unexpected error has occured.](https://github.com/illinoistech-itm/2019-team-04r/issues/45) - Resolved
    - [VM Warning when cloning repo](https://github.com/illinoistech-itm/2019-team-04r/issues/380) - Resolved
    

10. Layout design (ITMD 361, 362, ITMM 471)
* Diagrams of site functionality need to match delivered features – images of individual page renders need to be in the diagrams folder.
Please visit https://github.com/illinoistech-itm/2019-team-04r/tree/master/diagrams to view diagrams
Current blog page will reflect diagram “newsfeeduser.png” in diagrams directory
* Diagrams of colors, fonts, and other usability features
   ![Branding_Guide](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/quadrangle_brandingguide.PNG)

	* https://docs.google.com/document/d/1u-mOGDUYAeGbj9wV6RN139hfKpEvamWT921unzBM2XA/edit?usp=sharing

11. Management of Visio (or comparable) diagram tool of work flow (ITM 301, ITMO 456)
   * Need a diagram that shows the backend layout of all the components, Database/store, caching layer, Webserver, and other parts you may have and their connections overlaid.
	![Visio Diagram](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/sprint3_visio.png)

12. Management of project progress (ITMM 471)
* Trello – correlate completed goals to DONE Trello cards and unfinished goals to in progress Trello cards
   * https://trello.com/b/ezTuZBxa/2019-team-04r
   * ### Completed Goals
     * [Document use of adding firebase rules](https://trello.com/c/3pzs6Tk7/89-firebase-database-rules-and-add-onto-the-users)
     * [Document the implementation of css-responsive design](https://trello.com/c/eIik881l/93-make-crud-look-nice-on-admin-feed)
     * [Document use of creating CRUD](https://trello.com/c/KKZs0WUa/91-create-crud-admin)
     * [Document use of vagrant building](https://trello.com/c/1rgy0p97/94-vagrant-packer-build)


* Slack
   * https://itmt430team-who-group.slack.com
   - Slack is currently being used to monitor GitHub commits and issues.
* Development Environment – What development environments were used by the team members?
   * Visual Studio Code
   * Atom
* GitHub - correlate completed goals to GitHub commits.
   * https://github.com/illinoistech-itm/2019-team-04r

13. Team must generate at least 15 real “test” user data that is inserted upon instance creation and proper data to test functionality of a system
   * No system is ever used “blank” always fill it up with real data. https://github.com/illinoistech-itm/2019-team-04r/commit/35e7f99d80ffa4a8321dd2109c27eae6487f00fa
	![QuadRangle Firebase Test Users](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/firebasetestusers.PNG "QuadRangle Firebase Test Users")
