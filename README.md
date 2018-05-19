# ws-client
Simple REST client over ws-demo SOAP server

To use this app you should run [ws-demo](https://github.com/EugeneVanchugov/ws-demo) before. 

Endpoint: localhost:8080/countries

**POST Body Example**: 
```json
{
    "name": "Russia",
    "population": 146880432,
    "capital": "Moscow",
    "currency": "RUB"
}
```

**Response**:
```json
{
    "id": 1,
    "name": "Russia",
    "population": 146880432,
    "capital": "Moscow",
    "currency": "RUB"
}
```
