# Sprint-04
## Due April 5th 2019
### Written by Martae Marshall
#### Project Base Requirements 

Each Project will have additional specific details per job to be delivered once project subject is determined and require you to explain your implementation and decisions in these categories:
Each element here where applicable needs a git commit SHA and URL and or a Trello card

1. Language and framework of your choice (ITM 311, ITM 312, ITMD 361, ITMD 411)
* JavaScript – NodeJS/React/Express/Firebase

2. Operating System Platform of Choice (ITM 301, ITMO 456)
* Operating System and Why Chosen
   * Ubuntu Linux 16.04 - A free, secure and open-source operating system that allows for customization of system environments
* Packages:
   * N/A
* Language/Framework packages:
   * Bootstrap
   * Firebase
* Implementation and Collection of Application Metrics and Monitoring
   * Firebase allows us to take metrics by showing our development progress.
   ![Metrics_DB](/diagrams/sprint3_metrics.png "Database Metrics")
   * Firebase allows us to view user analytics as shown in the image below.
   * ![UA](/diagrams/sprint3_metrics_2.png "UA")

3. Use of Data Store/Storage (ITMD 421, ITMD 411, ITMO 456)
* Database or similar storage technology
   * Firebase http://firebase.google.com/

4. Data encrypted at rest (ITMS 448)
* Using Google Cloud Technologies, data will be encrypted by sets of master keys
https://stackoverflow.com/questions/35708611/firebase-encryption-at-rest/35709006#35709006
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
   * Bootstrap has CSS in which contains media queries, and adjusted page layouts based on specific screen sizes.
![Responsive Design](/diagrams/responsive1.png "Responsive Design")
![Responsive Design](/diagrams/responsive2.png "Responsive Design")
![Responsive Design](/diagrams/responsive3.png "Responsive Design")
![Responsive Design](/diagrams/responsive4.png "Responsive Design")
![Responsive Design](/diagrams/responsive5.png "Responsive Design")
![Responsive Design](/diagrams/responsive6.png "Responsive Design")
![Responsive Design](/diagrams/responsive7.png "Responsive Design")

7. Use of https (ITMS 448, ITMO 456)
* Self-signed Certs
	* We previously considered using Cloudflare until we learned that it would require us to buy a domain. Going forward, we are considering making our own Self-Signed Certificate (using openSSL may be an option but not finalized at this point in time).
* Login authentication mechanism
   * Google Sign-In
       * Describe how you are doing this.
		* Having an HTML button that, when clicked on, will call upon Google. There, the user will login with their Google credentials in order to access the page.
       * Describe how you are securing this.
		* Using Google Cross-Account Protection, offered through Google
		* Our security technology helps detect suspicious events to better protect your Google Account. With Cross-Account Protection, we can share security notifications about suspicious events with apps and sites you’ve connected to your Google Account. That way, third-party apps and sites can use Google’s suspicious event detection to help keep you safer online. 
https://support.google.com/accounts/answer/112802?co=GENIE.Platform%3DDesktop&hl=en&oco=1
* Explanation of security assumptions relating to:
	* Firewall – list what ports are open and why
   		* 5000 - allows connection to Firebase, allowing information to be read and written into a database
	* Authentication keys – explain how they are being distributed securely
		* We are considering using authentication keys when resetting user passwords.
		https://firebase.google.com/docs/auth/#key_capabilities
	* Seeding of usernames and passwords – demonstrate with code snippets
		* ![Password Hashing](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/password_hash_parameters.png)
	* Pre-seeding databases/datastores with schema and records - demonstrate with code snippets
		* ![Firebase Initialize](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/firebaseInitialize.PNG )
		* ![Firebase pre-seeding](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/preseedingDatabase.PNG )

8. Use of user authentication (ITMD 361)
* Must use HTTP/webserver Session (This controls an authenticated user’s session)
* Different UI for Unauthenticated users - NOT Applicable, as our application will be focused on user authentication
- Must have read/only features for unauthenticated users - NOT Applicable, as our application will be focused on user authentication
* Different UI for Authenticated users
![QuadRangle News Feed Page](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/quadnewsfeed.PNG)
- Must have a user account management page (EDIT Page)
![QuadRangle User Account Management Page](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/userAccountManagement.PNG)
* Different UI for Administrative users
- Must have an administrative database dump and restore feature 
	* Can edit, update and delete members with Firebase
	* UI page dedicated to Admin users is NOT Applicable at the time of this sprint
	![Admin News Feed](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/newsfeedadmin.png)
* UI is modified per authenticated user via CSS

9. Creation of Dev Environment (local laptop), (ITMO 456)
* Must work according to specification and have accurate build and access instructions (how I get to your first page) in the root of the repo in the Readme.md
https://github.com/illinoistech-itm/2019-team-04r see “README.md”
* Environment must be configurable via script pre-deploy
* No manual editing or installing
* Explanation of UI/UX testing methodology
* Demonstration of bug reports being filed, tracked, fixed, and closed via Trello cards and GitHub commits
	* https://github.com/illinoistech-itm/2019-team-04r/issues?q=is%3Aopen+is%3Aissue
	* https://github.com/illinoistech-itm/2019-team-04r/issues?q=is%3Aissue+is%3Aclosed

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

* Slack
   * https://itmt430team-who-group.slack.com
* Development Environment – What development environments were used by the team members?
   * Visual Studio Code
   * Atom
* GitHub - correlate completed goals to GitHub commits.
   * https://github.com/illinoistech-itm/2019-team-04r
	* Completed Goals - w/ commits verifying
		* Implementation of users in database
		* Work on implementation on web pages with Firebase
		* Login authentication using Google OAuth 2.0
		* Research on how Firebase is Encrypting/Securing data with Firebase

		* https://github.com/illinoistech-itm/2019-team-04r/commits/master
		* https://github.com/illinoistech-itm/2019-team-04r/commits/master?after=5ebfc54041a0911c5868a833a51d2e763285f095+104
		* https://github.com/illinoistech-itm/2019-team-04r/commits/master?before=5ebfc54041a0911c5868a833a51d2e763285f095+105
		* https://github.com/illinoistech-itm/2019-team-04r/commits/master?before=5ebfc54041a0911c5868a833a51d2e763285f095+70
		* https://github.com/illinoistech-itm/2019-team-04r/commits/master?before=5ebfc54041a0911c5868a833a51d2e763285f095+35

* GitHub Issues resolve bug posts from UI/UX tester
* List all open bugs, closed bugs and who they were assigned to by the PM
	* Bug resolved, assigned to Deborah: https://github.com/illinoistech-itm/2019-team-04r/issues/23
	* Bug resolved, assigned to Deborah: https://github.com/illinoistech-itm/2019-team-04r/issues/24
	* Bug resolved, assigned to David: https://github.com/illinoistech-itm/2019-team-04r/issues/31
	* Bug resolved, assigned to David: https://github.com/illinoistech-itm/2019-team-04r/issues/32
	* Bug unresolved, assigned to David and Erick: https://github.com/illinoistech-itm/2019-team-04r/issues/33
	* Bug resolved, assigned to David and Erick: https://github.com/illinoistech-itm/2019-team-04r/issues/34
	* Bug unresolved, assigned to David and Erick: https://github.com/illinoistech-itm/2019-team-04r/issues/38

13. Team must generate at least 15 real “test” user data that is inserted upon instance creation and proper data to test functionality of a system
   * No system is ever used “blank” always fill it up with real data. https://github.com/illinoistech-itm/2019-team-04r/commit/35e7f99d80ffa4a8321dd2109c27eae6487f00fa
	![QuadRangle Firebase Test Users](https://github.com/illinoistech-itm/2019-team-04r/blob/master/diagrams/firebasetestusers.PNG "QuadRangle Firebase Test Users")

14. Plans for Future Sprint(s)
* Listen for UID Personalization of user accounts
* Implement Bootstrap CSS (for rest of UI/UX pathway)
* Specifying only IIT emails access to create an account to this app
* Create the Admin UI to deploy to our application
* Implement self-signed certificates to our application
