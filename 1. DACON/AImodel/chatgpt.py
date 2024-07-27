import requests
import json

# OpenAI API 키 설정
api_key = ""  # OpenAI 대시보드에서 발급받은 API 키를 여기에 입력하세요.

# API 요청을 보낼 URL 설정
url = "https://api.openai.com/v1/chat/completions"

# 요청 헤더 설정
headers = {
    "Content-Type": "application/json",
    "Authorization": f"Bearer {api_key}"
}

# 요청 데이터 설정
data = {
    "model": "gpt-3.5-turbo",
    "messages": [
        {"role": "system", "content": "You are a helpful assistant."},
        {"role": "user", "content": "Hello! How can I use ChatGPT API?"}
    ]
}

# 요청을 보내고 응답 받기
response = requests.post(url, headers=headers, data=json.dumps(data))

# 응답 출력
if response.status_code == 200:
    response_data = response.json()
    print("응답 성공:", response_data)
    print("GPT-3의 응답:", response_data['choices'][0]['message']['content'])
else:
    print("응답 실패:", response.status_code, response.text)
