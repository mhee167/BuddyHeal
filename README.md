# 미취학 아동 질병 분석 생성형 AI 웹 지원 서비스


## 프로젝트 설명
이 프로젝트는 미취학 아동의 건강 상태를 예측하고 질병 발생 가능성, 예방 접종 일정 등을 안내하는 시스템입니다.


## 프론트엔드

- jsp, html, js, css를 사용하여 화면을 구성합니다.




### index 페이지 (메인)
![image](https://github.com/user-attachments/assets/c6c2dc3d-4127-4019-97a2-92f7941da64e)

![image](https://github.com/user-attachments/assets/362e73b4-7372-4648-bcb7-7cc01475dbd1)



### chat bot 페이지
 
![image](https://github.com/user-attachments/assets/d402c134-aaf9-4517-acdb-6b182719ee03)

![image](https://github.com/user-attachments/assets/d09e6a75-9cb2-4cc0-9018-707eb3c0a607)
- 챗봇과의 대화는 사용자가 메시지를 입력하고 엔터키를 누르거나 카테고리 버튼을 클릭하면 시작됨.


## morbidity 페이지 (아동 질병률)

- 아동 질병률 페이지는 Chart.js를 이용하여 데이터를 시각화하였고 모든 화면은 반응형 웹 디자인을 적용.

![image](https://github.com/user-attachments/assets/90150f24-51c2-4fc8-9400-e585b2e53d7b)

![image](https://github.com/user-attachments/assets/186e421e-8c31-4602-87a7-7700f4cd3c39)

![image](https://github.com/user-attachments/assets/d412c5a7-79a4-4217-9126-d83bfdd8759e)



## 백엔드
- Spring framework를 사용하여 RESTful API를 제공
- 구글 로그인 api를 활용한 회원가입/로그인 기능
- 구글 이메일을 기반으로 대화기록 저장 기능.


## ai 
- spring framework통해 chatgpt-api를 연결해서 실행 시켰지만 fine-tuning과 시나리오 적용에 어려움이 생겨 node.js에서 gpt-assistant를 연결시키고 비동기 방식으로 spring mvc에서 gpt연결을 구현
   - gpt-assistant : openai-dashboard에서 파일을 넣어서 학습시키고 fine-tuning을 해서 상황에 따른 시나리오를 학습


## 예측
- Holt-Winters 지수평활법을 이용한 예측 분석
  - 환경 요인이 감염병과 상관관계가 있음을 파악한 후, 계절성을 고려하여 시계열 데이터의 패턴을 모델링하기 위해 Holt-Winters 지수평활법을 사용. 월별 평균기온, 미세먼지, 소아과 개수를 포함한 데이터를 기반으로 예측 분석을 수행.
  - 2024년 1월까지의 데이터를 학습에 사용하고, 2024년 6월까지의 데이터를 테스트에 사용했으며, 2024년 7월부터 12월까지의 예측을 수행함. 분석 결과, R² 값은 0.7로 나타나 다른 시계열 모델에 비해 높은 성능을 보임


## 건의사항
- 로컬 환경에서의 실행이 적절하지 않다면, 임시 배포 고려 여부.



## 현재 남은 일정
1. 백엔드, 프론트엔드, 모델 코드 통합
2. ai 모델은 현재 fine-tuning 및 학습데이터 입력 진행중


## 프로젝트 구조





