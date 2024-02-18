import Link from "next/link";

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
        }
    ]


    return (
        <>
            <div className={'topcomponents'}>
                <div className={'h-auto text-3xl'}>SHMK</div>
                <div className={'flex items-center ml-10 text-3xl'}>
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
            </div>
            <div className={'px-5 h-full'}>
                {children}
            </div>
        </>
    )
}