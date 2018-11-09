/* JS Document */

/******************************

[Table of Contents]

1. Vars and Inits
2. Set Header
3. Init Menu
4. Init Intro Slider
5. Init Price Slider
6. Init Google Map


******************************/

$(document).ready(function(){

    const urlParams = new URLSearchParams(window.location.search);
    var search = urlParams.get("kcufuoy");
    document.getElementById("adsid").innerHTML = search;
    console.log(search)
    loadAdDetails();
	"use strict";

	/*

	1. Vars and Inits

	*/

	var header = $('.header');
	var menu = $('.menu');
	var menuActive = false;
	var ctrl = new ScrollMagic.Controller();
	var map;

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
	initIntroSlider();
	initPriceSlider();
	initGoogleMap();

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

	/*

	4. Init Intro Slider

	*/

	function initIntroSlider()
	{
		if($('.intro_slider').length)
		{
			var introSlider = $('.intro_slider');
			introSlider.owlCarousel(
			{
				items:1,
				loop:true,
				autoplay:false,
				smartSpeed:1200,
				dots:false,
				nav:false
			});

			if($('.intro_slider_prev').length)
			{
				var prev = $('.intro_slider_prev');
				prev.on('click', function()
				{
					introSlider.trigger('prev.owl.carousel');
				});
			}

			if($('.intro_slider_next').length)
			{
				var next = $('.intro_slider_next');
				next.on('click', function()
				{
					introSlider.trigger('next.owl.carousel');
				});
			}
		}
	}

	/*

	5. Init Price Slider

	*/

    function initPriceSlider()
    {
		$('input[type="range"]').rangeslider(
		{
			// Feature detection the default is `true`.
			// Set this to `false` if you want to use
			// the polyfill also in Browsers which support
			// the native <input type="range"> element.
			polyfill: false,

			// Default CSS classes
			rangeClass: 'rangeslider',
			disabledClass: 'rangeslider--disabled',
			horizontalClass: 'rangeslider--horizontal',
			verticalClass: 'rangeslider--vertical',
			fillClass: 'rangeslider__fill',
			handleClass: 'rangeslider__handle',

			// Callback function
			onInit: function() {},

			// Callback function
			onSlide: function(position, value) {},

			// Callback function
			onSlideEnd: function(position, value) {}
		});
    }

    /*

	6. Init Google Map

	*/

	function initGoogleMap()
	{
		var myLatlng = new google.maps.LatLng(36.286728,-5.278741);
    	var mapOptions =
    	{
    		center: myLatlng,
	       	zoom: 17,
			mapTypeId: google.maps.MapTypeId.ROADMAP,
			draggable: true,
			scrollwheel: false,
			zoomControl: true,
			zoomControlOptions:
			{
				position: google.maps.ControlPosition.RIGHT_CENTER
			},
			mapTypeControl: false,
			scaleControl: false,
			streetViewControl: false,
			rotateControl: false,
			fullscreenControl: true,
			styles:
			[

			]
    	}

    	// Initialize a map with options
    	map = new google.maps.Map(document.getElementById('map'), mapOptions);

		// Re-center map after window resize
		google.maps.event.addDomListener(window, 'resize', function()
		{
			setTimeout(function()
			{
				google.maps.event.trigger(map, "resize");
				map.setCenter(myLatlng);
			}, 1400);
		});
	}



});

function loadAdDetails() {
    console.log("loading")
	var adid=document.getElementById("adsid").innerHTML
	console.log(adid)
    var ajaxConfig1 = {
        method: "GET",
        url: "http://localhost:8080/ads/"+adid,
        async: true
    };

    $.ajax(ajaxConfig1).done(function (response) {
    	console.log(response)
    	var userId = response.userid;
    	var bedrooms = response.noOfBedrooms;
    	var bathrooms = response.noOfBathrooms;
    	var location = response.location;
    	var price = response.price;
    	var description = response.description;
    	var title = response.title;
    	var date = response.ad_date;
    	var category = response.category;

    	console.log(userId)


		$("#ademail").val(userId);
    	document.getElementById("uid").innerText = userId;
    	document.getElementById("adbedrooms").innerHTML = bedrooms;
    	document.getElementById("adbathrooms").innerHTML = bathrooms;
    	document.getElementById("adlocation").innerHTML = location;
    	document.getElementById("adcategory").innerHTML = category;
    	document.getElementById("addescription").innerHTML = description;
		document.getElementById("adprice").innerHTML = price;
		document.getElementById("adtitle").innerHTML = title;
    	loadUserDetails(userId);
    });
}

function loadUserDetails(userId) {
    console.log("loadAllDetails")
	var uid=document.getElementById("uid").innerText;
    var ajaxConfig1 = {
        method: "GET",
        url: "http://localhost:8080/users/"+uid,
        async: true
    };

    $.ajax(ajaxConfig1).done(function (response) {
        console.log(response)
        var name = response.name;
        var address = response.address;
        var tel = response.tel;
        var email = response.email;
        $("#ademail").val(email);
        $("#adname").val(name);
        $("#adaddress").val(address);
        $("#adtel").val(tel);
    });
}

