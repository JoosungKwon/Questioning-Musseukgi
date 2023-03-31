# requests 와 json 을 활용하여 slack bot 조작하기
from init import FILE_PATH, WEBHOOK_URL, WEEKDAYS, WEEKDAYS_WORD, TODAY

import requests
import json
import random

def choose_random_number():
    f = open(FILE_PATH, 'r', encoding='UTF-8')
    file_size = len(list(enumerate(f)))

    return random.randint(1, file_size)

def change_jsondata(today, content):
    payload = {
        "username": "질문하는 머쓱이",
        "icon_emoji": ":yes_mussg:",
        "channel": "test_kwon",
        "text": today + "\n" + content
    }
    return payload

def post_message(payload):
    requests.post(WEBHOOK_URL,
                headers={'Content-Type': 'application/json'},
                data=json.dumps(payload))


def read_txt(random_number):
    with open(FILE_PATH, 'r', encoding='UTF-8') as f:
        count = 0
        while True:
            line = f.readline()
            if not line:
                break    

            count += 1
            if count == random_number:
                return line


if __name__ == "__main__" :
    random_number = choose_random_number()

    read_txt_data = read_txt(random_number)
    setting_info = change_jsondata(TODAY + " " + WEEKDAYS_WORD[WEEKDAYS], read_txt_data)
    post_message(setting_info)