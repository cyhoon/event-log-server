## 요구사항
 
유저 이벤트를 수집할 수 있으며 수집한 이벤트는 여러 써드파티에 전파될 수 있다.

## 아키텍처

<img width="883" src="https://user-images.githubusercontent.com/26565116/136768083-216b2b80-ba9c-4e55-8937-ae3dc3a1f792.png">

## API

**이벤트 트래킹 API**
```
POST /api/events/t HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 184

{
    "userId": "user-1",
    "name": "Order Completed",
    "property": {
        "title": "Sample Product #1",
        "price": 50000
    },
    "createDate": "2021-10-11T16:35:14"
}
```
