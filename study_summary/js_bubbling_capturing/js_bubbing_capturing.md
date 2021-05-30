# javascript bubbling & capturing

> 이 두가지는 기본적으로 이벤트 핸들러가 실행되는 순서를 정의하는 데 사용된다.<br>
bubbling과 capturing은 상위/하위 요소가 있는 경우, 유용하게 사용할 수 있다.

동봉된 예시에서는 각각 상위/하위 요소에 이벤트 리스너를 설정해, 각각 bubbling, capturing을 테스트하고 있다.

`index2.html`
```js
<h2 id="title">Capturing</h2>
<p id="parent">
    Lorem <strong id="child">Ipsum</strong> is simply dummy text of the printing and typesetting industry.
    Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
</p>
<script type="text/javascript">
    const parent = document.getElementById("parent");
    const child = document.getElementById("child");

    parent.addEventListener("click", function () {
        console.log("I am the PARENT");
    }, true);

    child.addEventListener("click", function () {
        console.log("I am the CHILD");
    });
</script>
```

위의 parent 객체에 대한 이벤트 리스너 처리를 해 준 경우, `세번째 argument`에 true를 입력하면 `capturing`이, false를 입력하면 `bubbling`이 적용된다.<br>
`default는 false --> bubbling`

## 1. bubbling

bubbling방식을 사용하면, 자식 객체를 클릭하는 경우 다음과 같이 출력

```
I am the CHILD
I am the PARENT
```

결과를 보면 알 수 있듯, bubbling방식을 사용하면 `지정한 하위 요소에 대한 이벤트부터 실행시키고, 그 다음 상위 요소에 대한 이벤트를 실행`시킨다.

## 2. capturing

capturing방식을 사용하면, 자식 객체를 클릭하는 경우 다음과 같이 출력

```
I am the PARENT
I am the CHILD
```

결과를 보면 알 수 있듯, capturing방식을 사용하면 bubbling방식과는 반대로 `지정한 상위 요소에 대한 이벤트부터 실행시키고, 그 다음 하위 요소에 대한 이벤트를 실행`시킨다.
