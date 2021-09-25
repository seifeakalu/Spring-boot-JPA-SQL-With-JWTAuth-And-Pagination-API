# spring-security-jwt-example

Reference : https://jwt.io/

## Register User account

### Request

`POST /users/`

    curl -i -H 'Accept: application/json' http://localhost:9192/users/
 {
    "userName": "seoAk47", "password": "123", "firstName": "seifedin",  "lastName": "ak47", "email": "test@test.com"
 }'
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
