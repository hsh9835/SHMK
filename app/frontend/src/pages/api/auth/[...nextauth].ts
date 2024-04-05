import NextAuth from 'next-auth'
import GithubProvider from 'next-auth/providers/github'

export const authOptions = {
    providers: [
        GithubProvider({
            clientId: 'b32e369ea9e5a0c88421',
            clientSecret: '2327a20e2045ccd8040d8188aa08cf8f9e68816d',
        }),
    ],
    secret:'qwer1234'
};

export default NextAuth(authOptions);