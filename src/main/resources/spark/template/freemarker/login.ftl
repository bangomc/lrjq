<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">
	<div class="row">
		  <h1> <small></small></h1>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
				  <div class="panel-heading">
				    <h3 class="panel-title">Login</h3>
				  </div>
				  <div class="panel-body">
				    <div class="form-group">
				      <label for="email">Email:</label>
				      <input type="email" class="form-control" id="email" placeholder="">
				    </div>
						<div class="form-group">
				      <label for="senha">Senha:</label>
				      <input type="password" class="form-control" id="senha" placeholder="">
				    </div>
						<button type="button" class="btn btn-primary btn-block" id="btn-logar">Entrar</button>
				  </div>
				</div>
			</div>
		</div>

  <#include "rodape.ftl">
</body>
</html>
