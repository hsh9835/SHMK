import {SearchProps} from "@/app/main/board/page";

interface BoardContents {
    title: string,
    hashtag: string[] | null,
    nickName: string,
    likeCount: number | 0,
    comment: number | 0,
    picture: string | null | undefined
}

export function BoardList(props:SearchProps) {

    props.search

    const boardList: [BoardContents] = [
            {
                title: "title",
                hashtag: ["@react", "@NextJS", "@SpringBoot", "@MariaDB"],
                nickName: "nickName",
                likeCount: 10,
                comment: 1,
                picture: null
            },
            {
                title: "title",
                hashtag: ["@react", "@NextJS", "@SpringBoot", "@MariaDB"],
                nickName: "nickName",
                likeCount: 10,
                comment: 1,
                picture: null
            },
            {
                title: "title",
                hashtag: ["@react", "@NextJS", "@SpringBoot", "@MariaDB"],
                nickName: "nickName",
                likeCount: 10,
                comment: 1,
                picture: null
            }
        ];

    return (
        <div>
            {
                boardList.map((board) => {

                    return(
                        <>
                            <div className={"w-full h-5 bg-white outline-1 outline-black"}>
                                <div>{board.picture}</div>
                                <div className={'flex-initial'}>
                                    <div className={'text-black'}>{board.title}</div>
                                </div>
                            </div>
                        </>
                    )
                })
            }
        </div>
    )
}