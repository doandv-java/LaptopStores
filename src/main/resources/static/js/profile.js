$(document).ready(function () {
    $('#submitBtn').click(function () {
        let profile = getDataProfile();
        $.ajax({
            type: 'POST',
            url: '/admin/profile',
            contentType: false,
            processData: false,
            data: profile
        });
    });
});

function getDataProfile() {
    let emptyFile = new File([], "test.png", {type: 'image/jpg'});
    let name = $('#name');
    let id = $('#id');
    let userName = $('#userName');
    let birthDay = $('#birthDay');
    let phone = $('#phone');
    let address = $('#address');
    let role = $('#role');
    let imageLink = $('#imageLink');
    let state = $('#state');
    let deleted = $('#deleted');
    let userNameOld = $('#userNameOld');
    let profile = new FormData();
    profile.set('id', id.val());
    profile.set('userName', userName.val());
    profile.set('role', role.val());
    profile.set('name',name.val());
    profile.set('birthDay',birthDay.val());
    profile.set('gender',$('#gender option:selected').val());
    profile.set('address',address.val());
    profile.set('phone', phone.val());
    profile.set('imageLink', imageLink.val());
    profile.set('image', $('#image').prop('files')[0] == null ? emptyFile : $('#image').prop('files')[0]);
    profile.set('state', state.val());
    profile.set('deleted', deleted.val());
    profile.set('userNameOld', userNameOld.val());
    return profile;
}

