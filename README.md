# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 요구 사항

1. 자동차 대 수와 레이서 이름, 횟수를 입력 받아 승자를 가려 내는 초간단 게임
2. 횟수 마다 자동차는 각각 랜덤으로 앞으로 전진 가능 (40%확률)

### 객체

- Car
  - public new
  - new(int canGoPercent)
  - boolean movable()

- Racer
  - String racerName
  
- Distance
  - int distance()
  - int add()

- Player
  - 멤버 변수
    - Racer
    - Car
  - int nextDistance(Distance currentDistance)
  - Racer getRacer()

- GameManager
  - public new(int roundCount, List\<Players\> players)
  - GameStatus play()

- RoundStatus
  - public new(Map\<Racer, Distance\> racerMap)
  - public List\<Racer\> getRacers()
  - public Distance getDistance(Racer racer)
  - public List\<Racer\> getMaxDistanceRacers()
  
- GameStatus
  - public new(RoundStatus... roundStatuses)
  - public List\<RoundStatus\> getRoundStatuses()
  - public List\<Racer\> getWinners()
