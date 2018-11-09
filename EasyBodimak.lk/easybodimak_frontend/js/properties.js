/* JS Document */

/******************************

[Table of Contents]

1. Vars and Inits
2. Set Header
3. Init Menu


******************************/

$(document).ready(function()
{
	$("#noresults").hide();
    const urlParams = new URLSearchParams(window.location.search);
    var search = urlParams.get("location");
    document.getElementById("searchlocation").innerHTML = search;
    console.log(search)
	if (search==null){
        loadAllAds();
	} else {
        loadAdsinCity();
	}

	"use strict";

	/*

	1. Vars and Inits

	*/

	var header = $('.header');
	var menu = $('.menu');
	var menuActive = false;
	var ctrl = new ScrollMagic.Controller();

	setHeader();

	$(window).on('resize', function()
	{
		setHeader();

		setTimeout(function()
		{
			$(window).trigger('resize.px.parallax');
		}, 375);
	});

	$(document).on('scroll', function()
	{
		setHeader();
	});

	initMenu();

	/*

	2. Set Header

	*/

	function setHeader()
	{
		if($(window).scrollTop() > 127)
		{
			header.addClass('scrolled');
		}
		else
		{
			header.removeClass('scrolled');
		}
	}

	/*

	3. Init Menu

	*/

	function initMenu()
	{
		if($('.hamburger').length && $('.menu').length)
		{
			var hamb = $('.hamburger');
			var close = $('.menu_close_container');

			hamb.on('click', function()
			{
				if(!menuActive)
				{
					openMenu();
				}
				else
				{
					closeMenu();
				}
			});

			close.on('click', function()
			{
				if(!menuActive)
				{
					openMenu();
				}
				else
				{
					closeMenu();
				}
			});


		}
	}

	function openMenu()
	{
		menu.addClass('active');
		menuActive = true;
	}

	function closeMenu()
	{
		menu.removeClass('active');
		menuActive = false;
	}




});

function loadAllAds() {
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
            var location = ad.location
            var price = ad.price;
            var category = ad.category;
            var bedrooms = ad.noOfBedrooms;
            var bathrooms = ad.noOfBathrooms;

            var html = "<div class=\"col-xl-4 col-lg-6 property_col\">\n" +
                "\t\t\t\t\t<div class=\"property\" id=\"properties\">\n" +
                "\t\t\t\t\t\t<div class=\"property_image\">\n" +
                "\t\t\t\t\t\t\t<img src=\"images/property_1.jpg\" alt=\"\"/>\n" +
                "<div class=\"tag_featured property_tag\" id=\"adsid\" hidden>"+adid+"</div>"+
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"property_body text-center\">\n" +
                "\t\t\t\t\t\t\t<div class=\"property_location\" id=\"location\">"+location+"</div>\n" +
                "\t\t\t\t\t\t\t<div class=\"property_title\"><a id=\"title\" href=\"property.html\?kcufuoy="+adid+"\">"+title+"</a></div>\n" +
                "\t\t\t\t\t\t\t<div class=\"property_price\" id=\"price\">"+price+"</div>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"property_footer d-flex flex-row align-items-center justify-content-start\">\n" +
                "\t\t\t\t\t\t\t<div class=\"col-\"><div class=\"property_icon\"><img src=\"images/icon_1.png\" alt=\"\"/></div><span id=\"category\">"+category+"</span></div>\n" +
                "\t\t\t\t\t\t\t<div class=\"col-\"><div class=\"property_icon\"><img src=\"images/icon_2.png\" alt=\"\"/></div><span id=\"bedrooms\">"+bedrooms+" Bedrooms</span></div>\n" +
                "\t\t\t\t\t\t\t<div class=\"col-\"><div class=\"property_icon\"><img src=\"images/icon_3.png\" alt=\"\"/></div><span id=\"bathrooms\">"+bathrooms+" Bathrooms</span></div>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>";

            $("#mainad").append(html);
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

    })

}

function loadAdsinCity() {
    console.log("adsincity")
    var location=document.getElementById("searchlocation").innerText;
    var ajaxConfig = {
        method: "GET",
        url: "http://localhost:8080/ads/location/"+location,
        async: true
    };

    $.ajax(ajaxConfig).done(function (response) {
    	console.log(response)
    	console.log(response===undefined || response.length == 0)

    	if (response===undefined || response.length == 0){
            $("#noresults").show();
		}else {
            response.forEach(function (ad) {
                var adid = ad.ad_id;
                var date = ad.ad_date;
                // var email = ad.uemail;
                var title = ad.title;
                var location = ad.location
                var price = ad.price;
                var category = ad.category;
                var bedrooms = ad.noOfBedrooms;
                var bathrooms = ad.noOfBathrooms;

                var html = "<div class=\"col-xl-4 col-lg-6 property_col\">\n" +
                    "\t\t\t\t\t<div class=\"property\" id=\"properties\">\n" +
                    "\t\t\t\t\t\t<div class=\"property_image\">\n" +
                    "\t\t\t\t\t\t\t<img src=\"images/property_1.jpg\" alt=\"\"/>\n" +
                    "<div class=\"tag_featured property_tag\" id=\"adsid\" hidden>"+adid+"</div>"+
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t<div class=\"property_body text-center\">\n" +
                    "\t\t\t\t\t\t\t<div class=\"property_location\" id=\"location\">"+location+"</div>\n" +
                    "\t\t\t\t\t\t\t<div class=\"property_title\"><a id=\"title\" href=\"property.html\?kcufuoy="+adid+"\">"+title+"</a></div>\n" +
                    "\t\t\t\t\t\t\t<div class=\"property_price\" id=\"price\">"+price+"</div>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t<div class=\"property_footer d-flex flex-row align-items-center justify-content-start\">\n" +
                    "\t\t\t\t\t\t\t<div class=\"col-\"><div class=\"property_icon\"><img src=\"images/icon_1.png\" alt=\"\"/></div><span id=\"category\">"+category+"</span></div>\n" +
                    "\t\t\t\t\t\t\t<div class=\"col-\"><div class=\"property_icon\"><img src=\"images/icon_2.png\" alt=\"\"/></div><span id=\"bedrooms\">"+bedrooms+" Bedrooms</span></div>\n" +
                    "\t\t\t\t\t\t\t<div class=\"col-\"><div class=\"property_icon\"><img src=\"images/icon_3.png\" alt=\"\"/></div><span id=\"bathrooms\">"+bathrooms+" Bathrooms</span></div>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>";

                $("#mainad").append(html);
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
		}
    })
}

