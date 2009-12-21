jQuery(function() {
	jQuery('.link-evento').click(function(){
		jQuery('#calendario-content').load(jQuery(this).attr('href')+'.html');
		return false;
	});
});