# 웹과 애니메이션

애니메이션은 매력적인 웹 어플리케이션과 사이트를 만드는 중요한 수단이다. 사용자는 반응성이 뛰어난 대화형 사용자 인터페이스를 기대한다.

웹 페이지에 CSS나 JavaScript를 사용해 애니메이션 효과를 줄 수 있고, 각 방법에는 사용할 때의 특징과 장/단점이 있다.

웹에서 CSS와 자바스크립트로 애니메이션을 만들 수 있다. 어느 것을 사용할 지는 프로젝트의 기타 종속성과 원하는 효과의 종류에 따라 결정된다.

## CSS animation

UI 요소 상태 전환과 같은 `간단한 원샷(one-shot) 전환에 CSS 애니메이션을 사용`한다.

CSS로 애니메이션을 만드는 것이 화면에서 움직임을 표현하는 가장 간단한 방법이다. UI 요소 상태 전환과 같은 간단한 효과에는 CSS를 사용하는 것이 좋다. `:hover`와 같은 가상 클래스 선택자 또는 js
이벤트와 같은 부수적 액션에 의해 발동된다. 미디어 쿼리를 사용해 반응형으로 애니메이션을 구현할 수 있다.

`CSS는 선언형`이기 때문에 이미 정해져 있는 속성들에 값을 넣는 규칙만 안다면, 쉽게 사용할 수 있지만, 어느 정도 `표현의 한계가 있다`. CSS 기반 애니메이션은 일반적으로 브라우저의 메인 스레드가
아닌 `컴포지터 스레드 (Compositor Thread)`에서 처리되기 때문에 `JS 애니메이션보다 효율적`이다.

CSS에는 움직임을 표현하는 데 사용하는 `트랜지션(transition)`과 `애니메이션(animation)`이라는 속성이 있다. 트랜지션 속성은 단순히 요소의 속성 변화에 초점을 맞췄다면, 애니메이션 속성은 하나의
흐름을 구성해 흐름을 제어하는 방법이다.

### 트랜지션 (Transition)

`요소의 변화를 일정 기간(duration)동안 일어나게 한다`. hover나 click과 같은 `이벤트 트리거에 의해 동작`한다. Layout을 변경시킬 경우, Reflow 발생을 줄이기 위해 낮은 계층의 요소에
효과를 주는 것이 좋다. 트랜지션 속성은 애니메이션 관련 프로퍼티와 값을 정의해 애니메이션 효과를 정의할 수 있다는 것이 핵심이다.

### 애니메이션 (Animation)

트랜지션 속성은 시작하기 위해 이벤트가 필요하지만, 애니메이션 속성은 시작, 정지, 반복까지 제어 가능하고, 이벤트 제어도 가능하다. 애니메이션을 나타내는 CSS스타일과 애니메이션의 상태를
나타내는 `keyframes`들로 이뤄진다.

트랜지션 속성으로도 어느 정도의 애니메이션 효과를 표현할 수 있지만, 애니메이션 속성보다는 제한적이다. 일반적으로 트랜지션 속성은 요소 프로퍼티 값이 다른 값으로 변화할 때 주로 사용하고, 요소의 로드와 함께
자동으로 발동되지 않는다.

CSS 클래스를 만들어 애니메이션을 관리하면 다음과 같이 `자바스크립트를 사용해서 애니메이션을 활성화/비활성화` 할 수 있다.

```html
<!doctype html>
<head>
    <title>CSS 애니메이션</title>
</head>
<body>
    <div class="box"></div>
</body>
</html>
```

```css
.box {
    width: 100px;
    height: 100px;
    background-color: aqua;
    
    -webkit-transform: translate(0, 0);
    -webkit-transition: -webkit-transform 500ms;
    
    transform: translate(0, 0);
    transition: transform 500ms;
    
    will-change: transform;
}

.box.move {
    -webkit-transform: translate(100px, 100px);
    transform: translate(100px, 100px);
}
```

```js
box.classList.toggle("move")
```

## js animation

CSS로 처리하기에는 복잡하고 무거운 애니메이션을 효율적이고 세밀하게 다루기 위해서 사용한다. 보통 `setInterval()`를 사용해서 일정 주기마다 `frame`함수를 실행하는 방식을 사용한다. vanilla js로 구현할 경우, 계속해서 요소의 위치를 계산하기 때문에 비효율적이고, 사용자의 눈에 가장 부드러운 60fps가 유지되지 않는다. 

이 때문에 `reqeustAnimationFrame`이 등장했고, 구현 방식은 동일하지만 60fps를 보장할 수 있게 됐다.또한 외부 라이브러리인 `Velocity.js`, `GSAP`과 같은 라이브러리나 Web Application API를 통해서 성능 좋은 애니메이션을 구현할 수 있다.

JS 애니메이션은 `요소의 스타일이 변하는 순간마다 제어`할 수 있기 때문에 애니메이션의 세밀한 구성이 가능하다. `GPU를 통한 하드웨어 가속을 제어`할 수 있다. CSS의 특정 속성으로 인한 가속을 막아주는데, 하드웨어 가속은 `모바일에서 성능 저하 방지 면`에서 좋다.

js 애니메이션 사용 예

```html
<!doctype html>
<head>
    <title>JS Animation</title>
</head>
<body>
    <div class="box"></div>
</body>
</html>
```

```css
.box {
    width: 100px;
    height: 100px;
    background-color: aqua;
    position: relative;
}
```

```js
const box = document.querySelector(".box");

let interval = 0;
let intervalFlag = true;

// setInterval 방식
box.onclick = function () {
    if (intervalFlag) {
        box.style.left = "0px";
        interval = 0;
        intervalFlag = false;
    } else {
        const intervalFun = setInterval(function () {
            if (interval > 100) {
                clearInterval(intervalFun);
                intervalFlag = true;
            } else {
                box.style.left = parseInt(box.style.left) + 1 + "px";
                interval++;
            }
        }, 16);
    }
};

// requsetAnimationFrame 방식
let count = 0;
let requestAnimationFrameFlag = true;

function run() {
    if (count < 100) {
        count++;
        box.style.left = box.style.left = parseInt(box.style.left) + 1 + "px";
        requestAnimationFrame(run);
    } else {
        requestAnimationFrameFlag = true;
        count = 0;
    }
}

box.onclick = function () {
    if (requestAnimationFrameFlag) {
        box.style.left = "0px";
        requestAnimationFrameFlag = false;

        requestAnimationFrame(run);
    }
};

// Web Animation API 방식
let flag = true;

box.onclick = function () {
    if (flag) {
        const animation = box.animate(
            [{ transform: "translate(0)" }, { transform: "translate(100px, 100px)" }],
            300
        );
        animation.addEventListener("finish", function () {
            box.style.transform = "translate(100px, 100px)";
            flag = false;
        });
    } else {
        const animation = box.animate(
            [{ transform: "translate(100px, 100px)" }, { transform: "translate(0)" }],
            300
        );
        animation.addEventListener("finish", function () {
            box.style.transform = "translate(0)";
            flag = true;
        });
    }
};
```

## JS, CSS 애니메이션 차이점

* CSS 애니메이션은 낮은 버전의 브라우저에서는 지원하지 않는 경우가 있다.
* `JS 애니메이션은 스타일, 애니메이션 동작을 따로 관리`해야 하지만, `CSS 애니메이션은 CSS안에서 전부 관리`된다.

## 탄력성

CSS나 HTML은 일부 규칙이 깨진다고 해서 전체 웹 애플리케이션이 고장나진 않는다.

반면에, 사이트 로딩 이전에 자바스크립트 하나의 에러 구문, null 또는 undefined 체크를 하면 전체 애플리케이션에 영향을 주기 때문에 유저의 진행 상황을 상실할 수 있다.

JS는 CSS에 비해 탄력성이 떨어지기 때문에 잘 작성된 JS라도 `UI나 브라우저 오류`를 일으킬 수 있다. 하지만 `CSS를 사용하면 하위 브라우저는 transition속성을 자동으로 무시`하므로 정상적으로 사용할 수 있다. JS에서는 사용자가 오래된 하드웨어나 저사양 하드웨어를 실행하고 있음을 감지해야 한다. CSS를 사용하면 사용자의 환경에 맞춰서 적절한 품질을 유지할 수 있다.


<br><br><br><br>
[Reference - wysiwyr.dev blog](https://wysiwyr.dev/posts/web/css-js-animation) <br>
[Reference - google dev js & css animation](https://developers.google.com/web/fundamentals/design-and-ux/animations/css-vs-javascript?hl=ko) <br>
[Reference - google dev js & css animation performance](https://developers.google.com/web/fundamentals/design-and-ux/animations/animations-and-performance?hl=ko#css-vs-javascript-performance) <br>
..... wisiwyr는 뭐지...?

udemy에 찾아보니까 css, js 애니메이션 이용한 심플 프로젝트들이 제공되고 있으니까 한번 만들어보자.