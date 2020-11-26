package com.neosoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

//    @GetMapping("/{id}")
//    public User update(@PathVariable("id")String id, @RequestBody User user){
//        user.setId(id);
//        return userRepository.save(user);
//    }

    //分页参数   页首和每页多少个
    @GetMapping("/list")
    public Page<User> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "1")Integer pageSize){
        PageRequest pageRequest = PageRequest.of(pageNum-1,pageSize);
        return userRepository.findAll(pageRequest);
    }

//    @GetMapping("/{id}")
//    public User getById(@PathVariable("id")String id){
//        Optional<User> optional=userRepository.findById(id);
////        User user = new User();
//        //等价于 User::new
//        //对象::new  创建
//        return optional.orElseGet(User::new);
//    }

    //保存
    @PostMapping()
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }











}
