-- CREATE DATABASE yamanin_db;
-- CREATE USER 'yamanin'@'localhost' IDENTIFIED BY 'yamanin97';

--  GRANT ALL PRIVILEGES ON yamanin_db.* TO 'yamanin'@'localhost';
--  FLUSH PRIVILEGES;
--  
use yamanin_db;

# 1. User Table 생성
DROP TABLE IF EXISTS User;
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

INSERT INTO User (login_id, password, name, phone, email, age, gender, nickName) 
VALUES 
    ('john_doe', 'jd2024!', 'John Doe', '123-456-7890', 'john.doe@example.com', 28, 'M', 'Johnny'),
    ('jane_doe', 'password123', 'Jane Doe', '321-654-0987', 'jane.doe@example.com', 32, 'F', 'Jany'),
    ('sam_smith', 'samsam', 'Sam Smith', '456-123-6789', 'sam.smith@example.com', 24, 'M', 'SSmith');
    
# select * from user;

# 2. PostItem Table 생성
DROP TABLE IF EXISTS post_items;
CREATE TABLE post_items (
    postId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT,
    gameId INT,
    seatInfo VARCHAR(255),
    seatType VARCHAR(20),
    title VARCHAR(255),
    detail TEXT,
    price INT,
    ticketImg BLOB,
    viewCnt INT,
    createdDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    updatedDate DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO post_items (userId, gameId, seatInfo, seatType, title, detail, price, ticketImg, viewCnt, createdDate, updatedDate)
VALUES
(100, 200, 'A1', 'LEFT', 'Exciting Game!', 'Best seat in the house!', 150, 'binary_data_here', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

(101, 201, 'B2', 'RIGHT', 'Close Action!', 'Right at the sideline.', 200, 'binary_data_here', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

(102, 202, 'C3', 'LEFT', 'Perfect View!', 'See everything from here.', 180, 'binary_data_here', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

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


# 4. question table

DROP TABLE IF EXISTS question;
CREATE TABLE question (
	qnaId INT AUTO_INCREMENT PRIMARY KEY,
	userId INT,
	detail TEXT,
	qnaType VARCHAR(255),
	createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO question (userId, detail, qnaType, createdDate, UpdatedDate)
VALUES
(1, 'What is the best strategy for early game?', 'QUESTION', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'How to improve shooting skills?', 'ANSWER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Recommended gear for beginners?', 'ANSWER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

select * from question;


# 5. bookList

DROP TABLE IF EXISTS book_list;
CREATE TABLE book_list (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT,
    user_id INT,
    game_id INT,
    book_user_id INT,
    book_detail TEXT,
	createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	UpdatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);

INSERT INTO book_list (post_id, user_id, game_id, book_user_id, book_detail, createdDate, UpdatedDate)
VALUES
(101, 1, 201, 1, 'Reservation for upcoming match', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(102, 2, 202, 2, 'Book seats for championship game', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(103, 3, 203, 3, 'Booking for local tournament', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

# 6. Alarm

DROP TABLE IF EXISTS alarm;
CREATE TABLE alarm (
    alarm_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    game_id INT,
    alarm_detail TEXT,
	alarm_read TEXT,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    
);

INSERT INTO alarm (user_id, game_id, alarm_detail, alarm_read, created_date)
VALUES
(1, 201, 'Reservation for upcoming match', 'unread', CURRENT_TIMESTAMP),
(2, 202, 'Book seats for championship game', 'unread', CURRENT_TIMESTAMP),
(3, 203, 'Booking for local tournament', 'unread', CURRENT_TIMESTAMP);

SELECT * FROM alarm;

# 7. MannerTemp
DROP TABLE IF EXISTS manner_temp;
CREATE TABLE manner_temp (
    user_id INT,
    review_id INT,
    marked_id INT,
	game_id INT,
	review_cnt INT
    
);

-- INSERT INTO manner_temp (user_id, review_id, marked_id, game_id, review_cnt)
-- VALUES
-- (1, 1, 201, 'Reservation for upcoming match', 'unread', 5);

-- SELECT * FROM manner_temp;


# 8. PostLike
DROP TABLE IF EXISTS post_like;
CREATE TABLE post_like (
    like_id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT,
    user_id INT,
	game_id INT
);

-- INSERT INTO post_like (post_id, user_id, game_id)
-- VALUES
-- (1, 1, 201);

-- SELECT * FROM post_like;

# 9. Review
DROP TABLE IF EXISTS review;
CREATE TABLE review (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    review_point INT,
    user_id INT,
	marked_id INT,
    review_detail INT,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO review (review_point, user_id, marked_id, review_detail)
VALUES
(5, 1, 2, 101),
(3, 2, 3, 102),
(4, 1, 3, 103);

DROP TABLE IF EXISTS game_info;
CREATE TABLE game_info (
    game_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_DT VARCHAR(30),
    homeTeam VARCHAR(10),
    awayTeam VARCHAR(10),
    homeScore INT,
    awayScore INT,
    game_place VARCHAR(20)
);

INSERT INTO game_info (Game_DT, homeTeam, awayTeam, homeScore, awayScore, game_place) VALUES
('2024-05-15 20:00', 'TeamA', 'TeamB', 3, 2, 'StadiumA'),
('2024-05-16 18:00', 'TeamC', 'TeamD', 1, 1, 'StadiumB'),
('2024-05-17 21:00', 'TeamE', 'TeamF', 0, 4, 'StadiumC');

DROP TABLE IF EXISTS comment;
CREATE TABLE comment (
    comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id BIGINT,
    user_id2 BIGINT,
    game_id2 BIGINT,
    comment_detail TINYTEXT,
    created_date DATETIME,
    updated_date DATETIME
);

INSERT INTO Comment (post_id, user_id2, game_id2, comment_detail, created_date, updated_date)
VALUES
(101, 1001, 2001, 'This game is awesome!', '2024-05-15 10:00:00', '2024-05-15 10:00:00'),
(102, 1002, 2002, 'Could be better.', '2024-05-15 11:00:00', '2024-05-15 11:30:00'),
(103, 1003, 2003, 'Loved the new update!', '2024-05-15 12:00:00', '2024-05-15 12:00:00');

DROP TABLE IF EXISTS recomment;
CREATE TABLE recomment (
    recomment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    comment_id BIGINT,
    post_id BIGINT,
    user_id2 BIGINT,
    game_id2 BIGINT,
    comment_detail TINYTEXT,
    created_date DATETIME,
    updated_date DATETIME
);

INSERT INTO recomment (comment_id, post_id, user_id2, game_id2, comment_detail, created_date, updated_date)
VALUES
(1, 101, 1001, 2001, 'ㄹㅇㅋㅋ', '2024-05-15 10:00:00', '2024-05-15 10:00:00'),
(2, 102, 1002, 2002, '화이팅', '2024-05-15 11:00:00', '2024-05-15 11:30:00'),
(3, 103, 1003, 2003, '점검보상을 내놓아라', '2024-05-15 12:00:00', '2024-05-15 12:00:00');

