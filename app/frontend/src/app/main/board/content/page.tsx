import {MKServer} from "@/pages/api/MKServer";
import ToastUIViewer from "@components/toast_ui/editor/toast_ui_viewer";
import {ReactElement} from "react";

export const dynamic = "force-dynamic";

export default async function Content():Promise<ReactElement> {

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