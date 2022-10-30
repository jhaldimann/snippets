# Snippets Organizer

## Infrastructure
Start the needed infrastructure in the root directory with the following command
```bash
$ docker compose up
```

## Backend
Build Backend with docker use the following command:
```bash
$ cd backend
$ docker build -t snippet .
```

Run docker container
```bash
$ docker run -p 1337:1337 --env HOST=host.docker.internal  --name backend -d -it snippets
```

## Frontend
