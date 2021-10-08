$(function () {

    const MAX_X = 5;
    const MIN_X = -3;

    function isNumber(number) {
        return !isNaN(number) && isFinite(number);
    }

    function validateX() {
        let x = getX();
        let input = $("#x-input");

        if (isNumber(x) && x >= MIN_X && x <= MAX_X) {

            input.removeClass("input-error");
            return true;
        }
        input.addClass("input-error");
        return false;
    }

    function validateY() {

        let graphMode = $(".graph_point_info").val();
        let y = parseFloat($("#graph-y").val());
        if (graphMode === "true" && isNumber(y)) {
            return true;
        }
        return $("input[type='radio']").is(":checked");

    }

    function validateData() {

        return validateX() & validateY();
    }

    function getY() {
        if ($("input[type='radio']").is(":checked")) {
            return parseFloat($("input[type='radio']:checked").val());
        } else {
            let graphMode = $(".graph_point_info").val();
            let y = parseFloat($("#graph-y").val());
            if (graphMode === "true" && isNumber(y)) {
                return y;
            }
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
        if (isNumber(x) && isNumber(y) && isNumber(r) && x >= MIN_X && x <= MAX_X) {
            let relativeX = x * 100 / r;
            let relativeY = y * 100 / r;
            let absoluteX = CENTER_X + Math.round(relativeX);
            let absoluteY = CENTER_Y - Math.round(relativeY);
            drawDotInAbsoluteCoord(absoluteX, absoluteY);

        } else {
            dot.attr("r", 0);
        }
    }

    function drawDotInAbsoluteCoord(absoluteX, absoluteY) {
        let dot = $("#dot");
        dot.attr("r", 3);
        dot.attr("cx", absoluteX);
        dot.attr("cy", absoluteY);
        alert("lol")
    }

    function setGraphModeOnForm(x, y) {
        $(".graph_point_info").val("true");
        $("input[type='radio']").prop("checked", false);
        $("#graph-y").val(y);
        $("#x-input").val(x);
    }

    function getXYCoordsFromAbsoluteOffset(absoluteXOffset, absoluteYOffset, r) {
        const CENTER_X = 150;
        const CENTER_Y = 120;
        return {
            x: Math.round(((absoluteXOffset - CENTER_X)*r/100)*1000)/1000,
            y: Math.round(((CENTER_Y - absoluteYOffset)*r/100)*1000)/1000
        }
    }

    function redrawDotsAfterRChanged() {
        let dots = $(".prev-dot");
        dots.each(function (i, dot){
            alert(dot.getAttribute("cx"));
            //drawDot(getX(), getY(), getR());
        });
    }

    $("button.reset").on("click", function () {
        $(".clear_info").val("true");
    });

    $("#values-form").on("submit", function (event) {
        if (!validateData() && event.target.getAttribute("class").indexOf("reset")===-1) event.preventDefault();

    });

    $(".svg-graph").on("click", function (event) {

        let graph = document.getElementById("graph-svg");
        let boundingRect = graph.getBoundingClientRect();
        let body = document.body;

        let dx = Math.round((event.pageX - (boundingRect.left + body.scrollLeft)) * 100) / 100;
        let dy = Math.round((event.pageY - (boundingRect.top + body.scrollTop)) * 100) / 100;
        let r = getR();
        drawDotInAbsoluteCoord(dx, dy);

        let {x, y} = getXYCoordsFromAbsoluteOffset(dx, dy, r);
        setGraphModeOnForm(x, y);
        $("button.submit").click();
    });


    $("#r-options").on("change", function () {
        drawDot(getX(), getY(), getR());
        redrawDotsAfterRChanged();
    });

    $("#x-input").on("keypress", function (event) {
        let test = /[0-9.,\-+]/.test(event.key);
        if (!test) {
            event.preventDefault();
        }
    });

    $("#x-input").on("input", function () {
        drawDot(getX(), getY(), getR());
    });

    $("#yradio").on("change", function () {
        drawDot(getX(), getY(), getR());
    })

});

