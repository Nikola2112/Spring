INSERT INTO note (note_title, note_content)
VALUES
    ('Таблетки', 'Выпить таблетки в промежуке с 21:00 до 23:00'),
    ('Сделать дз по GOIT', 'Проверить все ли сделано по тз перед сдачей ментору '),
    ('Подготовка к собеседыванию', 'Дай ответы на вопросы которые в Word, повторить весь материал по курсу, также попросить кого-то задать тебе эти вопросы, но ответ давать на английском');

INSERT INTO "user" (id, username, password, enabled, role)
VALUES
    (1, 'user', '$2a$12$LackGTKRPBGV5TVg7IkH8.CTMOs1bRcwFzPHyyLooif79LHXIwQXS', 'true', 'USER'),
    (2, 'nick', '$2a$12$xistkTtBYFp6rY0ccFINE.49QKuMR2zIf.kv5fgtXQxLeFS8XHRky', 'true', 'USER');
