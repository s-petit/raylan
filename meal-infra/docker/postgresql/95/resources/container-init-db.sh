psql -U postgres -c "DROP DATABASE IF EXISTS raylan_db"
psql -U postgres -c "CREATE DATABASE raylan_db WITH OWNER = raylan ENCODING 'UTF8'"
psql -U postgres -c "DROP DATABASE IF EXISTS raylan_test"
psql -U postgres -c "CREATE DATABASE raylan_test WITH OWNER = raylan ENCODING 'UTF8'"
psql -U raylan raylan_db < ./init-db.sql
psql -U raylan raylan_test < ./init-db.sql