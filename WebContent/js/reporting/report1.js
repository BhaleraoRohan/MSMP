function report1()
{
	loadReport1();
	
	function loadReport1(){
		$('#dataTables-report1').DataTable({
			
			dom : 'T<"clear">lfrtip',
			tableTools : {
				"aButtons" : [ "copy", "csv", "xls",

				{
					"sExtends" : "pdf",
					"sPdfOrientation" : "landscape",
					"sPdfMessage" : "Your custom message would go here."
				}, "print" ]
			},
			destroy : true,
			serverside:true,
			"bProcessing": true,
			colVis : {
				restore : "Restore",
				showAll : "Show all"
			},

			sAjaxSource : '../../DRec/report1?Index=fsc',
			"aoColumns" : [ {
				"mData" : "Zone"
			},{
				"mData" : "Technician"
			} ,{
				"mData" : "week29"
			} ,{
				"mData" : "week30"
			} ,{
				"mData" : "week31"
			} ,{
				"mData" : "week32"
			} ,{
				"mData" : "week33"
			} ,{
				"mData" : "week34"
			} ,{
				"mData" : "week35"
			} ,{
				"mData" : "week36"
			} ,{
				"mData" : "week37"
			} ,{
				"mData" : "week38"
			} ,{
				"mData" : "week39"
			} ,{
				"mData" : "week40"
			} ,{
				"mData" : "week41"
			} 
			],
			"fnDrawCallback" : function(Settings) {
				$('#dataTables-report1')
						.dataTable()
						.$('tr')
						.click(
								function() {
									  
								});
			}

		});

}

}