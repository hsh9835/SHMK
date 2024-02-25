

export function SearchResultType() {

    const typeList:string[] = [
        "React",
        "NextJS",
        "Spring Boot",
        "MariaDB"
    ]

    return (
        <>
            <nav className={'flex'}>
                <a className={'mx-2 ml-5'}>
                    전체
                </a>
                <div className={'mx-2'}>/</div>
                {
                    typeList.map((type) => {
                        return (
                            <>
                                <a className={'mx-2 hover:underline'}>{type}</a>
                            </>
                        )
                    })
                }
            </nav>
        </>
    )
}