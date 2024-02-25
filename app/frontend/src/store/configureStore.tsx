import { createStore, applyMiddleware } from 'redux';
import thunkMiddleware from 'redux-thunk';
import { composeWithDevTools } from 'redux-devtools-extension';

// 초기 상태
const initialState = {
    // 초기 상태를 여기에 정의
};

// 리듀서
const reducer = (state = initialState, action) => {
    switch (action.type) {
        // 액션 유형에 따른 상태 업데이트 로직을 작성
        default:
            return state;
    }
};

// 미들웨어
const middleware = [thunkMiddleware];

// 스토어 생성
const store = createStore(
    reducer,
    initialState,
    composeWithDevTools(applyMiddleware(...middleware))
);

export default store;


