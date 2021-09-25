# REST API example application

This is a Rest API that let you send message to user based on ORM Model Relation, 
To register message, This API Lets you register user and authenticate with JWT

    Open the project with STS IDE and Run the application,
    STS will install necessary dependency for this API 

`pom.xml` containes necessary dependency of this project.

`application.properties` containes database connection

## POST/DELETE/PUT/GET Request of The API

JWT PlayGround : https://jwt.io/

### Register User Request

POST /users/
   
     ContentType: application/json 
     URI: http://localhost:9192/users/   
     
     Sample Register user Post Body Content:
     {    
	 "userName": "seoAk47",
        "password": "123",
        "firstName": "seifedin",
        "lastName": "ak47",
        "email": "test@test.com"    
    }
   
### Register User Response

    Content-Type: application/json
    Content-Length: 1

    [User]
    
 
### Login Request

POST /users/authenticate
   
     ContentType: application/json 
     URI: http://localhost:9192/users/authenticate  
     
     Sample Login Post Body Content:
     {    
	    "userName": "seoAk47",
            "password": "123",  
    }
   
### Login Response

    Content-Type: application/json
    Content-Length: 1

    [Token]

### Send message Request

POST /message/receiver_id

     Authorization: Bearer {token}
     ContentType: application/json 
     
     URI: http://localhost:9192/message/1 
     
     Sample Send message Body Content:
     {  
	"subject": "new message",
        "message": "Hello from test message"
    }
   
### Message Response

    Content-Type: application/json
    Content-Length: 1

    {
    "id": 12,
    "subject": "new message",
    "message": "hello from test message",
    "receiver": {
        "id": 1,
        "userName": "seo",
        "password": "$2a$10$Lcl28upfITuYXAFS6vfVwOWy8QDR/RLabpha9AariVgJWeyy/d5du",
        "email": "ak@ak.com",
        "firstName": "seifedin",
        "lastName": "akalu"
         }
      }



### Get Message By ID

`GET Message by ID  /message/message_id`
    Authorization: Bearer {token}
    curl -i -H 'Accept: application/json' http://localhost:9192/message/1

### Response

    Content-Type: application/json
    Content-Length: 1

    {
    "id": 1,
    "subject": "seo",
    "message": "yo yo yo ll",
    "sender": {
        "id": 3,
        "userName": "seo1",
        "password": "$2a$10$Lcl28upfITuYXAFS6vfVwOWy8QDR/RLabpha9AariVgJWeyy/d5du",
        "email": "kk",
        "firstName": null,
        "lastName": null
    },
    "receiver": {
        "id": 1,
        "userName": "seo",
        "password": "$2a$10$Lcl28upfITuYXAFS6vfVwOWy8QDR/RLabpha9AariVgJWeyy/d5du",
        "email": "ak@ak.com",
        "firstName": "seifedin",
        "lastName": "akalu"
      }
    }
