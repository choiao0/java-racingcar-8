# java-racingcar-precourse

### ⚙️ 기능 목록

- [ ]  자동차 이름을 입력받는다.
- [ ]  쉼표 기준으로 각 자동차를 구분한다.
    - [ ]  각 자동차 이름이 유효한지 검증한다.
- [ ]  시도 횟수를 입력받는다.
    - [ ]  시도 횟수가 양수인지 검증한다.
- [ ]  시도 횟수만큼 게임 차수를 반복한다.
    - [ ]  매 차수에 각 자동차는 전진을 시도한다.
        - [ ]  무작위 값이 4 이상이면 전진하고, 미만이면 이동하지 않는다.
        - [ ]  시도 결과를 출력한다.
- [ ]  우승자를 판단한다.
- [ ]  (단독/공동) 우승자를 출력한다.

### 🧩 예외 사항

- [ ]  자동차 이름이 유효하지 않은 경우
    - [ ]  자동차 이름이 빈 문자열이나 공백인 경우
    - [ ]  자동차 이름이 5자를 초과한 경우
    - [ ]  중복된 자동차 이름이 있는 경우
        - 자동차 이름에 쉼표를 제외한 특수문자는 사용할 수 있도록 한다.
- [ ]  시도 횟수가 양수가 아닌 경우
    - [ ]  자동차 이름이 빈 문자열이나 공백인 경우
    - [ ]  자동차 이름이 0이나 음수인 경우

### 📦 패키지 구조

```
src
├── main
│   └── java
│       └── racingcar
│           ├── controller
│           │   └── RacingGameController.java
│           ├── domain
│           │   ├── Car.java
│           │   └── Cars.java
│           ├── service
│           │   └── RacingGameService.java
│           └── view
│               └── Application.java
└── test
    └── java
        └── racingcar
            ├── domain
            │   ├── CarTest.java
            │   └── CarsTest.java
            ├── service
            │   └── RacingGameServiceTest.java
            └── ApplicationTest.java
```