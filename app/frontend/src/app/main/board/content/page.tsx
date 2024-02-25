import axios from "axios";

export interface SearchProps {
    setSearch: React.Dispatch<React.SetStateAction<string>>,
    search: string
}

export async function getServerSideProps(context) {
    const { title } = context.query;
    const res = await axios.get(``);
    const data = res.data;

    // Note: this will be passed as props to your page component
    return { props: { data } };
}

export default function Content() {

    return (
        <>
            <div>
                {title}
            </div>
        </>
    );
}


