import {MKServer} from "@/pages/api/MKServer";
import ToastUIEditor from "@components/toast_ui/editor/toast_ui_editor";
import ToastUIViewer from "@components/toast_ui/editor/toast_ui_viewer";

export default async function Content(props:any) {

    const boardContent:Promise<string> = await MKServer.get('/hello')
        .then(e=> e.data)
        .catch(() => 'error')


    return (
        <>
            <ToastUIViewer content={"# Hello World"}/>
        </>
    );
}