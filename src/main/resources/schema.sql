CREATE DATABASE yamanin_db;
CREATE USER 'yamanin'@'localhost' IDENTIFIED BY 'yamanin97';

 GRANT ALL PRIVILEGES ON yamanin_db.* TO 'yamanin'@'localhost';
 FLUSH PRIVILEGES;
 
 
 
use yamanin_db;

# 1. User Table 생성
CREATE TABLE IF NOT EXISTS User (
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

INSERT INTO User (login_id, password, name, phone, email, age, gender, nickName) 
VALUES 
    ('john_doe', 'jd2024!', 'John Doe', '123-456-7890', 'john.doe@example.com', 28, 'M', 'Johnny'),
    ('jane_doe', 'password123', 'Jane Doe', '321-654-0987', 'jane.doe@example.com', 32, 'F', 'Jany'),
    ('sam_smith', 'samsam', 'Sam Smith', '456-123-6789', 'sam.smith@example.com', 24, 'M', 'SSmith');
    
select * from user;

# 2. PostItem Table 생성
DROP TABLE IF EXISTS post_items;
CREATE TABLE post_items (
    postId INT PRIMARY KEY,
    userId INT,
    gameId INT,
    seatInfo VARCHAR(255),
    seatType VARCHAR(20),
    title VARCHAR(255),
    detail TEXT,
    price INT,
    ticketImg BLOB
);

INSERT INTO post_items (postId, userId, gameId, seatInfo, seatType, title, detail, price, ticketImg)
VALUES
(1, 100, 200, 'A1', 'LEFT', 'Exciting Game!', 'Best seat in the house!', 150, 'binary_data_here'),

(2, 101, 201, 'B2', 'RIGHT', 'Close Action!', 'Right at the sideline.', 200, 'binary_data_here'),

(3, 102, 202, 'C3', 'LEFT', 'Perfect View!', 'See everything from here.', 180, 'binary_data_here');

# 3. 
DROP TABLE IF EXISTS Profiles;

CREATE TABLE Profiles (
    userId INT PRIMARY KEY,
    profileImg BLOB,
    profileText TEXT,
    supportTeam VARCHAR(255)
);

INSERT INTO Profiles (userId, profileImg, profileText, supportTeam)
VALUES
(1, 'binary_data_here', 'Life-long fan of the team.', 'Team A'),

(2, 'binary_data_here', 'Excited about every game!', 'Team B'),

(3, 'binary_data_here', 'Supporting since childhood.', 'Team C');
