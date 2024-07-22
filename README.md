# 미취학 아동 질병 분석 생성형 AI 웹 지원 서비스

## 프로젝트 설명
이 프로젝트는 미취학 아동의 건강 상태를 예측하고 질병 발생 가능성, 예방 접종 일정 등을 안내하는 시스템입니다.

### 백엔드
- Spring framework를 사용하여 RESTful API를 제공합니다.
- 사용자의 위치를 받아 AI 모델 서버에 예측 요청을 보냅니다.

### AI 모델
- Python과 scikit-learn을 사용하여 미취학 아동의 건강 상태를 예측하는 모델을 구축합니다.
- Flask를 사용하여 모델 예측 결과를 REST API로 제공합니다.

### 실행 방법
#### 백엔드
1. 프로젝트 루트 디렉토리로 이동
2. `mvn spring-boot:run` 명령어 실행

#### AI 모델 서버
1. `ai_model` 디렉토리로 이동
2. `pip install -r requirements.txt` 명령어로 필요한 패키지 설치
3. `python model.py` 명령어로 서버 실행



## 프로젝트 구조
├── backend
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── healthprediction
│   │   │   │               ├── HealthPredictionApplication.java
│   │   │   │               ├── controller
│   │   │   │               │   └── PredictionController.java
│   │   │   │               ├── model
│   │   │   │               │   └── PredictionRequest.java
│   │   │   │               └── service
│   │   │   │                   └── PredictionService.java
│   │   │   └── resources
│   │   │       └── application.properties
├── ai_model
│   ├── model.py
│   └── requirements.txt
└── README.md


