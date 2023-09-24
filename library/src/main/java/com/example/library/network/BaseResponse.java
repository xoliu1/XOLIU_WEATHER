package com.example.library.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**目前只有一个搜索，后面如果有新增就往里面加，然后创建一个基础返回类*/
public class BaseResponse {

    /**
     * 结果码
     */
    @SerializedName("res_code")
    @Expose
    public Integer responseCode;

    /**
     * 返回的错误信息
     */
    @SerializedName("res_error")
    @Expose
    public String responseError;
}


