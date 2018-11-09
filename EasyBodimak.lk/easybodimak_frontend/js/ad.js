$(document).ready(function() {

    const urlParams = new URLSearchParams(window.location.search);
    var idUrl = urlParams.get("uid");
    document.getElementById("userID").innerHTML = idUrl;
    console.log("userid="+idUrl)
    loadUserDetails();
})
function onFileSelected(event) {
    var selectedFile = event.target.files[0];
    var reader = new FileReader();

    var imgtag = document.getElementById("adimg");
    //imgtag.title = selectedFile.name;

    reader.onload = function(event) {
        imgtag.src = event.target.result;
    };

    reader.readAsDataURL(selectedFile);
}

function onFileSelected1(event) {
    var selectedFile = event.target.files[0];
    var reader = new FileReader();

    var imgtag = document.getElementById("adimg1");
    //imgtag.title = selectedFile.name;

    reader.onload = function(event) {
        imgtag.src = event.target.result;
    };

    reader.readAsDataURL(selectedFile);
}

function onFileSelected2(event) {
    var selectedFile = event.target.files[0];
    var reader = new FileReader();

    var imgtag = document.getElementById("adimg2");
    //imgtag.title = selectedFile.name;

    reader.onload = function(event) {
        imgtag.src = event.target.result;
    };

    reader.readAsDataURL(selectedFile);
}

function onFileSelected3(event) {
    var selectedFile = event.target.files[0];
    var reader = new FileReader();

    var imgtag = document.getElementById("adimg3");
    //imgtag.title = selectedFile.name;

    reader.onload = function(event) {
        imgtag.src = event.target.result;
    };

    reader.readAsDataURL(selectedFile);
}

function onFileSelected4(event) {
    var selectedFile = event.target.files[0];
    var reader = new FileReader();

    var imgtag = document.getElementById("adimg4");
    //imgtag.title = selectedFile.name;

    reader.onload = function(event) {
        imgtag.src = event.target.result;
    };

    reader.readAsDataURL(selectedFile);
}


$('#btnpost').click(function () {
    console.log("post")
    var title = $('#ad_title').val();
    var category =$('#ad_category').val();
    var description =$('#ad_description').val();
    var location =$('#ad_location').val();
    var bathroms =$('#ad_bathrooms').val();
    var bedrooms =$('#ad_bedrooms').val();
    var price = $('#ad_price').val();
    var userId = document.getElementById("userID").innerHTML
    console.log(userId)


    var ajaxConfig = {
        method: "PUT",
        url: "http://localhost:8080/ads",
        data: JSON.stringify({
            "userid": userId,
            "title": title,
            "ad_date": "",
            "description": description,
            "location": location,
            "category": category,
            "noOfBedrooms": bedrooms,
            "noOfBathrooms": bathroms,
            "price": price,
            "map": "map",
            "image": ["img1","img2"],
            "status": ""
        }),
        contentType: 'application/json',
        async: true
    };

    $.ajax(ajaxConfig).done(function (response) {

            console.log(response)
            alert("Added Successs.! Your Ad will be Posted in few Minutes!!")
           // location.href = "ad.html";
    });

});

function loadUserDetails() {
    console.log("loading")
    var userId = document.getElementById("userID").innerHTML
    var ajaxConfig1 = {
        method: "GET",
        url: "http://localhost:8080/users/"+userId,
        async: true
    };

    $.ajax(ajaxConfig1).done(function (response) {
        console.log(response)
        var userId = response.userId;
        var name = response.name;
        var address = response.address;
        var tel = response.tel;
        var email = response.email;
        document.getElementById("username").innerHTML = name;
        document.getElementById("useremail").innerHTML = email;
        document.getElementById("useraddress").innerHTML = address;
        document.getElementById("usertel").innerHTML = tel;
    });
}
