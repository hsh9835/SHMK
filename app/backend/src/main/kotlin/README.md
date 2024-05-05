# Package 설명

## 구성 요소

> # main
> backend
> > ## common   
> > ENUM 모음
> 
> > ## config
> > Spring 관련 설정 모음
> > > ### Security
> > > `SpringSecurity`를 사용하여 보안을 관리함
> > 
> > > ### Swagger
> > > Swagger는 API 프론트엔드와 백엔드의 협업을 위해서 사용하는 툴인데 이 툴을 이용하면 요청 주소를 손쉽게 확인할 수 있음
> > 
> > > ### Jackson
> > > Rest 통신시 `JSON`으로 데이터를 변환해서 보내주기 위한 라이브러리로 `GSON`과 많이 비교가 되는데 `JackSON`이 좀 더 Spring 친화적이라고함 
> 
> > ## controller
> > 웹 API 관련 서비스 모음
> 
> > ## dto
> > dto 모음   
> > 내부 요소에 request, response 별 패키지가 존재
> 
> > ## entity
> > JPA 테이블 객체 모음
> 
> > ## repository
> > JPA 관련 Interface 모음
> 
> > ## service
> > 서비스 모음 아마
