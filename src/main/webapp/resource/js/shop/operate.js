/**
 *
 */
$(function () {
    var  intUrl = "/MockShopSystemManager/shop/getShopInitInfo";
    var   regisitShopUrl = "/MockShopSystemManager/shop/regisitShop";
    getShopInfo();
    console.log("已经进入到了js代码")
    function getShopInfo() {
        //请求接口
        $.getJSON(intUrl,function (data) {
            console.log("已经进入到了intUrl方法");
              if(data.success ){
                  var tempShopCategory = ""
                  var tempArea = "";
                  data.shopCategoryList.map(function (item, index) {
                      console.log("itemBean: " +item.toString()+item.shopCategoryName);
                      tempShopCategory += '<option data-id="'+item.shopCategoryId+'">'+item.shopCategoryName+'</option>';
                  });

                  data.shopAreaList.map(function (item, index) {
                      tempArea += '<option data-id="'+item.areaId+'">'+item.areaName+'</option>';
                  });
                  console.log("进入到了 success1 的方法");
                  $('#shop_category').html(tempShopCategory);
                  console.log("进入到了 success2 的方法");
                  $('#area_item').html(tempArea);

                  console.log("进入到了 success3 的方法");
                  console.log("sueecss4 "+tempShopCategory+"   "+tempShopCategory);
                  console.log("sueecss5 "+ $('#shop_category').val()+"   "+ $('#area_item').val());
              }else {
                  $.toast("失败了");
              }
        });
        $('#cancle').click(function () {
            console.log("返回上一层");
                $.toast("返回上一层");
        });
        $('#submit').click(function () {
            console.log("submit点击了");
            // 提交数据，请求接口
            var shop ={};
            shop.shopName = $('#shop_name').val();
            shop.shopDesc = $('#shop_desc').val();
            shop.phone = $('#shop_phone').val();
            shop.shopAddr = $('#shop_addr').val();

            console.log(shop.shopName+"   " +shop.shopDesc+"   "+shop.phone +"     "+ shop.shopAddr);
            shop.shopCategory = {
                shopCategoryId:$('#shop_category').find('option').not(function () {
                        return!this.selected;
                }).data('id')
            };
            shop.area = {
                areaId:$('#area_item').find("option").not(function () {
                    return !this.selected;
                }).data('id')
            };

            var shopImg = $('#shop_img')[0].files[0];
            var formData = new FormData();
            formData.append("shopImg",shopImg);
            formData.append("shopBody",JSON.stringify(shop));
            console.log("formData:  " +formData.toString());
            console.log("formData values:  " +formData.values());
            //遍历所有的form表单 语法 教程
           // https://developer.mozilla.org/en-US/docs/Web/API/FormData/entries
           /* for(var i=0;i<formData.length;i++){
                if( i == 0){
                    var body = formData.values();
                    for(let i in body){
                        console.log(i +" "+obj[i]);
                    }
                }
            }*/
            console.log( formData.get("shopBody"));
            for(var pair of formData.entries()) {
                console.log(pair[0]+ '==============='+ pair[1] +(pair[0] === 'shopBody'));
                if( pair[0] === 'shopBody'){
                    console.log(pair[0]+ '==============='+ pair[1]);
                    var body = formData.values();
                    console.log("body:    "+body);
                    console.log(body.shopName+"   " +body.shopDesc+"   "+body.phone +"     "+ body.shopAddr);
                    for(let i in body){
                        console.log(i +" "+body[i]);
                    }
                }
            }

            $.ajax({
                url:regisitShopUrl,
                type:'post',
                data:formData,
                contentType:false,
                processData:false,
                cache:false,
                success:function (data) {
                    console.log("request:  " +data.toString());
                    if(data.success){
                        $.toast("创建成功");
                    }else{
                        $.toast("创建失败，"+data.message);
                    }
                }
            });
        });
    }
})