module.exports = class Helper {
    axios
    setAxios(getaxios){
        this.axios = getaxios;
    }
    request(param){
        var type = 'post';

        if(param.type){
            type = param.type;
        }
        this.axios({
              method: type,
              url: param.url,
              data:param.data

        }).then((resp)=>{
            if(typeof(param.success) == 'function'){
                param.success(resp);
            }
        })
        .catch((resp)=>{
            if(typeof(param.error) == 'function'){
                param.error(resp);
            }

        })
    }
    get_user_info () {
            var user_info = {
                id: 0,
                identity: '',
                user_token: '',
                first_name: '',
                last_name: '',
                email: '',
                profile_pic: '',
                bg_img: '',
                cycle_img: '',
                date_of_birth: '',
                today_calander: '',
                life_time_info: '',
            };
            var user_info_local = JSON.parse(localStorage.getItem('user_info'));
            if (typeof (user_info_local) === 'object') {
                if (user_info_local !== null) {
                    if (typeof (user_info_local.id) !== 'undefined') {
                        if (user_info_local.id > 0) {
                            user_info.id = user_info_local.id;
                        }
                    }
                    if (typeof (user_info.user_token) !== 'undefined') {
                        if (user_info_local.user_token !== '') {
                            user_info.user_token = user_info_local.user_token;
                        }
                    }
                    if (typeof (user_info.first_name) !== 'undefined') {
                        if (user_info_local.first_name !== '') {
                            user_info.first_name = user_info_local.first_name;
                        }
                    }
                    if (typeof (user_info.last_name) !== 'undefined') {
                        if (user_info_local.last_name !== '') {
                            user_info.last_name = user_info_local.last_name;
                        }
                    }
                    if (typeof (user_info.email) !== 'undefined') {
                        if (user_info_local.email !== '') {
                            user_info.email = user_info_local.email;
                        }
                    }
                    if (typeof (user_info.identity) !== 'undefined') {
                        if (user_info_local.identity !== '') {
                            user_info.identity = user_info_local.identity;
                        }
                    }
                    if (typeof (user_info.bg_img) !== 'undefined') {
                        if (user_info_local.bg_img !== '') {
                            user_info.bg_img = user_info_local.bg_img;
                        }
                    }
                    if (typeof (user_info.cycle_img) !== 'undefined') {
                        if (user_info_local.cycle_img !== '') {
                            user_info.cycle_img = user_info_local.cycle_img;
                        }
                    }
                    if (typeof (user_info.profile_pic) !== 'undefined') {
                        if (user_info_local.profile_pic !== '') {
                            user_info.profile_pic = user_info_local.profile_pic;
                        }
                    }
                    if (typeof (user_info.date_of_birth) !== 'undefined') {
                        if (user_info_local.date_of_birth !== '') {
                            user_info.date_of_birth = user_info_local.date_of_birth;
                        }
                    }
                    if (typeof (user_info.life_time_info) !== 'undefined') {
                        if (user_info_local.life_time_info !== '') {
                            user_info.life_time_info = user_info_local.life_time_info;
                        }
                    }
                    if (typeof (user_info.today_calander) !== 'undefined') {
                        if (user_info_local.today_calander !== '') {
                            user_info.today_calander = user_info_local.today_calander;
                        }
                    }
                }

            }
            return user_info;
    }
    set_user_new_token = function (new_token) {
        var user_info = this.get_user_info();
        if (user_info.id > 0) {
            var user_info_local = JSON.parse(localStorage.getItem('user_info'));
            user_info_local.user_token = new_token;
            this.set_user_info(user_info_local);
        }
    }
    unset_user_info() {
        localStorage.removeItem('user_info');
    }
    set_user_info(datas) {  
        localStorage.setItem('user_info', JSON.stringify(datas));
    }


}