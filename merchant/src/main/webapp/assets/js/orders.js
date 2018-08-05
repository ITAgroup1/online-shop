$(document).ready(() => {
    axios.defaults.withCredentials = true;
    Vue.prototype.$http = axios;

    let app = new Vue({
        el: "#order-list",
        data: {
            orders: [],
            orderUrl: "http://10.222.29.149/merchant/merchant/order"
        },
        create(){
          this.initOrderList();
        },
        methods: {
            async initOrderList(){
                let res = await this.$http.get(this.orderUrl);
                console.log("orders",res);
                let params = res.data;
                if(params.status === "1"){
                    params.data.orderList.forEach((item)=>{
                        this.orders.push(item);
                    })
                }
            }
        }
    });


});