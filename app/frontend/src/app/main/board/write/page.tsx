import ToastUIEditor from "@components/toast_ui_editor";

export default function write(){
    return(
        <>
            <div className={'mt-10 h-screen'}>
                <div className={'mb-5'}>
                    <h3 className={'mb-1.5 dark:text-white'}>제목</h3>
                    <input
                        className={'w-full px-3 py-2.5 text-1xl border border-gray-300 rounded-md'}
                        type={'text'}
                        placeholder={'제목을 입력해주세요.'}
                    />
                </div>
                <ToastUIEditor/>
            </div>
        </>
    )
}