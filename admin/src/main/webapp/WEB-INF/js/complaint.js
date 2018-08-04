/**
 * 
 */
(function(){
    let pageable={
        "size" : 5,
        "offset" : 1,
		"totalSize": 5
    };
    let bt = new complaintComponent($("#app"),"http://localhost:9090/admin/complaint/");
    bt.init();
    function benAjax(url,method,data,callback){
        let options ={
            "url":url,
            "type":method,
            "data":data
        }

        $.ajax(options).done(function(obj){
            callback(obj);
        });
    }

    function form2json($form){
        let obj={};
        $.each($form.children("[type!=submit]"),function(index,item){
            let $item = $(item);
            obj[$item.attr("name")]=$item.val();
        });
        return obj;
    }

    setPageLength = function (newLength) {
        pageable.size = newLength;
        bt.init();
    }

    getPage = function (pageNum) {
        if (pageNum === "-1") {
            if (pageable.offset > 1) {
                pageable.offset = pageable.offset - 1;
                bt.init();
            }
        } else if (pageNum === "+1") {
            if (pageable.totalSize > (pageable.offset*pageable.size)) {
                pageable.offset = pageable.offset + 1;
                bt.init();
            }
        }

    }

    function complaintComponent($view,url){
        let model = null;
        let tbody = $view.find("#dataTable");
        let that =this;//that == BookComponent;

		this.getButton = function (complaint,status) {
            let td = $("<td>");
            td.addClass("pmd-table-row-action");

            let a1 = $("<a>");
            a1.addClass("btn pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-default btn-sm");
            let i1 = $("<i>update</i>");
            i1.addClass("material-icons md-dark pmd-sm");

            let a2 = $("<a>");
            a2.addClass("btn pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-default btn-sm");
            let i2 = $("<i>done</i>");
            i2.addClass("material-icons md-dark pmd-sm");

            let a3 = $("<a>");
            a3.addClass("btn pmd-btn-fab pmd-btn-flat pmd-ripple-effect btn-default btn-sm");
            let i3 = $("<i>clear</i>");
            i3.addClass("material-icons md-dark pmd-sm");


            a1.on("click", function () {
                that.updateStatus(complaint, 1);
            });
            a2.on("click", function () {
                that.updateStatus(complaint, 2);
            });
            a3.on("click", function () {
                that.updateStatus(complaint, 3);
            });



            a1.append(i1);
            a2.append(i2);
            a3.append(i3);

            td.append(a1);
            td.append(a2);
            td.append(a3);

            return td;
        }

        this.renderTable = function(){

            tbody.empty();
            model.forEach((item,index)=>{
                $("<tr>").append($("<td>").text(item.merchantId))
                    .append($("<td>").text(item.shopId))
                    .append($("<td>").text(item.content))
                    .append($("<td>").text(that.getStatus(item.status)))
					.append(that.getButton(item,item.status))
                    .appendTo(tbody);
            });
        }

        this.getStatus =function (status) {
            let thisStatus="";
            if(status==0){
                thisStatus="未处理";
            }else if(status==1){
                thisStatus="处理中";
            }else if(status==2){
                thisStatus="完成";
            }else if(status==3){
                thisStatus="忽略";
            }
            return thisStatus;
        }

        this.init = function(){

            benAjax(url+"list","GET",pageable,function(result){
                model=result.data.list.data;
                pageable.offset=result.data.list.offset;
                pageable.totalSize=result.data.list.totalSize;
                that.render();
            });

        }
        this.render=function(){
            that.renderTable();
        }

        this.updateStatus = function (complaint,status) {
            benAjax(url+complaint.id+"/"+status,"PUT",null,result=>{
                let index = model.indexOf(complaint);
                model.splice(index,1,result.data.complaint);
                that.render();

            })
        }


    }









})();