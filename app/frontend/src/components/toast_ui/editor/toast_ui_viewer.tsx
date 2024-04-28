'use client'

import React from "react";
import {Viewer} from "@toast-ui/react-editor";
import '@toast-ui/editor/dist/toastui-editor.css';
import 'tui-color-picker/dist/tui-color-picker.css';
import '@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css';

export default function ToastUIViewer(props: { content: string; }) {

    return (<>
        <Viewer
            initialValue={props.content}
        />
    </>
    );
}