# TodoApp<br>
Back-end for a web app. A user needs to register a  user account with a email address and password.<br> 
After that user needs to sign in for getting a Bearer token. With the token user can get access to rest of the end points of todo app. <br>
<br>
#Features<br>
-Takes user details such as email and password and saves in database when email already doesn't exist in database<br>
-User needs to sing in to get Bearer token and with Bearer toekn user can get access to rest of the api-es
- User can change password when Old password and new password matches.
-PostgresQL database<br>
-Create a todo item with descreption <br>
-Update a todo item<br>
-Crated time stamp and Updated time stamp <br>
<br>

#Instruction <br>
To run this app after cloning from github. Install PostgresSQL database and create a database. <br>
Go to the applicaiton.properties in resource folder. Put you own database name and password.<br>
<br>
#Bonous<br>
To test the backends from postman i have includend a file called Postman_collection.json, simple include it to your postman and test it

