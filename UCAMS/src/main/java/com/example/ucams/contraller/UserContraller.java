package com.example.ucams.contraller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ucams.model.User;
import com.example.ucams.servers.Userserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Users")
public class UserContraller {

    @Autowired//注入业务层
    private Userserver userserver;

    //RESTFUL开发模式
    //新增用@PostMapping
    // 删除用@DeletsMapping
    // 删除用@PutMapping
    // 查询用@GetMapping
    @GetMapping
    public R getAll() {
        return new R(true, userserver.getAll());
    }

    @PostMapping("/login")
    public R login(@RequestBody User user, HttpServletRequest request) {
        User ruser = userserver.getById(user.getUserId());
        if (ruser != null) {
            String realpwd = ruser.getUserPwd();
            if (realpwd.equals(user.getUserPwd())) {
                request.getSession().setAttribute("userName", user.getUserName());
                return new R(true, ruser);

            }
        }
        return new R(false, null);
    }


    @PostMapping
    public R save(@RequestBody User user) {
        return new R(userserver.save(user));
    }

    @PutMapping
    public R updata(@RequestBody User user) {
        return new R(userserver.updateById(user));
    }

    @DeleteMapping({"/{id}"})
    public R delete(@PathVariable Integer id) {
        return new R(userserver.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, userserver.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, User user) {
        IPage<User> page = userserver.getPage(currentPage, pageSize, user);
        //为了防止删除末页最后一个数据时页面出现的的无数据显示
        if (currentPage > page.getPages()) {
            page = userserver.getPage((int) page.getPages(), pageSize, user);
        }
        return new R(true, page);
    }
}
