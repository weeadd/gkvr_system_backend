package com.scu.gkvr_system.controller;

import com.scu.common.vo.Result;
import com.scu.gkvr_system.entity.UserSchoolMajorId;
import com.scu.gkvr_system.service.IUserVoluntaryService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzc
 * @since 2023-07-17
 */
@RestController
@RequestMapping("/userVoluntary")
@CrossOrigin
public class UserVoluntaryController {

    @Resource
    private IUserVoluntaryService userVoluntaryService;

    @PostMapping("/addVoluntary")
    public Result<Map<String,Object>> addVoluntary(@RequestBody UserSchoolMajorId userSchoolMajorId){
        String message = userVoluntaryService.addVoluntary(userSchoolMajorId.getUserId(), userSchoolMajorId.getSchoolId(), userSchoolMajorId.getMajorId());
        if (message.equals("添加成功！")) {
            return Result.success("添加成功！");
        }
        return Result.fail(20001, message);
    }
    @PostMapping("/deleteVoluntary")
    public Result<Map<String,Object>> deleteVoluntary(@RequestBody UserSchoolMajorId userSchoolMajorId){
        String message = userVoluntaryService.deleteVoluntary(userSchoolMajorId.getUserId(), userSchoolMajorId.getSchoolId(), userSchoolMajorId.getMajorId());
        if (message.equals("删除成功！")) {
            return Result.success("删除成功！");
        }
        return Result.fail(20001, message);
    }
    @GetMapping("/getVoluntary")
    public Result<Map<String,Object>> getVoluntary(@RequestParam String userId){
        Map<String, Object> data = userVoluntaryService.getVoluntary(userId);
        if (data != null) {
            return Result.success("获取", data);
        }
        return Result.fail(20001, "获取失败");
    }

}
