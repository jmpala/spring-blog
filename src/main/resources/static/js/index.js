$(document).ready(function(){
    $('.index-carousel').slick({
        autoplay    :true,
        arrows      :false,
        dots        :true,
        appendDots  :$(".index-carousel"),
        fade        :true,
    });

    $(function () {
        $('.kiss-pop').tooltip()();
      })
  });