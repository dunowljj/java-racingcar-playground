## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.
---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

# 1. 문자열 덧셈 계산기
## 주의 사항
### TDD 기억하기
- 실패하는 단위 테스트 작성할 때까지 프로덕션 코드x
- 컴파일은 성공, 실행은 실패할 정도로만 단위 테스트 작성
- 현재 실패하는 테스트 통과할 정도만 프로덕션 작성
###  도메인 잘 모르겠다...
안돼면 일단 구현해서 도메인 지식 쌓고 다시하기


## 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환  
(예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.   
커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.  
예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

---

- 기본 구분자 : ',', ';' 둘 다 사용 가능
- 커스텀 구분자 지정 가능 -> "//" "\n" 사이에 입력
- 예시로 //;\n1;2;3

---

## 구현 계획

### 흐름 
1. default인지 custom인지 구분
- Macher, Pattern 활용하여 custom 기호 인식

2. 분류
+ default 일 때
  - split
  - 숫자 이외의 값 또는 음수 -> 런타임 예외 던지기 
+ custom 일 때 
   - find, group으로 구분자 검증
     - 커스텀 구분자 지정 후 디폴트 사용 가능?
   - 숫자 이외의 값 또는 음수 -> 런타임 예외 던지기

3. 예외 처리
- default 일 때
  - split후 값 검사, split자체 예외 되던지기?
- custom 일 때
  - group - 입력된 커스텀 문자가 기호가 아니면 예외(Illegal custom symbol?)
  - split한 숫자들 음수(음수 예외)거나 문자인지 검사
  - split 자체 예외 되던지기

4.덧셈 후 출력
- split한 숫자 다 더하기

5. 빼먹은 것
- 숫자 하나 일 때
- 빈 문자열 또는 null -> 0 반환
***

## 구현 순서
### 1 커스텀인지 디폴트인지 판단
- 패턴과 String 비교해서 default, custom 판단  -> Pattern 정규표현식 활용  
- //\n관련 정규표현식과 일치하면 CUSTOM , //\n 일치안하면 DEFAULT

### 2 기능 구현

- 덧셈 기능까지 모두 구현
+ Todo
  - 숫자 하나일 때 처리 -> 진행중
  - 빈 문자열 또는 null -> 0 반환 -> 진행중 
  - 음수 전달 시 RuntimeException
  - split 자체 예외 -> 구분자 이상할때만 예외나옴
  - 커스텀 구분자가 기호 아니면 예외
  - group값 제대로 안들어올때
  - 마지막이 기호일떄?
***

### 3 일부 예외 처리

- 음수 전달 시 RuntimeException -> 완료
- split 자체 예외 -> 구분자 이상할때만 예외나옴, 따로 확인 o numberformat 되던짐

+ Todo 
- 숫자 하나일 때 처리 -> 진행중
- 빈 문자열 또는 null -> 0 반환 -> 진행중
- 커스텀 구분자가 기호 아니면 예외
- group값 제대로 안들어올때

***

### 4 예외적인 입력값 처리

- 숫자 하나일 때 처리
- 빈 문자열 또는 null -> 0 반환
- group1 커스텀 구분자가 영어나 숫자면 예외

***
# 2. 레이싱 카
