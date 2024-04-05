import {AdditionalContent} from "@main/board/components/AdditionalContent";
import {SearchComponent} from "@main/board/components/SearchComponent";
import {SearchResultType} from "@main/board/components/SearchResultType";
import {BoardList} from "@main/board/components/BoardList";
import Link from "next/link";

export interface SearchProps {
    setSearch: React.Dispatch<React.SetStateAction<string>>,
    search: string
}


export default function Board():JSX.Element {

    return (
        <>
            <div className={'mb-5 flex'}>
                <Link href={'/main/board/write'}
                      className={'mr-auto w-20 text-white flex items-center justify-center rounded-xl bg-blue-600 hover:bg-blue-800'}
                >
                    작성
                </Link>
                <SearchComponent/>
            </div>
            <div className={'flex flex-grow'}>
                <div className={'w-4/5'}>
                    <SearchResultType/>
                    <BoardList/>
                </div>
                <div className={'ml-5 w-1/5'}>
                    <AdditionalContent/>
                </div>
            </div>
        </>
    );
}


