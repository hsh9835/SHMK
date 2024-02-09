"use client"

import React, {useState} from "react";
import {AdditionalContent} from "@/app/main/board/AdditionalContent";
import {SearchComponent} from "@/app/main/board/SearchComponent";
import {SearchResultType} from "@/app/main/board/SearchResultType";
import {BoardList} from "@/app/main/board/BoardList";

export interface SearchProps {
    setSearch: React.Dispatch<React.SetStateAction<string>>,
    search: string
}


export default function Board() {

    const [search, setSearch] = useState<string>("안녕")

    return (
        <>
            <div className={'text-white'}>{search}</div>
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


