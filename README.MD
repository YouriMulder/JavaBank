# Java Bank
This is repository contains code for the java assignment of the Capgemini java training.

# dependencies
Before cloning the project you should install the following dependencies.

- Java 17/18
- Tomcat server
- Maven
- Docker
    - PostgreSQL container (https://hub.docker.com/_/postgres)
- IDE of choice (Used Intellij)

# Install
- import project into IDE
- Change the application.properties to connect to your PostgreSQL database.
- Configure the tomcat server (Tested with Smart Tomcat plugin in Intellij)
- Run the application to automaticly create the schema's in the database.
- Manually execute the sql in the data.sql file to fill the database.

# Test
- Use the /api/register endpoint to create a new account and transfer the initial balance.

```
.../api/register
{
  "firstName": "Youri",
  "lastName": "Mulder",
  "initialBalance": 25
}
```

- Check ..api/CreditAccount/2 if the credit and customer account is created and the balance is transfered.
- Check ../api/CreditAccount/1 if the bank has a balance lower than 100000.