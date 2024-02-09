create table main_board
(
    seq         int auto_increment comment '개시판 시퀀스'
        primary key,
    title       varchar(50)   not null comment '게시물 제목',
    content     varchar(5000) null comment '게시물 내용',
    seq_hashtag int           not null comment '해시태그 시퀀스',
    seq_user    int           not null comment '유저 시퀀스',
    like_count  int           null comment '추천수',
    hate_count  int           null,
    seq_comment int           null,
    REG_DT      datetime      not null comment '생성날짜',
    REG_ID      varchar(20)   not null comment '생성 주체 ID',
    UPD_DT      datetime      null,
    UPD_ID      varchar(20)   null,
    constraint main_board_user_info_ID_fk
        foreign key (REG_ID) references shmk.user_info (ID),
    constraint main_board_user_info_ID_fk_2
        foreign key (UPD_ID) references shmk.user_info (ID)
);

create table main_comment
(
    seq             int auto_increment
        primary key,
    board_seq       int           not null comment '게시판 번호',
    content         varchar(5000) null comment '댓글 내용',
    sub_seq         int           null,
    comment_hashtag varchar(21)   null,
    like_count      int           null comment '추천 수',
    hate_count      int           null comment '싫어요 수',
    REG_DT          datetime      not null comment '등록 날짜',
    REG_ID          varchar(20)   not null comment '등록인',
    UPD_DT          datetime      null,
    UPD_ID          varchar(20)   null,
    constraint main_comment_main_board_seq_fk
        foreign key (board_seq) references shmk.main_board (seq),
    constraint main_comment_user_info_ID_fk
        foreign key (REG_ID) references shmk.user_info (ID),
    constraint main_comment_user_info_ID_fk_2
        foreign key (UPD_ID) references shmk.user_info (ID)
)
    comment '게시물 댓글';

create table user_info
(
    ID       varchar(20) not null comment 'ID'
        primary key,
    password varchar(64) null,
    nickname int         null comment '닉네임'
)
    comment '유저 정보';

