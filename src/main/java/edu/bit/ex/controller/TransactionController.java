package edu.bit.ex.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.bit.ex.service.TxService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class TransactionController {

    @Autowired
    private TxService txService;
    
    // security 설정 파일에서 테스트를 위해 아래 설정
    // intercept-url pattern="/tx/**" access="permitAll"
    @GetMapping("/tx/{num}")
    public void transaction(@PathVariable("num") int num) throws SQLException{
        log.info("transaction() ..");
        
        if(num == 1) {
            log.info("tx test1");
            txService.txTest1();
        } else if(num == 2) {
            log.info("tx test2");
            txService.txTest2();
        } else if(num == 3) {
            log.info("tx test3");
            txService.txTest3();
        } else if(num == 4) {
            log.info("tx test4");
            txService.txTest4();
        } else if(num == 5) {
            log.info("tx test5");
            txService.txTest5();
        } else if(num == 6) {
            log.info("tx test6");
            txService.txTest6();
        } else if(num == 7) {
            log.info("tx test7");
            txService.txTest7();
        }
        
    }
}
