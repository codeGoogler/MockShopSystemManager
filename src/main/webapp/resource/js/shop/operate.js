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
            alert(data);
              if(data.success ){
                  var tempShopCategory = ""
                  var tempArea = "";
                  data.shopCategoryList.map(function (itemBean, index) {
                      tempShopCategory += '<option data-id="'+itemBean.getShopcategoryId+'">'+itemBean.getShopcategoryName+'</option>';
                  });

                  data.shopAreaList.map(function (itemBean, index) {
                      tempArea += '<option data-id="'+itemBean.getAreaId+'">'+itemBean.getAreaName+'</option>';
                  });
                  $('shop_category').html(tempShopCategory);
                  $('area_item').html(tempShopCategory);


              }else {
                  $.toast("失败了");
              }
        });
        $('cancle').click(function () {
                $.toast("返回上一层");
        });
        $('submit').click(function () {
            // 提交数据，请求接口
            var shop ={};
            shop.shopName = $('shop_name').val();
            shop.shopDesc = $('shop_desc').val();
            shop.phone = $('shop_phone').val();
            shop.shopAddr = $('shop_addr').val();
            shop.shopCategory = {
                shopCategoryId:$('shop_category').find('option').not(function () {
                        return!this.selected;
                }).data('id')
            };
            shop.area = {
                areaId:$('area_item').find("option").not(function () {
                    return !this.selected;
                }).data('id')
            };

            shop.shopImg = $('shop_img')[0].files[0];
            var formData = new FormData();
            formData.append("shopImg",shopImg);
            formData.append("shopBody",shop);
            $.ajax({
                url:regisitShopUrl,
                type:'post',
                data:formData,
                contentType:false,
                processData:false,
                cache:false,
                success:function (data) {
                    if(data.success()){
                        $.toast("创建成功");
                    }else{
                        $.toast("创建失败，"+data.message);
                    }
                }
            });
        });
    }
})