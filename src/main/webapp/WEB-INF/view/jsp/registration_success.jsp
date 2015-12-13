<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h1><fmt:message key="user.registration.success.header"/></h1>

<p>
    <fmt:message key="user.registration.success">
        <fmt:param>
            <strong>${user.username}</strong>
        </fmt:param>
    </fmt:message>

    <br/>

    <a href="<c:url value="/user/new"/>"><fmt:message key="user.registration.back"/></a>
</p>
