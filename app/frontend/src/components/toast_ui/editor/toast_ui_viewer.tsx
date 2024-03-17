'use client'

import React from "react";
import {Viewer} from "@toast-ui/react-editor";
import '@toast-ui/editor/dist/toastui-editor.css';
import 'tui-color-picker/dist/tui-color-picker.css';
import '@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css';
import colorSyntax from '@toast-ui/editor-plugin-color-syntax';

export default function ToastUIViewer() {

    return (<>
        <Viewer
            initialValue="# Hello World!"
        />
    </>
    );
}