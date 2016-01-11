var content;

$(document).ready(function(){
	
	$(".modify").click(function() {
		var id = $(this).parent().parent().attr('id');
		$("#" + id + " .modify_hidden").toggle("slow");
		
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