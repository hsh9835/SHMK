'use client'

import { signIn, signOut } from 'next-auth/react'

export function GithubLogin() {



    return (
        <>
            <button onClick={() => {signIn('github')}} className={'bg-black text-white p-2 rounded-lg'}>github</button>
            <button onClick={() => {signOut()}} className={'bg-black text-white p-2 rounded-lg'}>logout</button>
        </>
    )
}