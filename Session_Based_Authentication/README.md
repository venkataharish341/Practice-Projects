This project helps understand
1) Session based Authentication that happen in old monolithic projects.
2) Filters and their functioning.

<b>Session Based Authentication:</b>

Sessions are used to track subsequent calls after the authentication process. Filters play an important role here. When the user first login to our website, he gives username/password which will be authenticated against DB/LDAP data. Then we create session for the logged in user and store that in Database/Redis cache etc. When session is created, a cookie named JSESSIONID is created automatically and session Id is embeded into that cookie and that cookie is attached to HTTP response sent to the user. Then for all the subsequent calls the browser attaches the cookie to HTTP request header based on the server url (localhost:8080/Session_Based_Authentication). This is checked in the Filter and permission will be granted to access the resource the user is requesting.

<b>This Project:</b>

Here there are 2 filters namely RequestLoggingFilter and AuthenticationFilter. In web.xml, we give /* which means all the requests should go through those 2 filters. When any request arrives, it first goes thorugh

1) RequestLoggingFilter (pre)
2) AuthenticationFilter (pre)
3) Actual Servlet
4) AuthenticationFilter (post)
5) RequestLoggingFilter (post)

In our authentication process, the same thing happens. The request gets logged when passed through first filter, then when it passed through second filter, it is checked for any cookies. Then it goes to LoginServlet, gets authenticated then session is created and embedded into cookie named JSESSIONID (which server creates automatically). That cookie is then added to HTTP response. Then it goes again through both the filters and user will see welcome page of website. Then in the subsequent calls, browser atttaches the cookies in HTTP request header and sends to server. That request when passed through Filters gets verified and access to resource will be given.

<b>Note:</b>
1) request.getSession() or request.getSession(true) in LoginServlet.java creates session if doesnot exist or gets session if exist.
2) req.getSession(false) in AuthenticationFilter doesnot create any session but gets session if exist.
3) chain.doFilter(request, response) in Filters passes the request to next filter in chain or the servlet if it is last filter.


<img src="Session Authentication.png" height="420" width="650">
