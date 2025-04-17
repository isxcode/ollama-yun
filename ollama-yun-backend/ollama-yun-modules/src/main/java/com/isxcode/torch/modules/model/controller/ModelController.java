package com.isxcode.torch.modules.model.controller;

import com.isxcode.torch.api.main.constants.ModuleCode;
import com.isxcode.torch.api.model.req.PageModelReq;
import com.isxcode.torch.api.model.res.PageModelRes;
import com.isxcode.torch.api.user.constants.RoleType;
import com.isxcode.torch.common.annotations.successResponse.SuccessResponse;
import com.isxcode.torch.modules.model.service.ModelBizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@Tag(name = "模型仓库模块")
@RequestMapping(ModuleCode.MODEL)
@RestController
@RequiredArgsConstructor
public class ModelController {

    private final ModelBizService modelBizService;

    @Secured({RoleType.TENANT_MEMBER, RoleType.TENANT_ADMIN})
    @Operation(summary = "查询模型仓库")
    @PostMapping("/pageModel")
    @SuccessResponse("查询成功")
    public Page<PageModelRes> pageModel(@Valid @RequestBody PageModelReq pageModelReq) {

        return modelBizService.pageModel(pageModelReq);
    }
}
