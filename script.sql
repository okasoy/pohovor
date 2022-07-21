create table account
(
    id       integer not null
        primary key,
    password varchar(255),
    payment  integer not null,
    username varchar(255)
);

alter table account
    owner to postgres;

create table disk_space
(
    id       integer not null
        primary key,
    capacity integer not null,
    user_id  integer
        constraint fkp08pmt0ute0q2418q4ee6o92g
            references account
);

alter table disk_space
    owner to postgres;

create table document
(
    id            integer not null
        primary key,
    document      varchar(255),
    disk_space_id integer
        constraint fkirx5of49bxg5gh2jdsrm1yyk7
            references disk_space
);

alter table document
    owner to postgres;
