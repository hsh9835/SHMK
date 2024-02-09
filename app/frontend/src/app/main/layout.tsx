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

        

            {children}
    )
};