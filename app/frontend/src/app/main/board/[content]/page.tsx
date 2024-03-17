import {MKServer} from "@/api/MKServer";
import ToastUIEditor from "@components/toast_ui/editor/toast_ui_editor";
import ToastUIViewer from "@components/toast_ui/editor/toast_ui_viewer";

export default async function Content(props:any) {

    const boardContent = MKServer.get('/hello')
        .then(e=> e.data)
        .catch(() => 'error')

    return (
        <>
            <div>
                {props.params.content}
                {boardContent}
            </div>
            <ToastUIViewer/>
        </>
    );
}