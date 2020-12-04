package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.Admin;
import com.neusoft.springbootsell.form.AdminForm;
import com.neusoft.springbootsell.repository.AdminRepository;
import com.neusoft.springbootsell.services.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;


@RestController
@RequestMapping("/seller/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    AdminRepository repository;

//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    @Autowired
//    private ProjectUrlConfig projectUrlConfig;

    //登陆界面
    @GetMapping("/login")
    public ModelAndView index(){
        return new ModelAndView("/admin/login");
    }

    //注册页面
    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("/admin/register");
    }

    //注册方法
    @PostMapping("/load_register")
    public ModelAndView register1(@Valid AdminForm form,
                               BindingResult bindingResult,
                               Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "seller/category/list");
            return new ModelAndView("common/error", map);
        }
        Admin admin = new Admin();
        try {
            BeanUtils.copyProperties(form,admin);
            System.out.println(admin);
            repository.save(admin);
        } catch (Exception e) {
            map.put("msg",e.getMessage());
            map.put("url","seller/admin/register");
            return new ModelAndView("common/error",map);
        }
        map.put("url", "/seller/admin/login");
        return new ModelAndView("common/success", map);
    }



    //登陆
    @PostMapping("/load_login")
    public ModelAndView login1(@Valid AdminForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "seller/admin/login");
            return new ModelAndView("common/error", map);
        }
        Admin admin = new Admin();
        admin =  adminService.findByAdminNameAndPassword(form.getAdminName(),form.getPassword());
        System.out.println(admin);
        if(admin == null){
            //返回错误页面
            map.put("url", "/admin/login");
            return new ModelAndView("common/error", map);
        }else {
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/success", map);
        }
    }

    //登出
    @GetMapping("/logout")
    public ModelAndView logout(){
        return new ModelAndView("admin/login");
    }

//    //登陆
//    @GetMapping("/login")
//    public ModelAndView login(HttpServletRequest request, BindingResult bindingResult,
//                              Map<String, Object> map){
//        String adminName = request.getParameter("adminName");
//        String password = request.getParameter("password");
//        if (adminService.findByAdminNameAndPassword(adminName,password)==null){
//            //返回错误页面
//            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
//            map.put("url", "/seller/product/list");
//            return new ModelAndView("common/error", map);
//        }
//        map.put("url", "/seller/product/list");
//        return new ModelAndView("common/success", map);
//    }

//    //注册
//    @RequestMapping(value = "/userRegister/submit",method = RequestMethod.GET)
//    public boolean Register(HttpServletRequest request){
//        String adminName = request.getParameter("adminName");
//        String password = request.getParameter("password");
//        Admin admin = new Admin(adminName,password);
//        return adminService.addAdmin(admin);
//    }




//    //进入登陆界面
//    @GetMapping("/login")
//    public ModelAndView login(@RequestParam("openId") String openId,
//                              HttpServletResponse response,
//                              Map<String,Object> map){
//
//        //1.openid去和数据库里的数据匹配
//        Admin admin = adminService.findByOpenId(openId);
//        if(admin==null){
//            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
//            map.put("url","/product/list");
//            return new ModelAndView("common/error");
//        }
//        //2.设置token至redis
//        String token= UUID.randomUUID().toString();
//        Integer expire= RedisConstant.EXPIRE;
//        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openId,expire, TimeUnit.SECONDS);
//
//        //3.设置token至cookie
//        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
//
//        return new ModelAndView("redirect:"+projectUrlConfig.getSell()+"product/list");
//    }
//
//    @GetMapping("/logout")
//    public ModelAndView logout(HttpServletRequest request,
//                               HttpServletResponse response,
//                               Map<String,Object> map){
//
//        //1.从cookie里查询
//        Cookie cookie=CookieUtil.get(request,CookieConstant.TOKEN);
//        if(cookie!=null){
//            //2.清除redis
//            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
//            //3.清除cookie
//            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
//        }
//        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
//        map.put("url","/order/list");
//        return new ModelAndView("common/success",map);
//
//    }

//    @GetMapping("/login")
//    public ModelAndView login(@RequestParam(value = "adminName",required = false)String adminName,
//                              @RequestParam(value = "password",required = false)String password,
//                              BindingResult bindingResult,
//                              Map<String, Object> map){
//        try{
//            Admin admin  = adminService.findByAdminNameAndPassword(adminName,password);
//            if(admin==null){
//                //返回错误页面
//                map.put("msg", bindingResult.getFieldError().getDefaultMessage());
//                map.put("url", "/seller/product/list");
//                return new ModelAndView("common/error", map);
//            }
//        } catch (SellException exception){
//            map.put("msg", exception.getMessage());
//            map.put("url", "/seller/product/list");
//            return new ModelAndView("common/error");
//        }
//        map.put("url", "/seller/product/list");
//        return new ModelAndView("common/success", map);
//    }
//

}
