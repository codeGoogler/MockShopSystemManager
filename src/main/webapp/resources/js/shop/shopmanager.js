$(function () {
    var shopId = getQueryString('shopId');
    var shopUrl = '/MockYuerSystemManager/shop/getShopManagerInfo?shopId='+shopId;
     $.getJSON(shopUrl,function (data) {
         if(data.direct){
            window.location.href = data.url
         }else{
             if(data.shopId != undefined && data.shopId != null){
                shopId = data.shopId;
             }
             $('#shopInfo').attr('href','/MockYuerSystemManager/shopadmin/shopoperatetion?shopId='+shopId);
         }
     });
});