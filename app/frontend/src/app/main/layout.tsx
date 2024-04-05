import Link from "next/link";
import { DarkModeSwitch } from "@/components/switchs";

interface TopMenu {
    name: string,
    url: string
}

export default function MainLayout({children}: Readonly<{ children: React.ReactNode }>): JSX.Element {


    const topMenus: TopMenu[] = [
        {
            name: "Board",
            url: "/main/board"
        },
        {
            name: "admin",
            url: "/main/admin"
        },
        {
            name: "login",
            url: "/main/login"
        }
    ]


    return (
        <div id={'PageView'} className={'flex flex-col h-full'}>
            <div id={'Topcomponents'} className={'topcomponents'}>
                <div id={'PageLogo'} className={'h-auto text-3xl'}>SHMK</div>
                <div id={'TopMenuArea'} className={'flex items-center ml-10 text-3xl'}>
                    {
                        topMenus.map(data => {
                            return (
                                <>
                                    <Link href={data.url} className={'topMenu'}>{data.name}</Link>
                                </>
                            )
                        })
                    }
                </div>
                <div id={'DarkModeSwitchArea'} className={'ml-auto flex items-center'}>
                    <DarkModeSwitch/>
                </div>
            </div>
            <div id={'ContentsArea'} className={'flex flex-col flex-grow overflow-auto px-24 py-5'}>
                {children}
            </div>
        </div>
    )
}