package com.isxcode.torch.modules.app.controller;

import com.isxcode.torch.api.app.req.AddAppReq;
import com.isxcode.torch.api.app.req.PageAppReq;
import com.isxcode.torch.api.app.req.UpdateAppReq;
import com.isxcode.torch.api.app.res.PageAppRes;
import com.isxcode.torch.api.main.constants.ModuleCode;
import com.isxcode.torch.api.user.constants.RoleType;
import com.isxcode.torch.common.annotations.successResponse.SuccessResponse;
import com.isxcode.torch.modules.app.service.AppBizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@Tag(name = "应用模块")
@RequestMapping(ModuleCode.AI)
@RestController
@RequiredArgsConstructor
public class AppController {

    private final AppBizService appBizService;

    @Operation(summary = "添加应用接口")
    @PostMapping("/addApp")
    @SuccessResponse("添加成功")
    public void addApp(@Valid @RequestBody AddAppReq addAppReq) {

        appBizService.addApp(addAppReq);
    }

    @Secured({RoleType.TENANT_ADMIN})
    @Operation(summary = "更新应用接口")
    @PostMapping("/updateApp")
    @SuccessResponse("更新成功")
    public void updateApp(@Valid @RequestBody UpdateAppReq updateAppReq) {

        appBizService.updateApp(updateAppReq);
    }

    @Secured({RoleType.TENANT_MEMBER, RoleType.TENANT_ADMIN})
    @Operation(summary = "查询应用")
    @PostMapping("/pageApp")
    @SuccessResponse("查询成功")
    public Page<PageAppRes> pageApp(@Valid @RequestBody PageAppReq pageAppReq) {

        return appBizService.pageApps(pageAppReq);
    }

    // @Secured({RoleType.TENANT_ADMIN})
    // @Operation(summary = "删除ai接口")
    // @PostMapping("/deleteDatasource")
    // @SuccessResponse("删除成功")
    // public void deleteDatasource(@Valid @RequestBody DeleteDatasourceReq deleteDatasourceReq) {
    //
    // datasourceBizService.deleteDatasource(deleteDatasourceReq);
    // }
}
