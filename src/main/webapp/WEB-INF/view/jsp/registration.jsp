<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="alert alert-info" role="alert">
    <strong><fmt:message key="user.registration.validation.header"/></strong><br/>
    <p><fmt:message key="user.registration.validation.username"/></p>
    <p><fmt:message key="user.registration.validation.password"/></p>
</div>

<c:url var="registerAction" value="/user/register"></c:url>
<form:form method="post" modelAttribute="user" action="${registerAction}" id="registrationForm">
    <form:errors/>
  <div class="form-group has-feedback <spring:bind path="username"> <c:if test="${status.error}">has-error</c:if></spring:bind> ">
        <label for="usernameInput">
            <fmt:message key="user.username"/>
            <span class="required"><fmt:message key="form.required"/></span>
        </label>
        <form:input path="username" cssClass="form-control" id="usernameInput"/>
        <span class="glyphicon form-control-feedback" id="usernameInputFeedback"></span>
        <spring:bind path="username">
            <c:if test="${status.error}">
                <i class="form-control-feedback glyphicon-remove glyphicon static-error" style="display: block;"></i>
                <small class="help-block static-error">${status.getErrorMessagesAsString("<br/>")}</small>
            </c:if>
        </spring:bind>
  </div>

  <div class="form-group has-feedback <spring:bind path="password"><c:if test="${status.error}">has-error</c:if></spring:bind>">
    <label for="passwordInput">
        <fmt:message key="user.password"/>
        <span class="required"><fmt:message key="form.required"/></span>
    </label>
      <form:password path="password" cssClass="form-control" id="passwordInput"/>
      <span class="glyphicon form-control-feedback" id="passwordInputFeedback"></span>
      <spring:bind path="password">
          <c:if test="${status.error}">
              <i class="form-control-feedback glyphicon-remove glyphicon static-error"></i>
              <small class="help-block static-error">${status.getErrorMessagesAsString("<br/>")}</small>
          </c:if>
      </spring:bind>
  </div>

  <button type="submit" class="btn btn-primary"><fmt:message key="action.register"/></button>
</form:form>
