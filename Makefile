USERNAME := springstudent
PASSWORD := springstudent
DATABASE := spring-hibernate
IMAGE :=registry.redhat.io/rhel8/postgresql-13
PORT := 5432

database-ephemeral:
	podman run -d --name postgresql_database \
	  -e POSTGRESQL_USER=$(USERNAME) \
	  -e POSTGRESQL_PASSWORD=$(PASSWORD) \
	  -e POSTGRESQL_DATABASE=$(DATABASE) \
	  -p $(PORT):5432 \
	  $(IMAGE)

clean:
	podman kill postgresql_database
	podman rm postgresql_database
