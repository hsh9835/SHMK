import { createStore } from 'redux';

// 초기 상태
const initialState = {
    darkMode: window.matchMedia
};

// 리듀서
const reducer = (state = initialState, action: { type:never }) => {
    switch (action.type) {
        // 액션 유형에 따른 상태 업데이트 로직을 작성
        default:
            return state;
    }
};

// 미들웨어
// const middleware = [ThunkMiddleware];

// 스토어 생성
const store = createStore(
    reducer,
    initialState,
    // composeWithDevTools(applyMiddleware(...middleware))
);

export default store;


