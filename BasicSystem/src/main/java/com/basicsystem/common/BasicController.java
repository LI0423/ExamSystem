package com.basicsystem.common;

import com.basicsystem.entity.SysUserDO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public abstract class BasicController {
    public static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    /**
     * 封装layui table的数据
     * 这个方法使用有问题，没有count数据，count就是当前dataList的数量
     */
//    protected ResultEntityPage packageTableData(List<?> dataList) {
//        if (dataList instanceof Page) {
//            return this.packageTableData(new PageInfo<>(dataList));
//        }
//        return this.packageTableData(dataList, null);
//    }
//
//    protected ResultEntityPage packageTableData(List<?> dataList, Long count) {
//        ResultEntityPage result = ResultEntityPage.newResultEntityPage(ResultEntity.CODE_OK, ResultEntity.MSG_SUCCESS, dataList, 0L);
//        if (dataList != null) {
//            result.setTotal(count != null ? count : dataList.size());
//        }
//        return result;
//    }
//
//    /**
//     * 封装layui table的数据，分页
//     */
//    protected ResultEntityPage packageTableData(PageInfo<?> pageInfo) {
//        return ResultEntityPage.newResultEntityPage(ResultEntity.CODE_OK, ResultEntity.MSG_SUCCESS, pageInfo.getList(), pageInfo.getTotal());
//    }

    protected String getParamVal(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        if (StringUtils.isNotEmpty(value)) return value;
        return "";
    }

//    protected String getUserId() {
//        Subject subject = SecurityUtils.getSubject();
//        SysUserDO user = (SysUserDO) subject.getPrincipal();
//        return user.getId();
//    }
//
//    protected SysUserDO getSysUser() {
//        Subject subject = SecurityUtils.getSubject();
//        SysUserDO user = (SysUserDO) subject.getPrincipal();
//        return user;
//    }

}
