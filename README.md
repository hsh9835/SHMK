<div align="center">
    <h1>
        SHMK
    </h1>
    <h3>
        SeHwa & MikYeong's Toy Project
    </h3>
    <h5>
        홍세화와 정미경의 NextJS + SptringBoot 프로젝트
    </h5>
    <img src="https://img.shields.io/badge/14.1.0---?logo=react&label=NextJS&labelColor=dark"/>
    <img src="https://img.shields.io/badge/3.2.2---?logo=spring&label=spring&labelColor=dark"/>

</div>

* * *

## 프로젝트 진행상황

> ### 진행률
> ![Progress](https://progress-bar.dev/30)
>>해당 프로젝트는 제일 기본적인 게시판 제작을 목적으로 시작된 프로젝트, 추후 **Azure Cloud** 서버에 배포후 NextJS가 React를 개선하기 위해 탄생한 가장 큰 이유인 SEO 최적화를 테스트 해볼 예정
>
> >추후 ReactQuery를 이용한 실시간 채팅 기능을 구축 후 여러 방면에서 연구 할 예정


### [__FrontEnd__](https://github.com/hsh9835/SHMK/tree/feature/frontend)
![Yarn Version](https://img.shields.io/badge/4.1.0---?logo=yarn&label=yarn&labelColor=dark&color=blue)
![NextJS](https://img.shields.io/badge/14.1.0---?logo=react&label=NextJS&labelColor=dark)
![React](https://img.shields.io/badge/18.2.0---?logo=react&label=React&labelColor=dark)
![TypeScript](https://img.shields.io/badge/5.3.3---?logo=typescript&label=TypeScript&labelColor=dark)


---
- [x] List 페이지
- [ ] 읽기 페이지
  - BackEnd 구축 필요
  - testController와 Ajax 통신 가능 (Cors 설정)
- [ ] 쓰기 페이지
  - BackEnd 구축 필요
- [ ] Redux
  - 당장은 쓸일이 없을거 같음
- [x] Yarn PnP 적용
  - Yarn 기반임으로 다음의 설정 과정을 수행하기 바람(추후 .sh .bat 파일 작성후 정식 배포 예정)
    ```shell
    # ./SHMK
    cd add/frontend
    yarn install
    yarn next dev
    ```

### [__BackEnd__](https://github.com/hsh9835/SHMK/tree/feature/backend)
![Spring_Boot](https://img.shields.io/badge/3.2.2---?logo=spring&label=spring&labelColor=dark)

---
- [x] docker-compose - mariadb 기반 구축
- [x] DTO 구축
- [x] 컨트롤러 구축 완료
- [ ] JPA 테이블 생성
  - 시도중이나 계속 오류가 발생한다고함..
    - 분발하시길..
- [ ] CORS 설정
  개발 과정의 편의성을 위해 제한 해제
