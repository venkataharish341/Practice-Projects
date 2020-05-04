<b>Reference:</b><br>
https://youtu.be/3pZ3Nh8tgTE?list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE<br>
https://youtu.be/ykkrASGzG_M?list=PLD-mYtebG3X-wOVHINZf_GKknpJs3Oa3O

This is OAuth2 Authorization and Resource server for password flow with role based authorization.

<b>To Run:</b><br>
Rename data.txt to data.sql<br>
Install MySql<br>
Start both the spring boot projects.<br>

<b>Terminology:</b><br>

<b>Resource:</b> The rest end points you are securing.<br>
<b>Resource Server:</b> The server which hosts resource (Google Server).<br>
<b>Client :</b> The web application(print photos) from which you want to access Resource Server(Google photos).<br>
<b>Resourcer Owner:</b> The User.<br>
<b>Authorization Server:</b> Server which protects or issues access token to access end points in resource server.<br>

Client Id and Client Secret are the credentials given to client when he registers with Authorization server (Google server). This helps
Google server to tracking where the request is coming from (To track clients).

Here we are creating our own Authorization server and resource server instead of depending on some google or facebook authorization servers.

<b>Password flow meaning:</b>
Password flow means we are taking user's google credentials to access his photos on Google Server.(This flow works only when user trusts
the client. So helpful in microservices as all services are trusted.)

<b>Steps:</b>
1) Get access token from Authorization server (http://localhost:9191/oauth/token (POST request) by sending grant_type, username, 
password (like user's google credentials) in form -urlencoded and also providing client id and secret from basic authentication). This
gives us access token for that particular user.

2) We can check all the permissions, role assigned to that user (http://localhost:9191/oauth/check_token?token={accessToken}. Should also
provide client id and secret from basic auth.)

3) Final step is to use the access token to access resource or rest end point in our case.(http://localhost:8080/users/htavva/todos.
Should send "bearer {accessToken}" as authorization header).




