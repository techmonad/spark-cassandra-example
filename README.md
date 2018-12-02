# spark-cassandra-example




#### Keyspace and table creation: 
    $ cqlsh
    cqlsh> create  keyspace company with replication ={'class': 'SimpleStrategy', 'replication_factor':1} ;
    cqlsh> use company;
    cqlsh:company> create table employee (id Int primary key, name text, email text, dob timestamp);
    cqlsh:company> insert into employee(id, name, email, dob) values (1, 'bob' , 'bob@gmail.com', 615234600000);
    cqlsh:company> insert into employee(id, name, email, dob) values (2, 'rob' , 'rob@gmail.com', 610234600000);
    cqlsh:company> select * from employee ;
  
