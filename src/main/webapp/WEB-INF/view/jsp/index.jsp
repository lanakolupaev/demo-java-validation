<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html class="welcome">
<div class="intro">
    <h1><fmt:message key="global.app.name"/></h1>
    <p><fmt:message key="global.app.description"/></p>
    <p class="tip"><fmt:message key="global.app.tip"/></p>

    <div>
        <a href="<c:url value="/user/new"/>" class="btn btn-default btn-lg"><fmt:message key="nav.register"/></a>
    </div>
</div>

<!-- <fmt:message key="global.photoCredit"/> -->
</html>
