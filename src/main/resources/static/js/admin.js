$(document).ready(function () {
    validateChangePasswordForm();

    $('#image').change(function() {
        loadImage(this, 'image_view');
    });


});


function showError(id, message) {
    let element = $('#' + id);
    let error = $('#' + id + "_errors");
    element.addClass("input_error");
    error.text(message);
}

function hideError(id) {
    let element = $('#' + id);
    element.removeClass('input_error');
    let error = $('#' + id + "_errors");
    error.text('');
}


function loadImage(input, image_view) {
    if (input.files && input.files[0]) {
        let reader = new FileReader();
        reader.onload = function(e) {
            $('#' + image_view).attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}


/**
 * Change password section
 *
 */
//ChangePassword
function changePassword() {
    let changePasswordModal = $('#changePasswordModal');
    changePasswordModal.modal('show');
    let data = {};
    $('#changePassBtn').click(function () {
        $('.error').text('');
        let passwordOld = $('#passwordOld');
        let passwordNew = $('#passwordNew');
        let confirmPassword = $('#confirmPassword');
        data['passwordOld'] = passwordOld.val();
        data['passwordNew'] = passwordNew.val();
        data['confirmPassword'] = confirmPassword.val();
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            dataType: 'JSON',
            url: '/changePassword',
            data: JSON.stringify(data),
            cache: false,
            timeout: 60000,
            success: function (data) {
                if (data.status === 200) {
                    passwordOld.val('');
                    passwordNew.val('');
                    confirmPassword.val('');
                    changePasswordModal.modal('hide');
                } else {
                    let arrError = data.errors;
                    for (let i = 0; i < arrError.length; i++) {
                        showError(arrError[i].field, arrError[i].message);
                    }
                }
            }
        });
    });
}

function validateChangePasswordForm() {

    $('#passwordOld').keyup(function () {
        hideError('passwordOld');
    });
    $('#passwordNew').keyup(function () {
        hideError('passwordNew');
    });
    $('#confirmPassword').keyup(function () {
        hideError('confirmPassword');
    });
}

/**
 * Logout
 */
function Logout() {
    let logoutModal = $('#logoutConfirm');
    logoutModal.modal('show');
    $('#logoutBtn').click(function () {
        logoutModal.modal('hide');
        window.location.href = window.location.origin + '/logout';

    });
}


