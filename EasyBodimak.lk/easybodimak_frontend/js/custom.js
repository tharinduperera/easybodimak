/* JS Document */

/******************************

 [Table of Contents]

 1. Vars and Inits
 2. Set Header
 3. Init Menu
 4. Init Home Slider
 5. Init Recent Slider


 ******************************/

$(document).ready(function () {
    adsinCity();
    maponClick();
    "use strict";

    /*

    1. Vars and Inits

    */

    var header = $('.header');
    var menu = $('.menu');
    var menuActive = false;

    setHeader();

    $(window).on('resize', function () {
        setHeader();

        setTimeout(function () {
            $(window).trigger('resize.px.parallax');
        }, 375);
    });

    $(document).on('scroll', function () {
        setHeader();
    });

    initMenu();
    initHomeSlider();
    // initRecentSlider();
    loadAllAd()

    /*

    2. Set Header

    */

    function setHeader() {
        if ($(window).scrollTop() > 127) {
            header.addClass('scrolled');
        }
        else {
            header.removeClass('scrolled');
        }
    }

    /*

    3. Init Menu

    */

    function initMenu() {
        if ($('.hamburger').length && $('.menu').length) {
            var hamb = $('.hamburger');
            var close = $('.menu_close_container');

            hamb.on('click', function () {
                if (!menuActive) {
                    openMenu();
                }
                else {
                    closeMenu();
                }
            });

            close.on('click', function () {
                if (!menuActive) {
                    openMenu();
                }
                else {
                    closeMenu();
                }
            });


        }
    }

    function openMenu() {
        menu.addClass('active');
        menuActive = true;
    }

    function closeMenu() {
        menu.removeClass('active');
        menuActive = false;
    }

    /*

    4. Init Home Slider

    */

    function initHomeSlider() {
        if ($('.home_slider').length) {
            var homeSlider = $('.home_slider');
            homeSlider.owlCarousel(
                {
                    items: 1,
                    autoplay: false,
                    loop: true,
                    smartSpeed: 1200,
                    nav: false,
                    dots: false,
                    mouseDrag: false
                });
        }
    }

    /*

    5. Init Recent Slider

    */

    function initRecentSlider() {
        if ($('.recent_slider').length) {
            var recentSlider = $('.recent_slider');
            recentSlider.owlCarousel(
                {
                    items: 3,
                    autoplay: false,
                    loop: true,
                    smartSpeed: 1200,
                    nav: false,
                    dots: false,
                    responsive:
                        {
                            0:
                                {
                                    items: 1
                                },
                            991:
                                {
                                    items: 2
                                },
                            1199:
                                {
                                    items: 3
                                }
                        }
                });

            if ($('.recent_slider_prev').length) {
                var prev = $('.recent_slider_prev');
                prev.on('click', function () {
                    recentSlider.trigger('prev.owl.carousel');
                });
            }

            if ($('.recent_slider_next').length) {
                var next = $('.recent_slider_next');
                next.on('click', function () {
                    recentSlider.trigger('next.owl.carousel');
                });
            }
        }
    }

    function loadAllAd() {
        console.log("loading")
        var ajaxConfig = {
            method: "GET",
            url: "http://localhost:8080/ads/approved",
            async: true
        };

        $.ajax(ajaxConfig).done(function (response) {
            response.forEach(function (ad) {
                var adid = ad.ad_id;
                var date = ad.ad_date;
                // var email = ad.uemail;
                var title = ad.title;
                var location = ad.location;
                var price = ad.price;
                var category = ad.category;
                var bedrooms = ad.noOfBedrooms;
                var bathrooms = ad.noOfBathrooms;

                var html1 = " <div class=\"owl-item\">\n" +
                    "                            <div class=\"recent_item\">\n" +
                    "                                <div class=\"recent_item_inner\">\n" +
                    "                                    <div class=\"recent_item_image\">\n" +
                    "                                        <img src=\"images/property_1.jpg\"/>\n" +
                    "                                        <div class=\"tag_featured property_tag\" id=\"adid\" hidden>" + adid + "</div>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"recent_item_body text-center\">\n" +
                    "                                        <div class=\"recent_item_location\" id=\"adlocation\">" + location + "</div>\n" +
                    "                                        <div class=\"recent_item_title\"><a id=\"title\" href=\"property.html\?kcufuoy=" + adid + "\">" + title + "</a>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"recent_item_price\" id=\"adprice\">" + price + "</div>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"recent_item_footer d-flex flex-row align-items-center justify-content-start\">\n" +
                    "                                        <div>\n" +
                    "                                            <div class=\"recent_icon\"><img src=\"images/icon_1.png\" alt=\"\"/></div>\n" +
                    "                                            <span id=\"adcategory\"></span>" + category + "</div>\n" +
                    "                                        <div>\n" +
                    "                                            <div class=\"recent_icon\"><img src=\"images/icon_2.png\" alt=\"\"/></div>\n" +
                    "                                            <span id=\"adbedrooms\">" + bedrooms + "</span></div>\n" +
                    "                                        <div>\n" +
                    "                                            <div class=\"recent_icon\"><img src=\"images/icon_3.png\" alt=\"\"/></div>\n" +
                    "                                            <span id=\"adbatnrooms\"></span>" + bathrooms + "</div>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>";

                $("#mainads").append(html1);
                console.log(date)
                // document.getElementById("properties")
                //     document.getElementById("location").innerHTML = location
                //     document.getElementById("title").innerHTML = title
                //     document.getElementById("price").innerHTML = price
                //     document.getElementById("category").innerHTML = category
                //     document.getElementById("bedrooms").innerHTML = bedrooms
                //     document.getElementById("bathrooms").innerHTML = bathrooms
                //

            });

            initRecentSlider()

        })

    }
});

// handle map
function set_default_map() {
    let default_img = document.getElementById('slmap');
    default_img.setAttribute("src", "./images/slmap.png");
}

function set_new_map(type) {
    let default_img = document.getElementById('slmap');
    switch (type) {
        case type:
            default_img.setAttribute("src", "./images/" + type + ".png");
            break;
        default :
            default_img.setAttribute("src", "./images/slmap.png");
    }
}

function mapMouseEntered(id) {
    switch (id) {
        case id :
            set_new_map(id.replace("map", ''));
            break;
    }
}

function mapmouseLeave() {
    set_default_map();
}



function adsinCity() {

    $('.city_title').click(function () {

        console.log($('.city_title').index(this))
        var index = $('.city_title').index(this);
        var locationList = document.getElementsByClassName("city_title")
        console.log(locationList[index].innerHTML)
        var location = locationList[index].innerHTML;

        window.location.href = "boardinghouses.html?"+"location="+location;
    })
}

function maponClick() {
    $('.mapLocation').click(function () {
        console.log($('.mapLocation').index(this))
        var index = $('.mapLocation').index(this);
        var locationList = document.getElementsByClassName("mapLocation")
        console.log(locationList[index].innerHTML)
        var location = locationList[index].innerHTML;

        window.location.href = "boardinghouses.html?"+"location="+location;
    })
}

