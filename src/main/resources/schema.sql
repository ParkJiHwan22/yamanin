CREATE DATABASE yamanin_db;
CREATE USER 'yamanin'@'localhost' IDENTIFIED BY 'yamanin97';

 GRANT ALL PRIVILEGES ON yamanin_db.* TO 'yamanin'@'localhost';
 FLUSH PRIVILEGES;
 
use yamanin_db;

CREATE TABLE User (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    login_id VARCHAR(20) NOT NULL,
    password VARCHAR(30) NOT NULL,
    name VARCHAR(30),
    phone VARCHAR(20),
    email VARCHAR(30),
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    age INT,
    gender ENUM('M', 'F'),
    nickName VARCHAR(20)
);

-- Insert data into the User table
INSERT INTO User (login_id, password, name, phone, email, age, gender, nickName) 
VALUES 
    ('john_doe', 'jd2024!', 'John Doe', '123-456-7890', 'john.doe@example.com', 28, 'M', 'Johnny'),
    ('jane_doe', 'password123', 'Jane Doe', '321-654-0987', 'jane.doe@example.com', 32, 'F', 'Jany'),
    ('sam_smith', 'samsam', 'Sam Smith', '456-123-6789', 'sam.smith@example.com', 24, 'M', 'SSmith');
    
select * from user