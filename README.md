# 오점무   

## 소개   

- 전전직장에서 매일매일 "오점무?"라고 묻는 상사가 있었습니다.   
오늘 점심은 무엇이냐는 뜻이었고 막내인 제가 추천하는 것이었는데,   
여느 직장도 비슷한 경험이 있었고, 다른 사람들도 비슷한 고민이 있을 것이라고 생각했습니다.   
여기서 니즈를 찾았고 나름대로 키워드를 분석하고 아이디어를 구체화해서   
기획한 앱입니다.   

1. 메뉴는 크게 세 가지 방법으로 고를 수 있습니다.   
2. 
3. 첫 번째 탭, 대분류 -> 소분류 -> 음식점 으로 분야를 좁혀가며 고를 수 있습니다.   
(ex. 양식 -> 스테이크 -> 모모스테이크)   

3. 두 번째 탭, '음식점' 리스트가 모두 나열되어있습니다.   
이 리스트에서 음식점 이름을 검색하거나 최근 갔던 순 / 오래된 순으로 재정렬 할 수 있습니다.   

4. 세 번째 탭, 음식점 리스트를 받아와서 랜덤으로 선택할 수 있습니다.
여러번 랜덤돌리면 답정너가 되기 때문에 일부러 전면광고를 띄우도록 설계했습니다.   

5. 네 번째 탭, 설정입니다.   
특히나 디자인 설정은 사용자가 원하는대로 바꿀 수 있도록 극한의 자율성을 부여했고
Drawable 도 각각 만들어두어 버튼디자인도 색/모양별로 선택할 수 있도록 했습니다.   
이 외에도 폰트, 언어를 선택할 수 있고 카톡으로 건의할 수도 있고 저작권은 정해진대로 표기해두었습니다.

***

## 스크린샷   


***


## 분석   

- Language : JAVA   

- RecyclerView : 정말 유용하게 썼습니다. Grid, Linear 로 활용하고 ViewPager2에서도 활용했습니다.
- ViewPager2 : RecyclerView 를 사용한 ViewPager입니다. 앱을 처음 실행했을 때 인트로 설명에 사용했습니다.
처음이 아니더라도 메인화면 우측상단에 물음표 이미지를 터치하면 볼 수 있습니다.
- SQLiteHelper : Room을 쓰려다가 당시 이해하기 어려워서 하우매니에서 썼던 걸 그대로 썼습니다.
- TabLayout : 이번엔 Fragment 를 별도로 생성하여 보기 쉽고 전환이 용이하게 분리해두었습니다.
- Fragment : Activity와 Lifecycle을 같이 하는 Fragment를 많이 사용하는 기회가 되었습니다.
- AsyncTask : DB에서 값을 읽어오는 건 MainThread 에서 하기엔 부담스럽기 때문에   
비동기 방식으로 진행했습니다.
- Custom Dialog : 공부와 병행하다가 상속에 대해 제대로 이해하게 되어
Dialog 를 상속한 Custom Dialog를 만들었고, 비슷한 형식은 하나로 재사용 할 수 있게 만들었습니다.
- SharedPreference : 디자인/폰트/언어 설정 등은 모두 여기서 진행했습니다. 매우 편리했습니다.
- Drawable : 버튼 디자인은 Drawable type 리스트 중에서 고를 수 있습니다.
- Splash screen : 앱 시작 시 나오는 준비화면을 SplashActivity, style.xml 을 손봐서 만들었습니다.
준비화면 답게 DB를 모두 읽어오면 Intent를 사용하여 MainActivity로 이동합니다.
- Intent : Intent는 4대 컴포넌트를 연결하는 수단인 만큼 putExtra() 와 getExtra 관련 기능을 사용하여 정보를 주고 받았습니다.
- Typeface : 폰트 변경에 사용된 type 입니다.
- Animation : FloatingActionButton의 회전, 나타나기, FrameLayout의 투명도 조절 등에 사용했습니다.
- Random : 음식점 목록을 받아오고 그 갯수만큼 난수를 설정하여 구현한 기능입니다.
- Admob : Interstitial Ad와 Native Ad를 구현했습니다.
- Firebase : Firebase와 연동하여 사용자 유입, 사용현황, Clashlytics 등을 확인할 수 있습니다.
- Date : java.util.Date 와 SimpleDateFormat 을 활용하여 long형으로 날짜를 다루고,
유저에게 보여줄 때는 yyyy-mm-dd 방식으로 보여줄 수 있었습니다.


