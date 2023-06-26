jQuery(document).ready(function($) {

    // 관리자 START-----------------------------------------------------------------------------------------


    $(function(){
        menuWrap();
    });

    // GNB 메뉴
    function menuWrap(){
        $('.left-menu-wrap a.menu-1').mousedown(function(){
            $(this).children('span').removeClass('font-gray');
            $(this).children('span').addClass('font-green');
            $(this).children('span').next('i').removeClass('icon-gray-category');
            $(this).children('span').next('i').addClass('icon-green-program-list');
            $(this).addClass('actived');
            $('.left-menu-wrap a.menu-2').removeClass('actived');
            $('.left-menu-wrap a.menu-3').removeClass('actived');
            $('.left-menu-wrap a.menu-4').removeClass('actived');
            $('.left-menu-wrap a.menu-5').removeClass('actived');

            $('.left-menu-wrap .menu-2').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-2').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-2').children('span').next('i').removeClass('icon-green-category');
            $('.left-menu-wrap .menu-2').children('span').next('i').addClass('icon-gray-category');

            $('.left-menu-wrap .menu-3').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-3').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-3').children('span').next('i').removeClass('icon-green-group');
            $('.left-menu-wrap .menu-3').children('span').next('i').addClass('icon-gray-group');

            $('.left-menu-wrap .menu-4').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-4').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-4').children('span').next('i').removeClass('icon-green-program');
            $('.left-menu-wrap .menu-4').children('span').next('i').addClass('icon-gray-program');

            $('.left-menu-wrap .menu-5').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-5').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-5').children('span').next('i').removeClass('icon-green-edit');
            $('.left-menu-wrap .menu-5').children('span').next('i').addClass('icon-gray-edit');
        });


        $('.left-menu-wrap a.menu-2').mousedown(function(){
            $(this).children('span').removeClass('font-gray');
            $(this).children('span').addClass('font-green');
            $(this).children('span').next('i').removeClass('icon-gray-category');
            $(this).children('span').next('i').addClass('icon-green-category');
            $(this).addClass('actived');
            $('.left-menu-wrap a.menu-1').removeClass('actived');
            $('.left-menu-wrap a.menu-3').removeClass('actived');
            $('.left-menu-wrap a.menu-4').removeClass('actived');
            $('.left-menu-wrap a.menu-5').removeClass('actived');

            $('.left-menu-wrap .menu-1').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-1').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-1').children('span').next('i').removeClass('icon-green-program-list');
            $('.left-menu-wrap .menu-1').children('span').next('i').addClass('icon-gray-program-list');

            $('.left-menu-wrap .menu-3').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-3').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-3').children('span').next('i').removeClass('icon-green-group');
            $('.left-menu-wrap .menu-3').children('span').next('i').addClass('icon-gray-group');

            $('.left-menu-wrap .menu-4').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-4').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-4').children('span').next('i').removeClass('icon-green-program');
            $('.left-menu-wrap .menu-4').children('span').next('i').addClass('icon-gray-program');

            $('.left-menu-wrap .menu-5').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-5').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-5').children('span').next('i').removeClass('icon-green-edit');
            $('.left-menu-wrap .menu-5').children('span').next('i').addClass('icon-gray-edit');
        });


        $('.left-menu-wrap a.menu-3').mousedown(function(){
            $(this).children('span').removeClass('font-gray');
            $(this).children('span').addClass('font-green');
            $(this).children('span').next('i').removeClass('icon-gray-group');
            $(this).children('span').next('i').addClass('icon-green-group');
            $(this).addClass('actived');
            $('.left-menu-wrap a.menu-1').removeClass('actived');
            $('.left-menu-wrap a.menu-2').removeClass('actived');
            $('.left-menu-wrap a.menu-4').removeClass('actived');
            $('.left-menu-wrap a.menu-5').removeClass('actived');

            $('.left-menu-wrap .menu-1').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-1').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-1').children('span').next('i').removeClass('icon-green-program-list');
            $('.left-menu-wrap .menu-1').children('span').next('i').addClass('icon-gray-program-list');

            $('.left-menu-wrap .menu-2').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-2').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-2').children('span').next('i').removeClass('icon-green-category');
            $('.left-menu-wrap .menu-2').children('span').next('i').addClass('icon-gray-category');

            $('.left-menu-wrap .menu-4').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-4').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-4').children('span').next('i').removeClass('icon-green-program');
            $('.left-menu-wrap .menu-4').children('span').next('i').addClass('icon-gray-program');

            $('.left-menu-wrap .menu-5').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-5').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-5').children('span').next('i').removeClass('icon-green-edit');
            $('.left-menu-wrap .menu-5').children('span').next('i').addClass('icon-gray-edit');
        });


        $('.left-menu-wrap a.menu-4').mousedown(function(){
            $(this).children('span').removeClass('font-gray');
            $(this).children('span').addClass('font-green');
            $(this).children('span').next('i').removeClass('icon-gray-program');
            $(this).children('span').next('i').addClass('icon-green-program');
            $(this).addClass('actived');
            $('.left-menu-wrap a.menu-1').removeClass('actived');
            $('.left-menu-wrap a.menu-2').removeClass('actived');
            $('.left-menu-wrap a.menu-3').removeClass('actived');
            $('.left-menu-wrap a.menu-5').removeClass('actived');

            $('.left-menu-wrap .menu-1').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-1').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-1').children('span').next('i').removeClass('icon-green-program-list');
            $('.left-menu-wrap .menu-1').children('span').next('i').addClass('icon-gray-program-list');

            $('.left-menu-wrap .menu-2').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-2').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-2').children('span').next('i').removeClass('icon-green-category');
            $('.left-menu-wrap .menu-2').children('span').next('i').addClass('icon-gray-category');

            $('.left-menu-wrap .menu-3').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-3').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-3').children('span').next('i').removeClass('icon-green-group');
            $('.left-menu-wrap .menu-3').children('span').next('i').addClass('icon-gray-group');

            $('.left-menu-wrap .menu-5').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-5').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-5').children('span').next('i').removeClass('icon-green-edit');
            $('.left-menu-wrap .menu-5').children('span').next('i').addClass('icon-gray-edit');
        });


        $('.left-menu-wrap a.menu-5').mousedown(function(){
            $(this).children('span').removeClass('font-gray');
            $(this).children('span').addClass('font-green');
            $(this).children('span').next('i').removeClass('icon-gray-edit');
            $(this).children('span').next('i').addClass('icon-green-edit');
            $(this).addClass('actived');
            $('.left-menu-wrap a.menu-1').removeClass('actived');
            $('.left-menu-wrap a.menu-2').removeClass('actived');
            $('.left-menu-wrap a.menu-3').removeClass('actived');
            $('.left-menu-wrap a.menu-4').removeClass('actived');

            $('.left-menu-wrap .menu-1').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-1').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-1').children('span').next('i').removeClass('icon-green-program-list');
            $('.left-menu-wrap .menu-1').children('span').next('i').addClass('icon-gray-program-list');

            $('.left-menu-wrap .menu-2').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-2').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-2').children('span').next('i').removeClass('icon-green-category');
            $('.left-menu-wrap .menu-2').children('span').next('i').addClass('icon-gray-category');

            $('.left-menu-wrap .menu-3').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-3').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-3').children('span').next('i').removeClass('icon-green-group');
            $('.left-menu-wrap .menu-3').children('span').next('i').addClass('icon-gray-group');

            $('.left-menu-wrap .menu-4').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-4').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-4').children('span').next('i').removeClass('icon-green-program');
            $('.left-menu-wrap .menu-4').children('span').next('i').addClass('icon-gray-program');
        });


        // $('.left-menu-wrap .menu-1').on('mousedown ', function(){
        //     $('selectmenu').animate({
        //         top: '18px',
        //     }, 1, 'easeInOutQuart');
        // });
        // $('.left-menu-wrap .menu-2').on('mousedown ', function(){
        //     $('selectmenu').animate({
        //         top: '78px',
        //     }, 1, 'easeInOutQuart');
        // });
        // $('.left-menu-wrap .menu-3').on('mousedown ', function(){
        //     $('selectmenu').animate({
        //         top: '138px',
        //     }, 1, 'easeInOutQuart');
        // });
        // $('.left-menu-wrap .menu-4').on('mousedown ', function(){
        //     $('selectmenu').animate({
        //         top: '198px',
        //     }, 1, 'easeInOutQuart');
        // });
        // $('.left-menu-wrap .menu-5').on('mousedown ', function(){
        //     $('selectmenu').animate({
        //         top: '258px',
        //     }, 1, 'easeInOutQuart');
        // });
    }


    $(document).ready(function (){
        let link = document.location.href;

        if (link.includes('/manage/category')) {
            $('.left-menu-wrap a.menu-2').children('span').removeClass('font-gray');
            $('.left-menu-wrap a.menu-2').children('span').addClass('font-green');
            $('.left-menu-wrap a.menu-2').children('span').next('i').removeClass('icon-gray-category');
            $('.left-menu-wrap a.menu-2').children('span').next('i').addClass('icon-green-category');

            $('.left-menu-wrap .menu-1').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-1').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-1').children('span').next('i').removeClass('icon-green-program-list');
            $('.left-menu-wrap .menu-1').children('span').next('i').addClass('icon-gray-program-list');

            $('.left-menu-wrap .menu-3').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-3').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-3').children('span').next('i').removeClass('icon-green-group');
            $('.left-menu-wrap .menu-3').children('span').next('i').addClass('icon-gray-group');

            $('.left-menu-wrap .menu-4').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-4').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-4').children('span').next('i').removeClass('icon-green-program');
            $('.left-menu-wrap .menu-4').children('span').next('i').addClass('icon-gray-program');

            $('.left-menu-wrap .menu-5').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-5').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-5').children('span').next('i').removeClass('icon-green-edit');
            $('.left-menu-wrap .menu-5').children('span').next('i').addClass('icon-gray-edit');

            $('.left-menu-wrap .menu-1 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-2 selectmenu').removeClass('d-none');
            $('.left-menu-wrap .menu-3 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-4 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-5 selectmenu').addClass('d-none');
        }
        else if (link.includes('/manage/group')) {
            $('.left-menu-wrap a.menu-3').children('span').removeClass('font-gray');
            $('.left-menu-wrap a.menu-3').children('span').addClass('font-green');
            $('.left-menu-wrap a.menu-3').children('span').next('i').removeClass('icon-gray-group');
            $('.left-menu-wrap a.menu-3').children('span').next('i').addClass('icon-green-group');

            $('.left-menu-wrap .menu-1').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-1').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-1').children('span').next('i').removeClass('icon-green-program-list');
            $('.left-menu-wrap .menu-1').children('span').next('i').addClass('icon-gray-program-list');

            $('.left-menu-wrap .menu-2').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-2').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-2').children('span').next('i').removeClass('icon-green-category');
            $('.left-menu-wrap .menu-2').children('span').next('i').addClass('icon-gray-category');

            $('.left-menu-wrap .menu-4').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-4').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-4').children('span').next('i').removeClass('icon-green-program');
            $('.left-menu-wrap .menu-4').children('span').next('i').addClass('icon-gray-program');

            $('.left-menu-wrap .menu-5').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-5').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-5').children('span').next('i').removeClass('icon-green-edit');
            $('.left-menu-wrap .menu-5').children('span').next('i').addClass('icon-gray-edit');

            $('.left-menu-wrap .menu-1 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-2 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-3 selectmenu').removeClass('d-none');
            $('.left-menu-wrap .menu-4 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-5 selectmenu').addClass('d-none');
        }
        else if (link.includes('/manage/program')) {
            $('.left-menu-wrap a.menu-4').children('span').removeClass('font-gray');
            $('.left-menu-wrap a.menu-4').children('span').addClass('font-green');
            $('.left-menu-wrap a.menu-4').children('span').next('i').removeClass('icon-gray-program');
            $('.left-menu-wrap a.menu-4').children('span').next('i').addClass('icon-green-program');

            $('.left-menu-wrap .menu-1').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-1').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-1').children('span').next('i').removeClass('icon-green-program-list');
            $('.left-menu-wrap .menu-1').children('span').next('i').addClass('icon-gray-program-list');

            $('.left-menu-wrap .menu-2').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-2').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-2').children('span').next('i').removeClass('icon-green-category');
            $('.left-menu-wrap .menu-2').children('span').next('i').addClass('icon-gray-category');

            $('.left-menu-wrap .menu-3').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-3').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-3').children('span').next('i').removeClass('icon-green-group');
            $('.left-menu-wrap .menu-3').children('span').next('i').addClass('icon-gray-group');

            $('.left-menu-wrap .menu-5').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-5').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-5').children('span').next('i').removeClass('icon-green-edit');
            $('.left-menu-wrap .menu-5').children('span').next('i').addClass('icon-gray-edit');

            $('.left-menu-wrap .menu-1 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-2 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-3 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-4 selectmenu').removeClass('d-none');
            $('.left-menu-wrap .menu-5 selectmenu').addClass('d-none');
        }
        else if (link.includes('/manage/edit')) {
            $('.left-menu-wrap a.menu-5').children('span').removeClass('font-gray');
            $('.left-menu-wrap a.menu-5').children('span').addClass('font-green');
            $('.left-menu-wrap a.menu-5').children('span').next('i').removeClass('icon-gray-edit');
            $('.left-menu-wrap a.menu-5').children('span').next('i').addClass('icon-green-edit');

            $('.left-menu-wrap .menu-1').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-1').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-1').children('span').next('i').removeClass('icon-green-program-list');
            $('.left-menu-wrap .menu-1').children('span').next('i').addClass('icon-gray-program-list');

            $('.left-menu-wrap .menu-2').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-2').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-2').children('span').next('i').removeClass('icon-green-category');
            $('.left-menu-wrap .menu-2').children('span').next('i').addClass('icon-gray-category');

            $('.left-menu-wrap .menu-3').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-3').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-3').children('span').next('i').removeClass('icon-green-group');
            $('.left-menu-wrap .menu-3').children('span').next('i').addClass('icon-gray-group');

            $('.left-menu-wrap .menu-4').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-4').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-4').children('span').next('i').removeClass('icon-green-program');
            $('.left-menu-wrap .menu-4').children('span').next('i').addClass('icon-gray-program');

            $('.left-menu-wrap .menu-1 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-2 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-3 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-4 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-5 selectmenu').removeClass('d-none');
        }
        else{
            $('.left-menu-wrap a.menu-1').children('span').removeClass('font-gray');
            $('.left-menu-wrap a.menu-1').children('span').addClass('font-green');
            $('.left-menu-wrap a.menu-1').children('span').next('i').removeClass('icon-gray-program-list');
            $('.left-menu-wrap a.menu-1').children('span').next('i').addClass('icon-green-program-list');

            $('.left-menu-wrap .menu-2').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-2').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-2').children('span').next('i').removeClass('icon-green-category');
            $('.left-menu-wrap .menu-2').children('span').next('i').addClass('icon-gray-category');

            $('.left-menu-wrap .menu-3').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-3').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-3').children('span').next('i').removeClass('icon-green-group');
            $('.left-menu-wrap .menu-3').children('span').next('i').addClass('icon-gray-group');

            $('.left-menu-wrap .menu-4').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-4').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-4').children('span').next('i').removeClass('icon-green-program');
            $('.left-menu-wrap .menu-4').children('span').next('i').addClass('icon-gray-program');

            $('.left-menu-wrap .menu-5').children('span').removeClass('font-green');
            $('.left-menu-wrap .menu-5').children('span').addClass('font-gray');
            $('.left-menu-wrap .menu-5').children('span').next('i').removeClass('icon-green-edit');
            $('.left-menu-wrap .menu-5').children('span').next('i').addClass('icon-gray-edit');

            $('.left-menu-wrap .menu-1 selectmenu').removeClass('d-none');
            $('.left-menu-wrap .menu-2 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-3 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-4 selectmenu').addClass('d-none');
            $('.left-menu-wrap .menu-5 selectmenu').addClass('d-none');
        }
    });


    // 페이지네이션 페이지 클릭 시 색상 바뀌기
    $('.pagination a.num').on('click', function(){
        $(this).addClass('active');
    });


    //링크아이콘 마우스오버 시
    $('tr.list td.list-url a').on('mouseover', function(){
        $(this).children('a').removeClass('icon-gray-url');
        $(this).children('a').addClass('icon-green-url');
    });
    $('tr.list td.list-url a').on('mouseout', function(){
        $(this).children('a').removeClass('icon-green-url');
        $(this).children('a').addClass('icon-gray-url');
    });




    //모달

    // 배경선택 시 사라지기

    // $('.modal-back').on('click', function(){
    //     $(this).parent('.modal').fadeOut(150);
    // });

    //모달 헤더 내 화살표 선택 시 사라지기
    $('.modal .modal-header i.pre, .close, .modal-back').on('click', function (){
        $('.modal').fadeOut(150);
        $('.category-menu-back').click();
        $('.modal input:text').val('');
        $('.modal input:file').val('');
        $('.modal input:password').val('');
        $('.modal input:checkbox').prop('checked', false);
        $('.modal input:radio').prop('checked', false);
        $('.modal textarea').val('');
        $('.modal select option').prop('selected', false);
        $('.main-content .modal .modal-footer button.none').show();
        $('.main-content .modal .modal-footer button.search-btn').hide();
        $('.main-content .modal li i').removeClass('favicon');
        $('.main-content .modal div.incheon-city-area img.sel-before').css('display', 'block');
        $('.main-content .modal div.incheon-city-area .select-after img').css('display', 'none');
        let thememodal = $('#selectThemeModal ul li');
        if(thememodal.hasClass('selected-back-color')){
            thememodal.removeClass('selected-back-color');
            thememodal.addClass('basic-back-color');
            thememodal.children().children('p').removeClass('font-white');
            thememodal.children().children('img:nth-child(1)').show();
            thememodal.children().children('img:nth-child(2)').hide();
        }
        let thememodal2 = $('#selectThemeModal2 ul li');
        if(thememodal2.hasClass('selected-back-color')){
            thememodal2.removeClass('selected-back-color');
            thememodal2.addClass('basic-back-color');
            thememodal2.children().children('p').removeClass('font-white');
            thememodal2.children().children('img:nth-child(1)').show();
            thememodal2.children().children('img:nth-child(2)').hide();
        }
        $('#selectTypeModal select option:eq(0)').prop('selected', true);
        if($('#selectTypeModal select option:eq(0)').is(':selected') == true){
            $('#selectTypeModal input:text').hide();
        }
        $('#selectTypeModal2 select option:eq(0)').prop('selected', true);
        if($('#selectTypeModal2 select option:eq(0)').is(':selected') == true){
            $('#selectTypeModal2 input:text').hide();
        }
        $('.modal button.edit-group').addClass('btn-h50r-green');
        $('.modal button.edit-group').removeClass('btn-h50r-light-gray');
        $('.modal button.edit-program').removeClass('btn-h50r-green');
        $('.modal button.edit-program').addClass('btn-h50r-light-gray');
    });

    //닫기버튼 선택 시 사라지기


    //파일첨부
    let addFile1 = document.querySelector(".addFile1"); //프로그램 이미지1 추가
    let addFile2 = document.querySelector(".addFile2"); //프로그램 이미지2 추가
    let addFile = document.querySelector("#addFile"); //단체 이미지 추가
    let addThemeSymbol1 = document.querySelector("#addThemeSymbol1"); //테마아이콘1 추가
    let addThemeSymbol2 = document.querySelector("#addThemeSymbol2"); //테마아이콘2 추가

    $('.addThumb1').on('click', function(){
        addFile1.click();
    });
    $('.addThumb2').on('click', function(){
        addFile2.click();
    });
    $('#addThumb').on('click', function(){
        addFile.click();
    });
    $('.addThemeSymbol1').on('click', function(){
        addThemeSymbol1.click();
    });
    $('.addThemeSymbol2').on('click', function(){
        addThemeSymbol2.click();
    });

    //파일첨부 수정
    let editFile1 = document.querySelector(".editFile1"); //프로그램 이미지 수정1
    let editFile2 = document.querySelector(".editFile2"); //프로그램 이미지 수정2
    let editFile = document.querySelector("#editFile"); //단체 이미지 수정
    let editThemeSymbol1 = document.querySelector("#editThemeSymbol1"); //테마아이콘1 수정
    let editThemeSymbol2 = document.querySelector("#editThemeSymbol2"); //테마아이콘2 수정

    $('.editThumb1').on('click', function(){
        editFile1.click();
    });
    $('.editThumb2').on('click', function(){
        editFile2.click();
    });
    $('#editThumb').on('click', function(){
        editFile.click();
    });
    $('.editThemeSymbol1').on('click', function(){
        editThemeSymbol1.click();
    });
    $('.editThemeSymbol2').on('click', function(){
        editThemeSymbol2.click();
    });



    // 버튼영역 내 버튼 클릭 시 modal 띄우기
    $('.btn-wrap #btn-add').on('click', function(){
        $('#addModal').css('display', 'flex');
    });
    $('.btn-wrap #btn-del').on('click', function(){
        $('#deleteModal').css('display', 'flex');
    });
    $('.btn-wrap #btn-edit').on('click', function(){
        $('#editModal').css('display', 'flex');
    });
    $('.modal-footer #close').on('click', function(){
        $('#addModal').css('display', 'none');
        $('#deleteModal').css('display', 'none');
        $('#editModal').css('display', 'none');
    });



    //카테고리 관리
    //대상상세
    $('.table-list tr.list').on('click', function(){
        targetDetail();
    });
    $(function (){
        targetDetail();
    });
    function targetDetail(){
        let detailCont = $('.main-content-target-manage #detailModal li:nth-child(2)').height();
        if(detailCont >= 290){
            $('.main-content-target-manage #detailModal .modal-body .modal-content').addClass('pa-r-30px');
        }
        if(detailCont < 290){
            $('.main-content-target-manage #detailModal .modal-body .modal-content').removeClass('pa-r-30px');
        }
    }

    //테마상세
    $('.table-list tr.list').on('click', function(){
        themeDetail();
    });
    $(function (){
        themeDetail();
    });
    function themeDetail(){
        let detailCont = $('.main-content-theme-manage #detailModal li:nth-child(2)').height();
        if(detailCont >= 290){
            $('.main-content-theme-manage #detailModal .modal-body .modal-content').addClass('pa-r-30px');
        }
        if(detailCont < 290){
            $('.main-content-theme-manage #detailModal .modal-body .modal-content').removeClass('pa-r-30px');
        }
    }
    //유형상세
    $('.table-list tr.list').on('click', function(){
        groupDetail();
    });
    $(function (){
        groupDetail();
    });
    function typeDetail(){
        let detailCont = $('.main-content-type-manage #detailModal li:nth-child(2)').height();
        if(detailCont >= 290){
            $('.main-content-type-manage #detailModal .modal-body .modal-content').addClass('pa-r-30px');
        }
        if(detailCont < 290){
            $('.main-content-type-manage #detailModal .modal-body .modal-content').removeClass('pa-r-30px');
        }
    }
    // 단체상세
    $('.table-list tr.list').on('click', function(){
        groupDetail();
    });
    $(function (){
        groupDetail();
    });
    function groupDetail(){
        let detailCont = $('.main-content-group-manage #detailModal div.info-content').height();
        if(detailCont >= 127){
            $('.main-content-group-manage #detailModal .modal-body .modal-content').addClass('pa-r-30px');
        }
        if(detailCont < 127){
            $('.main-content-group-manage #detailModal .modal-body .modal-content').removeClass('pa-r-30px');
        }
    }


    // 프로그램 관리
    // 교육일정 추가
    $('#addModal .plus').on('click', function(){
        $('.main-content-program-manage #addModal ul:nth-child(12) li:nth-child(2)').append(
            '<div class="del-date">' +
            '<input class="input-gray addSchedule" type="text" placeholder="ex) 3월 (쉼표 사용 X)" value=""/>' +
            '<button class="minus"></button>' +
            '</div>'
        );
    });

    // 교육일정 수정
    $('#editModal .plus').on('click', function(){
        $('.main-content-program-manage #editModal ul:nth-child(12) li:nth-child(2)').append(
            '<div class="del-date">' +
            '<input class="input-gray editSchedule" type="text" placeholder="ex) 3월 (쉼표 사용 X)" value=""/>' +
            '<button class="minus"></button>' +
            '</div>'
        );
    });



    // 교육일정 삭제
    $('.main-content-program-manage #addModal ul:nth-child(12) li:nth-child(2)').on('click', '.minus', function(){
        $(this).parent().remove();
    });
    $('.main-content-program-manage #editModal ul:nth-child(12) li:nth-child(2)').on('click', '.minus', function(){
        $(this).parent().remove();
    });



    //참가비용 유료/무료 여부
    $(function(){
        changePay();

        let addPayState = $('.main-content-program-manage #addModal ul:nth-child(12) li:nth-child(2) .select-pay option:selected').val();
        let editPayState = $('.main-content-program-manage #editModal ul:nth-child(12) li:nth-child(2) .select-pay option:selected').val();
        if(addPayState == 'free'){
            $('.main-content-program-manage #addModal ul:nth-child(12) li:nth-child(2) .direct-input-pay').hide();
        }
        if(editPayState == 'free'){
            $('.main-content-program-manage #editModal ul:nth-child(12) li:nth-child(2) .direct-input-pay').hide();
        }

        //비용 입력 시 천단위 콤마
        // let addDirectPay = $('.main-content-program-manage #addModal ul:nth-child(12) li:nth-child(2) .direct-input-pay input');
        // let editDirectPay = $('.main-content-program-manage #editModal ul:nth-child(12) li:nth-child(2) .direct-input-pay input');

        // $(addDirectPay).on('keyup', function(){
        //     $(this).val(fcomma($(this).val().replace(/[^0-9]/g,"")));
        // });
        // $(editDirectPay).on('keyup', function(){
        //     $(this).val(fcomma($(this).val().replace(/[^0-9]/g,"")));
        // });
    });

    // 프로그램 추가 modal
    function changePay(){
        $('.main-content-program-manage #addModal .select-pay').change(function(){
            let payState = $('.main-content-program-manage #addModal ul:nth-child(12) li:nth-child(2) .select-pay option:selected').val();
            if(payState == 'pay'){
                $('.main-content-program-manage #addModal ul:nth-child(12) li:nth-child(2) .direct-input-pay').show();
            }else{
                $('.main-content-program-manage #addModal ul:nth-child(12) li:nth-child(2) .direct-input-pay').hide();
            }
        });

        // 프로그램 수정 modal
        $('.main-content-program-manage #editModal .select-pay').change(function(){
            let payState = $('.main-content-program-manage #editModal ul:nth-child(12) li:nth-child(2) .select-pay option:selected').val();
            if(payState == 'pay'){
                $('.main-content-program-manage #editModal ul:nth-child(12) li:nth-child(2) .direct-input-pay').show();
            }else{
                $('.main-content-program-manage #editModal ul:nth-child(12) li:nth-child(2) .direct-input-pay').hide();
            }
        });
    }



    //수정요청 관리
    $('.btn-wrap #btn-complete').on('click', function(){
        $('#completeModal').css('display', 'flex');
    });
    $('.btn-wrap #btn-confirm').on('click', function(){
        $('#confirmModal').css('display', 'flex');
    });
    $('.btn-wrap #btn-impossible').on('click', function(){
        $('#impossibleModal').css('display', 'flex');
    });

    $('.main-content-edit-manage #impossibleModal ul:nth-child(2)').hide();
    $('.main-content-edit-manage #impossibleModal select').on('change', function (){
        let etc =  $('.main-content-edit-manage #impossibleModal select option:eq(3)').is(':selected');
        if(etc == true){
            $('.main-content-edit-manage #impossibleModal ul:nth-child(2)').show();
        }else{
            $('.main-content-edit-manage #impossibleModal ul:nth-child(2)').hide();
        }
    });

    // 관리자 END-----------------------------------------------------------------------------------------







    // 사용자 START-----------------------------------------------------------------------------------------

    // 탑버튼(top button)
    $(document).ready(function (){
        topButton();
    });
    $(window).scroll(function (){
        topButton();
    });

    function topButton(){
        if($(this).scrollTop() > 100){
            $('.top-button').show();
        }else{
            $('.top-button').fadeOut(250);
        }

        $('.top-button').click(function(){
            //해당 컨텐츠로 스크롤 이동
            window.scrollTo({top: 0, behavior: "smooth"});
        });
    }


    // 헤더(mobile)
    $(document).ready(function (){
        let link = document.location.href;

        if(link.includes('/list/edit')){
            $('.header-wrap .category-area .category-title .menu-title').html('정보수정 요청');
        }
        else if(link.includes('/detail/group')){
            $('.header-wrap .category-area .category-title .menu-title').html('단체 상세');
        }
        else if(link.includes('/detail/program')){
            $('.header-wrap .category-area .category-title .menu-title').html('프로그램 상세');
        }
    });

    $(window).scroll(function (){
        if($(this).scrollTop() > 1){
            $('.header-wrap-transparent').addClass('blur');
        }else{
            $('.header-wrap-transparent').removeClass('blur');
        }
    });


    // 헤더 내 1차 카테고리 메뉴 선택여부에 따라 modal 띄우기
    $('.header-wrap div.category-title-select, .header-wrap ul li.menu-category').on('click', function (){
        $('div.category-area2').show();
        $('.category-menu-back').show();
    });
    $('.category-menu-back').on('click', function (){
        $('div.category-area2').hide();
        $('.category-menu-back').hide();
    });
    $('.header-wrap .category-area2 ul li:nth-child(2), .header-wrap-transparent .category-area2 ul li:nth-child(2)').on('click', function (){
        $('#selectAreaModal').css('display', 'flex');
        $('div.category-area2').hide();
        $('.category-menu-back').hide();
        $(this).parent().parent().parent().hide();
    });
    $('.header-wrap .category-area2 ul li:nth-child(3), .header-wrap-transparent .category-area2 ul li:nth-child(3)').on('click', function (){
        $('#selectTargetModal').css('display', 'flex');
        $('div.category-area2').hide();
        $('.category-menu-back').hide();
        $(this).parent().parent().parent().hide();
    });
    $('.header-wrap .category-area2 ul li:nth-child(4), .header-wrap-transparent .category-area2 ul li:nth-child(4)').on('click', function (){
        $('#selectThemeModal').css('display', 'flex');
        $('div.category-area2').hide();
        $('.category-menu-back').hide();
        $(this).parent().parent().parent().hide();
    });
    $('.header-wrap .category-area2 ul li:nth-child(5), .header-wrap-transparent .category-area2 ul li:nth-child(5)').on('click', function (){
        $('#selectTypeModal').css('display', 'flex');
        $('div.category-area2').hide();
        $('.category-menu-back').hide();
        $(this).parent().parent().parent().hide();
    });

    $('.top-menu-list-user .header-wrap .category-area2 ul li.category-area').on('click', function (){
        $('#selectAreaModal').css('display', 'none');
        $('#selectAreaModal2').css('display', 'flex');
        $('div.category-area2').hide();
        $('.category-menu-back').hide();
        $(this).parent().parent().parent().hide();
    });
    $('.top-menu-list-user .header-wrap .category-area2 ul li.category-target').on('click', function (){
        $('#selectTargetModal').css('display', 'none');
        $('#selectTargetModal2').css('display', 'flex');
        $('div.category-area2').hide();
        $('.category-menu-back').hide();
        $(this).parent().parent().parent().hide();
    });
    $('.top-menu-list-user .header-wrap .category-area2 ul li.category-theme').on('click', function (){
        $('#selectThemeModal').css('display', 'none');
        $('#selectThemeModal2').css('display', 'flex');
        $('div.category-area2').hide();
        $('.category-menu-back').hide();
        $(this).parent().parent().parent().hide();
    });
    $('.top-menu-list-user .header-wrap .category-area2 ul li.category-type').on('click', function (){
        $('#selectTypeModal').css('display', 'none');
        $('#selectTypeModal2').css('display', 'flex');
        $('div.category-area2').hide();
        $('.category-menu-back').hide();
        $(this).parent().parent().parent().hide();
    });



    // 슬라이딩 메뉴
    // 지역 선택 시
    $('div.sliding-menu .sliding-menu-wrap ul li.category-area').on('click', function (){
        $('.main-content #selectAreaModal').css('display', 'flex');
        $('div.sliding-menu').hide();
    });

    // 대상 선택 시
    $('div.sliding-menu .sliding-menu-wrap ul li.category-target').on('click', function (){
        $('.main-content #selectTargetModal').css('display', 'flex');
        $('div.sliding-menu').hide();
    });

    // 테마 선택 시
    $('div.sliding-menu .sliding-menu-wrap ul li.category-theme').on('click', function (){
        $('.main-content #selectThemeModal').css('display', 'flex');
        $('div.sliding-menu').hide();
    });

    // 유형 선택 시
    $('div.sliding-menu .sliding-menu-wrap ul li.category-type').on('click', function (){
        $('.main-content #selectTypeModal').css('display', 'flex');
        $('div.sliding-menu').hide();
    });

    if (matchMedia("screen and (max-width: 960px)").matches){

        // 슬라이딩 메뉴 보이기
        function showMenu(){
            $('.sliding-menu-wrap').animate({
                right: '0'
            }, 10, function (){
                // $('div.sliding-menu').css('display', 'flex');
                $('div.sliding-menu').fadeIn(10);
            });
        }

        // 슬라이딩 메뉴 숨기기
        function hideMenu(){
            $('.sliding-menu-wrap').animate({
                right: '-70%'
            }, 200, function (){
                // $('div.sliding-menu').css('display', 'none');
                $('div.sliding-menu').fadeOut(50);
            });
        }

        // 슬라이딩메뉴 버튼 선택 시
        $('.header-wrap-transparent i.sliding-menu, .header-wrap i.sliding-menu').on('click', function (){
            showMenu();
        });

        //배경 및 X버튼 선택 시 사라지기
        $('.sliding-menu-back, .sliding-menu-wrap i.close').click(function (){
            hideMenu();
        });

        //카테고리 메뉴 선택시 메뉴 접기/펼치기
        $('.sliding-menu-wrap ul li:nth-child(1)').on('click', function (){
            $(this).children('arrow').toggleClass('up');

            if($(this).children('arrow').hasClass('up') == true){
                $('.sliding-menu-wrap ul li:nth-child(1)').on('click', function (){
                    $('.sliding-menu-wrap ul li:nth-child(2)').hide();
                    $('.sliding-menu-wrap ul li:nth-child(3)').hide();
                    $('.sliding-menu-wrap ul li:nth-child(4)').hide();
                    $('.sliding-menu-wrap ul li:nth-child(5)').hide();
                    $('.sliding-menu-wrap ul li:nth-child(6)').hide();
                });
            }else{
                $('.sliding-menu-wrap ul li:nth-child(1)').on('click', function (){
                    $('.sliding-menu-wrap ul li:nth-child(2)').show();
                    $('.sliding-menu-wrap ul li:nth-child(3)').show();
                    $('.sliding-menu-wrap ul li:nth-child(4)').show();
                    $('.sliding-menu-wrap ul li:nth-child(5)').show();
                    $('.sliding-menu-wrap ul li:nth-child(6)').show();
                });
            }
        });
        if($(this).children('arrow').hasClass('up') == false){
            $('.sliding-menu-wrap ul li:nth-child(1)').on('click', function (){
                $('.sliding-menu-wrap ul li:nth-child(2)').hide();
                $('.sliding-menu-wrap ul li:nth-child(3)').hide();
                $('.sliding-menu-wrap ul li:nth-child(4)').hide();
                $('.sliding-menu-wrap ul li:nth-child(5)').hide();
                $('.sliding-menu-wrap ul li:nth-child(6)').hide();
            });
        }
    }


    //푸터(footer)
    //이용약관
    $('.footer-wrap .menu-area ul li:nth-child(1)').on('click', function (){
        $('#termsOfService').css('display', 'flex');
    });
    //개인정보취급방침
    $('.footer-wrap .menu-area ul li:nth-child(2)').on('click', function (){
        $('#privacyStatement').css('display', 'flex');
    });


    //메인(.main-content)
    //지역선택 modal 확인
    $('.main-content .category-box-area').click(function(){
        $('#selectAreaModal').css('display', 'flex');
    });


    //지역 리스트내 '전체' 선택 시 지역 색상변화(main-content)
    $('.main-content #selectAreaModal li.all').on('click', function (){

        $('#selectAreaModal .ganghwa-gun-sel').css('display', 'block');
        $('#selectAreaModal .jung-gu-sel').css('display', 'block');
        $('#selectAreaModal .ongjin-gun-sel').css('display', 'block');
        $('#selectAreaModal .western-sel').css('display', 'block');
        $('#selectAreaModal .gyeyang-gu-sel').css('display', 'block');
        $('#selectAreaModal .bupyeong-gu-sel').css('display', 'block');
        $('#selectAreaModal .dong-gu-sel').css('display', 'block');
        $('#selectAreaModal .michuholgu-sel').css('display', 'block');
        $('#selectAreaModal .namdong-gu-sel').css('display', 'block');
        $('#selectAreaModal .yeonsu-gu-sel').css('display', 'block');

        $('.main-content #selectAreaModal li.ganghwa-ongjin-gun i').addClass('favicon');
        // $('.main-content #selectAreaModal li.ongjin-gun i').addClass('favicon');
        $('.main-content #selectAreaModal li.gyeyang-gu i').addClass('favicon');
        $('.main-content #selectAreaModal li.namdong-gu i').addClass('favicon');
        $('.main-content #selectAreaModal li.dong-gu i').addClass('favicon');
        $('.main-content #selectAreaModal li.michuholgu i').addClass('favicon');
        $('.main-content #selectAreaModal li.bupyeong-gu i').addClass('favicon');
        $('.main-content #selectAreaModal li.western i').addClass('favicon');
        $('.main-content #selectAreaModal li.yeonsu-gu i').addClass('favicon');
        $('.main-content #selectAreaModal li.jung-gu i').addClass('favicon');

        changeModalButton();

        $('.main-content #selectAreaModal li.ganghwa-ongjin-gun').on('click', function (){
            $('.main-content #selectAreaModal li.all i').removeClass('favicon');
            $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.main-content #selectAreaModal li.gyeyang-gu').on('click', function (){
            $('.main-content #selectAreaModal li.all i').removeClass('favicon');
            $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.main-content #selectAreaModal li.namdong-gu').on('click', function (){
            $('.main-content #selectAreaModal li.all i').removeClass('favicon');
            $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.main-content #selectAreaModal li.dong-gu').on('click', function (){
            $('.main-content #selectAreaModal li.all i').removeClass('favicon');
            $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.main-content #selectAreaModal li.michuholgu').on('click', function (){
            $('.main-content #selectAreaModal li.all i').removeClass('favicon');
            $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.main-content #selectAreaModal li.bupyeong-gu').on('click', function (){
            $('.main-content #selectAreaModal li.all i').removeClass('favicon');
            $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.main-content #selectAreaModal li.western').on('click', function (){
            $('.main-content #selectAreaModal li.all i').removeClass('favicon');
            $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.main-content #selectAreaModal li.yeonsu-gu').on('click', function (){
            $('.main-content #selectAreaModal li.all i').removeClass('favicon');
            $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.main-content #selectAreaModal li.jung-gu').on('click', function (){
            $('.main-content #selectAreaModal li.all i').removeClass('favicon');
            $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
        });
    });


    //지역 리스트내 '전체' 선택 시 지역 색상변화(top-menu-content)
    $('.top-menu-content #selectAreaModal2 li.all').on('click', function (){

        $('#selectAreaModal2 .ganghwa-gun-sel').css('display', 'block');
        $('#selectAreaModal2 .jung-gu-sel').css('display', 'block');
        $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'block');
        $('#selectAreaModal2 .western-sel').css('display', 'block');
        $('#selectAreaModal2 .gyeyang-gu-sel').css('display', 'block');
        $('#selectAreaModal2 .bupyeong-gu-sel').css('display', 'block');
        $('#selectAreaModal2 .dong-gu-sel').css('display', 'block');
        $('#selectAreaModal2 .michuholgu-sel').css('display', 'block');
        $('#selectAreaModal2 .namdong-gu-sel').css('display', 'block');
        $('#selectAreaModal2 .yeonsu-gu-sel').css('display', 'block');

        $('.top-menu-content #selectAreaModal2 li.ganghwa-ongjin-gun i').addClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.gyeyang-gu i').addClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.namdong-gu i').addClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.dong-gu i').addClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.michuholgu i').addClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.bupyeong-gu i').addClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.western i').addClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.yeonsu-gu i').addClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.jung-gu i').addClass('favicon');

        changeModalButton2();

        $('.top-menu-content #selectAreaModal2 li.ganghwa-ongjin-gun').on('click', function (){
            $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
            $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.top-menu-content #selectAreaModal2 li.gyeyang-gu').on('click', function (){
            $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
            $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.top-menu-content #selectAreaModal2 li.namdong-gu').on('click', function (){
            $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
            $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.top-menu-content #selectAreaModal2 li.dong-gu').on('click', function (){
            $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
            $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.top-menu-content #selectAreaModal2 li.michuholgu').on('click', function (){
            $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
            $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.top-menu-content #selectAreaModal2 li.bupyeong-gu').on('click', function (){
            $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
            $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.top-menu-content #selectAreaModal2 li.western').on('click', function (){
            $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
            $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.top-menu-content #selectAreaModal2 li.yeonsu-gu').on('click', function (){
            $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
            $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
        });

        $('.top-menu-content #selectAreaModal2 li.jung-gu').on('click', function (){
            $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
            $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
        });
    });



    //지역 그림 선택 시 색상변화
    // 전체 선택
    $('.main-content #selectAreaModal .all').click(function(){
        $('.ganghwa-gun-sel').css('display', 'block');

        $('.main-content #selectAreaModal li:not(:first-child) input:checkbox').prop('checked', true);
        $('.main-content #selectAreaModal li:not(:first-child) i').addClass('favicon');
        changeModalButton();

        if($('.main-content #selectAreaModal li.all i').hasClass('favicon')){
            $('#selectAreaModal .ganghwa-gun-sel').css('display', 'none');
            $('#selectAreaModal .jung-gu-sel').css('display', 'none');
            $('#selectAreaModal .ongjin-gun-sel').css('display', 'none');
            $('#selectAreaModal .western-sel').css('display', 'none');
            $('#selectAreaModal .gyeyang-gu-sel').css('display', 'none');
            $('#selectAreaModal .bupyeong-gu-sel').css('display', 'none');
            $('#selectAreaModal .dong-gu-sel').css('display', 'none');
            $('#selectAreaModal .michuholgu-sel').css('display', 'none');
            $('#selectAreaModal .namdong-gu-sel').css('display', 'none');
            $('#selectAreaModal .yeonsu-gu-sel').css('display', 'none');

            $('.main-content #selectAreaModal li:not(:first-child) input:checkbox').removeAttr('checked');
            $('.main-content #selectAreaModal li:not(:first-child) i').removeClass('favicon');
        }
    });
    // 전체 선택(헤더)
    $('.top-menu-content #selectAreaModal2 .all').click(function(){
        $('.ganghwa-gun-sel').css('display', 'block');

        $('.top-menu-content #selectAreaModal2 li:not(:first-child) input:checkbox').prop('checked', true);
        $('.top-menu-content #selectAreaModal2 li:not(:first-child) i').addClass('favicon');
        changeModalButton2();

        if($('.top-menu-content #selectAreaModal2 li.all i').hasClass('favicon')){
            $('#selectAreaModal2 .ganghwa-gun-sel').css('display', 'none');
            $('#selectAreaModal2 .jung-gu-sel').css('display', 'none');
            $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'none');
            $('#selectAreaModal2 .western-sel').css('display', 'none');
            $('#selectAreaModal2 .gyeyang-gu-sel').css('display', 'none');
            $('#selectAreaModal2 .bupyeong-gu-sel').css('display', 'none');
            $('#selectAreaModal2 .dong-gu-sel').css('display', 'none');
            $('#selectAreaModal2 .michuholgu-sel').css('display', 'none');
            $('#selectAreaModal2 .namdong-gu-sel').css('display', 'none');
            $('#selectAreaModal2 .yeonsu-gu-sel').css('display', 'none');

            $('.top-menu-content #selectAreaModal2 li:not(:first-child) input:checkbox').removeAttr('checked');
            $('.top-menu-content #selectAreaModal2 li:not(:first-child) i').removeClass('favicon');
        }
    });


    // 강화·옹진군 리스트 선택
    $('.main-content #selectAreaModal li.ganghwa-ongjin-gun').click(function(){
        $('#selectAreaModal .ganghwa-gun-sel').css('display', 'block');
        $('#selectAreaModal .ongjin-gun-sel').css('display', 'block');

        if($('.main-content #selectAreaModal li.ganghwa-ongjin-gun i').hasClass('favicon')){
            $('#selectAreaModal .ganghwa-gun-sel').css('display', 'none');
            $('#selectAreaModal .ongjin-gun-sel').css('display', 'none');
        }
    });
    // 강화·옹진군 리스트 선택(헤더)
    $('.top-menu-content #selectAreaModal2 li.ganghwa-ongjin-gun').click(function(){
        $('#selectAreaModal2 .ganghwa-gun-sel').css('display', 'block');
        $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'block');

        if($('.top-menu-content #selectAreaModal2 li.ganghwa-ongjin-gun i').hasClass('favicon')){
            $('#selectAreaModal2 .ganghwa-gun-sel').css('display', 'none');
            $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'none');
        }
    });

    // 강화군 지도 선택 시
    $('.main-content #selectAreaModal img.ganghwa-gun').click(function(){
        ongjin();

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.ganghwa-ongjin-gun i').addClass('favicon');

        if($('.main-content #selectAreaModal li.ganghwa-ongjin-gun i').hasClass('favicon') == true) {
            $('.ganghwa-gun-sel').css('display', 'block');
            $('.ongjin-gun-sel').css('display', 'block');
            //강화·옹진군 선택 시 체크박스 체크
            $('.main-content #selectAreaModal li:nth-child(2) input:checkbox').prop('checked', true);
        }else{
            $('.ganghwa-gun-sel').css('display', 'none');
            $('.ongjin-gun-sel').css('display', 'none');
        }
    });
    // 강화군 지도 선택 시(헤더)
    $('.top-menu-content #selectAreaModal2 img.ganghwa-gun').click(function(){
        ongjin2();

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.ganghwa-ongjin-gun i').addClass('favicon');

        if($('.top-menu-content #selectAreaModal2 li.ganghwa-ongjin-gun i').hasClass('favicon') == true) {
            $('#selectAreaModal2 .ganghwa-gun-sel').css('display', 'block');
            $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'block');
            //강화·옹진군 선택 시 체크박스 체크
            $('.top-menu-content #selectAreaModal2 li:nth-child(2) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal2 .ganghwa-gun-sel').css('display', 'none');
            $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'none');
        }
    });

    $(function (){
        ongjin();
        ongjin2();
    });

    // 옹진군 지도 선택시
    function ongjin(){
        $('.main-content #selectAreaModal img.ongjin-gun').click(function (){
            $('.main-content #selectAreaModal li.all i').removeClass('favicon');
            $('.main-content #selectAreaModal li.ganghwa-ongjin-gun i').addClass('favicon');

            if($('.main-content #selectAreaModal li.ganghwa-ongjin-gun i').hasClass('favicon') == true) {
                $('#selectAreaModal .ganghwa-gun-sel').css('display', 'block');
                $('#selectAreaModal .ongjin-gun-sel').css('display', 'block');
                //강화·옹진군 선택 시 체크박스 체크
                $('.main-content #selectAreaModal li:nth-child(2) input:checkbox').prop('checked', true);
                changeModalButton();
            }else{
                $('#selectAreaModal .ganghwa-gun-sel').css('display', 'none');
                $('#selectAreaModal .ongjin-gun-sel').css('display', 'none');
            }
        });
    }
    // 옹진군 지도 선택시(헤더)
    function ongjin2(){
        $('.top-menu-content #selectAreaModal2 img.ongjin-gun').click(function (){
            $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
            $('.top-menu-content #selectAreaModal2 li.ganghwa-ongjin-gun i').addClass('favicon');

            if($('.top-menu-content #selectAreaModal2 li.ganghwa-ongjin-gun i').hasClass('favicon') == true) {
                $('#selectAreaModal2 .ganghwa-gun-sel').css('display', 'block');
                $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'block');
                //강화·옹진군 선택 시 체크박스 체크
                $('.top-menu-content #selectAreaModal2 li:nth-child(2) input:checkbox').prop('checked', true);
                changeModalButton2();
            }else{
                $('#selectAreaModal2 .ganghwa-gun-sel').css('display', 'none');
                $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'none');
            }
        });
    }

    //강화군 (녹색)지도 선택 시
    $('.main-content #selectAreaModal .ganghwa-gun-sel').click(function(){
        $(this).css('display', 'none');
        $('#selectAreaModal .ongjin-gun-sel').css('display', 'none');

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.ganghwa-ongjin-gun i').removeClass('favicon');

        //강화·옹진군 재선택 시 체크박스 체크해제
        $('.main-content #selectAreaModal li:nth-child(2) input:checkbox').removeAttr('checked');
        $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
    });
    //강화군 (녹색)지도 선택 시(탑메뉴)
    $('.top-menu-content #selectAreaModal2 .ganghwa-gun-sel').click(function(){
        $(this).css('display', 'none');
        $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'none');

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.ganghwa-ongjin-gun i').removeClass('favicon');

        //강화·옹진군 재선택 시 체크박스 체크해제
        $('.top-menu-content #selectAreaModal2 li:nth-child(2) input:checkbox').removeAttr('checked');
        $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
    });

    //옹진군 (녹색)지도 선택 시
    $('.main-content #selectAreaModal .ongjin-gun-sel').click(function(){
        $('#selectAreaModal .ganghwa-gun-sel').css('display', 'none');
        $(this).css('display', 'none');

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.ganghwa-ongjin-gun i').removeClass('favicon');

        //옹진군 재선택 시 체크박스 체크해제
        $('.main-content #selectAreaModal li:nth-child(2) input:checkbox').removeAttr('checked');
        $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
    });
    //옹진군 (녹색)지도 선택 시(탑메뉴)
    $('.top-menu-content #selectAreaModal2 .ongjin-gun-sel').click(function(){
        $('#selectAreaModal2 .ganghwa-gun-sel').css('display', 'none');
        $(this).css('display', 'none');

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.ganghwa-ongjin-gun i').removeClass('favicon');

        //옹진군 재선택 시 체크박스 체크해제
        $('.top-menu-content #selectAreaModal2 li:nth-child(2) input:checkbox').removeAttr('checked');
        $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
    });


    // 중구 선택
    $('.main-content #selectAreaModal li.jung-gu').click(function(){
        $('#selectAreaModal .jung-gu-sel').css('display', 'block');

        if($('.main-content #selectAreaModal li.jung-gu i').hasClass('favicon')){
            $('#selectAreaModal .jung-gu-sel').css('display', 'none');
        }
    });

    $('.main-content #selectAreaModal .jung-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.jung-gu i').removeClass('favicon');

        //중구 재선택 시 체크박스 체크해제
        $('.main-content #selectAreaModal li:nth-child(10) input:checkbox').removeAttr('checked');
        $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
    });

    $('.main-content #selectAreaModal img.jung-gu').click(function(){
        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.jung-gu i').toggleClass('favicon');

        if($('.main-content #selectAreaModal li.jung-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal .jung-gu-sel').css('display', 'block');
            //중구 선택 시 체크박스 체크
            $('.main-content #selectAreaModal li:nth-child(10) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal .jung-gu-sel').css('display', 'none');
        }
    });


    // 중구 선택(탑메뉴)
    $('.top-menu-content #selectAreaModal2 li.jung-gu').click(function(){
        $('#selectAreaModal2 .jung-gu-sel').css('display', 'block');

        if($('.top-menu-content #selectAreaModal2 li.jung-gu i').hasClass('favicon')){
            $('#selectAreaModal2 .jung-gu-sel').css('display', 'none');
        }
    });

    $('.top-menu-content #selectAreaModal2 .jung-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.jung-gu i').removeClass('favicon');

        //중구 재선택 시 체크박스 체크해제
        $('.top-menu-content #selectAreaModal2 li:nth-child(10) input:checkbox').removeAttr('checked');
        $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
    });

    $('.top-menu-content #selectAreaModal2 img.jung-gu').click(function(){
        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.jung-gu i').toggleClass('favicon');

        if($('.top-menu-content #selectAreaModal2 li.jung-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal2 .jung-gu-sel').css('display', 'block');
            //중구 선택 시 체크박스 체크
            $('.top-menu-content #selectAreaModal2 li:nth-child(10) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal2 .jung-gu-sel').css('display', 'none');
        }
    });


    // 강화 및 웅진군 선택
    $('.main-content #selectAreaModal img.ongjin-gun').click(function(){
        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.ongjin-gun i').addClass('favicon');
        $('.main-content #selectAreaModal img.ganghwa-gunsel').css('display', 'block');

        if($('.main-content #selectAreaModal li.ongjin-gun i').hasClass('favicon') == true) {
            $('#selectAreaModal .ongjin-gun-sel').css('display', 'block');
            //옹진군 선택 시 체크박스 체크
            $('.main-content #selectAreaModal li:nth-child(2) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal .ongjin-gun-sel').css('display', 'none');
        }
    });

    // 강화 및 웅진군 선택(탑메뉴)
    $('.top-menu-content #selectAreaModal2 img.ongjin-gun').click(function(){
        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.ongjin-gun i').addClass('favicon');
        $('.top-menu-content #selectAreaModal2 img.ganghwa-gunsel').css('display', 'block');

        if($('.top-menu-content #selectAreaModal2 li.ongjin-gun i').hasClass('favicon') == true) {
            $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'block');
            //옹진군 선택 시 체크박스 체크
            $('.top-menu-content #selectAreaModal2 li:nth-child(2) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal2 .ongjin-gun-sel').css('display', 'none');
        }
    });


    // 서구 선택
    $('.main-content #selectAreaModal li.western').click(function(){
        $('.western-sel').css('display', 'block');

        if($('.main-content #selectAreaModal li.western i').hasClass('favicon')){
            $('.western-sel').css('display', 'none');
        }
    });

    $('.main-content #selectAreaModal .western-sel').click(function(){
        $(this).css('display', 'none');

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.western i').removeClass('favicon');

        //서구 재선택 시 체크박스 체크해제
        $('.main-content #selectAreaModal li:nth-child(8) input:checkbox').removeAttr('checked');
        $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
    });

    $('.main-content #selectAreaModal img.western').click(function(){
        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.western i').toggleClass('favicon');

        if($('.main-content #selectAreaModal li.western i').hasClass('favicon') == true) {
            $('#selectAreaModal .western-sel').css('display', 'block');
            //서구 선택 시 체크박스 체크
            $('.main-content #selectAreaModal li:nth-child(8) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal .western-sel').css('display', 'none');
        }
    });


    // 서구 선택(탑메뉴)
    $('.top-menu-content #selectAreaModal2 li.western').click(function(){
        $('#selectAreaModal2 .western-sel').css('display', 'block');

        if($('.top-menu-content #selectAreaModal2 li.western i').hasClass('favicon')){
            $('#selectAreaModal2 .western-sel').css('display', 'none');
        }
    });

    $('.top-menu-content #selectAreaModal2 .western-sel').click(function(){
        $(this).css('display', 'none');

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.western i').removeClass('favicon');

        //서구 재선택 시 체크박스 체크해제
        $('.top-menu-content #selectAreaModal2 li:nth-child(8) input:checkbox').removeAttr('checked');
        $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
    });

    $('.top-menu-content #selectAreaModal2 img.western').click(function(){
        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.western i').toggleClass('favicon');

        if($('.top-menu-content #selectAreaModal2 li.western i').hasClass('favicon') == true) {
            $('#selectAreaModal2 .western-sel').css('display', 'block');
            //서구 선택 시 체크박스 체크
            $('.top-menu-content #selectAreaModal2 li:nth-child(8) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal2 .western-sel').css('display', 'none');
        }
    });


    // 계양구 선택
    $('.main-content #selectAreaModal li.gyeyang-gu').click(function(){
        $('#selectAreaModal .gyeyang-gu-sel').css('display', 'block');

        if($('.main-content #selectAreaModal li.gyeyang-gu i').hasClass('favicon')){
            $('#selectAreaModal .gyeyang-gu-sel').css('display', 'none');
        }
    });

    $('.main-content #selectAreaModal .gyeyang-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.gyeyang-gu i').removeClass('favicon');

        //계양구 재선택 시 체크박스 체크해제
        $('.main-content #selectAreaModal li:nth-child(3) input:checkbox').removeAttr('checked');
        $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
    });

    $('.main-content #selectAreaModal img.gyeyang-gu').click(function(){
        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.gyeyang-gu i').toggleClass('favicon');

        if($('.main-content #selectAreaModal li.gyeyang-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal .gyeyang-gu-sel').css('display', 'block');
            //계양구 선택 시 체크박스 체크
            $('.main-content #selectAreaModal li:nth-child(3) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal .gyeyang-gu-sel').css('display', 'none');
        }
    });


    // 계양구 선택(탑메뉴)
    $('.top-menu-content #selectAreaModal2 li.gyeyang-gu').click(function(){
        $('#selectAreaModal2 .gyeyang-gu-sel').css('display', 'block');

        if($('.top-menu-content #selectAreaModal2 li.gyeyang-gu i').hasClass('favicon')){
            $('#selectAreaModal2 .gyeyang-gu-sel').css('display', 'none');
        }
    });

    $('.top-menu-content #selectAreaModal2 .gyeyang-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.gyeyang-gu i').removeClass('favicon');

        //계양구 재선택 시 체크박스 체크해제
        $('.top-menu-content #selectAreaModal2 li:nth-child(3) input:checkbox').removeAttr('checked');
        $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
    });

    $('.top-menu-content #selectAreaModal2 img.gyeyang-gu').click(function(){
        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.gyeyang-gu i').toggleClass('favicon');

        if($('.top-menu-content #selectAreaModal2 li.gyeyang-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal2 .gyeyang-gu-sel').css('display', 'block');
            //계양구 선택 시 체크박스 체크
            $('.top-menu-content #selectAreaModal2 li:nth-child(3) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal2 .gyeyang-gu-sel').css('display', 'none');
        }
    });


    // 부평구 선택
    $('.main-content #selectAreaModal li.bupyeong-gu').click(function(){
        $('.bupyeong-gu-sel').css('display', 'block');

        if($('.main-content #selectAreaModal li.bupyeong-gu i').hasClass('favicon')){
            $('.bupyeong-gu-sel').css('display', 'none');
        }
    });

    $('.main-content #selectAreaModal .bupyeong-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.bupyeong-gu i').removeClass('favicon');

        //부평구 재선택 시 체크박스 체크해제
        $('.main-content #selectAreaModal li:nth-child(7) input:checkbox').removeAttr('checked');
        $('.main-content #selectAreaModal li:nth-child(1) input:checkbox').removeAttr('checked');
    });

    $('.main-content #selectAreaModal img.bupyeong-gu').click(function(){
        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.bupyeong-gu i').toggleClass('favicon');

        if($('.main-content #selectAreaModal li.bupyeong-gu i').hasClass('favicon') == true) {
            $('.bupyeong-gu-sel').css('display', 'block');
            //부평구 선택 시 체크박스 체크
            $('.main-content #selectAreaModal li:nth-child(7) input:checkbox').prop('checked', true);
        }else{
            $('.bupyeong-gu-sel').css('display', 'none');
        }
    });


    // 부평구 선택(탑메뉴)
    $('.top-menu-content #selectAreaModal2 li.bupyeong-gu').click(function(){
        $('#selectAreaModal2 .bupyeong-gu-sel').css('display', 'block');

        if($('.top-menu-content #selectAreaModal2 li.bupyeong-gu i').hasClass('favicon')){
            $('#selectAreaModal2 .bupyeong-gu-sel').css('display', 'none');
        }
    });

    $('.top-menu-content #selectAreaModal2 .bupyeong-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.bupyeong-gu i').removeClass('favicon');

        //부평구 재선택 시 체크박스 체크해제
        $('.top-menu-content #selectAreaModal2 li:nth-child(7) input:checkbox').removeAttr('checked');
        $('.top-menu-content #selectAreaModal2 li:nth-child(1) input:checkbox').removeAttr('checked');
    });

    $('.top-menu-content #selectAreaModal2 img.bupyeong-gu').click(function(){
        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.bupyeong-gu i').toggleClass('favicon');

        if($('.top-menu-content #selectAreaModal2 li.bupyeong-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal2 .bupyeong-gu-sel').css('display', 'block');
            //부평구 선택 시 체크박스 체크
            $('.top-menu-content #selectAreaModal2 li:nth-child(7) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal2 .bupyeong-gu-sel').css('display', 'none');
        }
    });


    // 동구 선택
    $('.main-content #selectAreaModal li.dong-gu').click(function(){
        $('#selectAreaModal .dong-gu-sel').css('display', 'block');

        if($('.main-content #selectAreaModal li.dong-gu i').hasClass('favicon')){
            $('#selectAreaModal .dong-gu-sel').css('display', 'none');
        }
    });

    $('.main-content #selectAreaModal .dong-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.dong-gu i').removeClass('favicon');

        //동구 재선택 시 체크박스 체크해제
        $('.main-content #selectAreaModal li:nth-child(5) input:checkbox').removeAttr('checked');
    });

    $('.main-content #selectAreaModal img.dong-gu').click(function(){
        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.dong-gu i').toggleClass('favicon');

        if($('.main-content #selectAreaModal li.dong-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal .dong-gu-sel').css('display', 'block');
            //동구 선택 시 체크박스 체크
            $('.main-content #selectAreaModal li:nth-child(5) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal .dong-gu-sel').css('display', 'none');
        }
    });


    // 동구 선택(탑메뉴)
    $('.top-menu-content #selectAreaModal2 li.dong-gu').click(function(){
        $('#selectAreaModal2 .dong-gu-sel').css('display', 'block');

        if($('.top-menu-content #selectAreaModal2 li.dong-gu i').hasClass('favicon')){
            $('#selectAreaModal2 .dong-gu-sel').css('display', 'none');
        }
    });

    $('.top-menu-content #selectAreaModal2 .dong-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.dong-gu i').removeClass('favicon');

        //동구 재선택 시 체크박스 체크해제
        $('.top-menu-content #selectAreaModal2 li:nth-child(5) input:checkbox').removeAttr('checked');
    });

    $('.top-menu-content #selectAreaModal2 img.dong-gu').click(function(){
        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.dong-gu i').toggleClass('favicon');

        if($('.top-menu-content #selectAreaModal2 li.dong-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal2 .dong-gu-sel').css('display', 'block');
            //동구 선택 시 체크박스 체크
            $('.top-menu-content #selectAreaModal2 li:nth-child(5) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal2 .dong-gu-sel').css('display', 'none');
        }
    });


    // 미추홀구 선택
    $('.main-content #selectAreaModal li.michuholgu').click(function(){
        $('#selectAreaModal .michuholgu-sel').css('display', 'block');

        if($('.main-content #selectAreaModal li.michuholgu i').hasClass('favicon')){
            $('#selectAreaModal .michuholgu-sel').css('display', 'none');
        }
    });

    $('.main-content #selectAreaModal .michuholgu-sel').click(function(){
        $(this).css('display', 'none');

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.michuholgu i').removeClass('favicon');

        //미추홀구 재선택 시 체크박스 체크해제
        $('.main-content #selectAreaModal li:nth-child(6) input:checkbox').removeAttr('checked');
    });

    $('.main-content #selectAreaModal img.michuholgu').click(function(){
        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.michuholgu i').toggleClass('favicon');

        if($('.main-content #selectAreaModal li.michuholgu i').hasClass('favicon') == true) {
            $('#selectAreaModal .michuholgu-sel').css('display', 'block');
            //미추홀구 선택 시 체크박스 체크
            $('.main-content #selectAreaModal li:nth-child(6) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal .michuholgu-sel').css('display', 'none');
        }
    });


    // 미추홀구 선택(탑메뉴)
    $('.top-menu-content #selectAreaModal2 li.michuholgu').click(function(){
        $('#selectAreaModal2 .michuholgu-sel').css('display', 'block');

        if($('.top-menu-content #selectAreaModal2 li.michuholgu i').hasClass('favicon')){
            $('#selectAreaModal2 .michuholgu-sel').css('display', 'none');
        }
    });

    $('.top-menu-content #selectAreaModal2 .michuholgu-sel').click(function(){
        $(this).css('display', 'none');

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.michuholgu i').removeClass('favicon');

        //미추홀구 재선택 시 체크박스 체크해제
        $('.top-menu-content #selectAreaModal2 li:nth-child(6) input:checkbox').removeAttr('checked');
    });

    $('.top-menu-content #selectAreaModal2 img.michuholgu').click(function(){
        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.michuholgu i').toggleClass('favicon');

        if($('.top-menu-content #selectAreaModal2 li.michuholgu i').hasClass('favicon') == true) {
            $('#selectAreaModal2 .michuholgu-sel').css('display', 'block');
            //미추홀구 선택 시 체크박스 체크
            $('.top-menu-content #selectAreaModal2 li:nth-child(6) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal2 .michuholgu-sel').css('display', 'none');
        }
    });


    // 남동구 선택
    $('.main-content #selectAreaModal li.namdong-gu').click(function(){
        $('#selectAreaModal .namdong-gu-sel').css('display', 'block');

        if($('.main-content #selectAreaModal li.namdong-gu i').hasClass('favicon')){
            $('#selectAreaModal .namdong-gu-sel').css('display', 'none');
        }
    });

    $('.main-content #selectAreaModal .namdong-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.namdong-gu i').removeClass('favicon');

        //남동구 재선택 시 체크박스 체크해제
        $('.main-content #selectAreaModal li:nth-child(4) input:checkbox').removeAttr('checked');
    });

    $('.main-content #selectAreaModal img.namdong-gu').click(function(){
        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.namdong-gu i').toggleClass('favicon');

        if($('.main-content #selectAreaModal li.namdong-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal .namdong-gu-sel').css('display', 'block');
            //남동구 선택 시 체크박스 체크
            $('.main-content #selectAreaModal li:nth-child(4) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal .namdong-gu-sel').css('display', 'none');
        }
    });


    // 남동구 선택(탑메뉴)
    $('.top-menu-content #selectAreaModal2 li.namdong-gu').click(function(){
        $('#selectAreaModal2 .namdong-gu-sel').css('display', 'block');

        if($('.top-menu-content #selectAreaModal2 li.namdong-gu i').hasClass('favicon')){
            $('#selectAreaModal2 .namdong-gu-sel').css('display', 'none');
        }
    });

    $('.top-menu-content #selectAreaModal2 .namdong-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.namdong-gu i').removeClass('favicon');

        //남동구 재선택 시 체크박스 체크해제
        $('.top-menu-content #selectAreaModal2 li:nth-child(4) input:checkbox').removeAttr('checked');
    });

    $('.top-menu-content #selectAreaModal2 img.namdong-gu').click(function(){
        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.namdong-gu i').toggleClass('favicon');

        if($('.top-menu-content #selectAreaModal2 li.namdong-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal2 .namdong-gu-sel').css('display', 'block');
            //남동구 선택 시 체크박스 체크
            $('.top-menu-content #selectAreaModal2 li:nth-child(4) input:checkbox').prop('checked', true);
        }else{
            $('#selectAreaModal2 .namdong-gu-sel').css('display', 'none');
        }
    });


    // 연수구 선택
    $('.main-content #selectAreaModal li.yeonsu-gu').click(function(){
        $('#selectAreaModal .yeonsu-gu-sel').css('display', 'block');

        if($('.main-content #selectAreaModal li.yeonsu-gu i').hasClass('favicon')){
            $('#selectAreaModal .yeonsu-gu-sel').css('display', 'none');
        }
    });

    $('.main-content #selectAreaModal .yeonsu-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.yeonsu-gu i').removeClass('favicon');

        //연수구 재선택 시 체크박스 체크해제
        $('.main-content #selectAreaModal li:nth-child(9) input:checkbox').removeAttr('checked');
    });

    $('.main-content #selectAreaModal img.yeonsu-gu').click(function(){
        $('.main-content #selectAreaModal li.all i').removeClass('favicon');
        $('.main-content #selectAreaModal li.yeonsu-gu i').toggleClass('favicon');

        //연수구 선택 시 체크박스 체크
        $('.main-content #selectAreaModal li:nth-child(9) input:checkbox').prop('checked', true);

        if($('.main-content #selectAreaModal li.yeonsu-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal .yeonsu-gu-sel').css('display', 'block');
        }else{
            $('#selectAreaModal .yeonsu-gu-sel').css('display', 'none');
        }
    });


    // 연수구 선택(탑메뉴)
    $('.top-menu-content #selectAreaModal2 li.yeonsu-gu').click(function(){
        $('#selectAreaModal2 .yeonsu-gu-sel').css('display', 'block');

        if($('.top-menu-content #selectAreaModal2 li.yeonsu-gu i').hasClass('favicon')){
            $('#selectAreaModal2 .yeonsu-gu-sel').css('display', 'none');
        }
    });

    $('.top-menu-content #selectAreaModal2 .yeonsu-gu-sel').click(function(){
        $(this).css('display', 'none');

        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.yeonsu-gu i').removeClass('favicon');

        //연수구 재선택 시 체크박스 체크해제
        $('.top-menu-content #selectAreaModal2 li:nth-child(9) input:checkbox').removeAttr('checked');
    });

    $('.top-menu-content #selectAreaModal2 img.yeonsu-gu').click(function(){
        $('.top-menu-content #selectAreaModal2 li.all i').removeClass('favicon');
        $('.top-menu-content #selectAreaModal2 li.yeonsu-gu i').toggleClass('favicon');

        //연수구 선택 시 체크박스 체크
        $('.top-menu-content #selectAreaModal2 li:nth-child(9) input:checkbox').prop('checked', true);

        if($('.top-menu-content #selectAreaModal2 li.yeonsu-gu i').hasClass('favicon') == true) {
            $('#selectAreaModal2 .yeonsu-gu-sel').css('display', 'block');
        }else{
            $('#selectAreaModal2 .yeonsu-gu-sel').css('display', 'none');
        }
    });


    // 메인페이지 내 지역리스트 선택
    $('.main-content #selectAreaModal ul li i.favicon').hide();
    // 탑메뉴 지역리스트 선택
    $('.top-menu-content #selectAreaModal ul li i.favicon').hide();

    //리스트 선택 시 버튼색상 변화
    $('.main-content #selectAreaModal ul li').on('click', function(){
        $(this).children('i').toggleClass('favicon');
        $(this).children('input:checkbox').prop('checked', true);

        // 리스트 선택 여부에 따른 하단 버튼변화
        if($(this).children('i').hasClass('favicon') == true){
            $(this).children('input:checkbox').prop('checked', 'true');
        }else{
            $(this).children('input:checkbox').removeAttr('checked');
        }
        changeModalButton();
    });

    //리스트 선택 시 버튼색상 변화(탑메뉴)
    $('.top-menu-content #selectAreaModal2 ul li').on('click', function(){
        $(this).children('i').toggleClass('favicon');
        $(this).children('input:checkbox').prop('checked', true);

        // 리스트 선택 여부에 따른 하단 버튼변화
        if($(this).children('i').hasClass('favicon') == true){
            $(this).children('input:checkbox').prop('checked', 'true');
        }else{
            $(this).children('input:checkbox').removeAttr('checked');
        }
        changeModalButton2();
    });

    //지도 선택 시 버튼색상 변화
    $('.main-content #selectAreaModal .incheon-city-area img').on('click', function (){
        changeModalButton();
    });

    //지도 선택 시 버튼색상 변화(탑메뉴)
    $('.top-menu-content #selectAreaModal2 .incheon-city-area img').on('click', function (){
        changeModalButton2();
    });

    // 버튼 색상변화
    function changeModalButton(){
        let areaChecked = $(".main-content #selectAreaModal input.areaChk:checked").length;
        let areaLength = $(".main-content #selectAreaModal input.areaChk").length;
        let searchAreaName="";
        $("#selectAreaModal .areaChk:checked").each(function(){
            searchAreaName =  $(this).val();
        });

        if(areaChecked >= 1) {
            $('.main-content #selectAreaModal .modal-footer button.none').hide();
            $('.main-content #selectAreaModal .modal-footer button.search-btn').show();

            if(areaChecked == 1) {
                $(".main-content #selectAreaModal #searchAreaName").html(searchAreaName);
                $(".main-content #selectAreaModal .etc").hide();
                $(".main-content #selectAreaModal .etcNum").hide();
            }else if(areaChecked==areaLength) {
                $(".main-content #selectAreaModal #searchAreaName").html("전체");
                $(".main-content #selectAreaModal .etc").hide();
                $(".main-content #selectAreaModal .etcNum").hide();
            }else {
                $(".main-content #selectAreaModal #searchAreaName").html(searchAreaName);
                $(".main-content #selectAreaModal .etc").show();
                $(".main-content #selectAreaModal .etcNum").html(areaChecked - 1);
                $(".main-content #selectAreaModal .etcNum").show();
            }
        }else if(areaChecked < 1){
            $('.main-content #selectAreaModal .modal-footer button.none').show();
            $('.main-content #selectAreaModal .modal-footer button.search-btn').hide();
        }
    }

    // 버튼 색상변화(top-menu-content)
    function changeModalButton2(){
        let areaChecked = $(".top-menu-content #selectAreaModal2 input.areaChk:checked").length;
        let areaLength = $(".top-menu-content #selectAreaModal2 input.areaChk").length;
        let searchAreaName="";
        $("#selectAreaModal2 .areaChk:checked").each(function(){
            searchAreaName =  $(this).val();
        });

        if(areaChecked >= 1) {
            $('.top-menu-content #selectAreaModal2 .modal-footer button.none').hide();
            $('.top-menu-content #selectAreaModal2 .modal-footer button.search-btn').show();

            if(areaChecked == 1) {
                $(".top-menu-content #selectAreaModal2 #searchAreaName2").html(searchAreaName);
                $(".top-menu-content #selectAreaModal2 .etc").hide();
                $(".top-menu-content #selectAreaModal2 .etcNum").hide();
            }else if(areaChecked==areaLength) {
                $(".top-menu-content #selectAreaModal2 #searchAreaName2").html("전체");
                $(".top-menu-content #selectAreaModal2 .etc").hide();
                $(".top-menu-content #selectAreaModal2 .etcNum").hide();
            }else {
                $(".top-menu-content #selectAreaModal2 #searchAreaName2").html(searchAreaName);
                $(".top-menu-content #selectAreaModal2 .etc").show();
                $(".top-menu-content #selectAreaModal2 .etcNum").html(areaChecked - 1);
                $(".top-menu-content #selectAreaModal2 .etcNum").show();
            }
        }else if(areaChecked < 1){
            $('.top-menu-content #selectAreaModal2 .modal-footer button.none').show();
            $('.top-menu-content #selectAreaModal2 .modal-footer button.search-btn').hide();
        }
    }


    // mobile modal START---------------------------------
    // '지도에서 선택' 버튼 클릭 시
    if (matchMedia("screen and (max-width: 960px)").matches) {
        // $('.main-content #selectAreaModal div.part-right .incheon-city-area').css({
        //     'position':'static'
        // });

        //푸터
        $('#selectAreaModal .modal-content .part-right').hide();

        $('#selectAreaModal .m-title-wrap .sel-map').on('click', function (){
            $('#selectAreaModal .modal-content .part-right').show();
            $('#selectAreaModal .modal-content .part-left').hide();
            $('#selectAreaModal .m-title-wrap .sel-list').show();
            $('#selectAreaModal .m-title-wrap .sel-map').hide();
        });

        // '목록에서 선택' 버튼 클릭 시
        $('#selectAreaModal .m-title-wrap .sel-list').on('click', function (){
            $('#selectAreaModal .modal-content .part-left').show();
            $('#selectAreaModal .modal-content .part-right').hide();
            $('#selectAreaModal .m-title-wrap .sel-map').show();
            $('#selectAreaModal .m-title-wrap .sel-list').hide();
        });

        //탑메뉴
        $('#selectAreaModal2 .modal-content .part-right').hide();

        $('#selectAreaModal2 .m-title-wrap .sel-map').on('click', function (){
            $('#selectAreaModal2 .modal-content .part-right').show();
            $('#selectAreaModal2 .modal-content .part-left').hide();
            $('#selectAreaModal2 .m-title-wrap .sel-list').show();
            $('#selectAreaModal2 .m-title-wrap .sel-map').hide();
        });

        // '목록에서 선택' 버튼 클릭 시
        $('#selectAreaModal2 .m-title-wrap .sel-list').on('click', function (){
            $('#selectAreaModal2 .modal-content .part-left').show();
            $('#selectAreaModal2 .modal-content .part-right').hide();
            $('#selectAreaModal2 .m-title-wrap .sel-map').show();
            $('#selectAreaModal2 .m-title-wrap .sel-list').hide();
        });
    }
    // mobile modal END---------------------------------



    //대상선택 modal 확인
    $('.main-content .category-box-target').click(function(){
        $('#selectTargetModal').css('display', 'flex');
        $('#targetUl').find('input').prop('checked', false);
        $('#targetUl').find('i').removeClass('favicon');
        $('.main-content #selectTargetModal .modal-footer button.none').show();
        $('.main-content #selectTargetModal .modal-footer button.search-btn').hide();
    });

    //대상선택 modal 확인(탑메뉴)
    $('.top-menu-content .category-box-target').click(function(){
        $('#selectTargetModal2').css('display', 'flex');
        $('#targetUl2').find('input').prop('checked', false);
        $('#targetUl2').find('i').removeClass('favicon');
        $('.top-menu-content #selectTargetModal2 .modal-footer button.none').show();
        $('.top-menu-content #selectTargetModal2 .modal-footer button.search-btn').hide();
    });

    // 메인페이지 내 대상 선택
    $('.main-content #selectTargetModal ul li i.favicon').hide();
    $('.main-content #selectTargetModal ul li:not(:nth-child(1))').on('click', function(){
        $(this).children('i').toggleClass('favicon');

        if(!$(this).children('input').prop("checked")) {
            $(this).children('input').prop("checked", true);
        }else {
            $(this).children('input').prop("checked", false);
        }

        // 리스트 선택 여부에 따른 하단 버튼변화
        // if($(this).children('i').hasClass('favicon') == true){
        //     $(this).children('input:checkbox').prop('checked', 'true');
        // }else{
        //     $(this).children('input:checkbox').removeAttr('checked');
        // }
        //
        let targetChecked = $(".main-content #selectTargetModal input:checked").length;

        let searchTargetName;
        $(".main-content #selectTargetModal input:checked").each(function(){
            searchTargetName = $(this).val();
        })

        if(targetChecked >= 1) {
            $('.main-content #selectTargetModal .modal-footer button.none').hide();
            $('.main-content #selectTargetModal .modal-footer button.search-btn').show();

            if(targetChecked==1) {
                $(".main-content #selectTargetModal #searchTargetName").html(searchTargetName);
                $(".main-content #selectTargetModal .etc").hide();
                $(".main-content #selectTargetModal .etcNum").hide();
            }else {
                $(".main-content #selectTargetModal #searchTargetName").html(searchTargetName);
                $(".main-content #selectTargetModal .etc").show();
                $(".main-content #selectTargetModal .etcNum").html(targetChecked-1);
                $(".main-content #selectTargetModal .etcNum").show();

            }
        }else if(targetChecked < 1){
            $('.main-content #selectTargetModal .modal-footer button.none').show();
            $('.main-content #selectTargetModal .modal-footer button.search-btn').hide();
        }

        //전체 선택 외 다른 대상 선택 시 '전체'항목 체크해제
        if($('.main-content #selectTargetModal ul li:not(:nth-child(1)) input:checkbox').is(':checked') == true){
            $('.main-content #selectTargetModal ul li:nth-child(1) input:checkbox').removeAttr('checked');
            $('.main-content #selectTargetModal ul li:nth-child(1) i').removeClass('favicon');
        }
    });

    // 메인페이지 내 대상 선택(탑메뉴)
    $('.top-menu-content #selectTargetModal2 ul li i.favicon').hide();
    $('.top-menu-content #selectTargetModal2 ul li:not(:nth-child(1))').on('click', function(){
        $(this).children('i').toggleClass('favicon');

        if(!$(this).children('input').prop("checked")) {
            $(this).children('input').prop("checked", true);
        }else {
            $(this).children('input').prop("checked", false);
        }

        // 리스트 선택 여부에 따른 하단 버튼변화
        // if($(this).children('i').hasClass('favicon') == true){
        //     $(this).children('input:checkbox').prop('checked', 'true');
        // }else{
        //     $(this).children('input:checkbox').removeAttr('checked');
        // }
        //
        let targetChecked = $(".top-menu-content #selectTargetModal2 input:checked").length;

        let searchTargetName;
        $(".top-menu-content #selectTargetModal2 input:checked").each(function(){
            searchTargetName = $(this).val();
        })

        if(targetChecked >= 1) {
            $('.top-menu-content #selectTargetModal2 .modal-footer button.none').hide();
            $('.top-menu-content #selectTargetModal2 .modal-footer button.search-btn').show();

            if(targetChecked==1) {
                $(".top-menu-content #selectTargetModal2 #searchTargetName2").html(searchTargetName);
                $(".top-menu-content #selectTargetModal2 .etc").hide();
                $(".top-menu-content #selectTargetModal2 .etcNum").hide();
            }else {
                $(".top-menu-content #selectTargetModal2 #searchTargetName2").html(searchTargetName);
                $(".top-menu-content #selectTargetModal2 .etc").show();
                $(".top-menu-content #selectTargetModal2 .etcNum").html(targetChecked-1);
                $(".top-menu-content #selectTargetModal2 .etcNum").show();

            }
        }else if(targetChecked < 1){
            $('.top-menu-content #selectTargetModal2 .modal-footer button.none').show();
            $('.top-menu-content #selectTargetModal2 .modal-footer button.search-btn').hide();
        }

        //전체 선택 외 다른 대상 선택 시 '전체'항목 체크해제
        if($('.top-menu-content #selectTargetModal2 ul li:not(:nth-child(1)) input:checkbox').is(':checked') == true){
            $('.top-menu-content #selectTargetModal2 ul li:nth-child(1) input:checkbox').removeAttr('checked');
            $('.top-menu-content #selectTargetModal2 ul li:nth-child(1) i').removeClass('favicon');
        }
    });


    //대상이 11개 이상/초과일 경우 ui 반응대비
    $(document).ready(function(){
        let targetLiLength = $('.main-content #selectTargetModal ul li').length;
        let targetLiLength2 = $('.top-menu-content #selectTargetModal2 ul li').length;

        if (matchMedia("screen and (min-width: 961px)").matches){
            if(targetLiLength <= 10){
                $('.main-content #selectTargetModal .modal-body').css({
                    'padding-left':'0',
                    'padding-right':'0'
                });
            }
            else if(targetLiLength > 10){
                $('.main-content #selectTargetModal .modal-body').css({
                    'padding-left':'0',
                    'padding-right':'30px'
                });
            }

            if(targetLiLength2 <= 10){
                $('.top-menu-content #selectTargetModal2 .modal-body').css({
                    'padding-left':'0',
                    'padding-right':'0'
                });
            }
            else if(targetLiLength2 > 10){
                $('.top-menu-content #selectTargetModal2 .modal-body').css({
                    'padding-left':'0',
                    'padding-right':'30px'
                });
            }
        }
    });

    $(document).ready(function (){
        //푸터
        if($('.main-content #selectTargetModal ul li').text().length >= 8){
            $('.main-content #selectTargetModal .modal-footer button.search-btn span.font-white').css({
                'text-overflow':'ellipsis',
                'white-space':'nowrap',
                'overflow':'hidden',
                'max-width':'40%',
                'display':'inline-block'
            });
        }else{
            $('.main-content #selectTargetModal .modal-footer button.search-btn span.font-white').css({
                'text-overflow':'unset',
                'white-space':'unset',
                'overflow':'unset',
                'max-width':'none',
                'display':'unset'
            });
        }

        //탑메뉴
        if($('.top-menu-content #selectTargetModal2 ul li').text().length >= 8){
            $('.top-menu-content #selectTargetModal2 .modal-footer button.search-btn span.font-white').css({
                'text-overflow':'ellipsis',
                'white-space':'nowrap',
                'overflow':'hidden',
                'max-width':'40%',
                'display':'inline-block'
            });
        }else{
            $('.top-menu-content #selectTargetModal2 .modal-footer button.search-btn span.font-white').css({
                'text-overflow':'unset',
                'white-space':'unset',
                'overflow':'unset',
                'max-width':'none',
                'display':'unset'
            });
        }
    });



    //전체 선택시 모든 리스트 선택되기
    $('.main-content #selectTargetModal ul li:nth-child(1)').on('click', function (){
        // $(this).children('input:checkbox').prop('checked', true);
        // $(this).children('i').toggleClass('favicon');
        // $('.main-content #selectTargetModal ul li:not(:nth-child(1)) input:checkbox').prop('checked', true);
        // $('.main-content #selectTargetModal ul li:not(:nth-child(1)) i').addClass('favicon');

        if($(this).children('i').hasClass('favicon')){ // 체크가 되어 있었을 때,
            // alert("a");
            $(this).children('input:checkbox').removeAttr('checked');
            $(this).children('i').removeClass('favicon');
            $('.main-content #selectTargetModal ul li:not(:nth-child(1)) input:checkbox').removeAttr('checked');
            $('.main-content #selectTargetModal ul li:not(:nth-child(1)) i').removeClass('favicon');
            $('.main-content #selectTargetModal .modal-footer button.none').show();
            $('.main-content #selectTargetModal .modal-footer button.search-btn').hide();

        }else{ // 체크가 안되어 있을 때,
            // alert("b");
            $(this).children('input:checkbox').prop('checked', true);
            $(this).children('i').addClass('favicon');
            $('.main-content #selectTargetModal ul li:not(:nth-child(1)) input:checkbox').prop('checked', true);
            $('.main-content #selectTargetModal ul li:not(:nth-child(1)) i').addClass('favicon');
            $('.main-content #selectTargetModal .modal-footer button.none').hide();
            $('.main-content #selectTargetModal .modal-footer button.search-btn').show();
            $(".main-content #selectTargetModal #searchTargetName").html($(this).children('input:checkbox:checked').val());
            $(".main-content #selectTargetModal .etc").hide();
            $(".main-content #selectTargetModal .etcNum").hide();
        }
    });


    //전체 선택시 모든 리스트 선택되기(탑메뉴)
    $('.top-menu-content #selectTargetModal2 ul li:nth-child(1)').on('click', function (){
        if($(this).children('i').hasClass('favicon')){ // 체크가 되어 있었을 때,
            // alert("a");
            $(this).children('input:checkbox').removeAttr('checked');
            $(this).children('i').removeClass('favicon');
            $('.top-menu-content #selectTargetModal2 ul li:not(:nth-child(1)) input:checkbox').removeAttr('checked');
            $('.top-menu-content #selectTargetModal2 ul li:not(:nth-child(1)) i').removeClass('favicon');
            $('.top-menu-content #selectTargetModal2 .modal-footer button.none').show();
            $('.top-menu-content #selectTargetModal2 .modal-footer button.search-btn').hide();

        }else{ // 체크가 안되어 있을 때,
            // alert("b");
            $(this).children('input:checkbox').prop('checked', true);
            $(this).children('i').addClass('favicon');
            $('.top-menu-content #selectTargetModal2 ul li:not(:nth-child(1)) input:checkbox').prop('checked', true);
            $('.top-menu-content #selectTargetModal2 ul li:not(:nth-child(1)) i').addClass('favicon');
            $('.top-menu-content #selectTargetModal2 .modal-footer button.none').hide();
            $('.top-menu-content #selectTargetModal2 .modal-footer button.search-btn').show();
            $(".top-menu-content #selectTargetModal2 #searchTargetName2").html($(this).children('input:checkbox:checked').val());
            $(".top-menu-content #selectTargetModal2 .etc").hide();
            $(".top-menu-content #selectTargetModal2 .etcNum").hide();
        }
    });

    // let targetChecked = $(".main-content #selectTargetModal input.targetChk:checked").length;
    //
    // if(targetChecked >= 1) {
    //     $('.main-content #selectTargetModal .modal-footer button.none').hide();
    //     $('.main-content #selectTargetModal .modal-footer button.search-btn').show();
    // }else if(targetChecked < 1){
    //     $('.main-content #selectTargetModal .modal-footer button.none').show();
    //     $('.main-content #selectTargetModal .modal-footer button.search-btn').hide();
    // }



    //테마선택 modal 확인
    $('.main-content .category-box-theme').click(function(){
        $('#selectThemeModal').css('display', 'flex');
    });

    //테마가 6개 이상/초과일 경우 ui 반응대비
    let themeLiLength = $('.main-content #selectThemeModal ul li').length;
    let themeLiLength2 = $('.top-menu-content #selectThemeModal2 ul li').length;
    if (matchMedia("screen and (min-width: 961px)").matches){
        //푸터
        if(themeLiLength <= 6){
            $('.main-content #selectThemeModal ul li').css({
                'width':'calc((100% - 10px) / 6.4)'
            });
        }
        else if(themeLiLength > 6){
            $('.main-content #selectThemeModal ul li').css({
                'width':'calc((100% - 10px) / 6.7)'
            });
            $('.main-content #selectThemeModal ul li:not(:nth-of-type(1))').css({
                'margin-top':'10px'
            });
            $('.main-content #selectThemeModal ul li:nth-of-type(2), .main-content #selectThemeModal ul li:nth-of-type(3),.main-content #selectThemeModal ul li:nth-of-type(4), .main-content #selectThemeModal ul li:nth-of-type(5), .main-content #selectThemeModal ul li:nth-of-type(6)').css({
                'margin-top':'0px'
            });
        }

        //탑메뉴
        if(themeLiLength2 <= 6){
            $('.top-menu-content #selectThemeModal2 ul li').css({
                'width':'calc((100% - 10px) / 6.4)'
            });
        }
        else if(themeLiLength2 > 6){
            $('.top-menu-content #selectThemeModal2 ul li').css({
                'width':'calc((100% - 10px) / 6.7)'
            });
            $('.top-menu-content #selectThemeModal2 ul li:not(:nth-of-type(1))').css({
                'margin-top':'10px'
            });
            $('.top-menu-content #selectThemeModal2 ul li:nth-of-type(2), .top-menu-content #selectThemeModal2 ul li:nth-of-type(3), .top-menu-content #selectThemeModal2 ul li:nth-of-type(4), .top-menu-content #selectThemeModal2 ul li:nth-of-type(5), .top-menu-content #selectThemeModal2 ul li:nth-of-type(6)').css({
                'margin-top':'0px'
            });
        }
    }
    if (matchMedia("screen and (max-width: 960px)").matches){
        //푸터
        if(themeLiLength > 6){
            $('.main-content #selectThemeModal ul li:not(:nth-of-type(1))').css({
                'margin-top':'10px'
            });
            $('.main-content #selectThemeModal ul li:nth-of-type(1), .main-content #selectThemeModal ul li:nth-of-type(2)').css({
                'margin-top':'0px'
            });
            $('.main-content #selectThemeModal .modal-content').css({
                'padding-right':'20px'
            });
            $('.main-content #selectThemeModal .modal-body').css({
                'padding':'0 0 0 20px'
            });
        }

        //탑메뉴
        if(themeLiLength2 > 6){
            $('.top-menu-content #selectThemeModal2 ul li:not(:nth-of-type(1))').css({
                'margin-top':'10px'
            });
            $('.top-menu-content #selectThemeModal2 ul li:nth-of-type(1), .main-content #selectThemeModal2 ul li:nth-of-type(2)').css({
                'margin-top':'0px'
            });
            $('.top-menu-content #selectThemeModal2 .modal-content').css({
                'padding-right':'20px'
            });
            $('.top-menu-content #selectThemeModal2 .modal-body').css({
                'padding':'0 0 0 20px'
            });
        }
    }

    //메인페이지 내 테마 선택
    $('.main-content #selectThemeModal ul li').on('click', function (){
        let themeChk = $(this).children('input:checkbox');
        if(themeChk.prop("checked")) {
            themeChk.prop("checked", false);
        }else {
            themeChk.prop("checked", true);
        }

        // $(".themeChk").each(function(){
        //     if($(this).prop("checked")) {
        //         alert($(this).val());
        //     }
        // });

        changeThemeModalButton();
    });

    //메인페이지 내 테마 선택(탑메뉴)
    $('.top-menu-content #selectThemeModal2 ul li').on('click', function (){
        let themeChk = $(this).children('input:checkbox');
        if(themeChk.prop("checked")) {
            themeChk.prop("checked", false);
        }else {
            themeChk.prop("checked", true);
        }

        // $(".themeChk").each(function(){
        //     if($(this).prop("checked")) {
        //         alert($(this).val());
        //     }
        // });

        changeThemeModalButton2();
    });

    function changeThemeModalButton(){
        let chkThemeLength = $('.main-content #selectThemeModal ul li input:checkbox:checked').length;
        let searchThemeName="";
        $("#selectThemeModal .themeChk:checked").each(function(){
            searchThemeName =  $(this).val();
        });
        if(chkThemeLength >= 1) {
            $('.main-content #selectThemeModal .modal-footer button.none').hide();
            $('.main-content #selectThemeModal .modal-footer button.search-btn').show();
            if(chkThemeLength == 1) {
                $(".main-content #selectThemeModal #searchThemeName").html(searchThemeName);
                $(".main-content #selectThemeModal .etc").hide();
                $(".main-content #selectThemeModal .etcNum").hide();
            }else {
                $(".main-content #selectThemeModal #searchThemeName").html(searchThemeName);
                $(".main-content #selectThemeModal .etc").show();
                $(".main-content #selectThemeModal .etcNum").html(chkThemeLength - 1);
                $(".main-content #selectThemeModal .etcNum").show();
            }
        }else if(chkThemeLength < 1){
            $('.main-content #selectThemeModal .modal-footer button.none').show();
            $('.main-content #selectThemeModal .modal-footer button.search-btn').hide();
        }
    }

    function changeThemeModalButton2(){
        let chkThemeLength = $('.top-menu-content #selectThemeModal2 ul li input:checkbox:checked').length;
        let searchThemeName="";
        $("#selectThemeModal2 .themeChk:checked").each(function(){
            searchThemeName =  $(this).val();
        });
        if(chkThemeLength >= 1) {
            $('.top-menu-content #selectThemeModal2 .modal-footer button.none').hide();
            $('.top-menu-content #selectThemeModal2 .modal-footer button.search-btn').show();
            if(chkThemeLength == 1) {
                $(".top-menu-content #selectThemeModal2 #searchThemeName2").html(searchThemeName);
                $(".top-menu-content #selectThemeModal2 .etc").hide();
                $(".top-menu-content #selectThemeModal2 .etcNum").hide();
            }else {
                $(".top-menu-content #selectThemeModal2 #searchThemeName2").html(searchThemeName);
                $(".top-menu-content #selectThemeModal2 .etc").show();
                $(".top-menu-content #selectThemeModal2 .etcNum").html(chkThemeLength - 1);
                $(".top-menu-content #selectThemeModal2 .etcNum").show();
            }
        }else if(chkThemeLength < 1){
            $('.top-menu-content #selectThemeModal2 .modal-footer button.none').show();
            $('.top-menu-content #selectThemeModal2 .modal-footer button.search-btn').hide();
        }
    }


    //테마 선택 시 색상변화
    $('.main-content #selectThemeModal ul li').on('click', function (){
        if($(this).hasClass('basic-back-color')){
            $(this).toggleClass('selected-back-color');
            $(this).children().children('p').toggleClass('font-white');
            $(this).children().children('img:nth-child(1)').show();
            $(this).children().children('img:nth-child(2)').hide();
        }
        if($(this).hasClass('selected-back-color')){
            $(this).children().children('img:nth-child(1)').hide();
            $(this).children().children('img:nth-child(2)').show();
        }
    });

    $('.top-menu-content #selectThemeModal2 ul li').on('click', function (){
        if($(this).hasClass('basic-back-color')){
            $(this).toggleClass('selected-back-color');
            $(this).children().children('p').toggleClass('font-white');
            $(this).children().children('img:nth-child(1)').show();
            $(this).children().children('img:nth-child(2)').hide();
        }
        if($(this).hasClass('selected-back-color')){
            $(this).children().children('img:nth-child(1)').hide();
            $(this).children().children('img:nth-child(2)').show();
        }
    });


    // 유형선택 modal
    //유형선택 modal 확인
    $('.main-content .category-box-type').click(function(){
        $('#selectTypeModal').css('display', 'flex');
    });

    $(function (){
        $('#selectTypeModal .modal-content input').hide();
        $('#selectTypeModal2 .modal-content input').hide();
        selectTypeChange();
        selectTypeChange2();
    });
    $(document).ready(function (){
        $('#selectTypeModal .modal-footer button.none').show();
        $('#selectTypeModal .modal-footer button.search-btn').hide();
        $('#selectTypeModal2 .modal-footer button.none').show();
        $('#selectTypeModal2 .modal-footer button.search-btn').hide();
    });
    $('#selectTypeModal select').change(function (){
        selectTypeChange();
    });
    $('#selectTypeModal2 select').change(function (){
        selectTypeChange2();
    });

    function selectTypeChange(){
        if($('#selectTypeModal select option:selected').text() == '기타'){
            $('#selectTypeModal .modal-content input').val("");
            $('#selectTypeModal .modal-content input').show();
            $('#selectTypeModal .modal-footer button.none').hide();
            $('#selectTypeModal .modal-footer button.search-btn').show();
            $('#searchTypeName').html("기타 (전체) ");
        }else if($('#selectTypeModal select option:selected').text() != '기타'){
            $('#searchTypeName').html($('#selectTypeModal select option:selected').text());
            $('#selectTypeModal .modal-content input').hide();
            $('#selectTypeModal .modal-footer button.none').hide();
            $('#selectTypeModal .modal-footer button.search-btn').show();
            $('#selectTypeModal .modal-content input').val("");
        }
    }
    function selectTypeChange2(){
        if($('#selectTypeModal2 select option:selected').text() == '기타'){
            $('#selectTypeModal2 .modal-content input').val("");
            $('#selectTypeModal2 .modal-content input').show();
            $('#selectTypeModal2 .modal-footer button.none').hide();
            $('#selectTypeModal2 .modal-footer button.search-btn').show();
            $('#searchTypeName2').html("기타 (전체) ");
        }else if($('#selectTypeModal2 select option:selected').text() != '기타'){
            $('#searchTypeName2').html($('#selectTypeModal select option:selected').text());
            $('#selectTypeModal2 .modal-content input').hide();
            $('#selectTypeModal2 .modal-footer button.none').hide();
            $('#selectTypeModal2 .modal-footer button.search-btn').show();
            $('#selectTypeModal2 .modal-content input').val("");
        }
    }

    $('#selectTypeModal .modal-content input').on("keyup", function (){
        if($('#selectTypeModal .modal-content input').val()==""){
            $('#selectTypeModal .modal-footer button.none').hide();
            $('#selectTypeModal .modal-footer button.search-btn').show();
            $('#searchTypeName').html("기타 (전체) ");
        }else {
            $('#searchTypeName').html($('#selectTypeModal .modal-content input').val());
        }
    });

    $('#selectTypeModal2 .modal-content input').on("keyup", function (){
        if($('#selectTypeModal2 .modal-content input').val()==""){
            $('#selectTypeModal2 .modal-footer button.none').hide();
            $('#selectTypeModal2 .modal-footer button.search-btn').show();
            $('#searchTypeName2').html("기타 (전체) ");
        }else {
            $('#searchTypeName2').html($('#selectTypeModal2 .modal-content input').val());
        }
    });

    // 유형 직접입력 선택 시 입력필드 보이기
    $('.content-edu-list-user .sel-type-area input[type=\'text\']').css('display', 'none');
    $('.content-edu-list-user .sel-type-area input:checkbox:last-of-type').click(function (){
        let typeInput = $('.content-edu-list-user .sel-type-area input:checkbox:last-of-type');

        $('.content-edu-list-user .sel-type-area input[type=\'text\']').val();
        $('.content-edu-list-user .sel-type-area input[type=\'text\']').css({'display':'block'});
        $('.content-edu-list-user .sel-type-area input[type=\'text\']').focus();
        $('.content-edu-list-user .sel-type-area label:last-of-type').css({'width':'216px'});

        if(typeInput.prop('checked') == false){
            $('.content-edu-list-user .sel-type-area input[type=\'text\']').css('display', 'none');
            $('.content-edu-list-user .sel-type-area label:last-of-type').css({'width':'61px'});
        }
    });



    // mobile modal(모달 내 버튼색상 변화)
    // if (matchMedia("screen and (max-width: 960px)").matches){
    //     $('.content-edu-list-user').on('click', '.search-category-area-mobile', function (){
    //         $('.content-edu-list-user #searchModal').css({'display':'flex'});
    //     });
    //     searchModalButton();
    // }

    $('.content-edu-list-user #searchModal input.input-direct').on('keyup', function (){
        searchModalButton();
    });

    function searchModalButton(){
        if($('.content-edu-list-user #searchModal input.input-direct').val() == ''){
            $('.content-edu-list-user #searchModal .modal-footer button.none').show();
            $('.content-edu-list-user #searchModal .modal-footer button.search-btn').hide();
        }else {
            $('.content-edu-list-user #searchModal .modal-footer button.none').hide();
            $('.content-edu-list-user #searchModal .modal-footer button.search-btn').show();
        }
    }


    $('.main-content #selectTypeModal input.input-direct').on('keyup', function (){ //
        if($(this).val() == ''){
            $('.main-content #selectTypeModal .modal-footer button.none').hide();
            $('.main-content #selectTypeModal .modal-footer button.search-btn').show();
        }else{
            $('.main-content #selectTypeModal .modal-footer button.none').hide();
            $('.main-content #selectTypeModal .modal-footer button.search-btn').show();
            $('.main-content #selectTypeModal .modal-footer button.search-btn span.etc').hide();

            //입력내용이 8글자 이상인 경우 말줄임표시
            if($(this).val().length >= 8){
                $('.main-content #selectTypeModal .modal-footer button.search-btn > span').css({
                    'text-overflow':'ellipsis',
                    'white-space':'nowrap',
                    'overflow':'hidden',
                    'max-width':'125px',
                    'display':'inline-block'
                });
                $('.main-content #selectTypeModal .modal-footer button.search-btn').css({
                    'display':'flex',
                    'justify-content':'center'
                });
            }else if($('.main-content #selectTypeModal input.input-direct').val().length < 8){
                $('.main-content #selectTypeModal .modal-footer button.search-btn > span').css({
                    'text-overflow':'unset',
                    'white-space':'unset',
                    'overflow':'unset',
                    'max-width':'none',
                    'display':'unset'
                });
                $('.main-content #selectTypeModal .modal-footer button.search-btn').css({
                    'display':'flex',
                    'justify-content':'center'
                });
            }
        }
    });

    // 탑메뉴
    $('.top-menu-content #selectTypeModal2 input.input-direct').on('keyup', function (){ //
        if($(this).val() == ''){
            $('.top-menu-content #selectTypeModal2 .modal-footer button.none').hide();
            $('.top-menu-content #selectTypeModal2 .modal-footer button.search-btn').show();
        }else{
            $('.top-menu-content #selectTypeModal2 .modal-footer button.none').hide();
            $('.top-menu-content #selectTypeModal2 .modal-footer button.search-btn').show();
            $('.top-menu-content #selectTypeModal2 .modal-footer button.search-btn span.etc').hide();

            //입력내용이 8글자 이상인 경우 말줄임표시
            if($(this).val().length >= 8){
                $('.top-menu-content #selectTypeModal2 .modal-footer button.search-btn > span').css({
                    'text-overflow':'ellipsis',
                    'white-space':'nowrap',
                    'overflow':'hidden',
                    'max-width':'125px',
                    'display':'inline-block'
                });
                $('.top-menu-content #selectTypeModal2 .modal-footer button.search-btn').css({
                    'display':'flex',
                    'justify-content':'center'
                });
            }else if($('.top-menu-content #selectTypeModal2 input.input-direct').val().length < 8){
                $('.top-menu-content #selectTypeModal2 .modal-footer button.search-btn > span').css({
                    'text-overflow':'unset',
                    'white-space':'unset',
                    'overflow':'unset',
                    'max-width':'none',
                    'display':'unset'
                });
                $('.top-menu-content #selectTypeModal2 .modal-footer button.search-btn').css({
                    'display':'flex',
                    'justify-content':'center'
                });
            }
        }
    });

    // 1차 카테고리(지역, 대상, 테마, 유형) 선택값에 따라 choice chip 내용 다르게 나타내기
    $('.content-edu-list-user .search-category-area select.search-category1').on('change', function (){
        let selCategory = $('.content-edu-list-user .search-category-area select.search-category1 option:selected').val();
        if(selCategory == '지역'){
            $("#chip-areaAll").prop("checked", true);
            $("#areaChoiceChip .areaChk1").prop("checked", false);
            $('.content-edu-list-user div.content-wrap .sel-category-area').show();
            $('.content-edu-list-user div.content-wrap .sel-target-area').hide();
            $('.content-edu-list-user div.content-wrap .sel-theme-area').hide();
            $('.content-edu-list-user div.content-wrap .sel-type-area').hide();
        }
        if(selCategory == '교육대상'){
            $("#chip-targetAll").prop("checked", true);
            $("#targetChoiceChip .targetChk1").prop("checked", false);
            $('.content-edu-list-user div.content-wrap .sel-category-area').hide();
            $('.content-edu-list-user div.content-wrap .sel-target-area').show();
            $('.content-edu-list-user div.content-wrap .sel-theme-area').hide();
            $('.content-edu-list-user div.content-wrap .sel-type-area').hide();
        }
        if(selCategory == '교육테마'){
            $("#chip-themeAll").prop("checked", true);
            $("#themeChoiceChip .themeChk1").prop("checked", false);
            $('.content-edu-list-user div.content-wrap .sel-category-area').hide();
            $('.content-edu-list-user div.content-wrap .sel-target-area').hide();
            $('.content-edu-list-user div.content-wrap .sel-theme-area').show();
            $('.content-edu-list-user div.content-wrap .sel-type-area').hide();
        }
        if(selCategory == '교육유형'){
            $("#chip-typeAll").prop("checked", true);
            $("#typeChoiceChip .typeChk1").prop("checked", false);
            $('.content-edu-list-user div.content-wrap .sel-category-area').hide();
            $('.content-edu-list-user div.content-wrap .sel-target-area').hide();
            $('.content-edu-list-user div.content-wrap .sel-theme-area').hide();
            $('.content-edu-list-user div.content-wrap .sel-type-area').show();
        }
    });


    //지역 choice chip 선택 시
    $('.content-edu-list-user .sel-category-area input:checkbox').on('click', function (){
        if($(this).val()=='전체' || $(this).val()=='on') {
            $(".content-edu-list-user .sel-category-area input.areaChk1").removeAttr('checked');
            $(this).prop("checked", true);
        }
        // 선택된 일반 지역명 체크박스의 수 (일반 지역명 체크박스의 areaChk라는 class 추가됨)
        let areaChkLength = $(".content-edu-list-user .sel-category-area .areaChk1:checked").length;

        if(areaChkLength >= 1) {
            $(".content-edu-list-user .sel-category-area input:checkbox:nth-child(1)").removeAttr('checked');
        }else if(areaChkLength < 1) {
            $(".content-edu-list-user .sel-category-area input:checkbox:nth-child(1)").prop("checked", true);
        }

        // $(".content-edu-list-user .sel-category-area input:checkbox:nth-child(1)").on('click', function (){
        //    $(".content-edu-list-user .sel-category-area input.areaChk1").removeAttr('checked');
        //             $(this).prop("checked", true);
        // });
        let arrQuery = new Array();
        $(".content-edu-list-user .sel-category-area .areaChk1:checked").each(function(){
             arrQuery.push($(this).val());
        });
        page=1;
        createChoiceChip(arrQuery, keyword);
        cateNameByCateType(cateType);
        getSearchResult(cateType, cateName);
    });

    //대상 choice chip 선택 시
    $('.content-edu-list-user .sel-target-area input:checkbox').on('click', function (){
        if($(this).val()=='전체' || $(this).val()=='on') {
            $(".content-edu-list-user .sel-target-area input.targetChk1").removeAttr('checked');
            $(this).prop("checked", true);
        }
        let targetChkLength = $(".content-edu-list-user .sel-target-area .targetChk1:checked").length;

        if(targetChkLength >= 1) {
            $(".content-edu-list-user .sel-target-area input:checkbox:nth-child(1)").removeAttr('checked');
        }else if(targetChkLength < 1) {
            $(".content-edu-list-user .sel-target-area input:checkbox:nth-child(1)").prop("checked", true);
        }

        // $(".content-edu-list-user .sel-target-area input:checkbox:nth-child(1)").on('click', function (){
        //     $(".content-edu-list-user .sel-target-area input.targetChk1").removeAttr('checked');
        //     $(this).prop("checked", true);
        // });

        let arrQuery = new Array();
        $(".content-edu-list-user .sel-target-area .targetChk1:checked").each(function(){
            arrQuery.push($(this).val());
        });
        page=1;
        createChoiceChip(arrQuery, keyword);
        cateNameByCateType(cateType);
        getSearchResult(cateType, cateName);
    });

    //테마 choice chip 선택 시
    $('.content-edu-list-user .sel-theme-area input:checkbox').on('click', function (){
        if($(this).val()=='전체' || $(this).val()=='on') {
            $(".content-edu-list-user .sel-theme-area input.themeChk1").removeAttr('checked');
            $(this).prop("checked", true);
        }
        let themeChkLength = $(".content-edu-list-user .sel-theme-area .themeChk1:checked").length;

        if(themeChkLength >= 1) {
            $(".content-edu-list-user .sel-theme-area input:checkbox:nth-child(1)").removeAttr('checked');
        }else if(themeChkLength < 1) {
            $(".content-edu-list-user .sel-theme-area input:checkbox:nth-child(1)").prop("checked", true);
        }

        // $(".content-edu-list-user .sel-theme-area input:checkbox:nth-child(1)").on('click', function (){
        //     $(".content-edu-list-user .sel-theme-area input.themeChk1").removeAttr('checked');
        //     $(this).prop("checked", true);
        // });
        let arrQuery = new Array();
        $(".content-edu-list-user .sel-theme-area .themeChk1:checked").each(function(){
            arrQuery.push($(this).val());
        });
        page=1;
        createChoiceChip(arrQuery, keyword);
        cateNameByCateType(cateType);
        getSearchResult(cateType, cateName);
    });

    //유형 choice chip 선택 시
    $('.content-edu-list-user .sel-type-area input:checkbox').on('click', function (){
        if($(this).val()=='전체' || $(this).val()=='on') {
            $('.content-edu-list-user .sel-type-area input.typeChk1').removeAttr('checked');
            $(this).prop("checked", true);
            $("#etcText").val("");
            $("#etcText").css("display", "none");
            $('.content-edu-list-user .sel-type-area input[type=\'text\']').css('display', 'none');
            $('.content-edu-list-user .sel-type-area label:last-of-type').css({'width':'61px'});
        }
        if($(this).val()=='기타') {
            $("#etcText").val('');
        }
        let typeChkLength = $(".content-edu-list-user .sel-type-area .typeChk1:checked").length;

        if(typeChkLength >= 1) {
            $(".content-edu-list-user .sel-type-area input:checkbox:nth-child(1)").removeAttr('checked');
        }else if(typeChkLength < 1) {
            $(".content-edu-list-user .sel-type-area input:checkbox:nth-child(1)").prop("checked", true);
        }

        // $(".content-edu-list-user .sel-type-area input:checkbox:nth-child(1)").on('click', function (){
        //     $('.content-edu-list-user .sel-type-area input.typeChk1').removeAttr('checked');
        //     $(this).prop("checked", true);
        // });
        let arrQuery = new Array();
        let txtQuery = $("#etcText").val();
        $(".content-edu-list-user .sel-type-area .typeChk1:checked").each(function(){
            let query = $(this).val();
            if(query=='기타' && txtQuery!='') {
                arrQuery.push(txtQuery);
            }else {
                arrQuery.push(query);
            }
        });
        page=1;
        createChoiceChip(arrQuery, keyword);
        cateNameByCateType(cateType);
        getSearchResult(cateType, cateName);
    });

    //mobile 검색 후 나타나는 키워드
    //삭제버튼 선택 시 해당 choice chip 버튼 사라지기
    $('.content-edu-list-user .result-chip-area .result-chip i.delete').on('click', function (){
        $(this).parent().remove();
    });


    // 단체상세
    // 상단 탭바 선택 시 포커스효과
    $('.content-group-detail-user .top-tab ul li:nth-child(1)').on('click', function (event){
        event.preventDefault();
        $('.content-group-detail-user .top-tab bar.bottom-bar').animate({
            left: '0',
            width: '63.05px',
        }, 1, 'easeInOutQuart');
        $('.content-group-detail-user .top-tab ul li:nth-child(1)').addClass('focus');
        $('.content-group-detail-user .top-tab ul li:nth-child(2)').removeClass('focus');

        //해당 컨텐츠로 스크롤 이동
        window.scrollTo({top: 0, behavior: "smooth"});
    });
    $('.content-group-detail-user .top-tab ul li:nth-child(2)').on('click', function (event){
        event.preventDefault();
        $('.content-group-detail-user .top-tab bar.bottom-bar').animate({
            left: '84px',
            width: '98.22px',
        }, 1, 'easeInOutQuart');
        $('.content-group-detail-user .top-tab ul li:nth-child(2)').addClass('focus');
        $('.content-group-detail-user .top-tab ul li:nth-child(1)').removeClass('focus');

        //해당 컨텐츠로 스크롤 이동
        let offset = document.querySelector('.group-info-content3').offsetTop;
        let topMenuHeight = document.querySelector('.header-wrap').offsetHeight;
        let tabBarHeight = document.querySelector('.top-tab').offsetHeight;
        window.scrollTo({top: offset - (topMenuHeight + tabBarHeight), behavior: 'smooth'});
    });



    // 프로그램 썸네일 반응형
    // if (matchMedia("screen and (max-height: 915px)").matches){
    //     $('.content-program-detail-user .part-left .part1 .img-area').css({
    //         'height':'34vh'
    //     });
    //     $('.content-program-detail-user .part-left .part1 .img-area ul:nth-child(1) li').css({
    //         'height':'34vh'
    //     });
    //     $('.content-program-detail-user .part-left .part1 .img-area ul:nth-child(1) li img').css({
    //         'height':'34vh'
    //     });
    // }



    // 정보수정 요청
    // modal
    // 입력필드에 입력 시
    let editInput1 = $('.content-edit-list-user #addModal ul.selected-group:nth-of-type(2) li:nth-child(2) input');
    let editInput2 = $('.content-edit-list-user #addModal ul.selected-group:nth-of-type(3) li:nth-child(2) input');
    let editInput3 = $('.content-edit-list-user #addModal ul.selected-group:nth-of-type(4) li:nth-child(2) input');
    let editInput4 = $('.content-edit-list-user #addModal ul.selected-group:nth-of-type(5) li:nth-child(2) input');
    let editContent = $('.content-edit-list-user #addModal ul li:nth-child(2) textarea');
    let editPass = $('.content-edit-list-user #addModal ul li:nth-child(2) input:password');
    let btnSelectedOption1 = $('.content-edit-list-user #addModal .btn-area button:nth-child(1)'); //단체명
    let btnSelectedOption2 = $('.content-edit-list-user #addModal .btn-area button:nth-child(2)'); //프로그램명

    //정보입력 여부에 따른 버튼 색상효과 START
    //단체변경
    if(btnSelectedOption1.hasClass('btn-h50r-green') == true) {
        editGroup();
        $('.content-edit-list-user #addModal input').on('keyup', function () {
            editGroup();
        });
        $('.content-edit-list-user #addModal ul.selected-group select').on('change', function (){
            editGroup();
            // if(requestType=="program"){
            //     editProgram();
            // }
        });
        $('.content-edit-list-user #addModal .btn-area button').on('click', function (){
            editGroup();
        });
    }

    function editGroup(){
        if (editInput1.val() == '' || editInput2.val() == '' || editInput3.val() == '' || editInput4.val() == '' || editContent.val() == '' || editPass.val().length < 6 || $('.content-edit-list-user #addModal ul.selected-group li:nth-child(2) select option:selected').text() == '단체 선택') {
            $('.content-edit-list-user #addModal .modal-footer button.none').show();
            $('.content-edit-list-user #addModal .modal-footer button.btn-insert').hide();
        } else {
            $('.content-edit-list-user #addModal .modal-footer button.none').hide();
            $('.content-edit-list-user #addModal .modal-footer button.btn-insert').show();
        }
    }

    //프로그램변경
    $('.content-edit-list-user #addModal .btn-area button').on('click', function (){
        if(btnSelectedOption2.hasClass('btn-h50r-green') == true){
            editProgram();
            $('.content-edit-list-user #addModal input').on('keyup', function () {
                editProgram();
            });
            $('.content-edit-list-user #addModal ul.selected-program select').on('change', function (){
                editProgram();
            });
            $('.content-edit-list-user #addModal .btn-area button').on('click', function (){
                editProgram();
            });
        }
    });

    function editProgram(){
        if (editInput1.val() == '' || editInput2.val() == '' || editInput3.val() == '' || editInput4.val() == '' || editContent.val() == '' || editPass.val().length < 6 || $('.content-edit-list-user #addModal ul.selected-group li:nth-child(2) select option:selected').text() == '단체 선택' || $('.content-edit-list-user #addModal ul.selected-program li:nth-child(2) select option:selected').text() == '프로그램 선택') {
            $('.content-edit-list-user #addModal .modal-footer button.none').show();
            $('.content-edit-list-user #addModal .modal-footer button.btn-insert').hide();
        } else {
            $('.content-edit-list-user #addModal .modal-footer button.none').hide();
            $('.content-edit-list-user #addModal .modal-footer button.btn-insert').show();
        }
    }
    //정보입력 여부에 따른 버튼 색상효과 END


    if (matchMedia("screen and (max-width: 960px)").matches){
        $(editInput1).next('i.cancel').hide();
        if(editInput1.val() == ''){
            $(this).next('i.cancel').hide();
        }else{
            $(this).next('i.cancel').show();
        }
        $(editInput1).on('keyup', function (){
            if(editInput1.val() == ''){
                $(this).next('i.cancel').hide();
            }else{
                $(this).next('i.cancel').show();
            }
        });
        $(editInput1).next('i.cancel').on('click', function (){
            $(this).prev('input').val('');
            $(this).prev('input').focus();
            $(this).hide();
            editGroup();
        });

        $(editInput2).next('i.cancel').hide();
        if(editInput2.val() == ''){
            $(this).next('i.cancel').hide();
        }else{
            $(this).next('i.cancel').show();
        }
        $(editInput2).on('keyup', function (){
            if(editInput2.val() == ''){
                $(this).next('i.cancel').hide();
                $(this).next('i.cancel').show();
            }else{
                $(this).next('i.cancel').show();
            }
        });
        $(editInput2).next('i.cancel').on('click', function (){
            $(this).prev('input').val('');
            $(this).prev('input').focus();
            $(this).hide();
            editGroup();
        });

        $(editInput3).next('i.cancel').hide();
        if(editInput3.val() == ''){
            $(this).next('i.cancel').hide();
        }else{
            $(this).next('i.cancel').show();
        }
        $(editInput3).on('keyup', function (){
            if(editInput3.val() == ''){
                $(this).next('i.cancel').hide();
            }else{
                $(this).next('i.cancel').show();
            }
        });
        $(editInput3).next('i.cancel').on('click', function (){
            $(this).prev('input').val('');
            $(this).prev('input').focus();
            $(this).hide();
            editGroup();
        });

        $(editInput4).next('i.cancel').hide();
        if(editInput4.val() == ''){
            $(this).next('i.cancel').hide();
        }else{
            $(this).next('i.cancel').show();
        }
        $(editInput4).on('keyup', function (){
            if(editInput4.val() == ''){
                $(this).next('i.cancel').hide();
            }else{
                $(this).next('i.cancel').show();
            }
        });
        $(editInput4).next('i.cancel').on('click', function (){
            $(this).prev('input').val('');
            $(this).prev('input').focus();
            $(this).hide();
            editGroup();
        });

        // 필터검색 modal(mobile)
        $('.content-edit-list-user #searchModal input:text').on('keyup', function (){
            if($(this).val() == ''){
                $('.content-edit-list-user #searchModal .modal-footer button.none').show();
                $('.content-edit-list-user #searchModal .modal-footer button.search-btn').hide();
            }else{
                $('.content-edit-list-user #searchModal .modal-footer button.none').hide();
                $('.content-edit-list-user #searchModal .modal-footer button.search-btn').show();
            }
        });

        //mobile 검색 후 나타나는 키워드
        //삭제버튼 선택 시 해당 choice chip 버튼 사라지기
        // $('.content-edit-list-user #result-chip-slide-area .result-chip i.delete').on('click', function (){
        //     $(this).parent().remove();
        // });
    }


    // 사용자 END-----------------------------------------------------------------------------------------

});

