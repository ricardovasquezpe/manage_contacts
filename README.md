# Manage Contacts Documentation
This is a REST API built in Java with SpringBoot to Manage Contacts.

## Dependencies used 
Java Version: 14
Maven Version: 4.0.0
SpringBoot Version: 2.3.2.RELEASE
SpringBoot Starter Cache: 1.3.0.RELEASE
jUnit Version: 4.12

## First Step
You need to run the manage_contact.sql file in your mysql database in order to create the database and tables.
The file is located in "/src/main/resources"

## Unit Test
There is 1 unit test created under this location "/src/test/java/com/test/managecontacts/controller"

## Endpoints
## GetAllContacts
**You get:** List of contacts created with their address

**Request:**
```json
GET /api/contacts HTTP/1.1
Accept: application/json
```
**Successful Response:**
```json
HTTP/1.1 200 OK
Content-Type: application/json

[
    {
        "id": 1,
        "fullName": "Ricardo",
        "birthDate": "2020-04-22T00:00:00.000+00:00",
        "address": {
            "id": 1,
            "city": "Lima",
            "postalCode": "01"
        }
    },
    {
        "id": 2,
        "fullName": "Carla",
        "birthDate": "2020-04-22T00:00:00.000+00:00",
        "address": {
            "id": 2,
            "city": "Chiclayo",
            "postalCode": "02"
        }
    }
]
```

## GetAllContactsByPostalCode
**You get:** List of contacts created with their address by PostalCode

**Request:**
```json
GET /api/contacts/search?postalCode=01 HTTP/1.1
Accept: application/json
```
**Successful Response:**
```json
HTTP/1.1 200 OK
Content-Type: application/json

[
    {
        "id": 1,
        "fullName": "Ricardo",
        "birthDate": "2020-04-22T00:00:00.000+00:00",
        "address": {
            "id": 1,
            "city": "Lima",
            "postalCode": "01"
        }
    }
]
```


## InsertNewContact
**You send:** New Contact information
**You get:** New ID Contact Created

**Request:**
```json
GET /api/contacts HTTP/1.1
Accept: application/json
Content-Type: application/json

{
    "fullName" : "Carla",
    "birthDate" : "22-04-2020",
    "address": {
        "city" : "Trujillo",
        "postalCode" : "03"
    }
}
```
**Successful Response:**
```json
HTTP/1.1 201 CREATED
Content-Type: application/json

{
    "contactId": 3
}
```
