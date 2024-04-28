import Link from "next/link";
import { DarkModeSwitch } from "@/components/switchs";
import {authOptions} from "@/pages/api/auth/[...nextauth]";
import {getServerSession} from "next-auth";
import {ReactElement, ReactNode} from "react";

interface TopMenu {
    name: string,
    url: string
}

export default async function MainLayout({children}: Readonly<{ children: ReactNode }>):Promise<ReactElement> {

    const session = await getServerSession(authOptions)

    const topLeftMenu: TopMenu[] = [
        {
            name: "Board",
            url: "/main/board"
        },
        {
            name: "admin",
            url: "/main/admin"
        },
    ];

    if(session) {
        console.log('session is exist')
    } else {
        console.log('session not exist')
    }
    console.log(session)



    return (
        <div id={'PageView'} className={'flex flex-col h-full'}>
            <div id={'Topcomponents'} className={'topcomponents'}>
                <div id={'PageLogo'} className={'h-auto text-3xl'}>SHMK</div>
                <div id={'TopLeftArea'} className={'flex items-center ml-10 text-3xl'}>
                    {
                        topLeftMenu.map(data => {
                            return (
                                <>
                                    <Link href={data.url} className={'topMenu'}>{data.name}</Link>
                                </>
                            )
                        })
                    }
                </div>
                <div id={'TopRightArea'} className={'flex items-center ml-auto'}>
                    <div id={'DarkModeSwitchArea'} className={'flex'}>
                        <DarkModeSwitch/>
                    </div>
                    {
                        session ?
                            <Link href={"/login"} className={'topMenu'}>Login</Link>
                            :
                            <button className={'bg-black text-white p-2 rounded-lg'}>logout</button>
                    }
                </div>
            </div>
            <div id={'ContentsArea'} className={'flex flex-col flex-grow overflow-auto px-24 py-5'}>
                {children}
            </div>
        </div>
    )
}