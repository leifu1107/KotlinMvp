package com.leifu.kotlinmvp.util;

import android.content.Context;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.lsky.ener.util.LogUtil;

/**
 * 创建人:雷富
 * 创建时间:2019/7/2 10:10
 * 描述:
 */
public class GpsAdressUtil implements GeocodeSearch.OnGeocodeSearchListener {
    Context context;
    private GeocodeSearch geocoderSearch;

    public GpsAdressUtil(Context context, double latitude, double longitude) {
        this.context = context;
        geocoderSearch = new GeocodeSearch(context);
        geocoderSearch.setOnGeocodeSearchListener(this);
        // 第一个参数表示一个Latlng，第二参数表示范围多少米，第三个参数表示是火系坐标系还是GPS原生坐标系
        RegeocodeQuery query = new RegeocodeQuery(new LatLonPoint(latitude, longitude), 200, GeocodeSearch.AMAP);
        geocoderSearch.getFromLocationAsyn(query);
    }

    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        LogUtil.INSTANCE.e(regeocodeResult.getRegeocodeAddress().getStreetNumber().getStreet() + "code--" + i);
        //解析result获取地址描述信息 1000为成功，其他为失败
        if (listener != null) {
            listener.onGetAddress(regeocodeResult.getRegeocodeAddress().getStreetNumber().getStreet() + regeocodeResult.getRegeocodeAddress().getStreetNumber().getNumber());
        }
    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {

    }

    private OnGetAddressListener listener;

    public void setOnGetAddressListener(OnGetAddressListener listener) {
        this.listener = listener;
    }

    public interface OnGetAddressListener {
        void onGetAddress(String address);
    }
}
