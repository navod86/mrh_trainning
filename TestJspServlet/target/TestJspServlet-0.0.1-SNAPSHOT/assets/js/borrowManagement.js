$(document).ready(function() {
	//Dissable DatePicker

	if ($(".date-start").val() !== "") 
		$(".date-end").prop("disabled", false)
	else 
		$(".date-end").prop("disabled", true)

	$(".date-start").on("change", function() {
		let dateS = $(".date-start").val();
		let dateE = $(".date-end").val();
		if (dateS === "" && dateE !== "")
			$(".date-end").prop("disabled", false);
		else if (dateS === "" && dateE === "")
			$(".date-end").prop("disabled", true);
		else $(".date-end").prop("disabled", false)
	})

	$(".date-end").on("change", function() {
		let dateS = $(".date-start").val();
		let dateE = $(".date-end").val();
		if (dateS === "" && dateE === "")
			$(".date-end").prop("disabled", true);
	})
});