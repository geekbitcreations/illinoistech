# Final Report

## ITMT 430 2019 - Deborah Barndt

### Sprint 4

1. Accomplishments:
   1. Work on implementation on web pages with Firebase
      1. Fixed a typo in the quad app deployment instructions that created an error and prevented application deployment.
      1. Created the new UI/UX diagrams for the login page, registration page, and the newsfeed page using Adobe XD.
      1. Created the login with Google diagram using Adobe XD.
      1. Updated the view diagrams for the users and admin and potential admin template using Adobe XD.
      1. Created another version of the login view diagram per Google design specifications using Adobe XD.
      1. Took screenshots of the responsive design of the quad app on all available platforms using the developer tools for the sprint report.
   1. Implementation of users in database
      1. Conducted research on the implementation of user in the firebase database being that we had just switched from MongoDB to Firebase in sprint 3 and were still learning about Firebase in the process.
      1. https://firebase.google.com/docs/database
      1. https://firebase.google.com/products/realtime-database
      1. https://www.101apps.co.za/index.php/item/182-firebase-realtime-database-tutorial.html
      1. https://firebase.google.com/docs/auth/users
      1. https://docs.expo.io/versions/latest/guides/using-firebase/
      1. https://www.raywenderlich.com/3-firebase-tutorial-getting-started
      1. https://pamartinezandres.com/lessons-learnt-the-hard-way-using-firebase-realtime-database-c609b52b9afb
      1. https://www.robinwieruch.de/complete-firebase-authentication-react-tutorial/
      1. https://firebase.google.com/docs/database/security/quickstart
      
   1. Login authentication using Google OAuth 2.0
      1. Conducted research on the Google OAuth 2.0 with Firebase being that we had just switched from MongoDB to Firebase in sprint 3 and were still learning about Firebase in the process.
      1. https://firebase.google.com/docs/auth
      1. https://www.oreilly.com/ideas/implement-oauth0-in-15-minutes-with-firebase
      1. https://medium.com/google-cloud/using-google-apis-with-firebase-auth-and-firebase-ui-on-the-web-46e6189cf571
      1. https://developers.google.com/identity/protocols/OAuth2
      1. https://developers.google.com/identity/protocols/OpenIDConnect
      1. https://developers.google.com/identity/sign-in/web/server-side-flow
      1. https://stackoverflow.com/questions/49127092/firebase-custom-oauth2-service-authorization-code

   1. Update our Visio sketch diagrams, since phasing away from initial design
      1. Created new diagram sketches of the login, newsfeed, and registration page using Adobe XD per the new design implementation we decided upon.
      1. ![logingoogle2](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/logingoogle2.png "login google 2")
      1. ![logingoogle](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/logingoogle.png "login google")
      1. ![newsfeed](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/newsfeed.png "newsfeed")
      1. ![loginregister](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/loginregister.png "login register")
      1. ![login](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/login.png "login")

1. Correlate goals:
   1. Work on implementation on web pages with Firebase
   1. Implementation of users in database
   1. Login authentication using Google OAuth 2.0
   1. Update our Visio sketch diagrams, since phasing away from initial design

1. Trello card screenshots:
   1. ![applicationdeployabletrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/applicationdeployable.png "application deployable trello card")

   1. ![deployuitrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/documentframework.png "deploy ui trello card")

   1. ![documentuserauthtrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/documentuserauth.png "document user auth trello card")

   1. ![fixbrokenimagetrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/fixbrokenimage.png "fix broken image trello card")

   1. ![updatevisiotrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/updatevisio.png "update visio trello card")

1. Github code commits:
    1. https://github.com/illinoistech-itm/2019-team-04r/commit/98689c361c77f9880565b8332a863144d224d277

    1. https://github.com/illinoistech-itm/2019-team-04r/commit/478d94a19efeeaf839b18b2a8f9393417c39908b

    1. https://github.com/illinoistech-itm/2019-team-04r/commit/f83e58d5af3426cd7f06765901daa4be8d7003f6

    1. https://github.com/illinoistech-itm/2019-team-04r/commit/58bca9fa00859a584bf5f35b8be8f425d38d6507

    1. https://github.com/illinoistech-itm/2019-team-04r/commit/334447145bfa33c27cc56fbf2746790105533ad3

    1. https://github.com/illinoistech-itm/2019-team-04r/commit/92cb8131fc0aa07aef10a848d77ebde2e2b097f2

    1. https://github.com/illinoistech-itm/2019-team-04r/commit/90103cae3231525efe1e25f9044cc6286f66367a

    1. https://github.com/illinoistech-itm/2019-team-04r/commit/5ebfc54041a0911c5868a833a51d2e763285f095

    1. https://github.com/illinoistech-itm/2019-team-04r/commit/2589449ab48b819bdcc602a241e1d51726a2c8d0

    1. https://github.com/illinoistech-itm/2019-team-04r/commit/a6cafd992cdbea918297b4f6513cc8a20148ab87

### Sprint 5

1. Accomplishments:
   1. Address different UI/UX for admin user, authorized users, and unauthorized users
      1. Conducted research on different admin dashboards for firebase to decide on what we wanted to implement for our admin user and authorized users.
      1. https://github.com/raynstudios/firebase-admin-dashboard
      1. https://github.com/JoeyHengst/AdminFire
      1. http://fireadmin.mobidonia.com/
      1. https://www.quora.com/Is-there-any-admin-dashboard-for-Firebase
      1. Conducted research for help with functions and routing for each of the different views.
      1. https://alligator.io/react/simple-authorization/
      1. https://www.scotchmedia.com/tutorials/express/authentication/2/05/
      1. https://blog.strapi.io/protected-routes-and-authentication-with-react-and-node-js/
      1. https://scotch.io/tutorials/route-middleware-to-check-if-a-user-is-authenticated-in-node-js
      1. Added rewrites for the admin view of the quad app
      1. Re-added the img folder that got deleted by accident to the q_app to get the images to work.
      1. Added our custom logo to the newsfeed page and customized the layout and fixed the title.

   1. Update our Visio sketch diagrams, since phasing away from initial design
      1. Created new diagram sketches of the login, newsfeed, and registration page using Adobe XD per the new design implementation we decided upon.
      1. ![logingoogle2](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/logingoogle2.png "login google 2")
      1. ![logingoogle](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/logingoogle.png "login google")
      1. ![newsfeed](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/newsfeed.png "newsfeed")
      1. ![loginregister](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/loginregister.png "login register")
      1. ![login](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/login.png "login")
1. Correlate goals:
   1. Address different UI/UX for admin user, authorized users, and unauthorized users
   1. Update our Visio sketch diagrams, since phasing away from initial design
1. Trello card screenshots:
   1. ![addressdifferentviewstrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/addressdifferentviews.png "address different views trello card")

   1. ![updatevisiotrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/updatevisio.png "update visio trello card")

   1. ![documentfirebasetrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/documentfirebase.png "document firebase trello card")

1. Github code commits:
   1. https://github.com/illinoistech-itm/2019-team-04r/commit/c24d9c2c42dbd3935a41e4febbbddc9a2363bf46

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/f6d09f294343730a8e75a6d90e4835e5e1cf3b21

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/f9d3b8c4fd9c965563229fec70a42b4248e31e9d

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/e59255778a47ea889b55a621ea3d1fb9fefa3662

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/ba4581a1e77079c5af7e59300000f128df72e6a8

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/d370b6f83b7657e735d14f7162d882d7ad1e1d05

### Sprint 6

1. Accomplishments:
   1. Update view diagrams to the final design to keep consistent
      1. Updated the view diagrams to the final design to keep everything consistent with the final design of the quadrangle application.
      1. ![logingooglefinal](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/logingooglefinal.png "login google final")
      1. ![newsfeedadminfinal](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/newsfeedadminfinal.png "newsfeed admin final")
      1. ![newsfeeduserfinal](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/newsfeeduserfinal.png "newsfeed user final")
   1. Create new diagrams for admin and login view
      1. Created new view diagrams for the admin and login view, including CRUD, using Adobe XD for consistency.
      1. ![logingooglefinal](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/logingooglefinal.png "login google final")
      1. ![newsfeedadminfinaledituser](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/newsfeedadminfinaledituser.png "newsfeed admin final edit user")
      1. ![newsfeedadminfinaladduser](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/newsfeedadminfinaladduser.png "newsfeed admin final add user")
      1. ![newsfeedadminfinal](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/newsfeedadminfinal.png "newsfeed admin final")
   1. Fix the login CSS
      1. Fixed the login CSS styles to bootstrap and implemented the quap app theme and design to the login for consistency.
      1. ![loginpagecss](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/loginpagecss.png "login page css")
   1. Add Firebase database rules and add onto the users
      1. Researched on firebase database rules to implement to firebase store rules for admin users.
      1. https://firebase.google.com/docs/firestore/manage-data/add-data
      1. https://firebase.google.com/docs/auth/admin/manage-users
      1. https://firebase.google.com/docs/admin/setup
      1. https://firebase.google.com/docs/storage/web/delete-files
      1. https://github.com/FirebaseExtended/firechat
      1. https://howtofirebase.com/firebase-security-rules-88d94606ce4a
      1. https://firebase.google.com/docs/auth/admin/custom-claims

   1. Make the CRUD functionality look nice on the admin feed
      1. Created CSS styles for the admin feed to make it consistent with the quad app theme and desired design.
      1. ![adminadduser](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/adminadduser.png "admin add user view")
      1. ![adminedituser](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/adminedituser.png "admin edit user view")
      1. ![adminuserlist](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/adminuserlist.png "admin user list")
      1. ![adminuserlist](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/adminuserlist2.png "admin user list")
   1. Make sure everyone can successfully do vagrant packer build
      1. Met with each of the team members to make sure that every team member could successfully deploy the quad app on their own computers using vagrant packer build.
   1. Setup SSL Certificate
      1. Researched on how to setup SSL certificates for our quad application and discussed option of doing a self-signed certificate with openssl.
      1. https://cloud.google.com/load-balancing/docs/ssl-certificates
      1. https://stackoverflow.com/questions/8169999/how-can-i-create-a-self-signed-cert-for-localhost
      1. https://stackoverflow.com/questions/8169999/how-can-i-create-a-self-signed-cert-for-localhost

1. Correlate goals:
   1. Update view diagrams to the final design to keep consistent
   1. Create new diagrams for admin and login view
   1. Fix the login CSS
   1. Add Firebase database rules and add onto the users
   1. Make the CRUD functionality look nice on the admin feed
   1. Make sure everyone can successfully do vagrant packer build
   1. Setup SSL Certificate

1. Trello card screenshots:
   1. ![fixlogincsstrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/fixlogincss.png "fix login css trello card")

   1. ![firebasedatabaserulestrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/firebasedatabaserules.png "firebase database rules trello card")

   1. ![updatediagramsfinaltrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/updatediagramsfinal.png "update diagrams final trello card")

   1. ![crudadminfeedtrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/crudadminfeed.png "crud admin feed trello card")

   1. ![vagrantpackerbuildtrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/vagrantpackerbuild.png "vagrant packer build trello card")

   1. ![newadminlogindiagramstrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/newadminlogindiagrams.png "new admin login diagrams trello card")

   1. ![documentframeworktrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/documentframework.png "document framework trello card")

   1. ![setupssltrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/setupssl.png "setup ssl trello card")

   1. ![documentostrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/documentos.png "document os trello card")

   1. ![documentsecretstrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/documentsecrets.png "document secrets trello card")

   1. ![documentfirewalltrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/documentfirewall.png "document firewall trello card")

   1. ![documentauthkeystrellocard](https://github.com/illinoistech-itm/dbarndt/blob/master/itmt-430/images/documentauthkeys.png "document auth keys trello card")

1. Github code commits:
   1. https://github.com/illinoistech-itm/2019-team-04r/commit/ccc156a802bce9f19368a6183536305725e59bc4

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/35fadd19899d44ac94a06fcbebf9cb18084b6507

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/d4f7f97f96acc787d0f5750fc94eab7132158a18

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/204c4d8702b798ee73ef5d515ef234458f470865 

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/979ffd7e8e0339ff49d76304c81aa1716a595a02

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/ce256a6223fa6162020739f56d0e722dde3bb109

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/7408466b09fcedecdf5858408e5caf34de928b7a

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/d5d84cac2942b22aad3f6d0a4d85597de4599796

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/3bbd05a405ef40050b48066e08d45b9314002dd1

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/ba166681b0d596e327cd18eea4da3a5342455bef

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/2cf27c2bb78fb1b5cbc284d02077afc7ab041b57

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/a9d05659a38fb1378d2672d708da493cfd8a0e20

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/62a968a90b2db6cc04bd8eb92c1ae5d11b096da0

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/57845d76f9ea0a35bc48bc930dddb4de9cbfdfc9

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/0ae70669ab702b8f3ebc2050dd979d2d5f2de16b

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/0e0c308211a843e78b6147cd34375a781ebbdbdb

   1. https://github.com/illinoistech-itm/2019-team-04r/commit/cd9fc78eef0a75f918607c39ba97bcbe30101def

