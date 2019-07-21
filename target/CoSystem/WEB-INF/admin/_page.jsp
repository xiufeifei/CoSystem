<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style type="text/css">
    ul {
        list-style: none;
        padding-left: 0;
    }

    ul li {
        padding: 0 10px;
        vertical-align: top;
        display: inline-block;
        font-size: 14px;
        min-width: 36px;
        min-height: 28px;
        line-height: 28px;
        cursor: pointer;
        box-sizing: border-box;
        text-align: center;
        background-color: #ffffff;
        color: #606266;
        border-radius: 6px;
        margin: 0 1px;
        border: 1px solid #ebebeb;
        height: 30px;
    }

    ul li:hover {
        transform: scale(1.1);
        background-color: #F4F6F8;
    }

    li.active {
        background: #98A6AD;
        color: white;
        cursor: not-allowed;
    }

    li.disabled {
        cursor: not-allowed;
    }

    li.totalPage {
        background: transparent;
        cursor: default;
        border: none;
        padding: 0 6px;
    }

    li.totalPage:hover {
        transform: none;
        background-color: #ffffff;
    }

    li input {
        -webkit-appearance: none;
        background-color: #fff;
        background-image: none;
        border-radius: 4px;
        border: 1px solid #dcdfe6;
        box-sizing: border-box;
        color: #606266;
        display: inline-block;
        font-size: inherit;
        outline: none;
        padding: 3px 5px;
        transition: border-color .2s cubic-bezier(.645, .045, .355, 1);
        width: 40px;
        height: 25px;
        margin: 0 6px;
    }

    li input:focus {
        border-color: #98A6AD;
    }

    {
        user-select: none;
    }

    ul:nth-child(2) {
        border-radius: 6px;
    }

    input[type=number] {
        -moz-appearance: textfield;
    }

    input[type=number]::-webkit-inner-spin-button,
    input[type=number]::-webkit-outer-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
</style>
<div style="float: right;margin-right: 20px;">
    <div>
        <c:if test="${data.totalPageNum>1}">
            <ul class="pagination">
                <c:if test="${data.pageNum == 1}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${data.pageNum != 1}">
                <li class="active">
                    </c:if>
                    <a href="${pageContext.request.contextPath}/${data.url}?pageNum=1">首页</a>
                </li>

                <c:if test="${data.pageNum>1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/${data.url}?pageNum=${data.prePageNum}">上一页</a>
                    </li>
                </c:if>

                <c:forEach begin="1" step="1" end="${data.totalPageNum}" var="i">
                    <c:if test="${data.pageNum == i}">
                        <li class="disabled">
                    </c:if>
                    <c:if test="${data.pageNum != i}">
                        <li class="active">
                    </c:if>
                    <a href="${pageContext.request.contextPath}/${data.url}?pageNum=${i}">${i}</a>
                    </li>
                </c:forEach>

                <c:if test="${data.pageNum<data.totalPageNum}">
                    <li>
                        <a href="${pageContext.request.contextPath}/${data.url}?pageNum=${data.nextPageNum}">下一页</a>
                    </li>
                </c:if>

                <c:if test="${data.pageNum == totalPageNum}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${data.pageNum != totalPageNum}">
                <li class="active">
                    </c:if>
                    <a href="${pageContext.request.contextPath}/${data.url}?pageNum=${data.totalPageNum}">尾页</a>
                </li>
                <li>
                    跳转到
                    <input type="number" name="pageNum" width="2">
                    页
                </li>
            </ul>
        </c:if>
    </div>
</div>


