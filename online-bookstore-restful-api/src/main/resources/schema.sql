CREATE TABLE IF NOT EXISTS book (
    isbn INT PRIMARY KEY NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    price DOUBLE NOT NULL,
    stock_quantity INT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);


-----------------------------------------------


CREATE TABLE IF NOT EXISTS orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    total_price DOUBLE NOT NULL,
    order_date DATE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-----------------------------------------------

CREATE TABLE IF NOT EXISTS order_books (
    order_id INT NOT NULL,
    book_id INT NOT NULL,
    PRIMARY KEY (order_id, book_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (book_id) REFERENCES book(isbn)
);

-----------------------------------------------

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-----------------------------------------------

CREATE TABLE authorities (
    id INT,
    name VARCHAR(255),
    authority VARCHAR(255),
    FOREIGN KEY (id) REFERENCES users(id)
);