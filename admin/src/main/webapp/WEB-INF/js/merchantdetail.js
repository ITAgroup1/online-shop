/**
 * 
 */
	( getList=function (){
		
		let merchantDetails;
		let currNum =1;
		let pageLength =5;
        let pageUtil = {};

		setPageLength = function(newLength){
			pageLength =newLength;
			getData(currNum);
		}
		
		getData = function(currNum){
            let pageable={};
            pageable.size = pageLength;
            pageable.offset = currNum;
		    $.ajax({
                type:"GET",
                url:"http://localhost:9090/merchantDetail/listUpdate",
                data:pageable,
                success:function(result){
                    merchantDetails = result.data.list.data;
                    pageUtil.total = result.data.list.totalSize;
                    pageUtil.endNum = result.data.list.size * result.data.list.offset;
                    displayList(merchantDetails);
            },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("status:"+XMLHttpRequest.status+" readystatus:"+XMLHttpRequest.readyState+" textStatus:"+textStatus);//获取的信息即是异常中的Message
                } 
            });
			
		}
		
		getPage = function(pageNum){
			if(pageNum==="-1"){			
				if(currNum > 1){
					currNum =currNum-1;
					getData(currNum);
				}
			}else if(pageNum==="+1"){			
				if(pageUtil.total>pageUtil.endNum || pageUtil==""){
					currNum =currNum+1;
					getData(currNum);
				}
			}
			
			
		
		}
		
		refreshUpdate = function(merchantDetail){
			let newtr=createEle(merchantDetail);
			let oldtr =$("#"+merchantDetail.id);
			oldtr.replaceWith(newtr);
		}
		
		
		updateStatus= function(merchantDetailID,status){
			let id = merchantDetailID;
			let tStatus = status;

			    $.ajax({
	                type:"PUT",
                    url: "http://localhost:9090/merchantDetail/"+id+"/"+status,
                    data: null,
	                success:function(result){
                        let flag = result.status;
                        if (flag == "1") {
                            let merchantDetail = result.data.merchantDetail;
                            refreshUpdate(merchantDetail);
                        }
                        else {
                            let message = result.message;
                            $("#message").html(message);
                            $('#myModal').modal('show');
                        }
	            },
	                error:function (XMLHttpRequest, textStatus, errorThrown) {
	                	let message = "status:"+XMLHttpRequest.status+" readystatus:"+XMLHttpRequest.readyState+" textStatus:"+textStatus;
	                	$("#message").html(message);
	                	$('#myModal').modal('show'); 	                } 
	            });
		
		}
			
		getButtun = function(merchantDetailID,status){
			let td = $("<td>");
			td.addClass("pmd-table-row-action");
			let a1 = $("<a>");<!--未添加方法 -->
			a1.addClass("btn pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-default btn-sm");
			let i1 = $("<i>done</i>");
			i1.addClass("material-icons md-dark pmd-sm");
			let a2 = $("<a>");<!--未添加方法 -->
			a2.addClass("btn pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-default btn-sm");
			let i2 = $("<i>clear</i>");
			i2.addClass("material-icons md-dark pmd-sm");
			
			a1.on("click",function(){updateStatus(merchantDetailID,1);});
			a2.on("click",function(){updateStatus(merchantDetailID,3);});
			
			a1.append(i1);
			a2.append(i2);
			td.append(a1);
			td.append(a2);
	
			return td;
		}
		
		getStatus = function(status){
			let td = $("<td>");
			
			let thisStatus="";
			if(status==0){
				thisStatus="未处理";
			}else if(status==1){
				thisStatus="同意";
			}else if(status==2){
				thisStatus="驳回";
			}else if(status==3){
				thisStatus="不同意";
			}
			
			td.html(thisStatus);
			return td;
		}
		
		createEle = function(merchantDetail){
			
			let mytr = $("<tr>");
			mytr.attr("id",merchantDetail.id);
            let merchantId=$("<td>"+merchantDetail.merchant.id+"</td>");
			let idcardNum=$("<td>"+merchantDetail.idcardNum+"</td>");
			let merchantName=$("<td>"+merchantDetail.merchantName+"</td>");
			let address=$("<td>"+merchantDetail.address+"</td>");
			let status=getStatus(merchantDetail.status);
			let button = getButtun(merchantDetail.id,merchantDetail.status);

			mytr.append(merchantId);
			mytr.append(idcardNum);
			mytr.append(merchantName);
			mytr.append(address);
			mytr.append(status);
			mytr.append(button);
			return mytr;
		}
		
		
		displayList = function(merchantDetails){

			let tbody = $("#dataTable");
			let tr =$("#dataTable>tr");
			tr.remove();

			for(let i =0,l=merchantDetails.length;i<l;i++){
				let mytr = createEle(merchantDetails[i]);
				tbody.append(mytr);
			}
			
			
		}
		
		getData(currNum);

		
		
		
	})();
	

	