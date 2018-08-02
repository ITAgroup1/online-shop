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
    
   Merchant {
      
      // update shop
      updateShop: {
        url: "/shop/",
        method: 'PUT',
        requestData: {
            Shop-jsonString(contain merchantDetailId)
        },
        responseData: {
            ResultBody-jsonString
        }
      }
      
      // get shop by merchantDetailId
      getShop: {
        url : "/shop/{merchantDetailId}",
        method : 'GET',
        requestData: {
            merchantDetailId（contain in url）
        }
        responseData: {
            ResultBody-jsonString
        }
      },
    }
    
    Admin {
        // merchant login
        saveMerchant:{
            url: "/merchant/register",
            method: 'POST',
            requestData: {
                resultBody-jsonString
            }
        }
        // merchant login
        findMerchant:{
            url: "/merchant/login",
            method: 'POST',
            requestData: {
                resultBody-jsonString
            }
        }        
    }    
    
    Client {
        Login: {
            url : "/client/login",
            method : "POST",
            data : {
                status : #String
                data : {
                    client : #Object
                }
            }
        },
        getRecipeList {
            url : "/recipe/:merchantId/"
            method : "GET",
            response: {
                statuts : #String,
                data:{
                    recipes: #Array
                }
            }
        }
    }
