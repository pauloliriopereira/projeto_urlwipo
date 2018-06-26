<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h2>Dados do Processo</h2>
<div id="retorno">
	<div class="form-group">
		<label for="numPub">N� de pub</label> 
		<input type="text" value="${modelProcesso.numPub}" class="form-control" id="numPub" name="numPub" placeholder="N� de pub">
	</div>
	<div class="form-group">
		<label for="numInternacional">N� do pedido Intenacional</label> 
		<input type="text" value="${modelProcesso.numInternacional}"  class="form-control" id="numInternacional" name="numInternacional" placeholder="N� do pedido Intenacional">
	</div>
	<div class="form-group">
		<label for="dataPublicacao">Data de Publica��o</label>
		<fmt:formatDate pattern="dd/MM/yyyy" value="${modelProcesso.dataPublicacao}" var="dataFormatada" />
		<input type="text" value="${dataFormatada}" class="form-control" id="dataPublicacao" name="dataPublicacao" placeholder="Data de Publica��o">
	</div>
	<div class="form-group">
		<label for="requerentes">Requerentes</label> 
		<input type="text" value="${modelProcesso.requerentes}" class="form-control" id="requerentes" name="requerentes" placeholder="Requerentes">
	</div>
	<div class="form-group">
		<label for="titulo">T�tulo</label> 
		<input type="text" value="${modelProcesso.titulo}" class="form-control" id="titulo" name="titulo" placeholder="T�tulo">
	</div>
</div>
<button id="processoSalvar" type="submit" class="btn btn-success">Salvar Processo</button>
<script type="text/javascript">
$(function(){
        $("#processoSalvar").click(function(){
        	var _numPub = $("input[name=numPub]").val();
        	var _numInternacional = $("input[name=numInternacional]").val();
        	var _dataPublicacao = $("input[name=dataPublicacao]").val();
        	var _requerentes = $("input[name=requerentes]").val();
        	var _titulo = $("input[name=titulo]").val();
            $.ajax({
                type: "POST",
                data: { numPub:_numPub, 
                	    numInternacional:_numInternacional,
                	    dataPublicacao:_dataPublicacao,
                	    requerentes:_requerentes,
                	    titulo:_titulo},
                url: "/processo/salvar",
                dataType:'text',
                success: function(result) {
                    $("*").html(result);
                }
            });
        });
    });
</script>