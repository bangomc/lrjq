var main = function(){
	//Botao de login do sistema
	$('#btn-logar').on('click',function(ev){
		var u = $('#txt-login').val();
		var s = $('#txt-senha').val();


		$.post('/user', {email:u, senha:s})
			.done(function( data ) {
				alert("Bem vindo " + data);
			})
			.fail(function( data ) {
				alert( "error" + data);
			})
	});

	//Botao de cadastro de novo usuario
	$('#btn-sigin').on('click', function(ev){
		var txtnome = $('#txt-nome');
		var txtemail = $('#txt-email');
		var txtsenha = $('#txt-senha');
		var txtresenha = $('#txt-resenha');

		var nome = txtnome.val();
		var email = txtemail.val();
		var senha = txtsenha.val();
		var resenha = txtresenha.val();
		
		var completo = true;

		if(nome==null || nome==''){
			if(!txtnome.hasClass('notificado')){
				txtnome.addClass('notificado');
				$('#lb-nome').after('<h5 id="nomenotificado" class="vermelho">Campo obrigatório</h5>');
				completo = false;
			}
		}else{
			if(txtnome.hasClass('notificado')){
				txtnome.removeClass('notificado');
				$('#nomenotificado').detach();
			}
		}
		
		if(email==null || email==''){
			if(!txtemail.hasClass('notificado')){
				txtemail.addClass('notificado');
				$('#lb-email').after('<h5 id="emailnotificado" class="vermelho">Campo obrigatório</h5>');
				completo = false;
			}
		}else{
			if(txtemail.hasClass('notificado')){
				txtemail.removeClass('notificado');
				$('#emailnotificado').detach();
			}
		}

		if(senha==null || senha==''){
			if(!txtsenha.hasClass('notificado')){
				txtsenha.addClass('notificado');
				$('#lb-senha').after('<h5 id="senhanotificado" class="vermelho">Campo obrigatório</h5>');
				completo = false;
			}
		}else{
			if(txtsenha.hasClass('notificado')){
				txtsenha.removeClass('notificado');
				$('#senhanotificado').detach();
			}
		}

		if(resenha==null || resenha==''){
			if(!txtresenha.hasClass('notificado')){
				txtresenha.addClass('notificado');
				$('#lb-resenha').after('<h5 id="resenhanotificado" class="vermelho">Campo obrigatório</h5>');
				completo = false;
			}
		}else{
			if(txtresenha.hasClass('notificado')){
				txtresenha.removeClass('notificado');
				$('#resenhanotificado').detach();
			}
		}

		if(senha != resenha){
			if(!txtresenha.hasClass('naoconfere')){
				txtresenha.addClass('naoconfere');
				$('#lb-resenha').after('<h5 id="senhanaoconfere" class="vermelho">Senha não confere</h5>');
				completo = false;
			}
		}else{
			if(txtresenha.hasClass('naoconfere')){
				txtresenha.removeClass('naoconfere');
				$('#senhanaoconfere').detach();
			}
		}
		
		if(completo){
			var user = {'nome':nome,'senha':senha,'email':email};

			$.post('/incuser', jQuery.parseJSON(user))
				.done(function( data ) {
					alert("Usuario " + data.nome + " cadastrado");
				})
				.fail(function( data ) {
					alert( "erro" + data);
				})
		}
	});
}

$(document).ready(main);