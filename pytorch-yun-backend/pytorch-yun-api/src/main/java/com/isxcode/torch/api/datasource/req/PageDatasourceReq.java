package com.isxcode.torch.api.datasource.req;

import com.isxcode.torch.backend.api.base.pojos.BasePageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageDatasourceReq extends BasePageRequest {

    @Schema(title = "数据源类型")
    private String datasourceType;
}
