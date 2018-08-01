<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Busca Processo</title>
        <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
    	<a class="navbar-brand" href="/">HOME</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="/processo/buscar">Pesquisar Processos<span class="sr-only">(current)</span></a>
				</li>
			</ul>
		</div>
	</nav>
    <div class="container">
        <div id="formulario" class="jumbotron" align="center" style="margin-top: 50px;">
            <h2>Seja bem-vindo ao Urlwipo</h2>
	        <div class="form-group">
				<label for="numero">Nº do processo</label> 
				<input type="text" class="form-control" id="numero" name="numero" placeholder="Numero">
			</div>
            <div align="center">
                <button id="processo" type="submit" class="btn btn-lg btn-primary">Clique aqui para consultar seu processo</button>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
	    $(function(){
	        $("#processo").click(function(){
	            var p = $("input[name=numero]").val();
	     
	            $.ajax({
	                type: "POST",
	                data: { numero:p },
	                url: "/processo/consultar",
	                dataType:'text',
	                success: function(result) {
	                    $("#formulario").html(result);
	                }
	            });
	        });
	    });
    </script>
    </body>
</html>