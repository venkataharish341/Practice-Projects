<b>Why Database Connection Pool:</b>

Typically, opening a database connection on demand is an expensive operation, especially if the database is remote. You have to open up 
network sessions, authenticate, have authorisation checked, and so on. Pooling keeps the connections active so that, when a connection
is later requested, one of the active ones is used in preference to having to create another one.
