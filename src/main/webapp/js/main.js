$(function() {

	const MAX_X = 5;
	const MIN_X = -3;

	function isNumber(number) {
		return !isNaN(number) && isFinite(number);
	}

	function validateX() {
		let x = getX();
		let input = $("#x-input");

		if (isNumber(x) && x>=MIN_X && x<=MAX_X) {

			input.removeClass("input-error");
			return true;
		}
		input.addClass("input-error");
		return false;
	}

	function validateY() {

		return $("input[type='radio']").is(":checked");

	}

	function validateData() {

		return validateX() & validateY();
	}

	function getY() {
		if ($("input[type='radio']").is(":checked")) {
			return parseFloat($("input[type='radio']:checked").val());
		}
		return NaN;
	}

	function getX() {
		let x = $("#x-input").val();
		if (typeof x != "undefined") {
			x = x.replace(",", ".");
			if (/^[+-]?[0-9]+\.?[0-9]*$/.test(x)) {
				return parseFloat(x);
			} 
		}
		return NaN;
		
	}

	function getR() {
		return parseFloat($("#r-options").val());
	}

	function drawDot(x, y, r) {
		const CENTER_X = 150;
		const CENTER_Y = 120;
		let dot = $("#dot");
		if (isNumber(x) && isNumber(y) && isNumber(r) && x>=MIN_X && x<=MAX_X) {
			let relativeX = x*100/r;
			let relativeY = y*100/r;
			let absoluteX = CENTER_X + Math.round(relativeX);
			let absoluteY = CENTER_Y - Math.round(relativeY);
			dot.attr("r", 3);
			dot.attr("cx", absoluteX);
			dot.attr("cy", absoluteY);

		} else {
			$("#dot").attr("r", 0);
		}
	}


	$("button.reset").on("click", function (){
		$(".clear_info").val("true");
	});

	$("#values-form").on("submit", function(event) {

		if (!validateData()) event.preventDefault();

	});


	$("#r-options").on("change", function() {
		drawDot(getX(), getY(), getR());
	});

	$("#x-input").on("keypress", function(event) {
		let test = /[0-9.,\-+]/.test(event.key);
		if (!test) {
			event.preventDefault();
		}
	}); 

	$("#x-input").on("input", function() {
		drawDot(getX(), getY(), getR());
	});

	$("#yradio").on("change", function () {
		drawDot(getX(), getY(), getR());
	})

});

