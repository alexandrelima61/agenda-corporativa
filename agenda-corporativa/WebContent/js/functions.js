jQuery(function() {

	selecionado = null;
	jQuery("#show-calendario").datepicker({
		dateFormat: 'dd/mm/yy',
		onSelect: function(dataText, inst)
		{
			if(selecionado != null)
				selecionado.removeClass('dia-selecionado');
				
			selecionado = jQuery('.'+dataText[0]+dataText[1]);
			
			selecionado.addClass('dia-selecionado');
		}
	});
	
	jQuery('#tabela-calendario tbody tr:odd').addClass('odd');
	jQuery('#tabela-calendario tbody tr:even').addClass('even');
	
	jQuery('#tabela-calendario tbody tr td').hover(function(){
		jQuery(this).toggleClass('linha-hover');
	}, function(){
		jQuery(this).toggleClass('linha-hover');
	});
	
	jQuery('.eventos-dia-calendario').tooltip();
	$('#calendario-sidebar').sortable({
			connectWith: '.column'
		});

	$('.portlet').addClass('ui-widget ui-widget-content ui-helper-clearfix ui-corner-all')
		.find('.portlet-header')
			.addClass('ui-widget-header ui-corner-all')
			.prepend('<span class="ui-icon "></span>')
			.end()
		.find('.portlet-content');

	$('.portlet-header .ui-icon').click(function() {
		$(this).toggleClass('ui-icon-plusthick');
		$(this).parents('.portlet:first').find('.portlet-content').toggle();
	});
	$(".column").disableSelection();
	
	adicionaClassCalendario();
	
	$("#tabela-calendario tr td").contextMenu({
        menu: 'menu-direito'
    },
        function(action, el, pos) {
		var evento = action.split('-');
		//alert(evento[1]+'/cadastrar.html')
		jQuery('#calendario-content').load(evento[1]+'s/cadastrar.html');
		
    });


});

function adicionaClassCalendario()
{
	jQuery('#tabela-calendario').find('td').each(function(i){
		i++;
		if(i < 10)
			i = '0'+i;
		jQuery(this).addClass(''+i+'');
	});	
}

