import {AdditionalContent} from "@main/board/components/AdditionalContent";
import {SearchComponent} from "@main/board/components/SearchComponent";
import {SearchResultType} from "@main/board/components/SearchResultType";
import {BoardList} from "@main/board/components/BoardList";

export interface SearchProps {
    setSearch: React.Dispatch<React.SetStateAction<string>>,
    search: string
}


export default function Board():JSX.Element {

    return (
        <>
            <div className={'my-5 h-7 flex justify-end'}>
                <SearchComponent/>
            </div>
            <div className={'flex w-full h-100'}>
                <div className={'w-4/5 h-full'}>
                    <SearchResultType/>
                    <BoardList/>
                </div>
                <div className={'w-1/5 h-full'}>
                    <AdditionalContent></AdditionalContent>
                </div>
            </div>
        </>
    );
}


