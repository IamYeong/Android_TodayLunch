# 오점무   

## 소개   

<img src="https://user-images.githubusercontent.com/59534301/116389796-574a2f00-a858-11eb-810c-6bf240cda979.png" width="100px" height="100px" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

- 전전직장에서 매일매일 "오점무?"라고 묻는 상사가 있었습니다.   
오늘 점심은 무엇이냐는 뜻이었고 막내인 제가 추천하는 것이었는데,   
여느 직장도 비슷한 경험이 있었고, 다른 사람들도 비슷한 고민이 있을 것이라고 생각했습니다.   
여기서 니즈를 찾았고 나름대로 키워드를 분석하고 아이디어를 구체화해서   
기획한 앱입니다.   

1. 메뉴는 크게 세 가지 방법으로 고를 수 있습니다.   

2. 첫 번째 탭, 대분류 -> 소분류 -> 음식점 으로 분야를 좁혀가며 고를 수 있습니다.   
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
   
<!--
![뷰페이져](https://user-images.githubusercontent.com/59534301/116384998-58c52880-a853-11eb-9e5f-df199ee8889f.jpg)
![fragment1_pink](https://user-images.githubusercontent.com/59534301/116385059-68447180-a853-11eb-8a1a-fd02cef02d25.jpg)
![fragment1_pink2](https://user-images.githubusercontent.com/59534301/116385077-6b3f6200-a853-11eb-9330-3bf9bcaee0f5.jpg)
![fragment_green](https://user-images.githubusercontent.com/59534301/116385086-6d092580-a853-11eb-8ccc-e748aebe2897.jpg)
![fragment2_blue](https://user-images.githubusercontent.com/59534301/116385108-73979d00-a853-11eb-8081-b9147db56638.jpg)
![fragment2_custom](https://user-images.githubusercontent.com/59534301/116385126-76928d80-a853-11eb-9755-4de1c812ac8e.jpg)
![fragment2_pink_custom](https://user-images.githubusercontent.com/59534301/116385142-78f4e780-a853-11eb-954e-90bac536fe4a.jpg)
![검색](https://user-images.githubusercontent.com/59534301/116385172-7eeac880-a853-11eb-9a6c-a514c90a3aa6.jpg)
![상세메뉴](https://user-images.githubusercontent.com/59534301/116385192-81e5b900-a853-11eb-8156-3b9c3c441075.jpg)
![상세메뉴음식점](https://user-images.githubusercontent.com/59534301/116385213-86aa6d00-a853-11eb-943d-2e3c34450d37.jpg)
![랜덤](https://user-images.githubusercontent.com/59534301/116385243-90cc6b80-a853-11eb-972a-d8efad1645df.jpg)
![메뉴수정](https://user-images.githubusercontent.com/59534301/116385283-9cb82d80-a853-11eb-9e8a-8bb2c77a440f.jpg)
![스피너](https://user-images.githubusercontent.com/59534301/116385301-9fb31e00-a853-11eb-8e5c-8092e4bc7f00.jpg)
![애니메이션](https://user-images.githubusercontent.com/59534301/116385324-a6da2c00-a853-11eb-97a1-7ce7db675a2c.jpg)
![최신순](https://user-images.githubusercontent.com/59534301/116385337-aa6db300-a853-11eb-8bcb-173497074ff3.jpg)
![링크](https://user-images.githubusercontent.com/59534301/116385376-b3f71b00-a853-11eb-9cc3-d9e8ea13dd4f.jpg)
![전면광고](https://user-images.githubusercontent.com/59534301/116385400-b9546580-a853-11eb-845c-90692caffdd2.jpg)
![설정화면](https://user-images.githubusercontent.com/59534301/116385452-c40efa80-a853-11eb-9e60-fa39580a4dff.jpg)
![폰트설정](https://user-images.githubusercontent.com/59534301/116385493-cd986280-a853-11eb-9d54-75f9e6a154ea.jpg)
![언어설정](https://user-images.githubusercontent.com/59534301/116385508-d0935300-a853-11eb-819f-edb0d556750a.jpg)
![저작권](https://user-images.githubusercontent.com/59534301/116385516-d2f5ad00-a853-11eb-8e53-5f291d37bb03.jpg)
![디자인설정](https://user-images.githubusercontent.com/59534301/116385548-da1cbb00-a853-11eb-9c39-0e01d6f6eedb.jpg)
![색상설정](https://user-images.githubusercontent.com/59534301/116385560-ddb04200-a853-11eb-9083-988259e0fc4f.jpg)
![버튼설정](https://user-images.githubusercontent.com/59534301/116385577-e274f600-a853-11eb-8070-c659484a7291.jpg)
![종료](https://user-images.githubusercontent.com/59534301/116385600-e9036d80-a853-11eb-84e2-8e2418194bc1.jpg)

<img src="https://user-images.githubusercontent.com/59534301/116231898-6a93c680-a794-11eb-8bb0-a3af2f66f119.PNG" width="80px" height="80px" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
-->

- **인트로 설명 및 각종 테마 적용**   
   
<img src="https://user-images.githubusercontent.com/59534301/116384998-58c52880-a853-11eb-9e5f-df199ee8889f.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385059-68447180-a853-11eb-8a1a-fd02cef02d25.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385077-6b3f6200-a853-11eb-9330-3bf9bcaee0f5.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385086-6d092580-a853-11eb-8ccc-e748aebe2897.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385108-73979d00-a853-11eb-8081-b9147db56638.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
   

- **그리드 : 대분류 > 소분류 > 음식점 예시**   
(상단에 putExtra()를 활용하여 정보도 가져와서 경로를 표기하게 했습니다)
   
<img src="https://user-images.githubusercontent.com/59534301/116385077-6b3f6200-a853-11eb-9330-3bf9bcaee0f5.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385192-81e5b900-a853-11eb-8156-3b9c3c441075.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385213-86aa6d00-a853-11eb-943d-2e3c34450d37.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
   

- **리스트 : 최신순 / 검색 /  링크 예시**   
('선택'은 음식점을 골랐다는 의미로, 날짜를 오늘로 바꾸고 전면광고를 팝업합니다)
   
<img src="https://user-images.githubusercontent.com/59534301/116385126-76928d80-a853-11eb-9755-4de1c812ac8e.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385337-aa6db300-a853-11eb-8bcb-173497074ff3.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385172-7eeac880-a853-11eb-9a6c-a514c90a3aa6.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385376-b3f71b00-a853-11eb-9cc3-d9e8ea13dd4f.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
   

- **랜덤 : 전면광고 -> 결과 보여주기 예시**   
   
<img src="https://user-images.githubusercontent.com/59534301/116385243-90cc6b80-a853-11eb-972a-d8efad1645df.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385400-b9546580-a853-11eb-845c-90692caffdd2.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

- **설정 : 언어설정 / 저작권 표기 예시**   
(나머지 메뉴는 Gmail, 오픈카톡링크, 블로그 링크, 구글 플레이 링크로 구성)   
   
<img src="https://user-images.githubusercontent.com/59534301/116385452-c40efa80-a853-11eb-9e60-fa39580a4dff.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385508-d0935300-a853-11eb-819f-edb0d556750a.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385516-d2f5ad00-a853-11eb-8e53-5f291d37bb03.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>


- **디자인 설정 : 영역별 색상 선택과 버튼디자인, 폰트 설정 예시**   
   
<img src="https://user-images.githubusercontent.com/59534301/116385548-da1cbb00-a853-11eb-9c39-0e01d6f6eedb.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385560-ddb04200-a853-11eb-9083-988259e0fc4f.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385577-e274f600-a853-11eb-8070-c659484a7291.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
<img src="https://user-images.githubusercontent.com/59534301/116385493-cd986280-a853-11eb-9d54-75f9e6a154ea.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

- **onBackPressed() Override 를 통한 종료 팝업 및 네이티브 광고**   
   
<img src="https://user-images.githubusercontent.com/59534301/116385600-e9036d80-a853-11eb-84e2-8e2418194bc1.jpg" width="100px" height="" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>


***


## 분석   

- Language : JAVA   

- RecyclerView : 정말 유용하게 썼습니다. Grid, Linear 로 활용하고 ViewPager2에서도 활용했습니다.
- ViewPager2 : RecyclerView 를 사용한 ViewPager입니다. 앱을 처음 실행했을 때 인트로 설명에 사용했습니다.
처음이 아니더라도 메인화면 우측상단에 물음표 이미지를 터치하면 볼 수 있습니다.
- SQLiteHelper : Room을 쓰려다가 당시 이해하기 어려워서 하우매니에서 썼던 걸 그대로 썼습니다.
- TabLayout : 이번엔 Fragment 를 별도로 생성하여 보기 쉽고 전환이 용이하게 분리해두었습니다.
- Spinner : 흔히 말하는 드롭다운 버튼이었습니다. 대분류 선택에 따라 상세메뉴 목록은 자동으로 변환되도록 구현했습니다.
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


