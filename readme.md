#项目模块

>online-shop

>>core

>>>admin

>>>client

>>>merchant

**WebService interfaces**

    let merchantServer = "http://localhost:3000";
    
    let clientServer = "http://localhost:3000";
    
    let imgServer = "http://localhost:3000";
    
    export default {
      
      listShop: {
        url : "/shop/",
        method : 'GET',
        data : {
            status : #String
            shops : #Array
        }
      },
      
      addShop: {
        url : "/shop/add",
        method : 'POST',
        data : {
            status : #String
            data : {
                shops : #Array
            }
        }
      },
      
      clientLogin: {
        url : "/client/login",
        method : "POST",
        data : {
            status : #String
            data : {
                client : #Object
            }
        }
      }
      
    }
