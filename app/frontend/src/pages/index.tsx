import { GetServerSideProps } from 'next';

export const getServerSideProps: GetServerSideProps = async (context) => {
    return {
        redirect: {
            destination: '/main/board',
            permanent: false,
        },
    }
}

export default function Home() {
    return <div>페이지 로드중..</div>;
}