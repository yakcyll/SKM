psql -c "DROP DATABASE rsodfs;"
psql -c "
DROP USER rsodfs;"

psql -c "
CREATE USER rsodfs WITH PASSWORD 'rsodfs11';"
psql -c "
CREATE DATABASE rsodfs OWNER rsodfs;"

psql -c "GRANT CONNECT ON DATABASE rsodfs TO rsodfs;"

psql -d rsodfs -c "
SET ROLE rsodfs;
create table files (
	id bigserial not null,
	name text not null,
	size bigint,
	status char(1),
	primary key (id)
);
alter table files add constraint files_status_constraint check (status = 'U' or status = 'D' or status = 'H');

create index pk_files on files (id);
create unique index uq_files on files (name);

create table servers (
	id bigserial not null,
	ip text not null,
	role char(1),
	memory bigint not null,
	last_connection timestamp not null,
	primary key (id)
);
alter table servers add constraint servers_role_constraint check (role = 'M' or role = 'H' or  role='L');

create index pk_servers on servers (ip);

create table files_on_servers (
	file_id bigint not null,
	server_id bigint not null,
	priority int not null,
	primary key (file_id, server_id),
	foreign key (server_id) references servers(id),
	foreign key (file_id) references files(id)
);

create index pk_filesonservers on files_on_servers (file_id, server_id);
create index fk_filesonservers on files_on_servers (server_id);

create table version (
	log bigserial not null
);

GRANT ALL ON files, servers,files_on_servers, version TO rsodfs;
"

psql -d rsodfs -f insert_test_data.sql
