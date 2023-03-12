# TodoApp<br>
Back-end for a web app. A user needs to register a  user account with a email address and password.<br> 
After that user needs to sign in for getting a Bearer token. With the token user can get access to rest of the end points of todo app. <br>
<br>
# Features<br>
- Takes user details such as email and password and saves in database when email already doesn't exist in database<br>
- User needs to sing in order to get Bearer token and with Bearer token user can get access to the rest of the api-es
- User can change password when old password matches with the password that exist in the database for the user.<br>
- Created timestamp and updated timestamp for a USER<br>
- PostgreSQL database<br>
- Create a todo item with a descreption <br>
- Update a todo item<br>
- Delete a todo item<br>
- Created time stamp and Updated time stamp for a todo item <br>
<br>

# Instruction <br>
- To run this app after cloning from github. Install PostgresSQL database and create a database. <br>
- Go to the applicaiton.properties in resource folder. Put you own database name and password.<br>
<br>
# Bonus<br>
To test the backends from postman i have includend a file called Postman_collection.json, simply include it to your postman and test it

