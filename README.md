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

 message Response Content:
   {
    "receiver": {
    }
  }



### Send Message Request

`POST authenticate`

    curl -i -H 'Accept: application/json' http://localhost:9192/users/authenticate

### Response

    Content-Type: application/json
    Content-Length: 1

    [User]
