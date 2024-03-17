'use client'

import {useEffect, useState} from "react";
import ToastUIEditor from "@components/toast_ui/editor/toast_ui_editor";
import toast, { Toaster } from "react-hot-toast";
import dynamic from "next/dynamic";

const DynamicToastUIEditor = dynamic(
    () => import('@components/toast_ui/editor/toast_ui_editor'),
    { ssr: false }  // This line is important. It disables server-side rendering for this module.
);

export default function Write(){

    const [tempSave, setTempSave] = useState<boolean>(false)

    useEffect(() => {

        tempSave ? toast.success('성공') : null;

        setTimeout(() => {
            setTempSave(false);
        }, 5000)

    }, [tempSave]);

    return(
        <>
            <Toaster
                position='bottom-center'
                reverseOrder={false}
            />
            <div className={'mb-5'}>
                <h3 className={'mb-1.5 dark:text-white'}>제목</h3>
                <input
                    className={'w-full px-3 py-2.5 text-1xl border border-gray-300 rounded-md'}
                    type={'text'}
                    placeholder={'제목을 입력해주세요.'}
                />
            </div>
            <DynamicToastUIEditor/>
            <div>
                <div className={'my-2.5'}>
                    <h3 className={'mb-1.5 dark:text-white'}>유형</h3>
                    <input
                        className={'w-full px-3 py-2.5 text-1xl border border-gray-300 rounded-md'}
                        type={'text'}
                        placeholder={'유형을 등록해주세요. [@유형]'}
                    />
                </div>
            </div>
            <div className={'w-full h-12 flex justify-end mt-2.5 mb-20'}>
                <p className={'text-blue-600'}>
                    {
                        tempSave ?
                            '임시 저장되었습니다.'
                            :
                            ''
                    }
                </p>
                <button
                    onClick={() => setTempSave(true)}
                      className={'ml-2.5 w-28 text-white flex items-center justify-center rounded-xl bg-blue-600 hover:bg-blue-800'}
                >
                    임시 저장
                </button>
                <button
                      className={'ml-2.5 w-28 text-white flex items-center justify-center rounded-xl bg-blue-600 hover:bg-blue-800'}
                >
                    수정
                </button>
            </div>
        </>
    )
}