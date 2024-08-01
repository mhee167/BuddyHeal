# 💊 Buddy Heal (버디힐)

📁 코드 : 1.DACON 폴더
<br><br>

## 서비스 소개
### "🤒 미취학 아동 질병 분석 생성형 AI 웹 지원 서비스"
면역 체계가 약해 "바이러스에 취약한 미취학 아동"들을 지키기 위해 24시간 가능한 의료 상담 AI 서비스를 지원합니다.<br>
예방 접종 일정과 같은 기본 의료 정보를 제공하는 것뿐만 아니라 (기후 변화, 대기 오염, 예방 접종 비율, 아동 의료 인프라 등)의 데이터 분석을 통해 예측한 발생 가능성이 높은 질병을 안내하여 사전에 대비할 수 있도록 합니다.
<br><br>

## TEAM 디딤
- 김민희(조장) : BACK (Spring MVC, 프론트&백 연결, 대화내용 DB 저장)<br>
- 황지영 : AI ChatGPT 커스텀, 감염병 예측모델 생성,node.js chatgpt api 연동<br>
- 권정현 : FRONT (메인, 아동질병률, 챗봇 서포트), 컨트롤러 연결<br>
- 한혜원 : FRONT 챗봇, 데이터 수집
<br>

## 개발 환경
- FE : jsp, css, javaScript, jquery
- BE : spring, node.js, python
- DB : Oracle sql developer
- AI : chatGPT
<br>

## 서비스 아키텍쳐
![아키텍처](https://github.com/user-attachments/assets/14b57b67-7cef-4fb6-a0f5-ef5a7996a981)
<br>

## 프로젝트 구조
```bash
📦main
┣ 📂 java
┃ ┗  📂com.daycon.buddyheal.config
┃ ┃ ┗ 📜GPTConfig.java
┃ ┗  📂com.daycon.buddyheal.controller
┃ ┃ ┣ 📜GPTController.java
┃ ┃ ┣ 📜LoginController.java
┃ ┃ ┗ 📜WebController.java
┃ ┗  📂com.daycon.buddyheal.dao
┃ ┃ ┣ 📜ChatLogRepository.java
┃ ┃ ┣ 📜ChatLogRepositoryImpl.java
┃ ┃ ┣ 📜UserRepository.java
┃ ┃ ┗ 📜UserRepositoryImpl.java
┃ ┗  📂com.daycon.buddyheal.model
┃ ┃ ┣ 📜ChatLogDTO.java
┃ ┃ ┣ 📜GPTRequestDTO.java
┃ ┃ ┣ 📜GPTResponseDTO.java
┃ ┃ ┗ 📜Message.java
┃ ┃ ┗📜UserInfoDTO.java
┃ ┗  📂com.daycon.buddyheal.service
┃ ┃ ┣ 📜GPTService.java
┃ ┃ ┣ 📜GPTServiceImpl.java
┃ ┃ ┣ 📜UserService.java
┃ ┃ ┗ 📜UserServiceImpl.java
┗ 📂 webapp
┃ ┗ 📂resources
┃ ┃ ┗ 📂css
┃ ┃ ┃ ┣ 📜chatbot.css
┃ ┃ ┃ ┣ 📜layout.css
┃ ┃ ┃ ┣ 📜main.css
┃ ┃ ┃ ┗ 📜morbidity.css
┃ ┣ 📂img
┃ ┗ 📂js
┃ ┃ ┃ ┣ 📜chart.js
┃ ┃ ┃ ┣ 📜chatbot.js
┃ ┃ ┃ ┣ 📜mainScroll.js
┃ ┃ ┃ ┗ 📜mainSlide.js
┗ 📂WEB-INF
┃ ┣ 📂views
┃ ┃ ┣ 📂chatbot
┃ ┃ ┃ ┗ 📜didimi.jsp
┃ ┃ ┣ 📂morbidity
┃ ┃ ┃ ┗ 📜analysis.jsp
┃ ┃ ┣ 📜footer.jsp
┃ ┃ ┣ 📜header.jsp
┃ ┃ ┗ 📜index.jsp
┃ ┗ 📜web.xml
```
<br><br>

## UI
| 페이지  | 이미지 |
| :---: | :---: |
| 메인  | <img src="https://github.com/user-attachments/assets/5193f9af-bbc5-4651-82ec-f374a1cf7056" alt="메인 페이지" width="650">  |
| 로그인  | <img src="https://github.com/user-attachments/assets/56789f90-6b7e-4f1a-a8ca-4c8f282e9e29" alt="구글 로그인 페이지" width="650">  |
| 챗봇  | <img src="https://github.com/user-attachments/assets/b6f3ed18-ab6b-440f-b422-6c62d2c70294" alt="의료 상담 AI 페이지" width="650">  |
| 질병률  | <img src="https://github.com/user-attachments/assets/69098636-01d2-4d34-9614-0f32acbaa0d8" alt="메인 페이지" width="650">  |
<br>
<br>
