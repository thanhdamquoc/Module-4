
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
  </head>
  <body>
  <h1>Dictionary</h1>
  <form method="post">
    <table>
      <tr>
        <td><label>English word</label></td>
        <td><input type="text" placeholder="enter a word" name="englishWord" value="${englishWord}"></td>
      </tr>
      <tr>
        <td><label>Meaning</label></td>
        <td><input readonly type="text" placeholder="meaning" value="${vietnameseWord}"></td>
      </tr>
      <tr>
        <td><input type="submit" value="translate"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
