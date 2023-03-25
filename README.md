# exam

Java spring + HTML exam.

- Create RESTful API using Spring boot
- Added Postman Collection for testing
- Added minimal frontend to working with data
- Automatically populate database with test users( should be disabled in real world use)

## API Reference

#### Get all players

```http
  GET /player
```

#### Get player

```http
  GET /player/${id}
```

#### DELETE player

```http
  DELETE /player/${id}
```

#### PUT player

```http
  PUT /player/${id}
```

#### PATCH player

```http
  PATCH /player/${id}
```

## Installation

Open the project with InteliJ, install dependancies with Maven, run the project. Backend will be reachable at <http://localhost:8080>

To open frontend open `frontend` directory with vscode and click start Live server. The frontend will be reachable at <http://localhost:5500/frontend/index.html>

## License

[MIT](https://choosealicense.com/licenses/mit/)
