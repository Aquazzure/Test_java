package com.neosoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bag")
public class LuckyMoneyController {
    @Autowired
    private LuckyMoneyRepository luckyMoneyRepository;

    /**
     * 获取红包列表
     * @return
     */

    @GetMapping("/list")
    public List<LuckyMoney> list(){
        return luckyMoneyRepository.findAll();
    }

    /**
     *发红包
     * @param producer
     * @param money
     * @return
     */
    @PostMapping("/post")
    public LuckyMoney postRedBag(@RequestParam(value = "producer", required = true)String producer , @RequestParam(value = "money", required = true) BigDecimal money){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setProducer(producer);
        luckyMoney.setMoney(money);
        return luckyMoneyRepository.save(luckyMoney);
    }

    /**
     *发红包
     * @param id
     * @return
     */
    @GetMapping("find/{id}")
    public LuckyMoney findId(@PathVariable("id") Integer id){
//        Optional<LuckyMoney> optional = luckyMoneyRepository.findById(id);
//        if(optional.isPresent()){
//           LuckyMoney luckyMoney = optional.get();
//           return luckyMoney;
//        }
//        return null;
        //如果有返回前面部分，如果没有，就填入()中值,即null
        return  luckyMoneyRepository.findById(id).orElse(null);
    }

    /**
     *收红包
     * @param consumer
     * @return
     */
    @PutMapping("/put/{id}")
    public LuckyMoney put(@PathVariable("id") Integer id,
                          @RequestParam String consumer){
        Optional<LuckyMoney> optional = luckyMoneyRepository.findById(id);
        if(optional.isPresent()){
            LuckyMoney luckyMoney = optional.get();
            luckyMoney.setConsumer(consumer);
            return luckyMoneyRepository.save(luckyMoney);
        }
        return null;
    }









}
