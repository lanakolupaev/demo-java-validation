$(document ).ready(function() {
    $('#registrationForm').validate({
        rules: {
            username: {
                minlength: 5,
                maxlength: 50,
                pattern: "^[A-Za-z0-9]+$",
                required: true,
                remote: {
                    url: "availability",
                    type: "post",
                    data: {
                        username: function() {
                            return $( "#usernameInput" ).val();
                        }
                    }
                }
            },
            password: {
                minlength: 8,
                maxlength: 50,
                pattern: "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).+$",
                required: true
            }
        },
        highlight: function (element) {
            var id_attr = "#" + $( element ).attr("id") + "Feedback";
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
            $(id_attr).removeClass('glyphicon-ok').addClass('glyphicon-remove');

        },
        unhighlight: function (element) {
            var id_attr = "#" + $( element ).attr("id") + "Feedback";
            $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
            $(id_attr).removeClass('glyphicon-remove').addClass('glyphicon-ok');
        },
        errorElement: 'small',
        errorClass: 'help-block',
        errorPlacement: function (error, element) {
            if (element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        },
        messages: {
            username: {
                required: "Should not be empty",
                minlength: $.validator.format("Enter at least {0} characters"),
                pattern: "Should contain letters and numbers only",
                remote: $.validator.format("{0} is not available, try another username")
            },
            password: {
                required: "Should not be empty",
                minlength: $.validator.format("Enter at least {0} characters"),
                pattern: "Should contain numbers, lowercase and uppercase characters"
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });

});