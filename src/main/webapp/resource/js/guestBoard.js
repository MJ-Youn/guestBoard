var content;

$(document).ready(function(){
	
	$(".modify").click(function() {
		$(".modify_hidden").toggle("slow");
		
		var id = $(this).parent().parent().attr('id');
		
		
		if ( $(this).val() === "modify" ) {
			$("#" + id + " textarea").removeAttr("readonly");
			content = $("#" + id + " textarea").val();
			$(this).val('cancel');
		}
		else {
			$("#" + id + " textarea").attr("readonly", "readonly");
			$("#" + id + " textarea").val(content);
			$(this).val('modify');
		}
	});
	
});