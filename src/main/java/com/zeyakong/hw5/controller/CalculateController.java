package com.zeyakong.hw5.controller;

import com.zeyakong.hw5.models.Default;
import com.zeyakong.hw5.services.CalculateService;
import com.zeyakong.hw5.services.DefaultService;
import com.zeyakong.hw5.services.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zeya Kong
 * On 4/5/2018 9:35 PM.
 */
@RestController
public class CalculateController {
    @Value("${zeya.uuid}")
    private String uuid;

    @Autowired
    private CalculateService calculateService;
    @Autowired
    private EncryptService encryptService;
    @Autowired
    private DefaultService defaultService;

    @RequestMapping(value = "/api/v1/{operation}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String,String> getOp(@PathVariable String operation,
                             @RequestHeader(value = "hash-lag") String hash,
                             @RequestParam(required = false) Integer x,
                             @RequestParam(required = false) Integer y) {
        Default d = defaultService.getDefault();
        List<Integer> def = d.getDefaultByOp(operation);
        System.out.println(x+"...."+y);
        if(x==null) x = def.get(0);
        if(y==null) y = def.get(1);
        String resCal,resHash;
        if(operation.equals("add")){
            resCal = calculateService.add(x,y);
            resHash = encryptService.getEncrypt(x+"+"+y+"="+resCal,hash);
        }else if(operation.equals("sub")){
            resCal = calculateService.sub(x,y);
            resHash = encryptService.getEncrypt(x+"-"+y+"="+resCal,hash);
        }else if(operation.equals("mul")){
            resCal = calculateService.mul(x,y);
            resHash = encryptService.getEncrypt(x+"*"+y+"="+resCal,hash);
        }else if(operation.equals("div")){
            resCal = calculateService.div(x,y);
            resHash = encryptService.getEncrypt(x+"/"+y+"="+resCal,hash);
        }else if(operation.equals("pow")){
            resCal = calculateService.pow(x,y);
            resHash = encryptService.getEncrypt(x+"^"+y+"="+resCal,hash);
        }else{
            return null;
        }

        Map<String ,String> result = new HashMap<>();
        result.put("x",x+"");
        result.put("y",y+"");
        result.put("op",operation);
        result.put("result",resCal);
        result.put("hash",resHash);
        result.put("hash-lag",hash);
        return result;
    }

    @RequestMapping(value = "/api/v1/{operation}", method = RequestMethod.POST)
    public @ResponseBody Map<String,String> postOp(@PathVariable String operation,
                         @RequestHeader(value = "hash-lag") String hash,
                         @RequestParam(required = false) Integer x,
                         @RequestParam(required = false) Integer y) {
        Default d = defaultService.getDefault();
        List<Integer> def = d.getDefaultByOp(operation);

        if(x==null) x = def.get(0);
        if(y==null) y = def.get(1);

        d.setDefault(operation,x,y);

        String resCal,resHash;

        if(operation.equals("add")){
            resCal = calculateService.add(x,y);
            resHash = encryptService.getEncrypt(x+"+"+y+"="+resCal,hash);
        }else if(operation.equals("sub")){
            resCal = calculateService.sub(x,y);
            resHash = encryptService.getEncrypt(x+"-"+y+"="+resCal,hash);
        }else if(operation.equals("mul")){
            resCal = calculateService.mul(x,y);
            resHash = encryptService.getEncrypt(x+"*"+y+"="+resCal,hash);
        }else if(operation.equals("div")){
            resCal = calculateService.div(x,y);
            resHash = encryptService.getEncrypt(x+"/"+y+"="+resCal,hash);
        }else if(operation.equals("pow")){
            resCal = calculateService.pow(x,y);
            resHash = encryptService.getEncrypt(x+"^"+y+"="+resCal,hash);
        }else{
            return null;
        }

        Map<String ,String> result = new HashMap<>();
        result.put("x",x+"");
        result.put("y",y+"");
        result.put("op",operation);
        result.put("result",resCal);
        result.put("hash",resHash);
        result.put("hash-lag",hash);
        return result;
    }
}
