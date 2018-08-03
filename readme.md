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
        
        //get passed shops list
        getPassedShop:{
            url:"/merchantDetail/shop"
            method : "GET",
            response: {
                statuts : #String,
                data:{
                    shops: #List<String>
                }
            }
        }
        
        //get merchantDetail
        getMerchantDetail:{
            url:"/merchantDetail"
            method : "GET",
            response: {
                statuts : #String,
                data:{
                    merchantDetail: #MerchantDetail
                }
            }
        }
       
        // merchant register
        saveMerchant:{
            url: "/merchant/register",
            method: 'POST',
            response: {
                statuts : #String,
                data:{
                    merchant: #Merchant
                }
            }
        }
        
        // merchant login
        findMerchant:{
            url: "/merchant/login",
            method: 'POST',
            response: {
                statuts : #String,
                data:{
                    merchant: #Merchant
                }
            }
            request:{
                merchant: #Merchant
            }
        }        
    }    
    
    Client {
        Login: {
            url : "/client/login",
            method : "POST",
            response : {
                status : #String
                data : {
                    client : #Object
                }
            }
        },
        getRecipeList {
            url : "/recipe/{shopId}"
            method : "GET",
            response: {
                statuts : #String,
                data:{
                    recipes: #Array
                }
            }
        }
    }
