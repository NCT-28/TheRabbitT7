<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title><dec:title/></title>
    <meta charset=UTF-8"/>
    <link rel="icon" href="${pageContext.request.contextPath}/template/client/images/fav.png" type="image/png"
          sizes="16x16">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/client/css/main.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/client/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/client/css/color.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/client/css/responsive.css">
    <dec:head/>
</head>
<body>
<div class="wavy-wraper">
    <div class="wavy">
        <span style="--i:1;">n</span>
        <span style="--i:2;">a</span>
        <span style="--i:3;">o</span>
        <span style="--i:4;">t</span>
        <span style="--i:5;">9</span>
        <span style="--i:6;">7</span>
        <span style="--i:7;">.</span>
        <span style="--i:8;">.</span>
        <span style="--i:9;">.</span>
    </div>
</div>
<div class="theme-layout">
    <div class="postoverlay"></div>
    <%@ include file="/common/client/themelayout/responsive-header.jsp" %>
    <%@ include file="/common/client/themelayout/topbar-stick.jsp" %>
    <%@ include file="/common/client/themelayout/fixed-sidebar-right.jsp" %>

    <dec:body/>
    <%@ include file="/common/client/footer.jsp" %>
</div>
<%@ include file="/common/client/popup-wraper2.jsp" %>
<%@ include file="/common/client/popup-wraper3.jsp" %>
<%@ include file="/common/client/popup-wraper1.jsp" %>

<script src="${pageContext.request.contextPath}/template/client/js/main.min.js"></script>
<script src="${pageContext.request.contextPath}/template/client/js/jquery-stories.js"></script>
<script src="${pageContext.request.contextPath}/template/client/js/locationpicker.jquery.js"></script>
<script src="${pageContext.request.contextPath}/template/client/js/map-init.js"></script>
<script src="${pageContext.request.contextPath}/template/client/js/script.js"></script>
<script>
    jQuery(document).ready(function($) {

        $('#us3').locationpicker({
            location: {
                latitude: -8.681013,
                longitude: 115.23506410000005
            },
            radius: 0,
            inputBinding: {
                latitudeInput: $('#us3-lat'),
                longitudeInput: $('#us3-lon'),
                radiusInput: $('#us3-radius'),
                locationNameInput: $('#us3-address')
            },
            enableAutocomplete: true,
            onchanged: function (currentLocation, radius, isMarkerDropped) {
                // Uncomment line below to show alert on each Location Changed event
                //alert("Location changed. New location (" + currentLocation.latitude + ", " + currentLocation.longitude + ")");
            }
        });

    });
</script>
</html>