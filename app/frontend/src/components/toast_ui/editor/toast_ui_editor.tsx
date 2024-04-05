'use client'

import React from "react";
import {Editor, Viewer} from "@toast-ui/react-editor";
import '@toast-ui/editor/dist/toastui-editor.css';
import 'tui-color-picker/dist/tui-color-picker.css';
import '@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css';
import colorSyntax from '@toast-ui/editor-plugin-color-syntax';

export default function ToastUIEditor() {

    const toolbarItems = [
        ['heading', 'bold', 'italic', 'strike'],
        ['hr'],
        ['ul', 'ol', 'task'],
        ['table', 'link'],
        ['image'],
        ['code'],
        ['scrollSync'],
    ];

    return (<>
        <Editor
            initialValue=" "
            height="calc(100% - 10rem)"
            initialEditType={'wysiwyg'}
            previewStyle={window.innerWidth > 1000 ? 'vertical' : 'tab'}
            hideModeSwitch={false}
            usageStatistics={true}
            toolbarItems={toolbarItems}
            useCommandShortcut={true}
            viewer={true}
            plugins={[colorSyntax]}
        />
    </>
    );
}