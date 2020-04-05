<h2>Welcome to Storefront application!  </h2><br>

<p>This application lists liveries (And potentially Vinyl groups) created for Forza Motorsport & Forza Horizon games. </p>

Features: <br>
CRUD: Create, read, update or delete Liveries, Games etc. <br>
REST: Features REST (Documentation not finished) <br>


<h3> How does it work? </h3>
<p> This program has three main controllers: <br>
  <b>UserController</b> takes charge of handling users and their roles, as well as mapping user related sites such as registerNewUser. <br>
  <b>ApiController</b> keeps up the REST service. <br>
  <b>LiveryController</b> is in charge of running the software main pages, as well as listing pages and edit pages.<br>

<h3>Notes: </h3><br>


<h3>To do (FIX): </h3>
<ul>
  <li>Editing user currently broken!</li>
  <li>Add new Java class "Profile" and add ability to add profile pictures to it on register screen</li>
  <li></li>
</ul>
<br>

<h3>To do (ADD): </h3>
Add Bootstrap CSS for better front end (Low priority) <br>
<ul>
  <li>Sticky footer! With at least social icons, github link etc.</li>
  <li>Custom fonts for the UI, maybe Monsterrat?</li>
  <li>New Glacier Repository logo in the same style as Varjo Designs 2020 logo</li>
</ul>
List pages:
<ul>
  <li>Add rich tables features, like filters, expands etc.</li>
  <li>Add profile picture to user who has saved the livery?</li>
  <li>Add pictures for added designs and liveries?</li>
</ul>
Add a new user sign up to the login page <br>
Add data validation <br>
Make sure only admins are allowed to CRUD, users are only allowed to read! <br>
Switch to MariaDB (High priority, but easier to test previous steps if on H2) <br>


<h3> Classes </h3>
Games<br>
Liveries<br>
Users<br>
Vinylgroups<br>
