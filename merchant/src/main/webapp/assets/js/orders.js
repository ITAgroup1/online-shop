//init toastr
toastr.options = {
    closeButton: false,  //是否显示关闭按钮（提示框右上角关闭按钮）
    debug: false,  //是否为调试；
    progressBar: true,  //是否显示进度条（设置关闭的超时时间进度条）
    positionClass: "toast-top-center",  //消息框在页面显示的位置
    onclick: null,  //点击消息框自定义事件
    showDuration: "300",  //显示动作时间
    hideDuration: "1000",  //隐藏动作时间
    timeOut: "2000",  //自动关闭超时时间
    extendedTimeOut: "1000",
    showEasing: "swing",
    hideEasing: "linear",
    showMethod: "fadeIn",  //显示的方式
    hideMethod: "fadeOut"  //隐藏的方式
};

$(document).ready(() => {
    axios.defaults.withCredentials = true;
    Vue.prototype.$http = axios;

    let app = new Vue({
        el: "#order-list",
        data: {
            orders: [],
            orderUrl: "http://localhost:9090/merchant/order"
        },
        created(){
            this.initOrderList();
            this.initWebSocket();
        },
        methods: {
            async initOrderList(){
                console.log(axios.defaults);
                let res = await this.$http.get(this.orderUrl);
                let params = res.data;
                if(params.status === "1"){
                    params.data.orderList.forEach((item)=>{
                        this.orders.push(item);
                    })
                }
            },
            initWebSocket(){
                this.ws = new WebSocket("ws://localhost:9090/merchant/socketServer");
                this.ws.onmessage = this.handleMessage;
            },
            handleOpen(){

            },
            handleMessage(msg){
                let data = msg.data;
                console.log(msg);
                let res = JSON.parse(data);
                let order = res.map.order;
                order.client = res.map.client;

                if(order.status === 1){
                    this.orders.unshift(order);
                }else{
                    this.orders.forEach((item) => {
                        if(order.id === item.id){
                           item.status = order.status;
                        }
                    })
                }
            },
            handleClose(){

            },
            accept(index){
                let order = this.orders[index];
                this.createMsg(order.status + 1,order);
            },
            deliver(index){
                let order = this.orders[index];
                this.createMsg(order.status + 1,order);
            },
            arrive(index){
                let order = this.orders[index];
                this.createMsg(order.status + 1,order);
            },
            createMsg(status,order){
                order.status = status;
                let senderId = order.shopId;
                let receiverId = order.client.id;
                let msg = {};
                let map = {};
                msg.senderId = senderId;
                msg.receiverId = receiverId;
                msg.map = map;
                map.order = order;
                this.ws.send(JSON.stringify(msg));
            }
        }
    });

});
