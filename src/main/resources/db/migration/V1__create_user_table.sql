CREATE TABLE IF NOT EXISTS `users`
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    alias VARCHAR(30) NOT NULL,
    email VARCHAR(60) NOT NULL,
    UNIQUE (alias),
    UNIQUE (email)
);