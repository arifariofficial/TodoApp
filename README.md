# TodoApp

Back-end for a web app. A user needs to register a  user account with a email address and password.
After that user needs to sign in for getting a Bearer token. With the token user can get access to rest of the end points of todo app.

## Features

- Takes user details such as email and password and saves in database when email already doesn't exist in database
- User needs to sing in order to get Bearer token and with Bearer token user can get access to the rest of the api-es
- User can change password when old password matches with the password that exist in the database for the user.
- Created timestamp and updated timestamp for a USER
- PostgreSQL database
- Create a todo item with a descreption
- Update a todo item
- Delete a todo item
- Created time stamp and Updated time stamp for a todo item

## Instruction

- To run this app after cloning from github. Install PostgresSQL database and create a database.
- Go to the applicaiton.properties in resource folder. Put you own database name and password.

## Bonus

To test the backends from postman i have includend a file called Postman_collection.json, simply include it to your postman and test it
