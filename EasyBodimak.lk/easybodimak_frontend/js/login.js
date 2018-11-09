$(function () {
    $('.button-checkbox').each(function () {
        var $widget = $(this),
            $button = $widget.find('button'),
            $checkbox = $widget.find('input:checkbox'),
            color = $button.data('color'),
            settings = {
                on: {
                    icon: 'glyphicon glyphicon-check'
                },
                off: {
                    icon: 'glyphicon glyphicon-unchecked'
                }
            };

        $button.on('click', function () {
            $checkbox.prop('checked', !$checkbox.is(':checked'));
            $checkbox.triggerHandler('change');
            updateDisplay();
        });

        $checkbox.on('change', function () {
            updateDisplay();
        });

        function updateDisplay() {
            var isChecked = $checkbox.is(':checked');
            // Set the button's state
            $button.data('state', (isChecked) ? "on" : "off");

            // Set the button's icon
            $button.find('.state-icon')
                .removeClass()
                .addClass('state-icon ' + settings[$button.data('state')].icon);

            // Update the button's color
            if (isChecked) {
                $button
                    .removeClass('btn-default')
                    .addClass('btn-' + color + ' active');
            }
            else {
                $button
                    .removeClass('btn-' + color + ' active')
                    .addClass('btn-default');
            }
        }

        function init() {
            updateDisplay();
            // Inject the icon if applicable
            if ($button.find('.state-icon').length == 0) {
                $button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i> ');
            }
        }

        init();
    });
});

$('#btnRegister').click(function () {
    $('#myModal').modal('hide')
});

$('#btnSignin1').click(function () {
    $('#myModal1').modal('hide');
});

$('#btnRegister1').click(function () {
    console.log("btnRegister1")
    var name = $('#name').val();
    var address = $('#address').val();
    var tel = $('#tel').val();
    var email = $('#email1').val();
    var password = $('#password1').val();
    var date = $('#date').val();

    var ajaxConfig = {
        method: "PUT",
        url: "http://localhost:8080/users",
        data: JSON.stringify({
            "email": email,
            "address": address,
            "name": name,
            "password": password,
            "registerDate": date,
            "tel": tel
        }),
        contentType: 'application/json',
        async: true
    };

    $.ajax(ajaxConfig).done(function (response) {
        console.log("asd")
        alert("Your Account has been successfully created!!!");
        location.href = "ad.html";
    });
});

n = new Date();
y = n.getFullYear();
m = n.getMonth() + 1;
d = n.getDate();
// document.getElementById("date").innerHTML = m + "/" + d + "/" + y;

$('#btnSignin').click(function () {
    console.log("sign")
    var email = $('#email').val();
    var password = $('#password').val();
    var ajaxConfig = {
        method: "POST",
        url: "http://localhost:8080/users/login",
        data: JSON.stringify({"email": email, "password": password}),
        contentType: 'application/json',
        async: true
    };

    $.ajax(ajaxConfig).done(function (response) {
        if (response) {

            window.location = "ad.html?"+"uid="+response;
        } else {
            alert("Invalid Username or password .!")
        }
    });

});
