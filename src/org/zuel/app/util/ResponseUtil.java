package org.zuel.app.util;

import org.zuel.app.module.ResponseObj;


public class ResponseUtil {
    public static ResponseObj ok(Object data)
    {
        ResponseObj result=new ResponseObj();
        result.setCode(1);
        result.setData(data);
        result.setMsg("操作成功。");
        return result;
    }

    public static ResponseObj ok(){return ok(null); }

    public static ResponseObj fail(Object data)
    {
        ResponseObj result=new ResponseObj();
        result.setCode(0);
        result.setData(data);
        result.setMsg("操作失败。");
        return result;
    }

    public static ResponseObj fail(){return fail(null); }

    public static ResponseObj badArg()
    {
        ResponseObj result=new ResponseObj();
        result.setCode(0);
        result.setMsg("参数有误。");
        return result;
    }
}
