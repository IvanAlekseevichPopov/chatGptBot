CREATE TABLE "user" (
   id uuid NOT NULL,
   external_id BIGINT,
   first_name VARCHAR(255),
   last_name VARCHAR(255),
   CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE chat (
   id uuid NOT NULL,
   user_id uuid,
   history VARCHAR(255),
   created_at TIMESTAMP WITHOUT TIME ZONE,
   CONSTRAINT pk_chat PRIMARY KEY (id)
);

ALTER TABLE chat ADD CONSTRAINT FK_CHAT_ON_USER FOREIGN KEY (user_id) REFERENCES "user" (id);