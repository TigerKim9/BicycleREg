<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="root"></div>
</body>
  <!-- React를 실행. -->
  <!-- 주의: 사이트를 배포할 때는 "development.js"를 "production.min.js"로 대체하세요. -->
  <script src="https://unpkg.com/react@17/umd/react.production.min.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@17/umd/react-dom.production.min.js" crossorigin></script>
<script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>
  <!-- 만든 React 컴포넌트를 실행. -->
  <script>
  const root = document.getElementById("root");
  const span = React.createElement("span"
  ,{
    id : "title",
    onmouseenter: () => console.log("mouse enter"),

  },
  "This is test page");
  ReactDOM.render(span, root);
  </script>

</html>