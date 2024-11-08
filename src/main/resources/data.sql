-- Inserting into the geolocalizations table
INSERT INTO geolocalizations (lat, lng) VALUES ('-37.3159', '81.1496');
INSERT INTO geolocalizations (lat, lng) VALUES ('-43.9509', '-34.4618');
INSERT INTO geolocalizations (lat, lng) VALUES ('-68.6102', '-47.0653');
INSERT INTO geolocalizations (lat, lng) VALUES ('29.4572', '-164.2990');
INSERT INTO geolocalizations (lat, lng) VALUES ('-31.8129', '62.5342');
INSERT INTO geolocalizations (lat, lng) VALUES ('-71.4197', '71.7478');
INSERT INTO geolocalizations (lat, lng) VALUES ('24.8918', '21.8984');
INSERT INTO geolocalizations (lat, lng) VALUES ('-14.3990', '-120.7677');
INSERT INTO geolocalizations (lat, lng) VALUES ('24.6463', '-168.8889');
INSERT INTO geolocalizations (lat, lng) VALUES ('-38.2386', '57.2232');

-- Inserting into the company table
INSERT INTO companies (name, catch_phrase, bs) VALUES ('Romaguera-Crona', 'Multi-layered client-server neural-net', 'harness real-time e-markets');
INSERT INTO companies (name, catch_phrase, bs) VALUES ('Deckow-Crist', 'Proactive didactic contingency', 'synergize scalable supply-chains');
INSERT INTO companies (name, catch_phrase, bs) VALUES ('Romaguera-Jacobson', 'Face to face bifurcated interface', 'e-enable strategic applications');
INSERT INTO companies (name, catch_phrase, bs) VALUES ('Robel-Corkery', 'Multi-tiered zero tolerance productivity', 'transition cutting-edge web services');
INSERT INTO companies (name, catch_phrase, bs) VALUES ('Keebler LLC', 'User-centric fault-tolerant solution', 'revolutionize end-to-end systems');
INSERT INTO companies (name, catch_phrase, bs) VALUES ('Considine-Lockman', 'Synchronised bottom-line interface', 'e-enable innovative applications');
INSERT INTO companies (name, catch_phrase, bs) VALUES ('Johns Group', 'Configurable multimedia task-force', 'generate enterprise e-tailers');
INSERT INTO companies (name, catch_phrase, bs) VALUES ('Abernathy Group', 'Implemented secondary concept', 'e-enable extensible e-tailers');
INSERT INTO companies (name, catch_phrase, bs) VALUES ('Yost and Sons', 'Switchable contextually-based project', 'aggregate real-time technologies');
INSERT INTO companies (name, catch_phrase, bs) VALUES ('Hoeger LLC', 'Centralized empowering task-force', 'target end-to-end models');

-- Inserting into the address table
INSERT INTO addresses (street, suite, city, zipcode, geo_id) VALUES ('Kulas Light', 'Apt. 556', 'Gwenborough', '92998-3874', 1);
INSERT INTO addresses (street, suite, city, zipcode, geo_id) VALUES ('Victor Plains', 'Suite 879', 'Wisokyburgh', '90566-7771', 2);
INSERT INTO addresses (street, suite, city, zipcode, geo_id) VALUES ('Douglas Extension', 'Suite 847', 'McKenziehaven', '59590-4157', 3);
INSERT INTO addresses (street, suite, city, zipcode, geo_id) VALUES ('Hoeger Mall', 'Apt. 692', 'South Elvis', '53919-4257', 4);
INSERT INTO addresses (street, suite, city, zipcode, geo_id) VALUES ('Skiles Walks', 'Suite 351', 'Roscoeview', '33263', 5);
INSERT INTO addresses (street, suite, city, zipcode, geo_id) VALUES ('Norberto Crossing', 'Apt. 950', 'South Christy', '23505-1337', 6);
INSERT INTO addresses (street, suite, city, zipcode, geo_id) VALUES ('Rex Trail', 'Suite 280', 'Howemouth', '58804-1099', 7);
INSERT INTO addresses (street, suite, city, zipcode, geo_id) VALUES ('Ellsworth Summit', 'Suite 729', 'Aliyaview', '45169', 8);
INSERT INTO addresses (street, suite, city, zipcode, geo_id) VALUES ('Dayna Park', 'Suite 449', 'Bartholomebury', '76495-3109', 9);
INSERT INTO addresses (street, suite, city, zipcode, geo_id) VALUES ('Kattie Turnpike', 'Suite 198', 'Lebsackbury', '31428-2261', 10);

-- Inserting into the user table
INSERT INTO users (name, creation_time, username, email, phone, website, address_id, company_id) VALUES ('Leanne Graham', '2023-11-01T08:30:00', 'Bret', 'Sincere@april.biz', '1-770-736-8031 x56442', 'hildegard.org', 1, 1);
INSERT INTO users (name, creation_time, username, email, phone, website, address_id, company_id) VALUES ('Ervin Howell', '2023-11-02T10:15:00', 'Antonette', 'Shanna@melissa.tv', '010-692-6593 x09125', 'anastasia.net', 2, 2);
INSERT INTO users (name, creation_time, username, email, phone, website, address_id, company_id) VALUES ('Clementine Bauch', '2023-11-03T12:00:00', 'Samantha', 'Nathan@yesenia.net', '1-463-123-4447', 'ramiro.info', 3, 3);
INSERT INTO users (name, creation_time, username, email, phone, website, address_id, company_id) VALUES ('Patricia Lebsack', '2023-11-04T14:30:00', 'Karianne', 'Julianne.OConner@kory.org', '493-170-9623 x156', 'kale.biz', 4, 4);
INSERT INTO users (name, creation_time, username, email, phone, website, address_id, company_id) VALUES ('Chelsey Dietrich', '2023-11-05T16:45:00', 'Kamren', 'Lucio_Hettinger@annie.ca', '(254)954-1289', 'demarco.info', 5, 5);
INSERT INTO users (name, creation_time, username, email, phone, website, address_id, company_id) VALUES ('Mrs. Dennis Schulist', '2023-11-06T18:10:00', 'Leopoldo_Corkery', 'Karley_Dach@jasper.info', '1-477-935-8478 x6430', 'ola.org', 6,6 );
INSERT INTO users (name, creation_time, username, email, phone, website, address_id, company_id) VALUES ('Kurtis Weissnat', '2023-11-07T09:00:00', 'Elwyn.Skiles', 'Telly.Hoeger@billy.biz', '210.067.6132', 'elvis.io', 7, 7);
INSERT INTO users (name, creation_time, username, email, phone, website, address_id, company_id) VALUES ('Nicholas Runolfsdottir V', '2023-11-08T13:20:00', 'Maxime_Nienow', 'Sherwood@rosamond.me', '586.493.6943 x140', 'jacynthe.com', 8, 8);
INSERT INTO users (name, creation_time, username, email, phone, website, address_id, company_id) VALUES ('Glenna Reichert', '2023-11-09T11:05:00', 'Delphine', 'Chaim_McDermott@dana.io', '(775)976-6794 x41206', 'conrad.com', 9, 9);
INSERT INTO users (name, creation_time, username, email, phone, website, address_id, company_id) VALUES ('Clementina DuBuque', '2023-11-10T08:45:00', 'Moriah.Stanton', 'Rey.Padberg@karina.biz', '024-648-3804', 'ambrose.net', 10, 10);
