Reference: https://www.youtube.com/playlist?list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE

Spring Security mechanism is automatic with Spring Boot Application. Delegating Filter and all the 8 to 9 filter are autoconfigured. And it works the default way when we add the dependency in pom.xml.

We have to change the Security Configuration in order to use our own database or LDAP which have the list of users and roles. Configuration for Spring Security can be changed by extending WebSecurityConfigurerAdapter.java.

1) This application provides the custom UserDetailsService which gets the user information from database or LDAP (From H2 database in this project). It also sets the custom roles. Then getting data from JPA source is normal.
2) We are also making /authentication, /h2-console/** to not have authentication as by default Spring security does authentication for all /**.
3) Then when the authentication is successful, it generates a JWT with userdetails and give to the client.
4) Then in the subsequent calls, the Client have to send the JWT as header with 
key = Authorization, value = Bearer {JWT}
5) This will be intercepted by another filter which extends from 'OncePerRequestFilter'. This filter checks if the JWT is in the header of the request and validates the JWT. If it finds the JWT is valid by checking the signature, it allows the request to reach the actual rest end points there by providing security in the subsequent calls.
