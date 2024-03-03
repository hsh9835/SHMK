export default async function Content(props:any) {

    // let content = await axios.get()

    return (
        <>
            <div>
                {props.params.content}
            </div>
        </>
    );
}


