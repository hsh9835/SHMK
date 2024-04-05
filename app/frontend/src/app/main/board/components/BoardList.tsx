import axios from "axios";
import Link from "next/link";

interface BoardContents {
    boardSeq:number,
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
                boardSeq:1,
                title: "React에 대하여",
                hashtag: ["@react", "@NextJS", "@SpringBoot", "@MariaDB"],
                nickName: "SeHwa",
                likeCount: 10,
                comment: 1,
                picture: null
            },
            {
                boardSeq:2,
                title: "LLM 모델 mixtral 구글에 역전 당하나?",
                hashtag: ["@react", "@NextJS", "@SpringBoot", "@MariaDB"],
                nickName: "SeHwa",
                likeCount: 10,
                comment: 1,
                picture: null
            },
            {
                boardSeq:3,
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
                            <Link href={'/main/board/' + board.boardSeq} className={"flex my-3 px-5 py-4 rounded-xl bg-gray-50 shadow-lg hover:bg-gray-100 dark:bg-gray-800 dark:hover:bg-gray-900 dark:text-gray-300 dark:border-gray-300"}>
                                {<div className={'group flex w-full items-center'}>
                                    <div
                                        className="w-10 h-10 bg-blue-500 rounded-full flex items-center justify-center text-white">
                                        H
                                    </div>
                                    <div className={'group flex-row w-8/12 mx-3'}>
                                        <div className={'border pl-2.5'}>{board.title}</div>
                                        <div className={'border pl-2.5'}>
                                            {
                                                Array.isArray(board.hashtag) && board.hashtag.every(tag => typeof tag === 'string') ?
                                                    board.hashtag.map((tag, tagIndex) => {
                                                        return (<a href={'#'} className={'mr-3.5'}>{tag}</a>)
                                                    }) : ''
                                            }
                                        </div>
                                    </div>
                                    <div className={'group flex items-center justify-center border mx-1 px-5 w-1/12 h-full'}>
                                        <p className={'overflow-hidden overflow-ellipsis'}>{board.nickName}</p>
                                    </div>
                                    <div className={'group flex items-center justify-center border mx-1 px-5 w-1/12 h-full'}>
                                        <p>추천 :</p>
                                        <p className={'overflow-hidden overflow-ellipsis'}>{board.likeCount}</p>
                                    </div>
                                    <div className={'group flex items-center justify-center border mx-1 px-5 w-1/12 h-full'}>
                                        <p>댓글 :</p>
                                        <p className={'overflow-hidden overflow-ellipsis'}>{board.likeCount}</p>
                                    </div>
                                </div>}
                            </Link>
                        </>
                    );
                })
            }
        </div>
    )
}