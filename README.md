# Configuration

# Docker
### Postgres

Run Command:
```
sudo docker run --name [container_name] -d -p [custom_port]:5432 -e POSTGRES_PASSWORD=[custom_password] postgres
```
sudo docker run --name library -d -p 5436:5432 -e POSTGRES_PASSWORD=D3c53f311 postgres
Execute psql:
```
sudo docker exec -it [container_name] psql -U [postgres_user]
```
