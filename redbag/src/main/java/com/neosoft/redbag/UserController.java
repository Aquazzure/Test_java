package com.neosoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 获取person列表
     * @return
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")String id){
        userRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id")String id){
        Optional<User> optional=userRepository.findById(id);
//        User user = new User();
        //等价于 User::new
        //对象::new  创建
        return optional.orElseGet(User::new);
    }

    //保存
    @PostMapping()
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }








}
