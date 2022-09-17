DROP TABLE IF EXISTS youtuder;
DROP TABLE IF EXISTS video;

CREATE TABLE youtuder(
	youtuder_id serial PRIMARY KEY,
	youtuder_name VARCHAR(50) NOT NULL
);

CREATE TABLE video(
	video_id serial PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
    youtuder_id integer REFERENCES youtuder
);