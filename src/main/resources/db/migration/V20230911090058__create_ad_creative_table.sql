DROP TABLE ad_creative;
CREATE TABLE ad_creative(
id            SERIAL PRIMARY KEY,
image_url     varchar(256) NOT NULL,
width_pixels  integer NOT NULL,
height_pixels integer NOT NULL,
location      varchar(256) NOT NULL,
device_type   varchar(256) NOT NULL
);
