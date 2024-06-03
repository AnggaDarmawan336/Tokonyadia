# Tokonyadia CRUD REST API

## CUSTOMERS

Product Manager Mau Buat Aplikasi Android Toko Online yang dimana orang-orang bisa daftar, dan ketika login
dan misalnya ke halaman profile itu bisa muncul info profile dari customer tersebut, di halaman tersebut customer bisa
update profile dan juga bisa deactivate account
Juga mau ada aplikasi admin dashboard yang bisa menampilkan seluruh customer

Business Analyst atau TL mengorganisasikan product requirement

1. Create a new customer
2. Get customer info by ID atau CIF (Customer Identification File/Form)
3. Update customer info
4. Delete customer

### Final Project Buat REST API
### API SPECIFICATIONS
for resource path i.e. customers in api/v1/customers the convention is to use Noun (kata benda) rather than (Kata kerja)
use plural instead of singular
get by id
GET resource_path/resource_id
GET resource_path?name="andi"

GET customers?name="andi"
[{
"name": "andi"
}]

GET customers?page=1&size=10 (FE)
GET customers?offset=0&limit=10 (BE) -> equal page 1

GET customers?page=2&size=10 (FE)
GET customers?offset=10&limit=10 (BE) -> equal page 2

api/v1/customers/customerId/wallets

GET customers?offset=0&limit=10

**Create a new customer**
- **Method** `POST`
- **Endpoint** `api/v1/customers`
- **Request Body**
    ```json
    {
      "name": "andi",
      "email": "andi@email.com"
    }
    ```
  
**scenario**
- **Successfully created customer**
  - **Response Body**
      ```json
      {
    "message":  "Customer successfully been created",
    "data":{
        "id": "cce3b8b7-8bc7-4e18-8f9b-b7d01d73ae09",
        "name": "andi",
        "email": "andi@email.com"
      }}
      ```
  - **Status Code** 201
- **Failed due to email duplicate**
    - **Response Body**
        ```json
        {
          "message": "Email already been registered"
        }
        ```
    - **Status Code** 409

    
