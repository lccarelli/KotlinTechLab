CREATE TABLE characters (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    status VARCHAR(50),
    species VARCHAR(50),
    type VARCHAR(50),
    gender VARCHAR(50),
    origin VARCHAR(255),
    location VARCHAR(255),
    image VARCHAR(255),
    episodes TEXT[],
    url VARCHAR(255),
    created TIMESTAMP,
    updated TIMESTAMP
);

INSERT INTO characters (name, status, gender, species, origin, location, image, episodes, url, created, updated)
VALUES
    ('Rick Sanchez', 'Alive', 'Male', 'Human', 'Earth (C-137)', 'Citadel of Ricks', 'https://rickandmortyapi.com/api/character/avatar/1.jpeg', ARRAY['https://rickandmortyapi.com/api/episode/1', 'https://rickandmortyapi.com/api/episode/2', 'https://rickandmortyapi.com/api/episode/3'], 'https://rickandmortyapi.com/api/character/1', '2017-11-04', '2017-11-04'),
    ('Morty Smith', 'Alive', 'Male', 'Human', 'unknown', 'Citadel of Ricks', 'https://rickandmortyapi.com/api/character/avatar/2.jpeg', ARRAY['https://rickandmortyapi.com/api/episode/1', 'https://rickandmortyapi.com/api/episode/2'], 'https://rickandmortyapi.com/api/character/2', '2017-11-04', '2017-11-04'),
    ('Summer Smith', 'Alive', 'Female', 'Human', 'Earth (Replacement Dimension)', 'Earth (Replacement Dimension)', 'https://rickandmortyapi.com/api/character/avatar/3.jpeg', ARRAY['https://rickandmortyapi.com/api/episode/6', 'https://rickandmortyapi.com/api/episode/7'], 'https://rickandmortyapi.com/api/character/3', '2017-11-04', '2017-11-04'),
    ('Beth Smith', 'Alive', 'Female', 'Human', 'Earth (Replacement Dimension)', 'Earth (Replacement Dimension)', 'https://rickandmortyapi.com/api/character/avatar/4.jpeg', ARRAY['https://rickandmortyapi.com/api/episode/6', 'https://rickandmortyapi.com/api/episode/7', 'https://rickandmortyapi.com/api/episode/8'], 'https://rickandmortyapi.com/api/character/4', '2017-11-04', '2017-11-04');
