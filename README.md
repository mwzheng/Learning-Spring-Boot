### Spring Boot Practice 

    Simple Java REST API made using Spring Boot and PostgreSQL
    
    Simple Get, Put, Delete, Post books within a local PostgreSql database

### Spring Notes:

    Controller: Determines which method from the "Service" the Get, Post, Put, Delete methods call

    Service: Contains logic for when REST methods ("Post", "GET", "PUT", "DELETE") are called

    Config: Sets up initial DB on run since DB is reset after each run

### Annotations:

    @Controller: Marks class as web request handler

    @Service: Indicates that the class contains all the "Business Logic"

    @Repository: Access the database directly, and does all the operations

    @Column: Allows you to set properties for a column in the table (Ex: name, updatable, unique, etc)

### PSQL Personal Notes:

    To start Postgres: $ brew services start postgresql

    To run Postgres from terminal: $ psql postgres

    To connect to a database: $ \c <db Name>