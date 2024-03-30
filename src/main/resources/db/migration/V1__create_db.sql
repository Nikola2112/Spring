CREATE TABLE note (
                      note_id SERIAL PRIMARY KEY,
                      note_title VARCHAR(255),
                      note_content TEXT,
                      note_date DATE
);

CREATE TABLE "user" (
                        id BIGSERIAL PRIMARY KEY,
                        username VARCHAR(255) NOT NULL,
                        password VARCHAR(255),
                        enabled VARCHAR(255),
                        role VARCHAR(255)
);
