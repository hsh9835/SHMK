import {Avatar} from "@mui/material";
import axios from "axios";
import Link from "next/link";

interface BoardContents {
    title: string,
    hashtag: string[] | null,
    nickName: string,
    likeCount: number | 0,
    comment: number | 0,
    picture: string | null | undefined
}

export function BoardList() {


    const boardList:BoardContents[] = [
            {
                title: "React에 대하여",
                hashtag: ["@react", "@NextJS", "@SpringBoot", "@MariaDB"],
                nickName: "SeHwa",
                likeCount: 10,
                comment: 1,
                picture: null
            },
            {
                title: "LLM 모델 mixtral 구글에 역전 당하나?",
                hashtag: ["@react", "@NextJS", "@SpringBoot", "@MariaDB"],
                nickName: "SeHwa",
                likeCount: 10,
                comment: 1,
                picture: null
            },
            {
                title: "홍세화와 정미경의 프로젝트 이제 시작되다.",
                hashtag: ["@react", "@NextJS", "@SpringBoot", "@MariaDB"],
                nickName: "SeHwa",
                likeCount: 10,
                comment: 1,
                picture: null
            }
        ];

    return (
        <div>
            {
                boardList.map((board, boardIndex) => {

                    return (
                        <>
                            <Link href={'/main/board/'+board.contentID} className={"group flex my-3 px-5 py-4 bg-red-700 rounded-xl"}>
                                <div className={'group flex w-full'}>
                                <Avatar className={'items-center justify-center'}>{board.picture ? board.picture : 'H'}</Avatar>
                                    <div className={'group flex-row h-full mx-3 w-96'}>
                                        <div className={'border pl-2.5'}>{board.title}</div>
                                        <div className={'border pl-2.5'}>
                                            {
                                                Array.isArray(board.hashtag) && board.hashtag.every(tag => typeof tag === 'string') ?
                                                    board.hashtag.map((tag, tagIndex) => {
                                                        return(<a href={'#'} className={'mr-3.5'}>{tag}</a>)
                                                    }):''
                                            }
                                        </div>
                                    </div>
                                    <div className={'group flex items-center justify-center border mx-1 px-5'}>
                                        {board.nickName}
                                    </div>
                                    <div className={'group flex items-center justify-center border mx-1 px-5'}>
                                        추천 : {board.likeCount}
                                    </div>
                                    <div className={'group flex items-center justify-center border mx-1 px-5'}>
                                        추천 : {board.likeCount}
                                    </div>
                                </div>
                            </Link>
                        </>
                    );
                })
            }
        </div>
    )
}