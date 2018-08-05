$(document).ready(function () {

    //config
    axios.defaults.withCredentials = true;

    let app = new Vue({
        el: "#complaint-list",
        data : {
            complaints : []
        },
        methods: {
            async listComplaint() {
                let res = await axios.get("http://localhost:9090/complaint/");
                let param = res.data;
                console.log(param);
                for(let item of param.data.complaints){
                    this.complaints.push(item);
                }
            }
        },
        created(){
            this.listComplaint();
        }
    });


});