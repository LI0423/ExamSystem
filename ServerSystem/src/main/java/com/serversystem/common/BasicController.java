package com.serversystem.common;

import com.basicsystem.common.ResponseResult;
import com.basicsystem.common.ResponseResultPage;
import com.basicsystem.entity.SysUserDO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class BasicController {
    public static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    /**
     * 封装layui table的数据
     * 这个方法使用有问题，没有count数据，count就是当前dataList的数量
     */
    protected ResponseResultPage packageTableData(List<?> dataList) {
        if (dataList instanceof Page) {
            return this.packageTableData(new PageInfo<>(dataList));
        }
        return this.packageTableData(dataList, null);
    }

    protected ResponseResultPage packageTableData(List<?> dataList, Long count) {
        ResponseResultPage result = ResponseResultPage.newResultEntityPage(ResponseResult.OK_CODE, ResponseResult.OK_MSG, dataList, 0L);
        if (dataList != null) {
            result.setTotal(count != null ? count : dataList.size());
        }
        return result;
    }

    /**
     * 封装layui table的数据，分页
     */
    protected ResponseResultPage packageTableData(PageInfo<?> pageInfo) {
        return ResponseResultPage.newResultEntityPage(ResponseResult.OK_CODE, ResponseResult.OK_MSG, pageInfo.getList(), pageInfo.getTotal());
    }

    protected String getParamVal(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        if (StringUtils.isNotEmpty(value)) return value;
        return "";
    }

    protected Long getUserId() {
        Subject subject = SecurityUtils.getSubject();
        SysUserDO user = (SysUserDO) subject.getPrincipal();
        return user.getId();
    }

    protected SysUserDO getSysUser() {
        Subject subject = SecurityUtils.getSubject();
        SysUserDO user = (SysUserDO) subject.getPrincipal();
        return user;
    }

}
