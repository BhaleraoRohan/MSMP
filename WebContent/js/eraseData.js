function erase(){
	
	
	$(document).ready(function () {
	    $(document).ajaxStart(function () {
	        $("#loading").show();
	    }).ajaxStop(function () {
	        $("#loading").hide();
	    });
	});
	
	
	$("#btnGetOpcos").click(function(){
		if($('#erased_siteid').val() != "IN-")
		{
			alert("asd");
			$.ajax({
				url : '../../DRec/eraseSite',
				data:{
					siteIdString:$('#erased_siteid').val()
				},
				type : 'POST',
				async: false,
				dataType : 'json',
				cache : false,
				success : function(data) 
				{	
					alert(data);
					/*for( var i = 0; i < data.length; i++) {
						$('drp_opcolist').append( '<option>' + data.opconame + '</option>' );
					}*/
						/*$.each(data, function(i,item) {
							
						$("#drpOPCO").find('option[value='+item+']').css('background-color', 'yellow');
					});*/
				}
			});	
		}
		else{
			showNotification("error","Enter siteid.");
		}
	});
	
	
	
	
	function showNotification(type,message)
	{
		var bgcolor;
		if(type == "error")
		{
			bgcolor = "#f44336";
		}
		
		notif({
			  type: type,
			  msg: message,
			  position: "center",
			  bgcolor: bgcolor,
			  width:600,
			  color: "#212121"
			});
	}
	
}