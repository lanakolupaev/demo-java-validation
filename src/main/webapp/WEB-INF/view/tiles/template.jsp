<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="<fmt:message key="global.app.name"/>">
    <meta name="author" content="<fmt:message key="global.me"/>">

    <title><fmt:message key="global.app.name"/></title>

    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/main.css" />" rel="stylesheet">

</head>

<body>

<!-- header -->
<tiles:insertAttribute name="header"/>

<!-- main content -->
<div class="container">

    <tiles:insertAttribute name="content"/>

</div>

<!-- footer -->
<div class="navbar navbar-footer navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <footer role="contentinfo">
                    <tiles:insertAttribute name="footer"/>
                </footer>
            </div>
        </div>
    </div>
</div>

<!-- scripts -->
<script src="<c:url value="/js/jquery.1.11.2.min.js" />"></script>
<script src="<c:url value="/js/jquery.validate.1.13.1.min.js" />"></script>
<script src="<c:url value="/js/jquery.validate.additionalmethods.1.13.1.min.js" />"></script>
<script src="<c:url value="/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/js/main.js" />"></script>

</body>
</html>
