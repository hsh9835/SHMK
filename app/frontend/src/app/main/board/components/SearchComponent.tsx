'use client'

import {useState} from "react"

import axios from 'axios'

export function SearchComponent():JSX.Element {

    const [search, setSearch] = useState<string>('')

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
                    axios.post('http://localhost:1045/boardList').then()
                }
            } className={"mx-5 px-5 text-xs rounded-md bg-indigo-600"}>검색</button>
        </>
    )
}