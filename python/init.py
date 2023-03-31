from datetime import datetime

FILE_PATH = "../../Downloads/slackbot/resource/questions.txt"
WEBHOOK_URL = "https://hooks.slack.com/services/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"

TODAY = datetime.today().strftime('%Y-%m-%d')  # YYYY-MM-DD 형식으로 날짜표시
WEEKDAYS = datetime.weekday(datetime.today())  # 오늘이 무슨요일인지 0 ~ 6 의 숫자로 표현
WEEKDAYS_WORD = {
    0: '월',
    1: '화',
    2: '수',
    3: '목',
    4: '금',
    5: '토',
    6: '일'
}