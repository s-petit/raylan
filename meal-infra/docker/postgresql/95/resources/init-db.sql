DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO raylan;

CREATE TABLE event_store (
  uuid           UUID                     NOT NULL,
  aggregate_id   TEXT                     NOT NULL, -- id fonctionnel, serialize : Meal-XX
  aggregate_type TEXT                     NOT NULL, -- id fonctionnel, serialize : Meal-XX
  payload        TEXT                     NOT NULL, -- events serialized in text or json
  user_id        BIGINT                   NOT NULL,
  version        BIGINT                   NOT NULL,
  process_id     BIGINT                   NOT NULL,
  date           TIMESTAMP WITH TIME ZONE NOT NULL,

  PRIMARY KEY (uuid)
);
ALTER TABLE event_store
  ADD CONSTRAINT idx_un_quote_line_external_id UNIQUE (aggregate_id, aggregate_type);
ALTER TABLE event_store
  ADD CONSTRAINT idx_un_quote_line_external_id_type UNIQUE (aggregate_id);