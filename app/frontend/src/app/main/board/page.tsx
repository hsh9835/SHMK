'use client'

import React, {useState} from "react";
import {AdditionalContent} from "@main/board/components/AdditionalContent";
import {SearchComponent} from "@main/board/components/SearchComponent";
import {SearchResultType} from "@main/board/components/SearchResultType";
import {BoardList} from "@main/board/components/BoardList";

export interface SearchProps {
    setSearch: React.Dispatch<React.SetStateAction<string>>,
    search: string
}


export default function Board() {

    const [search, setSearch] = useState<string>("안녕")

    return (
        <>
            <SearchComponent search={search} setSearch={setSearch}/>
            <div className={'flex flex-row w-full h-100'}>
                <div className={'w-4/5 h-full'}>
                    <SearchResultType search={search} setSearch={setSearch}></SearchResultType>
                    <BoardList search={search} setSearch={setSearch}></BoardList>
                </div>
                <div className={'w-1/5 h-full'}>
                    <AdditionalContent></AdditionalContent>
                </div>
            </div>
        </>
    );
}


