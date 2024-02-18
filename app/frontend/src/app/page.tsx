"use client";

export default function Home() {

  return (
      <>
          <p className={'bg-black'}>hello</p>
          <div className={'bg-white text-black text-lg'}>
              <p className={'text-black bg-red indigo-600 bg-indigo-950'}>hello</p>
              <button className={'py-2 px-4 rounded-md text-white bg-indigo-600'}>Yes</button>
              <div
                  className="pointer-events-auto h-6 w-10 rounded-full p-1 ring-1 ring-inset transition duration-200 ease-in-out bg-indigo-600 ring-black/20">
                  <div
                      className="h-4 w-4 rounded-full bg-white shadow-sm ring-1 ring-slate-700/10 transition duration-200 ease-in-out translate-x-4"></div>
              </div>
              <div
                  className="pointer-events-auto h-6 w-10 rounded-full p-1 ring-1 ring-inset transition duration-200 ease-in-out bg-slate-900/10 ring-slate-900/5">
                  <div
                      className="h-4 w-4 rounded-full bg-white shadow-sm ring-1 ring-slate-700/10 transition duration-200 ease-in-out"></div>
              </div>
          </div>
      </>
  );
}
