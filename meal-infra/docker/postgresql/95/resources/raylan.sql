CREATE TABLE event_store (
  id           BIGINT                   NOT NULL,
  aggregate_id TEXT                   NOT NULL, -- id fonctionnel, serialize : Meal-XX
  payload      JSONB                   NOT NULL, -- events serialized in text or json
  user_id      BIGINT                   NOT NULL,
  version      BIGINT                   NOT NULL,
  process_id   BIGINT                   NOT NULL,
  date         TIMESTAMP WITH TIME ZONE NOT NULL
);
