class ClientWS {

  constructor(url,options){
    this.url = url;
    this.options = options;
    this.init();
  }

  init(){
    try {
      this.ws = new WebSocket(this.url);
    }catch (e) {
      this.error(e);
    }
    this.ws.onopen = () => {
      this.open();
    };
    this.ws.onclose = () => {
      this.close();
    };
    this.ws.onerror = (e) => {
      this.error(e);
    };
    this.ws.onmessage = (msg) => {
      this.message(msg);
    };
  }

  open(){
    console.log("ws connected");
  }

  message(msg){
    console.log(msg);
  }

  close(){
    console.log("ws closed");
  }

  error(){
    console.log("errer")
  }

  sendOrder(client,cartItems,shopId,order) {
    /*{
      shopId : "8a5e9d1564fae4080164fae4195f0000" ,
        address : "ITA_class" ,
      phone : "110" ,
      cost : 100.00,
      client :{
      id : ""
    },
      remark : "" ,
        status : 1,
      orderItems : [orderItem1,orderItem2,orderItem3]
    };*/

  }
}

window.ClientWS = ClientWS;