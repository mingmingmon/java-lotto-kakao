## 1차 피드백
1. Application 클래스의 많은 책임이 존재한다
    - mvc 패턴 사용
    - 검증로직을 도메인 객체에 위임
2. MatchCount enum의 from 메소드 역할을 WinningLotto가 해보자
    - from 메소드를 MatchCount에 부여한 이유 설명
    - 제시해주신 match 함수 역할은 Lotto 객체에게 부여하는 것은 어떤지 제안
3. LottoNumber 클래스 생성을 해보자
    - 로또 번호의 검증 역할을 부여할 수 있을 것 같음
4. 로또 가격의 상수화
    - 로또 가격 이외에도 매직 넘버 부분은 상수 변수로 수정
5. Buyer 생성자의 private 의미가 무엇인가요
    - Lotto 클래스와 비슷하게 의도한 설계 설명
6. 주석 삭제하기
    - 주석 삭제 진행
7. LotteryChecker의 calculateReturnRate가 static인 이유
    - 초기 설계 목적 설명 후 수정
8. WinningLotto가 Lotto를 필드로 가지기
    - Lotto 객체를 필드로 가지면 도메인의 의미도 명확해짐
    - 불필요하게 List<Integer>를 꺼내지 않고 캡슐화 가능
9. 예외 상황에 대한 테스트 코드 추가
    - 1~45 가 아니면? 
    - 보너스번호가 로또번호와 중복이면?
10. 임시 변수명 수정 제안
    - 명확한 변수명으로 수정
11. 메소드가 10라인 넘기지 않도록 수정
    - Application 부분의 리팩토링 진행하면서 확인
12. MathCount의 from 메소드에서 null 처리 수정
    - NullPointException 핸들링
    - enum에 꽝을 의미하는 상수 추가
