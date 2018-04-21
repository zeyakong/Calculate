function getAdd() {
    operation("add","+");
}

function getMul() {
    operation("mul","*");
}

function getSub() {
    operation("sub","-");
}

function getPow() {
    operation("pow","^");
}

function getDiv() {
    operation("div","/");
}


//######################################ajax##########################

function operation(op,opLag) {
    var checkStatus = $("#defaultCheck").prop("checked");
    var hashLag = $("#hashLag").val();
    var x = $("#x").val();
    var y = $("#y").val();
    var method;
    if (checkStatus) method = "POST";
    else method = "GET";

    $.ajax({
        url: '/api/v1/' + op + "?x=" + x + "&y=" + y,
        type: method,
        headers: {
            'hash-lag': hashLag
        },
        success: function (data) {
            console.log(data);
            $("#opView").text(data.x+" "+opLag+" "+data.y+" = "+data.result);
            $("#hashView").text(hashLag+":"+data.hash);
            $("#x").val("");
            $("#y").val("");
        }
    });
}
