'use client'

import { useState } from "react"

export function SearchComponent() {

    const [search, setSearch] = useState<string>("안녕")

    return (
        <>
            <div className={'text-white mr-auto'}>{search}</div>
            <input className={"px-2 text-black"} type={"text"} placeholder={"검색어를 입력하세요"} onChange={
                e => {
                    setSearch(e.target.value)
                }
            }/>
            <button onClick={
                () => {
                    console.log(search)
                }
            } className={"mx-5 px-5 text-xs rounded-md bg-indigo-600"}>검색</button>
        </>
    )
}