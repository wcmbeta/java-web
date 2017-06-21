<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>客户</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
          rel=stylesheet>
    <script type="text/javascript">
        <%--//使用ajax加载数据字典--%>
        <%--//参数1   数据字典类型--%>
        <%--//参数2   将下拉放入标签id--%>
        <%--//参数3   select name属性--%>
        <%--//参数4   需要回显时,选中哪个option--%>
        <%--function loadSelect(typeCode, positionId, selectName, selectId) {--%>
            <%--//1创建select对象,将name属性指定--%>
            <%--var $select = $("<select name=" + selectName + "></select>");--%>
            <%--//2添加提示选项--%>
            <%--$select.append($("<option value=''>---请选择---</option>"));--%>
            <%--//3使用jq的ajax方法,访问后台的Action--%>
            <%--$.post("${pageContext.request.contextPath}/BaseDictAction",--%>
                <%--{dict_type_code: typeCode},--%>
                <%--function (data) {--%>
                    <%--//4返回json数组,遍历--%>
<%--//                    alert("data loaded:" + data);--%>
                    <%--$.each(data,function(i,json){--%>
                        <%--//创建option对象,判断是否需要回显,添加到select对象--%>
                        <%--var $option = $("<option value='"+json["dict_id"]+"'>"+json["dict_item_name"]+"</option>");--%>
                        <%--if (json["dict_id"] == selectId) {--%>
                            <%--$option.attr("selected","selected");--%>

                        <%--}--%>

                        <%--//5把select对象放到指定位置--%>
                        <%--$select.append($option);--%>
<%--//                        alert(json["dict_item_name"]);--%>
                    <%--});--%>

                <%--},--%>
                <%--"json");--%>



            <%--$("#" + positionId).append($select);--%>
        <%--}--%>
        <%--//使用 <s:if></s:if>标签--%>
        $(document).ready(function () {
            loadSelect("001", "hangye", "cust_industry.dict_id"<s:if test="#customer.cust_industry!=null">,<s:property value="#customer.cust_industry.dict_id" /></s:if>);
            loadSelect("004", "level", "cust_level.dict_id"<s:if test="#customer.cust_level!=null">,<s:property value="#customer.cust_level.dict_id" /></s:if>);
            loadSelect("005", "source", "cust_source.dict_id"<s:if test="#customer.cust_source!=null">,<s:property value="#customer.cust_source.dict_id" /></s:if>);

        })
    </script>

    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<%--为了上传文件,表单提交类型enctype
    必须多段式
    文件上传用<input type="file"/>组件
--%>
<FORM id=form1 name=form1
      action="${pageContext.request.contextPath }/CustomerAction_add"
      method=post enctype="multipart/form-data">
    <input type="hidden" name="cust_id" value="<s:property value="#customer.cust_id" />" >

    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
                              border=0></TD>
            <TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
                height=20></TD>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
                              border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
                    src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
            <TD vAlign=top width="100%" bgColor=#ffffff>
                <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                    <TR>
                        <TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>

                <TABLE cellSpacing=0 cellPadding=5 border=0>


                    <TR>
                        <td>客户名称：</td>
                        <td>
                            <INPUT class=textbox id=sChannel0
                                   style="WIDTH: 180px" maxLength=50 name="cust_name" value="<s:property value="#customer.cust_name"/>">
                        </td>
                        <td>客户级别 ：</td>
                        <td id="level">
                            <%--<INPUT class=textbox id=sChannel1--%>
                            <%--style="WIDTH: 180px" maxLength=50 name="cust_level">--%>
                        </td>
                    </TR>

                    <TR>

                        <td>客户来源 ：</td>
                        <td id="source" >
                            <%--<INPUT class=textbox id=sChannel2--%>
                                   <%--style="WIDTH: 180px" maxLength=50 name="cust_source">--%>
                        </td>
                        <td>客户行业：</td>
                        <td id="hangye">
                            <%--<INPUT class=textbox id=sChannel3--%>
                                   <%--style="WIDTH: 180px" maxLength=50 name="cust_linkman">--%>
                        </td>
                    </TR>

                    <TR>


                        <td>固定电话 ：</td>
                        <td >
                            <INPUT class=textbox id=sChannel4
                                   style="WIDTH: 180px" maxLength=50 name="cust_phone" value="<s:property value="#customer.cust_phone"/>">
                        </td>
                        <td>移动电话 ：</td>
                        <td >
                            <INPUT class=textbox id=sChannel5
                                   style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="<s:property value="#customer.cust_mobile"/>">
                        </td>
                    </TR>
                    <TR>
                        <td>图片上传 ：</td>
                        <td>
                            <input type="file" name="photo" />
                        </td>
                    </TR>
                    <tr>
                        <td rowspan=2>
                            <INPUT class=button id=sButton1 type=submit
                                   value=" 保存 " name=sButton1>
                        </td>
                    </tr>
                </TABLE>


            </TD>
            <TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
                <IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
                              border=0></TD>
            <TD align=middle width="100%"
                background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
                              border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</BODY>
</HTML>
