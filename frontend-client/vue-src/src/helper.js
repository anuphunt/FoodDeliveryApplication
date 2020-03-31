module.exports = class Helper {
    
    getUserInfo () {
            var userInfo = {
                identity: '',
                userToken: '',
                firstName: '',
                lastName: '',
                email: '',
                profilePic: '',
            };
            var userInfoLocal = JSON.parse(localStorage.getItem('userInfo'));
            if (typeof (userInfoLocal) === 'object') {
                if (userInfoLocal !== null) {
                    if (typeof (userInfo.identity) !== 'undefined') {
                        if (userInfoLocal.identity !== '') {
                            userInfo.identity = userInfoLocal.identity;
                        }
                    }
                    if (typeof (userInfo.userToken) !== 'undefined') {
                        if (userInfoLocal.userToken !== '') {
                            userInfo.userToken = userInfoLocal.userToken;
                        }
                    }
                    if (typeof (userInfo.firstName) !== 'undefined') {
                        if (userInfoLocal.firstName !== '') {
                            userInfo.firstName = userInfoLocal.firstName;
                        }
                    }
                    if (typeof (userInfo.lastName) !== 'undefined') {
                        if (userInfoLocal.lastName !== '') {
                            userInfo.lastName = userInfoLocal.lastName;
                        }
                    }
                    if (typeof (userInfo.email) !== 'undefined') {
                        if (userInfoLocal.email !== '') {
                            userInfo.email = userInfoLocal.email;
                        }
                    }
                    if (typeof (userInfo.profilePic) !== 'undefined') {
                        if (userInfoLocal.profilePic !== '') {
                            userInfo.profilePic = userInfoLocal.profilePic;
                        }
                    }
                }

            }
            return userInfo;
    }
    setUserNewToken = function (newToken) {
        var userInfo = this.getUserInfo();
        if (userInfo.identity != '') {
            var userInfoLocal = JSON.parse(localStorage.getItem('userInfo'));
            userInfoLocal.userToken = newToken;
            this.set_userInfo(userInfoLocal);
        }
    }
    unsetUserInfo() {
        localStorage.removeItem('userInfo');
    }
    set_userInfo(datas) {  
        localStorage.setItem('userInfo', JSON.stringify(datas));
    }
    getFormData(formData){
        formData.append('identity',this.getUserInfo().identity);
        formData.append('userToken',this.getUserInfo().userToken);

        return formData;
    }
    request(params) {

            if (typeof (params) === 'undefined') {
                alert('Empty parameter found.');
            } else {

                var formData = new FormData();
                if (typeof (params.data) !== 'undefined') {
                    formData = this.getFormData(params.data);
                }

                
                

                if (typeof (params.url) === 'undefined') {
                    alert('Api is missing');
                } else {
                    if (typeof(params.beforeSend) == 'function') {
                        params.beforeSend();
                    }
                    var method = 'POST';
                    if (typeof (params.type) !== 'undefined') {
                        method = params.type;
                    }
                    if (typeof(params.success) == 'function') {//start

                        if (window.$) {

                            window.$.ajax({
                                dataType: 'json',
                                url: params.url,
                                type: method,
                                cache: false,
                                contentType: false,
                                processData: false,
                                data: formData,
                                xhr: function () {
                                    var myXhr = window.$.ajaxSettings.xhr();
                                    if (typeof(params.uploadProgress) == 'function') {
                                        if (myXhr.upload) {
                                            myXhr.upload.addEventListener('progress', function (e) {
                                                var uploaded = e.loaded;
                                                var total_size = e.total;
                                                var percentage = (uploaded / total_size) * 100;
                                                if (percentage > 100) {
                                                    percentage = 100;
                                                }
                                                var return_datas = {
                                                    uploaded: uploaded,
                                                    total_size: total_size,
                                                    uploading_percent: percentage,
                                                };
                                                params.uploadProgress(return_datas);
                                            }, false);
                                        }
                                    }
                                    return myXhr;
                                },
                                complete:  (resp) =>{

                                    if(resp.status == 403 && this.getUserInfo().identity == ''){
                                        this.unsetUserInfo();
                                        window.location.href = '/';
                                    }else if (typeof(params.complete) == 'function') {
                                        params.complete(resp);
                                    }
                                },
                                success:  (resp) =>{
                                    if (typeof(params.success) == 'function') {
                                        params.success(resp);
                                    }
                                }
                            })
                        } else {
                            console.log('jquery not loaded');
                        }

                    }//end      

                }
            }
    }
    scroll_to_bottom(selector) {
        var objDiv = document.querySelector(selector);
        if (objDiv) {
            objDiv.scrollTop = objDiv.scrollHeight;
        }
    }

}