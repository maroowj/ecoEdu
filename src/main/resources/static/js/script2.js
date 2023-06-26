function toastModal(txt, sec) {
    let secs = 1000;
    if(sec == undefined || sec == null) secs = 1000;
    else secs = sec;

    const newDiv = document.createElement('div');
    const newText = document.createTextNode(txt);

    newDiv.appendChild(newText);

    $(newDiv).css({"position":"fixed","top":"49%","left":"50%","transform":"translateX(-50%)","background-color":"#5c9021","padding":"12px 30px","border-radius":"20px","color":"#fff","z-index":9999});

    document.body.appendChild(newDiv);

    setTimeout(function () {
        $(newDiv).animate({
            opacity: "hide"
        });
    }, secs);
}

function fConvertDateFrom(string) {
    let year = string.substr(0, 4);
    let month = string.substr(5, 2);

    let day = string.substr(8, 2);

    let returnDate = new Date(year, parseInt(month) - 1, day);
    returnDate.setHours(returnDate.getHours() + 9);

    let returnStr = returnDate.toISOString().replace("T", " ").replace(/\..*/, '');
    return returnStr;
}

function fConvertDateTo(string) {
    let year = string.substr(0, 4);
    let month = string.substr(5, 2);

    let day = (parseInt(string.substr(8, 2)) + 1) + '';

    let returnDate = new Date(year, parseInt(month) - 1, day);
    returnDate.setHours(returnDate.getHours() + 9);

    let returnStr = returnDate.toISOString().replace("T", " ").replace(/\..*/, '');
    return returnStr;
}

function fPagination(data, page) {
    let num = "";
    let reNum = parseInt(data.number / 5);
    let pre = "";
    let next = "";

    // 이전버튼 (5페이지씩 이동, 처음으로)
    if (reNum >= 1 && page > 5) {
        pre = "<a gopage='" + (reNum * 5) + "'><i id='pre' class='icon-green-arrow-left'></i></a>";
    }

    // 다음버튼 (5페이지씩 이동, 마지막으로)
    if (parseInt((data.totalPages - 1) / 5) != reNum && data.totalPages > 5) {
        next = "<a gopage='" + ( reNum * 5 + 6 ) + "'><i id='next' class='icon-green-arrow-left'></i></a>";
    }

    for ( let idx = 1; idx <= data.totalPages; idx++ ) {
        if ( idx <= reNum * 5 + 5 && idx > reNum * 5 ) {
            if (idx == page) {
                num += "<a class='num active' gopage=" + idx + ">" + idx + "</a>";
            } else {
                num += "<a class='num' gopage=" + idx + ">" + idx + "</a>";
            }
        }
    }
    $(".pagination").html(pre + num + next);
}

// 천단위 콤마
function fcomma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

// 천단위 콤마 제거
function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}

function fConvertHour(second) {
    let hour = parseInt((second % 3600) / 60) < 10 ? '0' + parseInt((second % 3600) / 60) : parseInt((second % 3600) / 60);

    return hour;
}
function fConvertMin(second) {
    let min = parseInt(second % 60) < 10 ? '0' + parseInt(second % 60) : parseInt(second % 60);

    return min;
}



