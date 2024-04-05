"use client"

import {useEffect, useState} from "react";
import {Switch} from "@headlessui/react";

export function DarkModeSwitch() {
    // const [darkMode, setDarkMode] = useSelector(state => state.darkMode);
    const [darkMode, setDarkMode] = useState<boolean>()


    useEffect(() => {
        const htmlEl = document.documentElement.classList;
        setDarkMode(localStorage.theme === 'dark' || (!('theme' in localStorage) && window.matchMedia('(prefers-color-scheme: dark)').matches))
        if (darkMode) {
            htmlEl.add('dark')
            localStorage.theme = 'dark'
            setDarkMode(true);
        } else {
            htmlEl.remove('dark')
            localStorage.theme = 'light'
            setDarkMode(false);
        }
    }, [darkMode]);

    return (
        <>
            <Switch
                checked={darkMode}
                onChange={setDarkMode}
                className={`${
                    darkMode ? 'bg-gray-200' : 'bg-gray-200'
                } relative inline-flex h-3 w-9 items-center rounded-full`}
            >
                <span className="sr-only">Enable notifications</span>
                <span
                    className={`${
                        darkMode ? 'bg-blue-800 translate-x-2' : 'bg-blue-800 translate-x-0' 
                    } inline-block h-7 w-7 transform rounded-full transition text-white flex justify-center items-center`}
                >
                    {darkMode ?
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor"
                             className="w-4 h-4">
                            <path fillRule="evenodd"
                                  d="M7.455 2.004a.75.75 0 0 1 .26.77 7 7 0 0 0 9.958 7.967.75.75 0 0 1 1.067.853A8.5 8.5 0 1 1 6.647 1.921a.75.75 0 0 1 .808.083Z"
                                  clipRule="evenodd"/>
                        </svg> :
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor"
                             className="w-5 h-5">
                            <path
                                d="M12 2.25a.75.75 0 0 1 .75.75v2.25a.75.75 0 0 1-1.5 0V3a.75.75 0 0 1 .75-.75ZM7.5 12a4.5 4.5 0 1 1 9 0 4.5 4.5 0 0 1-9 0ZM18.894 6.166a.75.75 0 0 0-1.06-1.06l-1.591 1.59a.75.75 0 1 0 1.06 1.061l1.591-1.59ZM21.75 12a.75.75 0 0 1-.75.75h-2.25a.75.75 0 0 1 0-1.5H21a.75.75 0 0 1 .75.75ZM17.834 18.894a.75.75 0 0 0 1.06-1.06l-1.59-1.591a.75.75 0 1 0-1.061 1.06l1.59 1.591ZM12 18a.75.75 0 0 1 .75.75V21a.75.75 0 0 1-1.5 0v-2.25A.75.75 0 0 1 12 18ZM7.758 17.303a.75.75 0 0 0-1.061-1.06l-1.591 1.59a.75.75 0 0 0 1.06 1.061l1.591-1.59ZM6 12a.75.75 0 0 1-.75.75H3a.75.75 0 0 1 0-1.5h2.25A.75.75 0 0 1 6 12ZM6.697 7.757a.75.75 0 0 0 1.06-1.06l-1.59-1.591a.75.75 0 0 0-1.061 1.06l1.59 1.591Z"/>
                        </svg>

                    }
                </span>
            </Switch>
        </>
    );
}