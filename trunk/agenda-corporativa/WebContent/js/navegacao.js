jQuery(document).ready(function(){
	
	jQuery('#agendas-wrap a').click(function(){
		jQuery('#calendario-content').load(jQuery(this).attr('href'));
		return false;
	});
	
});