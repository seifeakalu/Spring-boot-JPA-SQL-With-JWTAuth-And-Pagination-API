# REST API example application

This is a Rest API that let you send message to user based on ORM Model Relation, 
To register message, This API Lets you register user and authenticate with JWT

    Open the project with STS IDE and Run the application,
    STS will install necessary dependency for this API 

`pom.xml` containes necessary dependency of this project.

`application.properties` containes database connection
documentation below.


JWT PlayGround : https://jwt.io/

### Request

POST /users/
   
     Accept: application/json 
     URI: http://localhost:9192/users/   
     
     Sample Login Post Request:
     { "userName": "seoAk47", "password": "123", "firstName": "seifedin",  "lastName": "ak47", "email": "test@test.com" }
   
### Response

    Content-Type: application/json
    Content-Length: 1

    [User]
    
    
    ## Register User account

### Request

`POST authenticate`

    curl -i -H 'Accept: application/json' http://localhost:9192/users/authenticate

### Response

    Content-Type: application/json
    Content-Length: 1

    [User]
