// 이미지 슬라이드

// 어드민------------------------------------------------------------------------------------------------

$(document).ready(function (){
    let link = document.location.href;
    if(link.includes('/admin/manage/program')){
        //프로그램 관리(어드민)
        programManage();
    }else if(link.includes('/admin')){
        //프로그램 현황(어드민)
        programList();
    }else if(link.includes('/detail/program')){
        //프로그램 상세(사용자)
        detailProgramUser();
    }
});

//프로그램 현황
function programList(){
    let slides = document.querySelector('.main-content-program-list .img-slide'); //전체 슬라이드 컨테이너
    let slideImg = document.querySelectorAll('.main-content-program-list .img-slide li'); //모든 슬라이드들
    let currentIdx = 0; //현재 슬라이드 index
    let slideCount = slideImg.length; // 슬라이드 개수
    let prev = document.querySelector('.main-content-program-list .prev-img'); //이전 버튼
    let next = document.querySelector('.main-content-program-list .next-img'); //다음 버튼

    let slideWidth = 370; //한개의 슬라이드 넓이
    let slideMargin = 0; //슬라이드간의 margin 값

    //전체 슬라이드 컨테이너 넓이 설정
    slides.style.width = (slideWidth + slideMargin) * slideCount + 'px';

    function moveSlide(num) {
        slides.style.left = -num * 370 + 'px';
        currentIdx = num;
    }

    if(slideImg.length <= 1){
        $('.main-content-program-list .part-left i.next-img').hide();
        $('.main-content-program-list .part-left i.prev-img').hide();
        $('.main-content-program-list .part-left ul.pagination-img').hide();
    }else{
        $('.main-content-program-list .part-left i.prev-img').hide();
        prev.addEventListener('click', function () {
            /*첫 번째 슬라이드로 표시 됐을때는
            이전 버튼 눌러도 아무런 반응 없게 하기 위해
            currentIdx !==0일때만 moveSlide 함수 불러옴 */

            if (currentIdx !== 0) {
                moveSlide(currentIdx - 1);

                $('.main-content-program-list .part-left i.next-img').css({'display':'inline-block'});
                $('.main-content-program-list .part-left i.prev-img').css({'display':'inline-block'});
                $('.main-content-program-list .part-left ul.pagination-img').css({'display':'flex'});

                $('.main-content-program-list .part-left li.first').addClass('focus');
                $('.main-content-program-list .part-left li.second').removeClass('focus');
                $('.main-content-program-list .part-left i.prev-img').hide();
                $('.main-content-program-list .part-left i.next-img').show();
            }

        });
        next.addEventListener('click', function () {
            /* 마지막 슬라이드로 표시 됐을때는
            다음 버튼 눌러도 아무런 반응 없게 하기 위해
            currentIdx !==slideCount -  일때만
            moveSlide 함수 불러옴 */
            if (currentIdx !== slideCount - 1) {
                moveSlide(currentIdx + 1);
            }
            $('.main-content-program-list .part-left li.first').removeClass('focus');
            $('.main-content-program-list .part-left li.second').addClass('focus');
            $('.main-content-program-list .part-left i.next-img').hide();
            $('.main-content-program-list .part-left i.prev-img').show();
        });
    }
}


//프로그램 관리
function programManage(){
    let slides = document.querySelector('.main-content-program-manage .img-slide'); //전체 슬라이드 컨테이너
    let slideImg = document.querySelectorAll('.main-content-program-manage .img-slide li'); //모든 슬라이드들
    let currentIdx = 0; //현재 슬라이드 index
    let slideCount = slideImg.length; // 슬라이드 개수
    let prev = document.querySelector('.main-content-program-manage .prev-img'); //이전 버튼
    let next = document.querySelector('.main-content-program-manage .next-img'); //다음 버튼

    let slideWidth = 370; //한개의 슬라이드 넓이
    let slideMargin = 0; //슬라이드간의 margin 값

    //전체 슬라이드 컨테이너 넓이 설정
    slides.style.width = (slideWidth + slideMargin) * slideCount + 'px';

    function moveSlide(num) {
        slides.style.left = -num * 370 + 'px';
        currentIdx = num;
    }

    if(slideImg.length <= 1){
        $('.main-content-program-manage .part-left i.next-img').hide();
        $('.main-content-program-manage .part-left i.prev-img').hide();
        $('.main-content-program-manage .part-left ul.pagination-img').hide();
    }else{
        $('.main-content-program-manage .part-left i.prev-img').hide();
        prev.addEventListener('click', function () {
            /*첫 번째 슬라이드로 표시 됐을때는
            이전 버튼 눌러도 아무런 반응 없게 하기 위해
            currentIdx !==0일때만 moveSlide 함수 불러옴 */

            if (currentIdx !== 0) {
                moveSlide(currentIdx - 1);

                $('.main-content-program-manage .part-left i.next-img').css({'display':'inline-block'});
                $('.main-content-program-manage .part-left i.prev-img').css({'display':'inline-block'});
                $('.main-content-program-manage .part-left ul.pagination-img').css({'display':'flex'});

                $('.main-content-program-manage .part-left li.first').addClass('focus');
                $('.main-content-program-manage .part-left li.second').removeClass('focus');
                $('.main-content-program-manage .part-left i.prev-img').hide();
                $('.main-content-program-manage .part-left i.next-img').show();
            }

        });
        next.addEventListener('click', function () {
            /* 마지막 슬라이드로 표시 됐을때는
            다음 버튼 눌러도 아무런 반응 없게 하기 위해
            currentIdx !==slideCount -  일때만
            moveSlide 함수 불러옴 */
            if (currentIdx !== slideCount - 1) {
                moveSlide(currentIdx + 1);
            }
            $('.main-content-program-manage .part-left li.first').removeClass('focus');
            $('.main-content-program-manage .part-left li.second').addClass('focus');
            $('.main-content-program-manage .part-left i.next-img').hide();
            $('.main-content-program-manage .part-left i.prev-img').show();
        });
    }
}




// 사용자------------------------------------------------------------------------------------------------
// 프로그램 상세
function detailProgramUser(){
    const slides = document.querySelector('.content-program-detail-user .img-slide'); //전체 슬라이드 컨테이너
    const slideImg = document.querySelectorAll('.content-program-detail-user .img-slide li'); //모든 슬라이드들
    let currentIdx = 0; //현재 슬라이드 index
    const slideCount = slideImg.length; // 슬라이드 개수
    const prev = document.querySelector('.content-program-detail-user .prev'); //이전 버튼
    const next = document.querySelector('.content-program-detail-user .next'); //다음 버튼

    if (matchMedia("screen and (min-width: 1200px)").matches){
        const slideWidth = 524; //한개의 슬라이드 넓이
        const slideMargin = 0; //슬라이드간의 margin 값

        //전체 슬라이드 컨테이너 넓이 설정
        slides.style.width = (slideWidth + slideMargin) * slideCount + 'px';

        function moveSlide(num) {
            slides.style.left = -num * 524 + 'px';
            currentIdx = num;
        }

        if(slideImg.length <= 1){
            $('.content-program-detail-user .part-left .part1 i.next').hide();
            $('.content-program-detail-user .part-left .part1 i.prev').hide();
            $('.content-program-detail-user .part-left .part1 ul.pagination').hide();
        }else{
            $('.content-program-detail-user .part-left .part1 i.prev').hide();
            prev.addEventListener('click', function () {
                /*첫 번째 슬라이드로 표시 됐을때는
                이전 버튼 눌러도 아무런 반응 없게 하기 위해
                currentIdx !==0일때만 moveSlide 함수 불러옴 */

                if (currentIdx !== 0) {
                    moveSlide(currentIdx - 1);

                    $('.content-program-detail-user .part-left .part1 i.next').css({'display':'inline-block'});
                    $('.content-program-detail-user .part-left .part1 i.prev').css({'display':'inline-block'});
                    $('.content-program-detail-user .part-left .part1 ul.pagination').css({'display':'flex'});

                    $('.content-program-detail-user .part-left .part1 ul.pagination li.first').addClass('focus');
                    $('.content-program-detail-user .part-left .part1 ul.pagination li.second').removeClass('focus');
                    $('.content-program-detail-user .part-left .part1 i.prev').hide();
                    $('.content-program-detail-user .part-left .part1 i.next').show();
                }

            });
            next.addEventListener('click', function () {
                /* 마지막 슬라이드로 표시 됐을때는
                다음 버튼 눌러도 아무런 반응 없게 하기 위해
                currentIdx !==slideCount - 1 일때만
                moveSlide 함수 불러옴 */
                if (currentIdx !== slideCount - 1) {
                    moveSlide(currentIdx + 1);
                }
                $('.content-program-detail-user .part-left .part1 ul.pagination li.first').removeClass('focus');
                $('.content-program-detail-user .part-left .part1 ul.pagination li.second').addClass('focus');
                $('.content-program-detail-user .part-left .part1 i.next').hide();
                $('.content-program-detail-user .part-left .part1 i.prev').show();
            });
        }
    }


    if (matchMedia("screen and (max-width: 1199px) and (min-width: 961px)").matches){
        const slideWidth = 455; //한개의 슬라이드 넓이
        const slideMargin = 0; //슬라이드간의 margin 값

        //전체 슬라이드 컨테이너 넓이 설정
        slides.style.width = (slideWidth + slideMargin) * slideCount + 'px';

        function moveSlide(num) {
            slides.style.left = -num * 455 + 'px';
            currentIdx = num;
        }

        if(slideImg.length <= 1){
            $('.content-program-detail-user .part-left .part1 i.next').hide();
            $('.content-program-detail-user .part-left .part1 i.prev').hide();
            $('.content-program-detail-user .part-left .part1 ul.pagination').hide();
        }else{
            $('.content-program-detail-user .part-left .part1 i.prev').hide();
            prev.addEventListener('click', function () {
                /*첫 번째 슬라이드로 표시 됐을때는
                이전 버튼 눌러도 아무런 반응 없게 하기 위해
                currentIdx !==0일때만 moveSlide 함수 불러옴 */

                if (currentIdx !== 0) {
                    moveSlide(currentIdx - 1);

                    $('.content-program-detail-user .part-left .part1 i.next').css({'display':'inline-block'});
                    $('.content-program-detail-user .part-left .part1 i.prev').css({'display':'inline-block'});
                    $('.content-program-detail-user .part-left .part1 ul.pagination').css({'display':'flex'});

                    $('.content-program-detail-user .part-left .part1 ul.pagination li.first').addClass('focus');
                    $('.content-program-detail-user .part-left .part1 ul.pagination li.second').removeClass('focus');
                    $('.content-program-detail-user .part-left .part1 i.prev').hide();
                    $('.content-program-detail-user .part-left .part1 i.next').show();
                }

            });
            next.addEventListener('click', function () {
                /* 마지막 슬라이드로 표시 됐을때는
                다음 버튼 눌러도 아무런 반응 없게 하기 위해
                currentIdx !==slideCount - 1 일때만
                moveSlide 함수 불러옴 */
                if (currentIdx !== slideCount - 1) {
                    moveSlide(currentIdx + 1);
                }
                $('.content-program-detail-user .part-left .part1 ul.pagination li.first').removeClass('focus');
                $('.content-program-detail-user .part-left .part1 ul.pagination li.second').addClass('focus');
                $('.content-program-detail-user .part-left .part1 i.next').hide();
                $('.content-program-detail-user .part-left .part1 i.prev').show();
            });
        }
    }


    if (matchMedia("screen and (max-width: 960px)").matches){
        const slideWidth = 100; //한개의 슬라이드 넓이
        const slideMargin = 0; //슬라이드간의 margin 값

        //전체 슬라이드 컨테이너 넓이 설정
        slides.style.width = (slideWidth + slideMargin) * slideCount + 'vw';

        function moveSlide(num) {
            slides.style.left = -num * 100 + 'vw';
            currentIdx = num;
        }

        if(slideImg.length <= 1){
            $('.content-program-detail-user .part-left .part1 i.next').hide();
            $('.content-program-detail-user .part-left .part1 i.prev').hide();
            $('.content-program-detail-user .part-left .part1 ul.pagination').hide();
        }else{
            $('.content-program-detail-user .part-left .part1 i.prev').hide();
            prev.addEventListener('click', function () {
                /*첫 번째 슬라이드로 표시 됐을때는
                이전 버튼 눌러도 아무런 반응 없게 하기 위해
                currentIdx !==0일때만 moveSlide 함수 불러옴 */

                if (currentIdx !== 0) {
                    moveSlide(currentIdx - 1);

                    $('.content-program-detail-user .part-left .part1 i.next').css({'display':'inline-block'});
                    $('.content-program-detail-user .part-left .part1 i.prev').css({'display':'inline-block'});
                    $('.content-program-detail-user .part-left .part1 ul.pagination').css({'display':'flex'});

                    $('.content-program-detail-user .part-left .part1 ul.pagination li.first').addClass('focus');
                    $('.content-program-detail-user .part-left .part1 ul.pagination li.second').removeClass('focus');
                    $('.content-program-detail-user .part-left .part1 i.prev').hide();
                    $('.content-program-detail-user .part-left .part1 i.next').show();
                }

            });
            next.addEventListener('click', function () {
                /* 마지막 슬라이드로 표시 됐을때는
                다음 버튼 눌러도 아무런 반응 없게 하기 위해
                currentIdx !==slideCount - 1 일때만
                moveSlide 함수 불러옴 */
                if (currentIdx !== slideCount - 1) {
                    moveSlide(currentIdx + 1);
                }
                $('.content-program-detail-user .part-left .part1 ul.pagination li.first').removeClass('focus');
                $('.content-program-detail-user .part-left .part1 ul.pagination li.second').addClass('focus');
                $('.content-program-detail-user .part-left .part1 i.next').hide();
                $('.content-program-detail-user .part-left .part1 i.prev').show();
            });
        }
    }
}
