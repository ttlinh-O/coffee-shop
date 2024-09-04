# coffee-shop-test

## Sample data
### Coffee-shop
```json
{
  "id": "33333333-3333-3333-3333-333333333333",
  "name": "Shop 3",
  "description": "Description for Shop 3",
  "address_id": "33333333-3333-3333-3333-333333333333",
  "location_id": "33333333-3333-3333-3333-333333333333",
  "time_open": 8,
  "time_close": 20,
  "queue_size": 2,
  "queue_amount": 1,
  "created_on": "2023-09-30 00:00:00",
  "created_id": null,
  "updated_on": "2023-09-30 00:00:00",
  "updated_id": null,
  "deleted_on": null,
  "deleted_id": null
}
```

### customer

```json
{
  "id": "11111111-1111-1111-1111-111111111111",
  "username": "customer1",
  "password": "123456",
  "email": "customer1@example.com",
  "is_active": true,
  "created_on": "2023-09-30 00:00:00",
  "created_id": null,
  "updated_on": "2023-09-30 00:00:00",
  "updated_id": null,
  "deleted_on": null,
  "deleted_id": null
}
```

### menu
```json
{
  "id": "11111111-1111-1111-1111-111111111111",
  "shop_id": "33333333-3333-3333-3333-333333333333",
  "name": "Menu 1",
  "description": "Description for Menu 1",
  "created_on": "2023-09-30 00:00:00",
  "created_id": null,
  "updated_on": "2023-09-30 00:00:00",
  "updated_id": null,
  "deleted_on": null,
  "deleted_id": null
}
```

### menu_item
```json
[
  {
    "id": "11111111-1111-1111-1111-111111111111",
    "name": "Item 1",
    "description": "Description for Item 1",
    "price": 10000.00,
    "menu_id": "11111111-1111-1111-1111-111111111111",
    "category_id": "11111111-1111-1111-1111-111111111111",
    "is_active": true,
    "time_prepare": 10,
    "created_on": "2023-09-30 00:00:00",
    "created_id": null,
    "updated_on": "2023-09-30 00:00:00",
    "updated_id": null,
    "deleted_on": null,
    "deleted_id": null
  },
  {
    "id": "22222222-2222-2222-2222-222222222222",
    "name": "Item 2",
    "description": "Description for Item 2",
    "price": 20000.00,
    "menu_id": "11111111-1111-1111-1111-111111111111",
    "category_id": "22222222-2222-2222-2222-222222222222",
    "is_active": true,
    "time_prepare": 10,
    "created_on": "2023-09-30 00:00:00",
    "created_id": null,
    "updated_on": "2023-09-30 00:00:00",
    "updated_id": null,
    "deleted_on": null,
    "deleted_id": null
  }
]
```

and all other sample data you can refer src/db/migrations/data

## Demo
- Checkout repository
- cd to repository folder
- copy and run ```docker-compose -f docker-compose.yaml up -d``` in the command line
- Access api: open swagger ```{your-server-domain-name}:6005/swagger-ui/index.html```
  - Example: http://localhost:6005/swagger-ui/index.html if you run docker-compose from your local machine

### Case order successfully
use request body
```json
{
  "customerId": "11111111-1111-1111-1111-111111111111",
  "paymentId": "22222222-2222-2222-2222-222222222222",
  "totalPrice": 100,
  "totalAmount": 100,
  "shopId": "33333333-3333-3333-3333-333333333333",
  "orderItems": [
    {
      "itemId": "11111111-1111-1111-1111-111111111111",
      "amount": 2,
      "price": 10000.00
    },
    {
      "itemId": "22222222-2222-2222-2222-222222222222",
      "amount": 1,
      "price": 20000.00
    }
  ]
}
```

the response
```json
{
  "id": "3ddb12d1-9214-4b41-87b7-08b48b9b8a1b",
  "queuePosition": 1,
  "expectedWaitingTime": "2023-10-02T17:50:53.473689",
  "status": "ORDERED"
}
```

### Case customerId is invalid
use request body
```json
{
  "customerId": "11111111-1111-1111-1111-111111111118",
  "paymentId": "22222222-2222-2222-2222-222222222222",
  "totalPrice": 100,
  "totalAmount": 100,
  "shopId": "33333333-3333-3333-3333-333333333333",
  "orderItems": [
    {
      "itemId": "11111111-1111-1111-1111-111111111111",
      "amount": 2,
      "price": 10000.00
    },
    {
      "itemId": "22222222-2222-2222-2222-222222222222",
      "amount": 1,
      "price": 20000.00
    }
  ]
}
```

the response
```json
{
  "timestamp": "2023-10-02T17:35:33.258Z",
  "message": "could not find customer 11111111-1111-1111-1111-111111111118",
  "debugMessage": null,
  "code": null
}
```

### The same for case paymentId is invalid, or shopId is invalid

### Case queue is full (in example data, queue size is 2)
send request with this request body
```json
{
  "customerId": "11111111-1111-1111-1111-111111111111",
  "paymentId": "22222222-2222-2222-2222-222222222222",
  "totalPrice": 100,
  "totalAmount": 100,
  "shopId": "33333333-3333-3333-3333-333333333333",
  "orderItems": [
    {
      "itemId": "11111111-1111-1111-1111-111111111111",
      "amount": 2,
      "price": 10000.00
    },
    {
      "itemId": "22222222-2222-2222-2222-222222222222",
      "amount": 1,
      "price": 20000.00
    }
  ]
}
```

continue send another request with this request body
```json
{
  "customerId": "11111111-1111-1111-1111-111111111111",
  "paymentId": "22222222-2222-2222-2222-222222222222",
  "totalPrice": 100,
  "totalAmount": 100,
  "shopId": "33333333-3333-3333-3333-333333333333",
  "orderItems": [
    {
      "itemId": "11111111-1111-1111-1111-111111111111",
      "amount": 2,
      "price": 10000.00
    },
    {
      "itemId": "22222222-2222-2222-2222-222222222222",
      "amount": 1,
      "price": 20000.00
    }
  ]
}
```

the response
```json
{
  "timestamp": "2023-10-02T17:39:49.548Z",
  "message": "Queue is fulled, can not add a new order",
  "debugMessage": null,
  "code": null
}
```
