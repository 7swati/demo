package com.example.demo;

import com.example.demo.bean.UserDipRequest;
import com.example.demo.entity.jpa.UserDipDetails;
import com.example.demo.service.DipCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/luckDip")
public class DipCollectionController {

    @Autowired
    private DipCollectionService dipCollectionService;


    @GetMapping("/v1/getDeatils")
    public String getDetails(){
        String s = "These are the details;";

        return s;
    }



   @PostMapping("/v1/submitDip")
    public ResponseBody submitDip(@RequestBody UserDipRequest userDipRequest) throws Exception {
       try {
                dipCollectionService.saveUserDipRequest(userDipRequest);
       } catch (Exception e) {
           throw new Exception("Issue while saving dip details");
       }
       return null;
   }


}
