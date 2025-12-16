CREATE TABLE IF NOT EXISTS country (
                                       id BIGINT PRIMARY KEY,
                                       name TEXT,
                                       code VARCHAR(3)
    );

CREATE TABLE IF NOT EXISTS status (
                                      status TEXT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS conflict (
                                        id BIGINT PRIMARY KEY,
                                        name TEXT,
                                        startDate DATE,
                                        status TEXT REFERENCES status(status),
    description TEXT
    );

CREATE TABLE IF NOT EXISTS conflicts (
                                         country INT REFERENCES country(id),
    conflict INT REFERENCES conflict(id),
    PRIMARY KEY (country, conflict)
    );

CREATE TABLE IF NOT EXISTS faction (
                                       id BIGINT PRIMARY KEY,
                                       name TEXT,
                                       conflict INT REFERENCES conflict(id)
    );

CREATE TABLE IF NOT EXISTS supports (
                                        faction INT REFERENCES faction(id),
    conflict INT REFERENCES conflict(id),
    PRIMARY KEY (faction, conflict)
    );

CREATE TABLE IF NOT EXISTS event (
                                     id BIGINT PRIMARY KEY,
                                     eventDate DATE,
                                     location TEXT,
                                     description TEXT,
                                     conflict INT REFERENCES conflict(id)
    );