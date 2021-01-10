package org.zuel.app.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.zuel.app.util.ResponseUtil;
import org.zuel.app.util.HttpUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * a test of WeChat mini program,which can get the openid and session_key
 * @author 陈昕
 * **/
public class WechatServlet extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map=new HashMap<String,Object>();
        //接收微信小程序传入的code
        String code=request.getParameter("code");
        PrintWriter out=response.getWriter();
        //登陆凭证不能为空
        if(code==null||code.length()==0)
            out.print(JSON.toJSONString(ResponseUtil.fail("获取失败。")));
        else{
            String wxspAppid="wx319e6c738fe40017";
            String wxspSecret="0e4ce40d43d0e77d575f6e970a5db7f8";
            String grant_type="authorization_code";
            String param="appid="+wxspAppid+"&secret="+wxspSecret+"&js_code="+code+"&grant_type="+grant_type;
            String sr= HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session",
                    param);
            try{
                JSONObject json=JSONObject.parseObject(sr);
                System.out.println(json);
                String session_key=json.get("session_key").toString();
                String openid=json.get("openid").toString();
                map.put("openid",openid);
                map.put("session_key",session_key);
                System.out.println(map);
                out.print(JSON.toJSONString(ResponseUtil.ok(map)));
            }catch(Exception e){
                out.print(JSON.toJSONString(ResponseUtil.fail(sr)));
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        processRequest(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        processRequest(request,response);
    }
}

