<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	    <title>Wipo busca</title>
	    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	    <div id="lista" class="container">
	    	<h2>Inserir dados para Busca</h2>
				<div class="form-group">
					<label for="numPub">Nº de pub</label> 
					<input type="text" class="form-control" id="numPub" name="numPub" placeholder="Nº de pub">
				</div>
				<div class="form-group">
					<label for="requerentes">Requerentes</label> 
					<input type="text" class="form-control" id="requerentes" name="requerentes" placeholder="Requerentes">
				</div>
				<button id="processoBuscar" type="submit" class="btn btn-success">Buscar Processo</button>
	 	</div>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <script src="../bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript">
	    $(function(){
	        $("#processoBuscar").click(function(){
	        	var _numPub = $("input[name=numPub]").val();
	        	var _requerentes = $("input[name=requerentes]").val();
	            $.ajax({
	                type: "POST",
	                data: { numPub:_numPub, 
	                	    requerentes:_requerentes},
	                url: "/processo/listar",
	                dataType:'text',
	                success: function(result) {
	                    $("#lista").html(result);
	                }
	            });
	        });
	    });
    </script>
	</body>
</html>