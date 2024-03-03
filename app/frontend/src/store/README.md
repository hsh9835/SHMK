# Store 디렉토리 관련 설명

store 디렉토리는 redux 관리를 위해서 생성한 디렉토리인데, NextJS에서는 Stage Management를 해당 디렉토리에서 관리하는게 규칙인듯 하다.   
좌우지간 해당 디렉토리의 설명을 잠깐 하자면 다음과 같다

- configureStore.tsx   
Redux 스토어를 생성하고 내보내는 파일
- reducers.tsx   
리듀서 함수들을 정의하는 파일
- actions.tsx   
액션 생성자 함수들을 정의하는 파일

index.js 파일은 Redux 스토어를 생성하고, reducers.js 파일은 애플리케이션의 모든 리듀서를 결합하고, actions.js 파일은 액션 생성자 함수들을 정의한다고 한다.