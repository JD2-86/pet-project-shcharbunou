package by.shcharbunou.jee.controller;

import by.shcharbunou.core.dto.user.request.GroupRequest;
import by.shcharbunou.core.exception.AdminNotFoundException;
import by.shcharbunou.core.exception.GroupDuplicateException;
import by.shcharbunou.core.exception.TimeFormatException;
import by.shcharbunou.core.exception.UserNotFoundException;
import by.shcharbunou.core.service.admin.AdminService;
import by.shcharbunou.dal.entity.user.Group;
import by.shcharbunou.dal.entity.user.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Log4j2
@Controller
@SessionAttributes({"user", "ROLE"})
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public ModelAndView getAdminPanel(Authentication authentication) {
        ModelAndView mav = new ModelAndView();
        User admin = null;
        try {
            admin = adminService.findAdminByUsername(authentication.getName());
        } catch (AdminNotFoundException e) {
            mav.addObject("error", e.getMessage());
        }
        mav.addObject("user", admin);
        mav.addObject("ROLE", authentication.getAuthorities().stream().findFirst().orElseThrow());
        mav.setViewName("admin/admin");
        return mav;
    }

    @GetMapping("/admin/group/control")
    public ModelAndView getGroupAdminPanel() {
        return new ModelAndView("admin/group/group-adm");
    }

    @GetMapping("/admin/group/control/add-group")
    public ModelAndView getAddGroupPanel() {
        return new ModelAndView("admin/group/add-group");
    }

    @GetMapping("/admin/group/control/add-user-group")
    public ModelAndView getAddUserGroupPanel() {
        return new ModelAndView("admin/group/add-user-group");
    }

    @GetMapping("/admin/group/control/claims")
    public ModelAndView getClaimsPanel() {
        return new ModelAndView("admin/group/claims");
    }

    @GetMapping("/admin/group/control/del-group")
    public ModelAndView getDeleteGroupPanel() {
        return new ModelAndView("admin/group/del-group");
    }

    @GetMapping("/admin/group/control/del-user-group")
    public ModelAndView getDeleteUserGroupPanel() {
        return new ModelAndView("admin/group/del-user-group");
    }

    @GetMapping("/admin/group/control/show-groups")
    public ModelAndView showGroups() {
        return new ModelAndView("admin/group/show-groups");
    }

    @GetMapping("/admin/blog/control")
    public ModelAndView getBlogAdminPanel() {
        return new ModelAndView("admin/blog/blog-adm");
    }

    @GetMapping("/admin/homework/control")
    public ModelAndView getHomeworkAdminPanel() {
        return new ModelAndView("admin/homework/homework-adm");
    }

    @GetMapping("/admin/other/control")
    public ModelAndView getOtherAdminPanel() {
        return new ModelAndView("admin/other/other-adm");
    }

    @GetMapping("/admin/photo/control")
    public ModelAndView getPhotoAdminPanel() {
        return new ModelAndView("admin/photo/photo-adm");
    }

    @GetMapping("/admin/user/control")
    public ModelAndView getUserAdminPanel() {
        return new ModelAndView("admin/user/user-adm");
    }

    @PostMapping("/admin/group/control/add-group")
    public ModelAndView testGroupAdd(GroupRequest groupRequest) {
        ModelAndView mav = new ModelAndView();
        Group group;
        try {
            group = adminService.getGroupService().createGroup(groupRequest);
        } catch (TimeFormatException | GroupDuplicateException | UserNotFoundException
                | AdminNotFoundException e) {
            mav.addObject("error", e.getMessage());
            mav.setViewName("admin/group/add-group");
            return mav;
        }
        Group savedGroup = adminService.getGroupService().saveGroup(group);
        if (Objects.isNull(savedGroup)) {
            mav.setViewName("admin/group/add-group");
            mav.addObject("error", "Произошёл сбой: Группа не добавлена!");
        } else {
            mav.setViewName("admin/group/group-adm");
            mav.addObject("message", "Группа успешно добавлена!");
        }
        return mav;
    }
}
