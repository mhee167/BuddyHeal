from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
import joblib
import pandas as pd

# FastAPI 애플리케이션 생성
app = FastAPI()

# 모델 로드
model = joblib.load('health_model.pkl')

# 요청 모델 정의
class PredictionRequest(BaseModel):
    location: str

@app.post("/predict")
def predict(request: PredictionRequest):
    location = request.location
    # 위치 기반 데이터 처리 로직 추가 (예: 위치를 바탕으로 특성 생성)
    # 여기서는 간단히 예를 들어 랜덤한 데이터 사용
    processed_data = pd.DataFrame([[0, 1, 2]])  # 여기에 실제 처리된 데이터를 사용해야 함

    # 예측 수행
    prediction = model.predict(processed_data)
    return {"prediction": int(prediction[0])}

# 서버 실행
if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)
