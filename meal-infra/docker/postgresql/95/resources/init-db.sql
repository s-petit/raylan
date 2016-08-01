DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO raylan;

CREATE TABLE event_store (
  id           BIGINT                   NOT NULL,
  aggregate_id TEXT                   NOT NULL, -- id fonctionnel, serialize : Meal-XX
  payload      JSONB                   NOT NULL, -- events serialized in text or json
  user_id      BIGINT                   NOT NULL,
  version      BIGINT                   NOT NULL,
  process_id   BIGINT                   NOT NULL,
  date         TIMESTAMP WITH TIME ZONE NOT NULL
);
--      - ./resources/init-db.sql:/docker-entrypoint-initdb.d/init-db.sql