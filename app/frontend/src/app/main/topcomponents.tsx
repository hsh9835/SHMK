import {Link} from "react-router-dom";
import {useState} from "react";

import {lMenus, rMenus} from "@config/url/linkMenu";

// className 작성할때 마지막에 공백 꼭 작성할것
/** [세화] top menu에 사용되는 tailwindcss classname */
const menuCss:string = 'inline-block rounded-lg px-3 py-1 text-sm text-white hover:bg-slate-100 hover:text-slate-900 '

/** 상단[Top]
 *  - Logo
 *  - Navigator
 *  - Login 버튼
 * */
export default function TopFrameComponent() {

    const [login, setLogin] = useState(false)

    return(
        <div className={'flex w-full h-15 px-24 py-3'}>
            <div className={'h-auto text-3xl'}>Feedback</div>
            <div className={'flex items-center ml-10 text-3xl'}>
                {lMenus.map((e) => {
                    // return (<a className={menuCss} href={e.url}>{e.name}</a>)
                    return (<Link className={menuCss} to={e.url}>{e.name}</Link>)
                })}
            </div>

            <div className={'flex ml-auto items-center text-3xl'}>
                {
                    login ?
                    <div className={'inline-block rounded-lg px-3 py-1 text-sm text-white'}>Login</div>
                    :
                        <>
                            {rMenus.map(e => {
                                return (<button className={menuCss} onClick={() => {
                                    setLogin(true)
                                }
                                }>{e.name}</button>)
                                // return (<Link className={menuCss} to={e.url}>{e.name}</Link>)
                            })}
                        </>
                }
            </div>


        </div>
    )
}