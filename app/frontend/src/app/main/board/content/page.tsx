import {MKServer} from "@/pages/api/MKServer";
import ToastUIViewer from "@components/toast_ui/editor/toast_ui_viewer";

export default async function Content() {

    const boardContent:Promise<string> = await MKServer.get('/hello')
        .then(e=> e.data)
        .catch(() => 'error')

    console.log(boardContent)
    console.log(typeof boardContent)

    return (
        <>
            <ToastUIViewer content={"# Hello World"}/>
        </>
    );
}