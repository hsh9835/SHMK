import {MKServer} from "@/api/MKServer";

export default async function Content(props:any) {

    const boardContent = MKServer.get('/hello')
        .then(e=>e.data)
        .catch(() => 'error')

    return (
        <>
            <div>
                {props.params.content}
                {boardContent}
            </div>
        </>
    );
}