package com.antbox.rfidmachine.service;

import com.antbox.common.RestResult;
import com.antbox.domain.Merchant;
import com.antbox.domain.ProductLotno;
import com.antbox.domain.RfidMachine;
import com.antbox.domain.RfitRssi;
import com.antbox.rfidmachine.dto.ProductDto;
import com.antbox.rfidmachine.dto.RfidProductDto;
import com.antbox.rfidmachine.dto.UserDto;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

public abstract interface LocalService
{
  @POST("/bussiness/v1/sso/login")
  public abstract Call<RestResult<UserDto>> localLogin(@Body UserDto paramUserDto);
  
  @GET("/bussiness/v1/product/list")
  public abstract Call<RestResult<List<ProductDto>>> productList(@HeaderMap Map<String, String> paramMap, @Query("name") String paramString1, @Query("id") String paramString2);
  
  @GET("/bussiness/v1/rfid_product/list")
  public abstract Call<RestResult<List<RfidProductDto>>> rfidProductList(@HeaderMap Map<String, String> paramMap, @Query("rfidList") List<String> paramList);
  
  @POST("/bussiness/v1/rfid_product/save")
  public abstract Call<RestResult> saveRfidProduct(@HeaderMap Map<String, String> paramMap, @Body RfidProductDto paramRfidProductDto);
  
  @HTTP(method="DELETE", path="/bussiness/v1/rfid_product/delete", hasBody=true)
  public abstract Call<RestResult> deleteRfidProduct(@HeaderMap Map<String, String> paramMap, @Body RfidProductDto paramRfidProductDto);
  
  @GET("/bussiness/v1/merchant/domain_list")
  public abstract Call<RestResult<List<Merchant>>> selectMerchant(@Query("username") String paramString1, @Query("password") String paramString2);
  
  @GET("/bussiness/v1/download/newest/rfid_edition")
  public abstract Call<RestResult<RfidMachine>> downloadNewestRfidVersion();
  
  @GET("/bussiness/v1/rfid_rssi/value")
  public abstract Call<RestResult<RfitRssi>> findRfitRssiValue(@HeaderMap Map<String, String> paramMap);
  
  @GET("/bussiness/v1/product_lotno/list")
  public abstract Call<RestResult<List<ProductLotno>>> productLotnoList(@HeaderMap Map<String, String> paramMap, @Query("productId") Long paramLong);
}


/* Location:              D:\antbox-rfid-machine.jar!\com\antbox\rfidmachine\service\LocalService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */