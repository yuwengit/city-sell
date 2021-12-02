module.exports = {
  devServer: {
    port: 8080,
    proxy: {
      '/citysell': {
        target: 'http://127.0.0.1:9000', // 后台接口域名
        ws: true, //如果要代理 websockets，配置这个参数
        changeOrigin: true, //是否跨域
        pathRewrite: {
          '^/citysell': ''
        }
      }
    },
    headers: {
      'Access-Control-Allow-Origin': '*',
    }
  }
}