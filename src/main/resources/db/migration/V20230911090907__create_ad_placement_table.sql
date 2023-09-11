DROP TABLE ad_placement;
CREATE TABLE ad_placement(
id            SERIAL PRIMARY KEY,
width_pixels  integer NOT NULL,
height_pixels integer NOT NULL,
location      varchar(256) NOT NULL,
device_type   varchar(256) NOT NULL
);
