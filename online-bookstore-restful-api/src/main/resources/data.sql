
--password1,password2,password3,password4,password5
INSERT INTO users (id, name, email, password, created_at, updated_at) VALUES
(1, 'Ahmet', 'ahmet@email.com', '{bcrypt}$2a$10$aOSRNRzrp1gc5/uMtJ1dnO51W1XDEaNbIlZ2GcT2NwNEiTD9cMPW2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Mehmet', 'mehmet@email.com', '{bcrypt}$2a$10$A9mD5z.oDVC/YraRyoDLZOixjlys5SMUAInDuIv4fyPdrpPy7dPDi', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Ayşe', 'ayse@email.com', '{bcrypt}$2a$10$mHO7I0Vz2LsDYQuLbjeu6e87hgoslm1JgbGfsUve.Hx75vUKc1JtC', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Fatma', 'fatma@email.com', '{bcrypt}$2a$10$xpQPfZKjBC6MWOKq9ytNqu2R3nOWPPDagig3j7mzueeizC/kHFD.e', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Hakan', 'hakan@email.com', '{bcrypt}$2a$10$a1lhFWtYFGTvLVbfa3gMuuvsEYK8T7x0SW5QltGN4T2Ge5OL0O47G', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO authorities (id, name, authority)
SELECT id, name, 'USER' FROM users;

INSERT INTO authorities (id, name, authority) VALUES (3, 'Ayşe', 'MANAGER');
INSERT INTO authorities (id, name, authority) VALUES (5, 'Hakan', 'ADMIN');

INSERT INTO book (isbn, title, author, price, stock_quantity, created_at, updated_at) VALUES
(1, 'İstanbul Hatırası', 'Ahmet Ümit', 25.00, 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Serenad', 'Zülfü Livaneli', 30.00, 40, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Beyhude', 'Halide Edib Adıvar', 20.00, 60, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Kuyucaklı Yusuf', 'Sabahattin Ali', 18.00, 70, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Mai ve Siyah', 'Halit Ziya Uşaklıgil', 28.00, 45, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 'Kardeşimin Hikayesi', 'Zülfü Livaneli', 32.00, 55, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 'Çalıkuşu', 'Reşat Nuri Güntekin', 23.00, 65, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 'Aylak Adam', 'Yusuf Atılgan', 26.00, 60, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 'Yaban', 'Yakup Kadri Karaosmanoğlu', 22.00, 70, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 'Sineklerin Tanrısı', 'William Golding', 29.00, 55, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO orders (user_id, total_price, order_date, created_at, updated_at) VALUES
(1, 50.00, '2023-11-03', '2023-11-03', '2023-11-03'),
(2, 75.50, '2023-11-03', '2023-11-03', '2023-11-03'),
(3, 30.25, '2023-11-03', '2023-11-03', '2023-11-03'),
(4, 65.80, '2023-11-03', '2023-11-03', '2023-11-03'),
(5, 40.10, '2023-11-03', '2023-11-03', '2023-11-03'),
(1, 55.00, '2023-11-03', '2023-11-03', '2023-11-03'),
(2, 70.75, '2023-11-03', '2023-11-03', '2023-11-03'),
(3, 33.25, '2023-11-03', '2023-11-03', '2023-11-03'),
(4, 68.80, '2023-11-03', '2023-11-03', '2023-11-03'),
(5, 45.10, '2023-11-03', '2023-11-03', '2023-11-03'),
(1, 60.00, '2023-11-03', '2023-11-03', '2023-11-03'),
(2, 65.50, '2023-11-03', '2023-11-03', '2023-11-03'),
(3, 36.25, '2023-11-03', '2023-11-03', '2023-11-03'),
(4, 70.80, '2023-11-03', '2023-11-03', '2023-11-03'),
(5, 50.10, '2023-11-03', '2023-11-03', '2023-11-03'),
(1, 45.00, '2023-11-03', '2023-11-03', '2023-11-03'),
(2, 60.50, '2023-11-03', '2023-11-03', '2023-11-03'),
(3, 39.25, '2023-11-03', '2023-11-03', '2023-11-03'),
(4, 75.80, '2023-11-03', '2023-11-03', '2023-11-03'),
(5, 55.10, '2023-11-03', '2023-11-03', '2023-11-03'),
(1, 50.00, '2023-11-03', '2023-11-03', '2023-11-03'),
(2, 75.50, '2023-11-03', '2023-11-03', '2023-11-03'),
(3, 30.25, '2023-11-03', '2023-11-03', '2023-11-03'),
(4, 65.80, '2023-11-03', '2023-11-03', '2023-11-03'),
(5, 40.10, '2023-11-03', '2023-11-03', '2023-11-03'),
(1, 55.00, '2023-11-03', '2023-11-03', '2023-11-03'),
(2, 70.75, '2023-11-03', '2023-11-03', '2023-11-03'),
(3, 33.25, '2023-11-03', '2023-11-03', '2023-11-03');
