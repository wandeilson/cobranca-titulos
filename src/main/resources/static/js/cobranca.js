$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);//captura o botao que disparou o evento
	
	var codigoTitulo = button.data('codigo');//funcao data acessa os atributos colocados  na linha 47 do pesquisa titulo
	var descricaoTitulo = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action + codigoTitulo);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + descricaoTitulo + '</strong>?');
});

$(function(){
	$('[rel="tooltip"]').tooltip();
});