CREATE TABLE note (
                      note_id INT PRIMARY KEY AUTO_INCREMENT,
                      note_title VARCHAR(255),
                      note_content TEXT
);
CREATE TABLE "user"
(
    id       BIGINT AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL PRIMARY KEY,
    password VARCHAR(255),
    enabled  VARCHAR(255),
    role     VARCHAR(255)
);