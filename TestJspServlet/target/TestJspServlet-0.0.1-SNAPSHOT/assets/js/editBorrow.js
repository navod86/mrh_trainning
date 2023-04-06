$(document).ready(function(){
   $("#StudentID").on("change", function() {
	   let value =  $(this).children("option:selected").data("name");
	   $("#StudentName").val(value)
   })
   
   $(".date-end").prop("disabled", true )
   $(".date-start").on("change", function() {
	   $(".date-end").prop("disabled", false )
   })
});

/*function select() {
	var d = document.getElementById("StudentID");
			
	var displayValue = d.options[d.selectedIndex].getAttribute("data-name");
	console.log(displayValue)
	document.getElementById("StudentName").value= displayValue;
}*/