<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Formul�rio de adi��o de Tarefa</title>
</head>
<body>
<h3>Adicionar Tarefas</h3>
<form:errors path="tarefa.descricao"/>
<form action="adicionaTarefa" method="post">
	Descri��o:<br/>
	<textarea name="descricao" rows="5" cols="100"></textarea><br/>
	<input type="submit" value="Adicionar">
</form>
</body>
</html>