<h2>Welcome to Storefront application!  </h2><br>

<p>This application lists liveries (And potentially Vinyl groups) created for Forza Motorsport & Forza Horizon games. </p>

Features: <br>
CRUD: Create, read, update or delete Liveries, Games etc. <br>
REST: Features REST (Documentation not finished) <br>


<h3> How does it work? </h3>
<p> This program has three main controllers: <br>
  <b>UserController</b> takes charge of handling users and their roles, as well as mapping user related sites such as registerNewUser. 
  <b>ApiController</b> keeps up the REST service
  <b>LiveryController</b> is in charge of running the software main pages, as well as listing pages and edit pages.

Notes: <br>


To do (FIX): <br>
No backlog! :D

To do (ADD): <br>
Add Bootstrap CSS for better front end (Low priority) <br>
Add a new user sign up to the login page <br>
Add data validation <br>
Make sure only admins are allowed to CRUD, users are only allowed to read! <br>
Switch to MariaDB (High priority, but easier to test previous steps if on H2) <br>
