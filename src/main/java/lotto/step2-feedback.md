# [step 2]
## 1차 피드백
1. 로또 생성 로직의 인터페이스화
    - List<Lotto>를 담는 일급객체 Lottos 구현
    - LottosGenerator 인터페이스 구현
    - 구현체 구현 후 LottoIssuer의 리스트 생성 책임 제거
    - 호출부 수정
2. 숫자 상수 언더바 표현
    - 로또 가격의 표현 수정
3. Money 객체에서 구매 가능 로또 갯수 파악
    - 구매 가능 로또 갯수 파악 로직을 Money로 이동
4. Lotto의 주 생성자, 부 생성자 
    - Lotto에 다양한 생성자 지원
5. Enum 값 목록 조회 메소드 사용
    - aggreatematchCount 메소드에서 enum의 values 메소드 사용하도록 수정
6. 출력 책임이 model에 존재하는 것에 대해 다시 고민
