<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <spring:message code="webapp.version" />
      <spring:message code="webapp.versionMessage" />
      <spring:message code="webapp.code" />
      ${version}
      
    </div>
  </div>
</nav>