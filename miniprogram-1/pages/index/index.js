//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Wish You Were Here',
    userInfo: {},
    hasUserInfo: false,
    hasLogin:false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },

  serverLogin: function(e) {
    // 登录
    wx.login({
      success: res => {
        console.log(res)
        var code = res.code
        var that = this
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        wx.request({
        	// 此处填写实际servlet的请求url
          url: "http://localhost:8080/JSPTest_war_exploded/WechatServlet",
          data: {
            code: code
          },
          method: "Get",
          header: {
            'content-type': 'application/x-www-form-urlencoded',
          },
          success: function (res) {
            console.log(res.data)
            var result = res.data
            if(result.code == 0) {
              that.setData({motto: result.data})
            } else {
              console.log(result.data.openid)
              that.setData({motto: result.data.openid})
            }
          },
          fail: function (error) {
            console.log(error);
            that.setData({motto: error.errMsg})
          }
        })
      }
    })
  }
})
