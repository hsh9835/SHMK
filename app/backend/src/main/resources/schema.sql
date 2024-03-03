-- user_info 테이블 생성
CREATE TABLE IF NOT EXISTS user_info (
    ID VARCHAR(20) NOT NULL COMMENT 'ID' PRIMARY KEY,
    password VARCHAR(64) NULL,
    nickname INT NULL COMMENT '닉네임'
) COMMENT '유저 정보';

-- main_board 테이블 생성
CREATE TABLE IF NOT EXISTS main_board (
    seq INT AUTO_INCREMENT COMMENT '게시판 시퀀스' PRIMARY KEY,
    title VARCHAR(50) NOT NULL COMMENT '게시물 제목',
    content VARCHAR(5000) NULL COMMENT '게시물 내용',
    seq_hashtag INT NOT NULL COMMENT '해시태그 시퀀스',
    seq_user INT NOT NULL COMMENT '유저 시퀀스',
    like_count INT NULL COMMENT '추천수',
    hate_count INT NULL,
    seq_comment INT NULL,
    REG_DT DATETIME NOT NULL COMMENT '생성날짜',
    REG_ID VARCHAR(20) NOT NULL COMMENT '생성 주체 ID',
    UPD_DT DATETIME NULL,
    UPD_ID VARCHAR(20) NULL,
    CONSTRAINT main_board_user_info_ID_fk FOREIGN KEY (REG_ID) REFERENCES user_info (ID),
    CONSTRAINT main_board_user_info_ID_fk_2 FOREIGN KEY (UPD_ID) REFERENCES user_info (ID)
);

-- main_comment 테이블 생성
CREATE TABLE IF NOT EXISTS main_comment (
    seq INT AUTO_INCREMENT PRIMARY KEY,
    board_seq INT NOT NULL COMMENT '게시판 번호',
    content VARCHAR(5000) NULL COMMENT '댓글 내용',
    sub_seq INT NULL,
    comment_hashtag VARCHAR(21) NULL,
    like_count INT NULL COMMENT '추천 수',
    hate_count INT NULL COMMENT '싫어요 수',
    REG_DT DATETIME NOT NULL COMMENT '등록 날짜',
    REG_ID VARCHAR(20) NOT NULL COMMENT '등록인',
    UPD_DT DATETIME NULL,
    UPD_ID VARCHAR(20) NULL,
    CONSTRAINT main_comment_main_board_seq_fk FOREIGN KEY (board_seq) REFERENCES main_board (seq),
    CONSTRAINT main_comment_user_info_ID_fk FOREIGN KEY (REG_ID) REFERENCES user_info (ID),
    CONSTRAINT main_comment_user_info_ID_fk_2 FOREIGN KEY (UPD_ID) REFERENCES user_info (ID)
) COMMENT '게시물 댓글';
