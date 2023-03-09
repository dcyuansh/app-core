package com.common.commaddress.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (CommAddress)实体类
 *
 * @author makejava
 * @since 2023-03-09 16:53:06
 */
public class CommAddress implements Serializable {
    private static final long serialVersionUID = 859240936929784915L;
    
    private Integer id;
    
    private String addressId;
    
    private Integer addressSeqNo;
    
    private String provinceCode;
    
    private String provinceName;
    
    private String cityCode;
    
    private String cityName;
    
    private String districtCode;
    
    private String districtName;
    
    private String postCode;
    
    private String detailAddress;
    
    private String remarks;
    
    private Date insertTime;
    
    private Date timestamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Integer getAddressSeqNo() {
        return addressSeqNo;
    }

    public void setAddressSeqNo(Integer addressSeqNo) {
        this.addressSeqNo = addressSeqNo;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}

