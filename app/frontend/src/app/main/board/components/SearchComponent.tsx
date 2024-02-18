import {SearchProps} from "@main/board/page"

export function SearchComponent(props:SearchProps) {

    return (
        <div className={'my-5 h-7 flex justify-end'}>
            <input className={"px-2 text-black"} type={"text"} placeholder={"검색어를 입력하세요"} onChange={
                e => {
                    props.setSearch(e.target.value)
                }
            }/>
            <button onClick={
                () => {
                    console.log(props.search)
                }
            } className={"mx-5 px-5 text-xs rounded-md bg-indigo-600"}>검색</button>
        </div>
    )
}