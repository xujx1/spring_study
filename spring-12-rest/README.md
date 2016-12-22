
                RestTemplate定义了11个独立的操作，而每一个都有重载，这样一共是36个方法
    方　　法                描　　述
    delete()                在特定的URL上对资源执行HTTP DELETE操作
    exchange()              在URL上执行特定的HTTP方法，返回包含对象的ResponseEntity，这个对象是从响应体中映射得到的
    execute()               在URL上执行特定的HTTP方法，返回一个从响应体映射得到的对象
    getForEntity()          发送一个HTTP GET请求，返回的ResponseEntity包含了响应体所映射成的对象
    getForObject()          发送一个HTTP GET请求，返回的请求体将映射为一个对象
    headForHeaders()        发送HTTP HEAD请求，返回包含特定资源URL的HTTP头
    optionsForAllow()       发送HTTP OPTIONS请求，返回对特定URL的Allow头信息
    postForEntity()         POST数据到一个URL，返回包含一个对象的ResponseEntity，这个对象是从响应体中映射得到的
    postForLocation()       POST数据到一个URL，返回新创建资源的URL
    postForObject()         POST数据到一个URL，返回根据响应体匹配形成的对象
    put()                   PUT资源到特定的URL