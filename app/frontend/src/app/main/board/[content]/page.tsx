import axios from "axios";

export interface SearchProps {
    setSearch: React.Dispatch<React.SetStateAction<string>>,
    search: string
}

export default async function Content(props) {

    // let content = await axios.get()

    return (
        <>
            <div>
                {props.params.content}
            </div>
        </>
    );
}


