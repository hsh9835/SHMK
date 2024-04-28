import {GithubLogin} from "@components/buttons/loginbuttons";

export default async function login() {

    return(
        <div className={'flex flex-col bg-amber-200 h-full'}>
            <div className={'absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 bg-neutral-50 w-1/2 h-5/6 rounded-3xl p-10'}>
                <div className={'m-44'}>
                    <form method="POST" action="/api/jwt_auth">
                        <h1 className={'text-center text-7xl'}>SHMK</h1>
                        <div id={'Input_Area'} className={'flex flex-col'}>
                            <input type={"text"} className={'mt-5 h-10 pl-5'} name="ID" placeholder={'ID'}/>
                            <input type={"password"} className={'mt-5 h-10 pl-5'} name="PASSWORD" placeholder={'Password'}/>
                        </div>
                        <div className={'mt-5 flex gap-5'}>
                            <button type="submit"  className={'w-1/2 bg-blue-600 p-2.5 text-white rounded-lg'}>Login</button>
                            <button className={'w-1/2 bg-blue-600 p-2.5 text-white rounded-lg'}>회원가입</button>
                        </div>
                    </form>
                    <div className={'mt-3'}>
                        <GithubLogin/>
                    </div>
                </div>
            </div>
        </div>
    )
}