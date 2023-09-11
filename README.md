# ads-service
## Design Document
[Whimsical Document](https://whimsical.com/ad-creative-87CC76caBaudBhJ7Jn39hw)
## Pre-Requisites to run
Postgresql running on Docker with database ads
    
    docker run --name assignment-postgres -e POSTGRES_PASSWORD=password -e POSTGRES_USER=postgres -e POSTGRES_DB=ads -p 5432:5432 -d postgres
## To build docker image:
    docker build -t ads:latest . 
## To run docker image in a container:
    docker run -p 8080:8080 -d ads:latest

## APIs Exposed
### GET /api/v1/ad
    curl --location 'http://0.0.0.0:8080/api/v1/ad?id=1'
### POST /api/v1/ad/creative
    curl --location 'http://0.0.0.0:8080/api/v1/ad/creative' \
    --header 'Content-Type: application/json' \
    --data '{
        "imageUrl": "http/image-1.jpeg",
        "widthPixels": 200,
        "heightPixels": 200,
        "location": "New York",
        "deviceType": "Mobile"
    }'
### POST /api/v1/ad/placement
    curl --location 'http://0.0.0.0:8080/api/v1/ad/placement' \
    --header 'Content-Type: application/json' \
    --data '{
        "widthPixels": 200,
        "heightPixels": 200,
        "location": "New York",
        "deviceType": "Mobile"
    }'

