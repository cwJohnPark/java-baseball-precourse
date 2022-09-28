# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구 사항
- [ ] 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이라는 힌트를 준다.
- [ ] 게임 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
- [ ] 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 게임 플레이어가 입력한 숫자에 대한 결과를 출력한다.
- [ ] 임의의 수 3개를 입력하는 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- [ ] 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료된다.

## 프로그래밍 요구 사항
- 숫자야구 게임을 실행하는 시작점은 src/main/java 폴더의 baseball.Application 의 main() 이다.
- 숫자야구 게임은 JDK 8 버전에서 실행가능 해야 한다.
- JDK가 제공하는 Random 및 ScannerAPI 대신, `camp.nextstep.edu.missionutils` 의 API를 사용한다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms` 의 `pickNumberInRange()` 를 활용한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console` 의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을때, `src/test/java` 폴더의 `baseball.ApplicationTest` 에 있는 2개의 TestCase가 성공해야 한다.
- `ApplicationTest` 에서 제공하는 2개의 TestCase는 숫자야구 게임 구현을 위한 최소한의 TestCase이다.
- 필수 요구사항은 아니지만 제공하는 소스코드를 참고해 숫자야구게임을 위한 모든 TestCase를 추가해본다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.(https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)
- indent depth를 2가 넘지 않도록 구현한다. 1 까지만 허용한다.
  - 예를 들어, while 문 안에 if 문이있으면 들여쓰기는 2이다.
- 자바 8에 추가된 streamapi를 사용하지 않고 구현해야한다. 단, 람다는사용가능하다.
- else 예약어를 쓰지않는다.
- 함수(또는메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는메소드)가 한 가지 일만 잘하도록 구현한다.
- 도메인 로직 단위테스트를 구현해야 한다. 단,UI(System.out,System.in,Scanner) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    
## 과제 진행 요구 사항

