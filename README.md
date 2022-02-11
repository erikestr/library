# Configuration

# Docker
### Postgres

Run Command:
```
sudo docker run --name [container_name] -d -p [custom_port]:5432 -e POSTGRES_PASSWORD=[custom_password] postgres
```

Execute psql:
```
sudo docker exec -it [container_name] psql -U [postgres_user]
```

Start again:
```
sudo docker start -i [container_id]
```
