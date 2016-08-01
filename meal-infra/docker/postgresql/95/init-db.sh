docker cp resources/container-init-db.sh 95_raylan_db_1:/init-db.sh
docker cp resources/init-db.sql 95_raylan_db_1:/init-db.sql
docker exec 95_raylan_db_1 /bin/sh 'init-db.sh'