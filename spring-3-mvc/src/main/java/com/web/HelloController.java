package com.web;

import com.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "index";
    }


  /*  @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public User helloUser() {
        return new User("许金鑫", 20);
    }*/

    //http://localhost:8080/hello/user/name?name=test
    @RequestMapping(value = "/user/name", method = RequestMethod.GET)
    @ResponseBody
    public User helloUser(String name) {
        assert StringUtils.isNotEmpty(name);
        User user = new User();
        user.setUserName(name);
        return user;
    }

    //http://localhost:8080/hello/user/test
    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User hello(@PathVariable("name") String name) {
        assert StringUtils.isNotEmpty(name);
        User user = new User();
        user.setUserName(name);
        return user;
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public User hello(@ModelAttribute("user") User user) {
        assert null != user;
        return user;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file) {
        assert null != file;
        file.getName();
        return "index";
    }

   /* //抓捕异常
    @ExceptionHandler(NullPointerException.class)
    private void trance() {
        System.out.println("=========");
    }*/
}
